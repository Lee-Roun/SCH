package com.example.myapplication;

import android.app.ProgressDialog;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SQLiteDatabase sqliteDB;

    DBHelper dbHelper = null;

    private EditText mEditTextName;
    private EditText mEditTextAddress;
    private TextView mTextViewResult;

    private static final String TAG_JSON = "Bintuem";
    private static final String TAG_ID = "ID";
    private static final String TAG_PW = "PW";
    private static final String TAG_NAME = "Name";
    private static final String TAG_UNIV = "Stu_Univ";
    private static final String TAG_NUM = "Stu_Num";
    private static final String TAG_FIELD = "Stu_Field";
    private static final String TAG_GRADE = "Stu_Grade";

    ArrayList<HashMap<String, String>> mArrayList;
    ListView mlistView;
    String mJsonString;

    private static String TAG = "phptest_MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mTextViewResult = (TextView) findViewById(R.id.textView_main_result);
        mlistView = (ListView) findViewById(R.id.listView_courses);
        mArrayList = new ArrayList<>();

        GetData task = new GetData();
        task.execute("http://192.168.0.128/getPerson.php");


        setContentView(R.layout.searchpop);

        //탭레이아웃
        //탭 레이아웃 설정
        tabLayout = (TabLayout) findViewById(R.id.sch_tab);
        tabLayout.addTab(tabLayout.newTab().setText("필수과목"));
        tabLayout.addTab(tabLayout.newTab().setText("시간"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //뷰페이저 달기
        viewPager = (ViewPager) findViewById(R.id.sch_viewpager);

        //어댑터 연결
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //탭 선택리스너
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //SQLite 데이터베이스
        //sqliteDB = init_database();
        //init_tables();
/*
        mEditTextName = (EditText)findViewById(R.id.editText_main_name);
        mEditTextAddress = (EditText)findViewById(R.id.editText_main_address);
        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);

        Button buttonInsert = (Button)findViewById(R.id.button_main_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mEditTextName.getText().toString();
                String address = mEditTextAddress.getText().toString();

                InsertData task = new InsertData();
                task.execute(name,address);


                mEditTextName.setText("");
                mEditTextAddress.setText("");

            }
        });
*/
    }
/*
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String name = (String)params[0];
            String address = (String)params[1];

            String serverURL = "http://192.168.0.128/insert.php";
            String postParameters = "name=" + name + "&address=" + address;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setRequestProperty("content-type", "application/json");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

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
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }

    }
*/

//}


        private void init_tables(){
            dbHelper = new DBHelper(getApplicationContext(), "BinDB", null);
        }

        private SQLiteDatabase init_database(){

            SQLiteDatabase db = null;

            File file = new File(getFilesDir(), "contact.db");
            System.out.println("여기!!!!PATH: "+ file.toString());

            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("PATH: " + file.toString());
            dialog.create();
            dialog.show();

            try{
                db = SQLiteDatabase.openOrCreateDatabase(file, null);
            }catch (SQLiteException e){
                e.printStackTrace();
            }

            if(db==null){
                System.out.println("DB creation failed " + file.getAbsolutePath());
            }

            return db;
        }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null) {

                mTextViewResult.setText(errorString);
            } else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
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


    private void showResult() {
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getString(TAG_ID);
                String name = item.getString(TAG_NAME);
                String pw = item.getString(TAG_PW);
                String univ = item.getString(TAG_UNIV);
                String num = item.getString(TAG_NUM);
                String field = item.getString(TAG_FIELD);
                String grade = item.getString(TAG_GRADE);

                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put(TAG_ID, id);
                hashMap.put(TAG_NAME, name);
                hashMap.put(TAG_PW, pw);
                hashMap.put(TAG_UNIV, univ);
                hashMap.put(TAG_NUM, num);
                hashMap.put(TAG_FIELD, field);
                hashMap.put(TAG_GRADE, grade);

                mArrayList.add(hashMap);
            }
/*
            ListAdapter adapter = new SimpleAdapter(
                    MainActivity.this, mArrayList, R.layout.item_list,
                    new String[]{TAG_ID, TAG_NAME, TAG_ADDRESS},
                    new int[]{R.id.textView_list_id, R.id.textView_list_name, R.id.textView_list_address}
            );

            mlistView.setAdapter(adapter);
*/
        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        User user = new User();

        user.checkUser();

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
