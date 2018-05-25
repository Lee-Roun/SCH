package com.example.jeonwon.binteum;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by HeeJack on 2018-05-21.
 */

public class AddActivity extends AppCompatActivity {
    Button button, buttonAuto;
    TextView textViewStart, textViewEnd,  textViewMark, textViewBase;
    EditText editTextProf, editTextCourse;
    ListView listViewAll, listViewAdd;
    Spinner spinner1, spinner2;
    ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
    ArrayList<Lecture> lectureMyList = new ArrayList<Lecture>();
    LectureAdapter lectureAdapter, myLectureAdapter;
    String[] type, days;
    FrameLayout frameLayout;
    static int hori, verti, thisverti1, thisverti2;

//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//        lectureMyList = MainActivity.dbHelper.getMyLectureData();
//        ArrayList<Lecture> lectures = MainActivity.dbHelper.getMyLectureData();
//        for (Lecture lecture : lectures) {
//            makeMyLectureTable(lecture);
//            Log.i("Data", "Resume");
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        lectureMyList = MainActivity.dbHelper.getMyLectureData();
        textViewMark = (TextView) findViewById(R.id.textView102);

        hori = textViewMark.getWidth();
        verti = textViewMark.getHeight();
        Log.i("Location", "Hori : "+hori+"/Verti : "+verti);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        textViewBase = (TextView) findViewById(R.id.br);

        editTextProf = (EditText) findViewById(R.id.editTextProf);
        editTextCourse = (EditText) findViewById(R.id.editTextCourse);

        textViewStart = (TextView) findViewById(R.id.TextStart);
        textViewEnd = (TextView) findViewById(R.id.TextEnd);

        textViewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = new DateDialog(AddActivity.this);
                dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                    @Override
                    public void OnDateValidate(String time) {
                        textViewStart.setText(time);
                    }
                });
                dateDialog.show();
            }
        });

        textViewEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = new DateDialog(AddActivity.this);
                dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                    @Override
                    public void OnDateValidate(String time) {
                        textViewEnd.setText(time);
                    }
                });
                dateDialog.show();
            }
        });

        //내가 넣었던 강의 그대로 보여줌
//        makeMyLectureTable();

        /*전체 강의목록 리스트뷰*/
        listViewAll = (ListView) findViewById(R.id.listViewAllLecture);
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
//                                            lectureMyList.add(lectureList.get(position));
                                        MainActivity.dbHelper.addMyTable(lectureList.get(position));
                                        lectureMyList = MainActivity.dbHelper.getMyLectureData();
//                                        for(int t = 0; t<lectureMyList.size(); t++){
//                                            myLectureAdapter.addLecture(lectureMyList.get(position));
//                                        }
//                                        myLectureAdapter.notifyDataSetChanged();
                                        makeMyLectureTable(lectureList.get(position));
//                                        int[] param = calcLocation(lectureList.get(position));
//                                        Log.i("Location", "" + param[0] + "/" + param[1] + "/" + param[2] + "/" + param[3]);
//                                        //텍스트뷰 크기
//                                        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(hori, thisverti1);
//                                        //강의 위치
//                                        params1.leftMargin = param[0];
//                                        params1.topMargin = param[1];
//                                        TextView firstLecture = new TextView(AddActivity.this);
//                                        firstLecture.setBackgroundColor(Color.parseColor("#FF9999"));
//                                        firstLecture.setText(lectureList.get(position).getTitle());
//                                        frameLayout.addView(firstLecture, params1);
//
//                                        if (!lectureList.get(position).getDay2().equals("")) {
//                                            //텍스트뷰 크기
//                                            FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(hori, thisverti2);
//                                            //강의 위치
//                                            params2.leftMargin = param[2];
//                                            params2.topMargin = param[3];
//                                            TextView secondLecture = new TextView(AddActivity.this);
//                                            secondLecture.setBackgroundColor(Color.parseColor("#FF9999"));
//                                            secondLecture.setText(lectureList.get(position).getTitle());
//                                            frameLayout.addView(secondLecture, params2);
//                                        }
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

