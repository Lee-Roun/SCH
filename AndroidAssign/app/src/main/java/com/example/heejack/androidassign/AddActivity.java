package com.example.heejack.androidassign;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HeeJack on 2018-05-21.
 */

public class AddActivity extends AppCompatActivity {
    Button button;
    TextView editTextStart, editTextEnd;
    ListView listViewAll, listViewAdd;
    Spinner spinner1,spinner2;
    ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
    ArrayList<Lecture> lectureMyList = new ArrayList<Lecture>();
    LectureAdapter lectureAdapter, myLectureAdapter;
    String[] type, days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextStart = (TextView)findViewById(R.id.TextStart);
        editTextEnd = (TextView)findViewById(R.id.TextEnd);

        editTextStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = new DateDialog(AddActivity.this);
                dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                    @Override
                    public void OnDateValidate(String time) {
                        editTextStart.setText(time);
                    }
                });
                dateDialog.show();
            }
        });

        editTextEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = new DateDialog(AddActivity.this);
                dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                    @Override
                    public void OnDateValidate(String time) {
                        editTextEnd.setText(time);
                    }
                });
                dateDialog.show();
            }
        });

        /*전체 강의목록 리스트뷰*/
        listViewAll = (ListView)findViewById(R.id.listViewAllLecture);
        lectureAdapter = new LectureAdapter();
        myLectureAdapter = new LectureAdapter();
        listViewAll.setAdapter(lectureAdapter);
        listViewAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddActivity.this);

                alertBuilder.setTitle("확인");
                alertBuilder.setMessage("일정을 내 시간표에 추가하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        lectureMyList.add(lectureList.get(position));
                                        for(int t = 0; t<lectureMyList.size(); t++){
                                            myLectureAdapter.addLecture(lectureMyList.get(position));
                                        }
                                        myLectureAdapter.notifyDataSetChanged();
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
            }
        });
        /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

        /*내 강의목록 리스트뷰*/
        listViewAdd = (ListView)findViewById(R.id.listViewAdded);
        listViewAdd.setAdapter(myLectureAdapter);
        listViewAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddActivity.this);

                alertBuilder.setTitle("확인");
                alertBuilder.setMessage("일정을 삭제하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        myLectureAdapter.remove(lectureMyList.get(position));
                                    }
                                })
                        .setNegativeButton("취소",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertBuilder.create();
                alertDialog.show();
            }
        });
        /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

        spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner2 = (Spinner)findViewById(R.id.spinner2);

        button = (Button)findViewById(R.id.buttonSearch);

        type = getResources().getStringArray(R.array.type);
        days = getResources().getStringArray(R.array.day);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> spinner_adapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, type);
        ArrayAdapter<String> spinner_adapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, days);

        spinner_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinner_adapter1);
        spinner2.setAdapter(spinner_adapter2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pullAllLecture();
            }
        });
    }

    public void pullAllLecture(){
        lectureAdapter.deleteList();
//        lectureList = MainActivity.dbHelper.getAllPlanData();
        lectureList.add(new Lecture());
        Log.i("ListView", ""+lectureList);

        for(int i = 0; i<lectureList.size(); i++){
            lectureAdapter.addLecture(lectureList.get(i));
        }
        lectureAdapter.notifyDataSetChanged();
    }

}
