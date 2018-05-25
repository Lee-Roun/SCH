package com.example.jeonwon.binteum;

public class Lecture {
    private String L_Num, Title, FullInfo, Day1, Day2, STime1, STime2, ETime1, ETime2,
            Prof, Lang, Grade, Type, Target, Point, Univ;
    private int LID;

    public Lecture() {
//        this.Title = "TEST";
//        this.LID = 1;
//        this.FullInfo = "테스트";
//        this.L_Num = "10010-01";
//        this.Prof = "아저씨";

    }

    public Lecture(String L_Num, String Title, String FullInfo, String Day1, String STime1, String STime2,
                   String ETime1, String Day2, String ETime2, String Prof, String Point, String Lang, String Grade, String Type, String Target, String Univ) {
        this.Day1 = Day1;
        this.Day2 = Day2;
        this.FullInfo = FullInfo;
        this.ETime1 = ETime1;
        this.ETime2 = ETime2;
        this.L_Num = L_Num;
        this.STime1 = STime1;
        this.STime2 = STime2;
        this.Prof = Prof;
        this.Point = Point;
        this.Lang = Lang;
        this.Grade = Grade;
        this.Type = Type;
        this.Target = Target;
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
        this.Prof = lecture[9];
        this.Point = lecture[10];
        this.Lang = lecture[11];
        this.Grade = lecture[12];
        this.Type = lecture[13];
        this.Target = lecture[14];
        this.Univ = lecture[15];
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

    public void setProf(String Prof) {
        this.Prof = Prof;
    }

    public void setPoint(String Point) {
        this.Point = Point;
    }

    public void setLang(String Lang) {
        this.Lang = Lang;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setTarget(String Target) {
        this.Target = Target;
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

    public String getProf() {
        return this.Prof;
    }

    public String getPoint() {
        return this.Point;
    }

    public String getLang() {
        return this.Lang;
    }

    public String getGrade() {
        return this.Grade;
    }

    public String getType() {
        return this.Type;
    }

    public String getTarget() {
        return this.Target;
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
