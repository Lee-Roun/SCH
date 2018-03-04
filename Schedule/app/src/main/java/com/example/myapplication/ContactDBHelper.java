package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JeonWon on 2018-03-04.
 */
public class ContactDBHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DBFILE_CONTACT = "contact.db";

    public ContactDBHelper(Context context){
        super(context, DBFILE_CONTACT, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactDBCtrct.SQL_CREATE_TBL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oleVersion, int newVersion) {
        onCreate(db);
    }
}
