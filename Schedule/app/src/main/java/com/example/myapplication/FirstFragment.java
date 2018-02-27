package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * Created by JeonWon on 2018-02-27.
 */

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_1, null);

        ListView listView;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        adapter.addItem("데이터베이스","월","09:00~10:00","화","09:00 ~ 10:00");


        listView = (ListView) view.findViewById(R.id.listView_courses);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem)adapterView.getItemAtPosition(i);

                String courseName = item.getCourseName();

            }
        });

        return inflater.inflate(R.layout.fragment_1, container, false);
    }


}
