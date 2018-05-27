package com.example.jeonwon.binteum;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;

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
        createSQL1.append(" STIME1 DATETIME, ");
        createSQL1.append(" STIME2 DATETIME, ");
        createSQL1.append(" DAY2 TEXT, ");
        createSQL1.append(" ETIME1 DATETIME, ");
        createSQL1.append(" ETIME2 DATETIME, ");
        createSQL1.append(" PROF TEXT, ");
        createSQL1.append(" POINT TEXT, ");
        createSQL1.append(" LANG TEXT, ");
        createSQL1.append(" GRADE TEXT, ");
        createSQL1.append(" TYPE TEXT, ");
        createSQL1.append(" TARGET TEXT, ");
        createSQL1.append(" UNIV TEXT ) ");


        StringBuffer createSQL2 = new StringBuffer();
        createSQL2.append(" CREATE TABLE MY_LECTURE ( ");
        createSQL2.append(" LID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        createSQL2.append(" L_NUM TEXT, ");
        createSQL2.append(" TITLE TEXT, ");
        createSQL2.append(" FULLINFO TEXT, ");
        createSQL2.append(" DAY1 TEXT, ");
        createSQL2.append(" STIME1 DATETIME, ");
        createSQL2.append(" STIME2 DATETIME, ");
        createSQL2.append(" DAY2 TEXT, ");
        createSQL2.append(" ETIME1 DATETIME, ");
        createSQL2.append(" ETIME2 DATETIME, ");
        createSQL2.append(" PROF TEXT, ");
        createSQL2.append(" POINT TEXT, ");
        createSQL2.append(" LANG TEXT, ");
        createSQL2.append(" GRADE TEXT, ");
        createSQL2.append(" TYPE TEXT, ");
        createSQL2.append(" TARGET TEXT, ");
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
        insert.append("L_NUM, TITLE, FULLINFO, DAY1, STIME1, STIME2, DAY2, ETIME1, ETIME2, PROF, POINT, LANG, GRADE, TYPE, TARGET, UNIV) ");
        insert.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
                        lecture.getProf(),
                        lecture.getPoint(),
                        lecture.getLang(),
                        lecture.getGrade(),
                        lecture.getType(),
                        lecture.getTarget(),
                        lecture.getUniv()
                });
        db.close();

    }

    public void addMyTable(Lecture lecture) {
        SQLiteDatabase db = getWritableDatabase();

        StringBuffer insert = new StringBuffer();
        insert.append("INSERT INTO MY_LECTURE( ");
        insert.append("L_NUM, TITLE, FULLINFO, DAY1, STIME1, STIME2, DAY2, ETIME1, ETIME2, PROF, POINT, LANG, GRADE, TYPE, TARGET, UNIV) ");
        insert.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        Log.i("DELETE", "INSERT : "+lecture.getLID());
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
                        lecture.getProf(),
                        lecture.getPoint(),
                        lecture.getLang(),
                        lecture.getGrade(),
                        lecture.getType(),
                        lecture.getTarget(),
                        lecture.getUniv()
                });
        db.close();

    }

    public void deleteLecture(Lecture lecture) {
        SQLiteDatabase db = getWritableDatabase();
        Log.i("DELETE", "DELETE : " + lecture.getLID());
        db.execSQL("DELETE FROM MY_LECTURE WHERE LID = " + lecture.getLID() + ";");
        db.close();
    }

    public ArrayList<Lecture> getAllLectureData(String[] condition) {
        StringBuffer selectAll = new StringBuffer();
        ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
        if (condition[0].equals("")) {
            condition[0] = "%";
        }
        if (condition[1].equals("")) {
            condition[1] = "%";
        }
        if (condition[2].equals("")) {
            condition[2] = "%";
        }
        if (condition[3].equals("")) {
            condition[3] = "%";
        }
        if (condition[4].equals("")) {
            condition[4] = "00:00";
        }
        if (condition[5].equals("")) {
            condition[5] = "23:59";
        }
        selectAll.append("SELECT * FROM LECTURE WHERE PROF LIKE '%" + condition[0] + "%' AND TITLE LIKE '%" + condition[1] +
                "%' AND TYPE LIKE '%" + condition[2] + "%' AND DAY1 LIKE '" + condition[3] + "' AND DAY2 LIKE '" + condition[3]
                + "' AND STIME1 >= '" + condition[4] + "'");

        Log.i("Query", " Q : " + selectAll.toString());
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(selectAll.toString(), null);
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
            lecture.setProf(cursor.getString(10));
            lecture.setPoint(cursor.getString(11));
            lecture.setLang(cursor.getString(12));
            lecture.setGrade(cursor.getString(13));
            lecture.setType(cursor.getString(14));
            lecture.setTarget(cursor.getString(15));
            lecture.setUniv(cursor.getString(16));

            lectureList.add(lecture);
        }
        db.close();

        return lectureList;
    }

    public ArrayList<Lecture> getMyLectureData() {
        StringBuffer selectAll = new StringBuffer();
        selectAll.append("SELECT * FROM MY_LECTURE");

        // 읽기 전용 DB 객체를 만든다.
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(selectAll.toString(), null);
        ArrayList<Lecture> lectureList = new ArrayList<Lecture>();
        Lecture lecture = null; // moveToNext 다음에 데이터가 있으면 true 없으면 false
        Log.i("DB :", "내 강의 데이터 불러오기");

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
            lecture.setProf(cursor.getString(10));
            lecture.setPoint(cursor.getString(11));
            lecture.setLang(cursor.getString(12));
            lecture.setGrade(cursor.getString(13));
            lecture.setType(cursor.getString(14));
            lecture.setTarget(cursor.getString(15));
            lecture.setUniv(cursor.getString(16));

            lectureList.add(lecture);
        }
        db.close();

        return lectureList;
    }


}
