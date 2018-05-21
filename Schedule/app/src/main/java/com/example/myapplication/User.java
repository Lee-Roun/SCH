package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by JeonWon on 2018-02-26.
 */

public class User extends AppCompatActivity {

    private String ID;
    private String PW;
    private String Name;
    private String Student_Num;
    private int State;
    //로그인 가능 = 0, 계정 5회 틀림 = 1, 로그인 제한 = 2
    private String Phone_Num;
    private String Email;


    protected void MakeAccount(String ID, String PW, String Name, String Student_Num, String Phone_Num, String Email){
        this.State = 0;
        this.ID = ID;
        this.PW = PW;
        this.Name = Name;
        this.Student_Num = Student_Num;
        this.Phone_Num = Phone_Num;
        this.Email = Email;
    }




    protected boolean checkUser(){

        return false;
    }



}
