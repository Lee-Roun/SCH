package com.example.heejack.androidassign;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    private Context context;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //
        StringBuffer createSQL1 = new StringBuffer();
        createSQL1.append(" CREATE TABLE LECTURE (");
        createSQL1.append(" LID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        createSQL1.append(" L_NUM TEXT, ");
        createSQL1.append(" TITLE TEXT, ");
        createSQL1.append(" FULLINFO TEXT, ");
        createSQL1.append(" DAY1 TEXT, ");
        createSQL1.append(" STIME1 TEXT, ");
        createSQL1.append(" STIME2 TEXT, ");
        createSQL1.append(" DAY2 TEXT, ");
        createSQL1.append(" ETIME1 TEXT, ");
        createSQL1.append(" ETIME2 TEXT, ");
        createSQL1.append(" UNIV TEXT ) ");


        StringBuffer createSQL2 = new StringBuffer();
        createSQL2.append(" CREATE TABLE MY_LECTURE ( ");
        createSQL2.append(" LID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        createSQL2.append(" L_NUM TEXT, ");
        createSQL2.append(" TITLE TEXT, ");
        createSQL2.append(" FULLINFO TEXT, ");
        createSQL2.append(" DAY1 TEXT, ");
        createSQL2.append(" STIME1 TEXT, ");
        createSQL2.append(" STIME2 TEXT, ");
        createSQL2.append(" DAY2 TEXT, ");
        createSQL2.append(" ETIME1 TEXT, ");
        createSQL2.append(" ETIME2 TEXT, ");
        createSQL2.append(" UNIV TEXT ) ");

        sqLiteDatabase.execSQL(createSQL1.toString());
        sqLiteDatabase.execSQL(createSQL2.toString());

        Log.i("DBHelper", "DB성공");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void add(Lecture lecture) {
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer insert = new StringBuffer();
        insert.append("INSERT INTO LECTURE( ");
        insert.append("L_NUM, TITLE, FULLINFO, DAY1, STIME1, STIME2, DAY2, ETIME1, ETIME2, UNIV) ");
        insert.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        db.execSQL(insert.toString(),
                new Object[]{
                        lecture.getL_Num(),
                        lecture.getTitle(),
                        lecture.getFullInfo(),
                        lecture.getDay1(),
                        lecture.getSTime1(),
                        lecture.getSTime2(),
                        lecture.getDay2(),
                        lecture.getETime1(),
                        lecture.getETime2(),
                        lecture.getUniv()
        });
    }

    public List getAllPlanData() {
        StringBuffer selectAll = new StringBuffer();
        selectAll.append("SELECT * FROM LECTURE");

        // 읽기 전용 DB 객체를 만든다.
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(selectAll.toString(), null);
        List<Lecture> lectureList = new ArrayList();
        Lecture lecture = null; // moveToNext 다음에 데이터가 있으면 true 없으면 false
        Log.i("DB :", "데이터 불러오기");

        while (cursor.moveToNext()) {
            lecture = new Lecture();
            lecture.setLID(cursor.getInt(0));
            lecture.setL_Num(cursor.getString(1));
            lecture.setTitle(cursor.getString(2));
            lecture.setFullInfo(cursor.getString(3));
            lecture.setDay1(cursor.getString(4));
            lecture.setSTime1(cursor.getString(5));
            lecture.setSTime2(cursor.getString(6));
            lecture.setDay2(cursor.getString(7));
            lecture.setETime1(cursor.getString(8));
            lecture.setETime2(cursor.getString(9));
            lecture.setUniv(cursor.getString(10));

            lectureList.add(lecture);
        }

        return lectureList;
    }


}
