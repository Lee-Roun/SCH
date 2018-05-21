package com.example.heejack.androidassign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HeeJack on 2018-05-21.
 */

public class AddActivity extends AppCompatActivity {
    Button button;
    Spinner spinner;
    List<String> listview_Items;
    ArrayAdapter<String> listview_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ListView listView = (ListView)findViewById(R.id.listView);
        listview_Items = new ArrayList<>();
        listview_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listview_Items);
        listView.setAdapter(listview_Adapter);
        spinner = (Spinner)findViewById(R.id.spinner1);
        button = (Button)findViewById(R.id.button);

        final String[] array = getResources().getStringArray(R.array.test);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ""+array[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();

            }
        });

        List<String> spinner_items = new ArrayList<>();
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinner_items);


        spinner_items.add("1");
        spinner_items.add("2");
        spinner_items.add("3");
        spinner_items.add("4");

        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinner_adapter);
    }


}
