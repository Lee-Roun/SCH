package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by JeonWon on 2018-02-27.
 */

public class FirstFragment  extends Fragment {

    private static String TAG = "phptest_MainActivity";

    private static final String TAG_JSON="binteum";
    private static final String TAG_CLASS_NAME = "className";
    private ArrayList mArrayList;
    private String mJsonString;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_1, null);

        ListView listView = (ListView) view.findViewById(R.id.listView_courses);
        ListViewAdapter adapter;

        mArrayList = new ArrayList<>();
/*
        GetData task = new GetData();
        task.execute("http://192.168.0.128/test.php");
*/


        adapter = new ListViewAdapter();

        listView.setAdapter(adapter);




        adapter.addItem("데이터베이스","월","09:00~10:00","화","09:00 ~ 10:00");

        //adapter.notifyDataSetChanged();

        //return inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }

    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        Context context = getContext();

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context.getApplicationContext(), "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);

            progressDialog.dismiss();
            Log.d(TAG, "response -" + result);

            if(result == null){

            }
            else{
                mJsonString = result;
                showResult();

            }

        }

        @Override
        protected String doInBackground(String... params) {
            String serverURL = params[0];

            try{
                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();

                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }
        }

    }


    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String className = item.getString(TAG_CLASS_NAME);

                HashMap<String,String> hashMap = new HashMap<>();

                hashMap.put(TAG_CLASS_NAME, className);

                mArrayList.add(hashMap);
            }


            ListView listView = (ListView) view.findViewById(R.id.listView_courses);
            ListViewAdapter adapter;

            adapter = new ListViewAdapter();

            listView.setAdapter(adapter);

            HashMap<String, String> hashMap = new HashMap<>();

            adapter.addItem(hashMap.get(mArrayList),"월","09:00~10:00","화","09:00 ~ 10:00");

            /*
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, mArrayList, R.layout.item_list,
                    new String[]{TAG_ID,TAG_NAME, TAG_ADDRESS},
                    new int[]{R.id.textView_list_id, R.id.textView_list_name, R.id.textView_list_address}
            );
            */
            //mlistView.setAdapter(adapter);

        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }


    }

}
