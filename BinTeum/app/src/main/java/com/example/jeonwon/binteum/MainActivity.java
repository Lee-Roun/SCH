package com.example.jeonwon.binteum;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class MainActivity extends AppCompatActivity {
    private static final int REQ_ADD = 687;
    private static final int REQ_LOGIN = 687;
    public static DBHelper dbHelper;
    FloatingActionButton floatingActionButton;
    SharedPreferences myInfo;
    ArrayList<Lecture> lectureMyList;
    ArrayList<TextView> textViewArrayList;
    MenuItem menuItem;
    TextView textViewMark, textViewBase;
    FrameLayout frameLayout;

    static int hori, verti;


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        lectureMyList = dbHelper.getMyLectureData();
        ArrayList<Lecture> lectures = dbHelper.getMyLectureData();


        for (TextView tv : textViewArrayList) {
            frameLayout.removeView(tv);
        }

        textViewArrayList.removeAll(textViewArrayList);

        for (Lecture lecture : lectures) {
            makeMyLectureTable(lecture);
            Log.i("Make", "Make : 메인 테이블 만드는중");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        textViewArrayList = new ArrayList<TextView>();
        textViewMark = (TextView) findViewById(R.id.mainTextView91);
        textViewBase = (TextView) findViewById(R.id.mainBr);
        frameLayout = (FrameLayout) findViewById(R.id.mainFrameLayout);


        menuItem = null;

        myInfo = getSharedPreferences("myInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = myInfo.edit();


        //ture : 로그인 되있음 false : 로그인 안되있음
//        listViewLecture = (ListView)findViewById(R.id.listViewAllLecture);

        if (dbHelper == null) {
            dbHelper = new DBHelper(getApplicationContext(), "LECTURE", null, 1);
            Excel();
            Log.i("DBHelp", "DB생성 완료");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                lectureMyList = dbHelper.getMyLectureData();

                hori = textViewMark.getWidth();
                verti = textViewMark.getHeight();
                Log.i("Location", "최초 Hori : " + hori + "/Verti : " + verti);

                for (Lecture thisLecture : lectureMyList) {
                    Log.i("Make", "Make : 메인 테이블 만드는중");
                    makeMyLectureTable(thisLecture);
                }
            }
        }, 1000);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, REQ_ADD);
            }
        });


    }

    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plug) {
                    case 0:
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                        break;
                    case 1:
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffff84")));
                        break;
                    case 2:
                        floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#83b3f7")));
                        break;
                }

            }
        }
    };

    public void makeMyLectureTable(final Lecture lecture) {
//        ArrayList<Lecture> lectures = MainActivity.dbHelper.getMyLectureData();

        int[] param = calcLocation(lecture);
        Log.i("Location", "첫째날 위치 : " + param[0] + "/둘째날 위치 : " + param[1] + "/" + param[2] + "/" + param[3]);
        int color = Color.argb(255, new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
        final Intent intent = new Intent(MainActivity.this, PopUpDetailActivity.class);
        intent.putExtra("Lecture", lecture.getLecture());
        //텍스트뷰 크기
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(hori, param[4]);
        //강의 위치
        params1.leftMargin = param[0];
        params1.topMargin = param[1];
        final TextView firstLecture = new TextView(MainActivity.this);
        final TextView secondLecture = new TextView(MainActivity.this);
        firstLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(intent);
            }
        });
        firstLecture.setBackgroundColor(color);
        firstLecture.setText(lecture.getTitle());
        frameLayout.addView(firstLecture, params1);

        if (!lecture.getDay2().equals("")) {
            //텍스트뷰 크기
            FrameLayout.LayoutParams params2 = new FrameLayout.LayoutParams(hori, param[5]);
            //강의 위치
            params2.leftMargin = param[2];
            params2.topMargin = param[3];
            secondLecture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
            secondLecture.setBackgroundColor(color);
            secondLecture.setText(lecture.getTitle());
            frameLayout.addView(secondLecture, params2);
        }

        textViewArrayList.add(firstLecture);
        textViewArrayList.add(secondLecture);

    }

    public int dayLocation(String Day) {
        int base = textViewBase.getWidth();
        switch (Day) {
            case "월":
                return (0 * hori) + base;
            case "화":
                return (1 * hori) + base;
            case "수":
                return (2 * hori) + base;
            case "목":
                return (3 * hori) + base;
            case "금":
                return (4 * hori) + base;
        }
        return 0;
    }

    public int timeLocation(String Time) {
        int base = textViewBase.getHeight();
        long location;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Date STime1 = simpleDateFormat.parse(Time);
            Date standardTime = simpleDateFormat.parse("09:00");
            Log.i("Location", "base" + (STime1.getTime() - standardTime.getTime()));

            location = (int) (STime1.getTime() - standardTime.getTime());
            location = location / 30000;

            return base + (int) location;

        } catch (Exception e1) {
            e1.printStackTrace();
            return 0;
        }
    }

    public int[] calcSize(Lecture lecture) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        long size1 = 0, size2 = 0;
        if(lecture.getETime1().equals("")){
            try {
                Date STime1 = simpleDateFormat.parse(lecture.getSTime1());
                Date STime2 = simpleDateFormat.parse(lecture.getSTime2());



                size1 = STime2.getTime() - STime1.getTime();
//                Log.i("Location", "/size2 : " + size2 + "/thisverti1 : " + thisverti1 + "/thisverti2 : " + thisverti2);

                //몇분짜리인지 계산
                size1 = size1 / 60000;


//            Log.i("Location", "verti : " + verti + "stime2: " + STime2.getTime() + "stime1: " + STime1.getTime() + "/size1 : " + size1 + "/size2 : " + size2 + "/thisverti1 : " + thisverti1 + "/thisverti2 : " + thisverti2);

                return new int[]{(int) size1, 0};

            } catch (ParseException e) {
                e.printStackTrace();
                Log.i("Location", "SIZE2 ERROR");
                return new int[]{(int)size1, 0};
            }
        }
        else{
            try {
                Date STime1 = simpleDateFormat.parse(lecture.getSTime1());
                Date STime2 = simpleDateFormat.parse(lecture.getSTime2());

                Date ETime1 = simpleDateFormat.parse(lecture.getETime1());
                Date ETime2 = simpleDateFormat.parse(lecture.getETime2());


                size1 = STime2.getTime() - STime1.getTime();
                size2 = ETime2.getTime() - ETime1.getTime();
//                Log.i("Location", "/size2 : " + size2 + "/thisverti1 : " + thisverti1 + "/thisverti2 : " + thisverti2);

                //몇분짜리인지 계산
                size1 = size1 / 60000;
                size2 = size2 / 60000;


//            Log.i("Location", "verti : " + verti + "stime2: " + STime2.getTime() + "stime1: " + STime1.getTime() + "/size1 : " + size1 + "/size2 : " + size2 + "/thisverti1 : " + thisverti1 + "/thisverti2 : " + thisverti2);

                return new int[]{(int) size1, (int) size2};

            } catch (ParseException e) {
                e.printStackTrace();
                Log.i("Location", "SIZE2 ERROR");
                return new int[]{(int) size1, (int) size2};
            }
        }
    }

    public int[] calcLocation(Lecture lecture) {
        int[] loca = new int[6];
        Log.i("Location", "Day1 : " + lecture.getDay1() + "/ Day2 : " + lecture.getDay2() + "/ STime : " + lecture.getSTime1() + "/ ETime : " + lecture.getETime1() + "/");

        loca[0] = dayLocation(lecture.getDay1());
        if (!lecture.getDay2().equals("")) {
            loca[2] = dayLocation(lecture.getDay2());
        }
        loca[1] = timeLocation(lecture.getSTime1());
        if (!lecture.getETime1().equals("")) {
            loca[3] = timeLocation(lecture.getETime1());
        }

        loca[4] = calcSize(lecture)[0];
        loca[5] = calcSize(lecture)[1];

        return loca;
    }

    public void Excel() {
        try {
            String[] data = new String[16];
            int row = 0, column = 0;
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("lecture.xls");
            Log.i("Data-", "" + inputStream.toString());
            Workbook workbook = Workbook.getWorkbook(inputStream);

            Sheet Course = workbook.getSheet(0);
            row = Course.getRows();
            column = Course.getColumns();

            for (int r = 1; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    Cell cell = Course.getCell(c, r);
                    data[c] = cell.getContents();
                }
                Lecture lecture = new Lecture(data);
//                Log.i("Data :", ""+data);
                dbHelper.add(lecture);
            }

        } catch (Exception e1) {

        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if (menuItem != null) {
            if (myInfo.getBoolean("LOGINCHK", false)) {
                menuItem.setTitle("내정보");
            } else {
                menuItem.setTitle("로그인");
            }
        }

        //여기서 사용자의 시간표를 읽어와서 표시해줘야함

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        menuItem = menu.getItem(0);
        Log.i("Menu", "" + menuItem.getTitle());

        if (myInfo.getBoolean("LOGINCHK", false)) {
            menuItem.setTitle("내정보");
        } else {
            menuItem.setTitle("로그인");
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuProfile:
                //프로필 눌렀을때 로그인 중이면 내정보 화면으로 이동
                if (myInfo.getBoolean("LOGINCHK", false)) {
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}
