package com.example.myapplication;

import android.widget.CheckBox;

/**
 * Created by JeonWon on 2018-02-27.
 */

public class ListViewItem {
    private boolean chkBox;
    private String courseName;
    private String day1;
    private String time1;
    private String day2;
    private String time2;
/*
    public ListViewItem(){
        this.chkBox = false;
        this.courseName = "DB";
        this.day1 = "Mon";
        this.time1 = "09:00";
        this.day2 = "The";
        this.time2 = "10:00";
    }
*/
    public void setChkBox() {
        this.chkBox = false;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setDay1(String day1){
        this.day1 = day1;
    }
    public void setTime1(String time1){
        this.time1 = time1;
    }
    public void setDay2(String day2){
        this.day2 = day2;
    }
    public void setTime2(String time2){
        this.time2 = time2;
    }


    public boolean getChkBox(){ return this.chkBox; }
    public String getCourseName(){
        return this.courseName;
    }
    public String getDay1(){
        return this.day1;
    }
    public String getDay2(){
        return this.day2;
    }
    public String getTime1(){
        return this.time1;
    }
    public String getTime2(){
        return this.time2;
    }

}