//        /*내 강의목록 리스트뷰*/
//        listViewAdd = (ListView)findViewById(R.id.listViewAdded);
//        listViewAdd.setAdapter(myLectureAdapter);
//        listViewAdd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long l) {
//                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddActivity.this);
//
//                alertBuilder.setTitle("확인");
//                alertBuilder.setMessage("일정을 삭제하시겠습니까?")
//                        .setCancelable(false)
//                        .setPositiveButton("확인",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        myLectureAdapter.remove(lectureMyList.get(position));
//                                    }
//                                })
//                        .setNegativeButton("취소",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialogInterface, int i) {
//                                        dialogInterface.cancel();
//                                    }
//                                });
//
//                AlertDialog alertDialog = alertBuilder.create();
//                alertDialog.show();
//            }
//        });
//        /*@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);

        button = (Button) findViewById(R.id.buttonSearch);

        buttonAuto = (Button) findViewById(R.id.buttonAuto);

        type = getResources().getStringArray(R.array.type);

        days = getResources().getStringArray(R.array.day);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()

        {
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

        button.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                pullAllLecture();
            }
        });
        buttonAuto.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, PopUpAutoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void makeMyLectureTable(Lecture lecture) {
//        ArrayList<Lecture> lectures = MainActivity.dbHelper.getMyLectureData();
//        hori = textViewMark.getWidth();
//        verti = textViewMark.getHeight();

        Log.i("Data", lecture.getTitle());
        int[] param = calcLocation(lecture);
        Log.i("Location", "" + param[0] + "/" + param[1] + "/" + param[2] + "/" + param[3]);
        //텍스트뷰 크기
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(hori, thisverti1);
        //강의 위치
        params1.leftMargin = param[0];
        params1.topMargin = param[1];
        TextView firstLecture = new TextView(AddActivity.this);
        firstLecture.setBackgroundColor(Color.parseColor("#FF9999"));
        firstLecture.setText(lecture.getTitle());
        frameLayout.addView(firstLecture, params1);

        if (!lecture.getDay2().equals("")) {
            //텍스트뷰 크기
            FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(hori, thisverti2);
            //강의 위치
            params2.leftMargin = param[2];
            params2.topMargin = param[3];
            TextView secondLecture = new TextView(AddActivity.this);
            secondLecture.setBackgroundColor(Color.parseColor("#FF9999"));
            secondLecture.setText(lecture.getTitle());
            frameLayout.addView(secondLecture, params2);
        }


    }

    public int dayLocation(String Day) {
        int base = textViewBase.getWidth();
        switch (Day) {
            case "월":
                return 0 * hori + base;
            case "화":
                return 1 * hori + base;
            case "수":
                return 2 * hori + base;
            case "목":
                return 3 * hori + base;
            case "금":
                return 4 * hori + base;
        }
        return 0;
    }

    public int timeLocation(String Time) {
        int base = textViewBase.getHeight();
        Log.i("Location", "높이 : " + base);

        switch (Time) {
            case "09:00":
                return 0 * verti + base;
            case "10:00":
                return 1 * verti + base;
            case "11:00":
                return 2 * verti + base;
            case "12:00":
                return 3 * verti + base;
            case "13:00":
                return 4 * verti + base;
            case "14:00":
                return 5 * verti + base;
            case "15:00":
                return 6 * verti + base;
            case "16:00":
                return 7 * verti + base;
            case "17:00":
                return 8 * verti + base;
            case "18:00":
                return 9 * verti + base;
            case "19:00":
                return 10 * verti + base;
            case "20:00":
                return 11 * verti + base;
        }
        return base;
    }

    public void calcSize(Lecture lecture) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        try {
            Date STime1 = simpleDateFormat.parse(lecture.getSTime1());
            Date STime2 = simpleDateFormat.parse(lecture.getSTime2());
            Date ETime1 = simpleDateFormat.parse(lecture.getETime1());
            Date ETime2 = simpleDateFormat.parse(lecture.getETime2());

            //몇분짜리인지 계산
            long size1 = STime2.getTime() - STime1.getTime();
            long size2 = ETime2.getTime() - ETime1.getTime();

            size1 = size1 / 60000;
            size2 = size2 / 60000;

            thisverti1 = (int) size1 / (verti / 30);
            thisverti2 = (int) size2 / (verti / 30);
            Log.i("Location", "verti : " + verti +  "/size1 : "+ size1 + "/size2 : " + size2 + "/thisverti1 : " + thisverti1 + "/thisverti2 : " + thisverti2);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public int[] calcLocation(Lecture lecture) {
        int[] loca = new int[4];
        Log.i("Location", "Day1 : " + lecture.getDay1() + "/ Day2 : " + lecture.getDay2() + "/ STime : " + lecture.getSTime1() + "/ ETime : " + lecture.getETime1() + "/");

        loca[0] = dayLocation(lecture.getDay1());
        loca[2] = dayLocation(lecture.getDay2());

        loca[1] = timeLocation(lecture.getSTime1());
        loca[3] = timeLocation(lecture.getETime1());

        calcSize(lecture);

        return loca;
    }


    public void pullAllLecture() {
        lectureAdapter.deleteList();
        lectureList = MainActivity.dbHelper.getAllLectureData();
//        lectureList.add(new Lecture());
        Log.i("ListView", "" + lectureList);

        for (int i = 0; i < lectureList.size(); i++) {
            lectureAdapter.addLecture(lectureList.get(i));
        }
        lectureAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(AddActivity.this);

        alertBuilder.setTitle("확인");
        alertBuilder.setMessage("뒤로 가시겠습니까?")
                .setCancelable(false)
                .setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
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
}
