package com.example.myapplication;

/**
 * Created by JeonWon on 2018-03-04.
 */

public class ContactDBCtrct {

    public static final String TBL = "LECTURE";
    public static final String COL_NO = "NO";
    public static final String COL_LECTURE_NO = "LECTURE_NO";
    public static final String COL_LECTURE_NAME = "LECTURE_NAME";
    public static final String COL_POINT = "POINT";
    public static final String COL_LANG = "LANGUAGE";
    public static final String COL_GRADE = "GRADE";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_PROF = "PROFESSOR";
    public static final String COL_TARGET = "TARGET";
    public static final String COL_TIME = "TIME";
    public static final String COL_SEAT = "SEAT";
    public static final String COL_FEILD = "FEILD";
    public static final String COL_CAMPUS = "CAMPUS";

    // CREATE TABLE IF NOT EXISTS CONTACT_T (NO INTEGER NOT NULL, NAME TEXT, PHONE TEXT, OVER20 INTEGER)
    public static final String SQL_CREATE_TBL = "CREATE TABLE IF NOT EXISTS " + TBL + " " + "(" + COL_NO + " INTEGER NOT NULL" + ", " + COL_LECTURE_NO + " TEXT" + ", " + COL_LECTURE_NAME + " TEXT" + ", " +
            COL_POINT + " INTEGER" + COL_LANG + " INTEGER" + COL_GRADE + " INTEGER" + COL_TYPE + " INTEGER" + COL_PROF + " INTEGER" + COL_TARGET + " INTEGER" + COL_TIME + " INTEGER" + COL_SEAT + " INTEGER" + COL_FEILD + " INTEGER" + COL_CAMPUS + " INTEGER" +
            "PRIMARY KEY("+COL_NO+") "+")";
    // DROP TABLE IF EXISTS CONTACT_T
    public static final String SQL_DROP_TBL = "DROP TABLE IF EXISTS " + TBL;
    // SELECT * FROM CONTACT_T
    public static final String SQL_SELECT = "SELECT * FROM " + TBL;
    // INSERT OR REPLACE INTO CONTACT_T (NO, NAME, PHONE, OVER20) VALUES (x, x, x, x)
//    public static final String SQL_INSERT = "INSERT OR REPLACE INTO " + TBL + " " + "(" + COL_NO + ", " + COL_NAME + ", " + COL_PHONE + ", " + COL_OVER20 + ") VALUES ";
    // DELETE FROM CONTACT_T
    public static final String SQL_DELETE = "DELETE FROM " + TBL;


}
