package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * Created by JeonWon on 2018-02-27.
 */

public class FirstFragment  extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_1, null);

        ListView listView = (ListView) view.findViewById(R.id.listView_courses);
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listView.setAdapter(adapter);

        adapter.addItem("데이터베이스","월","09:00~10:00","화","09:00 ~ 10:00");

        //adapter.notifyDataSetChanged();

        //return inflater.inflate(R.layout.fragment_1, container, false);
        return view;
    }


}
