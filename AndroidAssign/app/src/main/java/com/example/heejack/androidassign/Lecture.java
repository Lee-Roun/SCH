package com.example.heejack.androidassign;

public class Lecture {
    //        createSQL1.append(" CREATE TABLE LECTURE ( ");
//        createSQL1.append(" LID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
//        createSQL1.append(" L_NUM INTEGER, ");
//        createSQL1.append(" TITLE TEXT, ");
//            createSQL1.append(" FULLINFO TEXT, ");
    //        createSQL1.append(" DAY1 TEXT, ");
//        createSQL1.append(" STIME1 TIME, ");
//        createSQL1.append(" STIME2 TIME, ");
//        createSQL1.append(" DAY2 TEXT, ");
//        createSQL1.append(" ETIME1 TIME, ");
//        createSQL1.append(" ETIME2 TIME, ");
//        createSQL1.append(" UNIV TEXT ) ");
    private String L_Num, Title, FullInfo, Day1, Day2, STime1, STime2, ETime1, ETime2, Univ;
    private int LID;

    public Lecture() {
        this.Title = "TEST";
        this.LID = 1;
    }

    public Lecture(String L_Num, String Title, String FullInfo, String Day1, String STime1, String STime2, String ETime1, String Day2, String ETime2, String Univ) {
        this.Day1 = Day1;
        this.Day2 = Day2;
        this.FullInfo = FullInfo;
        this.ETime1 = ETime1;
        this.ETime2 = ETime2;
        this.L_Num = L_Num;
        this.STime1 = STime1;
        this.STime2 = STime2;
        this.Title = Title;
        this.Univ = Univ;
    }

    public Lecture(String[] lecture) {
        this.L_Num = lecture[0];
        this.Title = lecture[1];
        this.FullInfo = lecture[2];
        this.Day1 = lecture[3];
        this.STime1 = lecture[4];
        this.STime2 = lecture[5];
        this.Day2 = lecture[6];
        this.ETime1 = lecture[7];
        this.ETime2 = lecture[8];
        this.Univ = lecture[9];
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setFullInfo(String FullInfo) {
        this.FullInfo = FullInfo;
    }

    public void setDay1(String Day1) {
        this.Day1 = Day1;
    }

    public void setDay2(String Day2) {
        this.Day2 = Day2;
    }

    public void setSTime1(String STime1) {
        this.STime1 = STime1;
    }

    public void setSTime2(String STime2) {
        this.STime2 = STime2;
    }

    public void setETime1(String ETime1) {
        this.ETime1 = ETime1;
    }

    public void setETime2(String ETime2) {
        this.ETime2 = ETime2;
    }

    public void setUniv(String Univ) {
        this.Univ = Univ;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public void setL_Num(String L_Num) {
        this.L_Num = L_Num;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getFullInfo() {
        return this.FullInfo;
    }

    public String getDay1() {
        return this.Day1;
    }

    public String getDay2() {
        return this.Day2;
    }

    public String getSTime1() {
        return this.STime1;
    }

    public String getSTime2() {
        return this.STime2;
    }

    public String getETime1() {
        return this.ETime1;
    }

    public String getETime2() {
        return this.ETime2;
    }

    public String getUniv() {
        return this.Univ;
    }

    public int getLID() {
        return this.LID;
    }

    public String getL_Num() {
        return this.L_Num;
    }

}
