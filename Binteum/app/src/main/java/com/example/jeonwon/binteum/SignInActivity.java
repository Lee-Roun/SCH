package com.example.jeonwon.binteum;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SignInActivity extends AppCompatActivity {

    EditText editTextID, editTextPW, editTextPWCF, editTextUniv, editTextField, editTextEmail;
    RadioGroup radioGroup;
    Button buttonCancle, buttonSignIn;
    SharedPreferences myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        myInfo = getSharedPreferences("myInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = myInfo.edit();

        editTextID = (EditText)findViewById(R.id.editTextSignID);
        editTextPW= (EditText)findViewById(R.id.editTextSignPW);
        editTextPWCF= (EditText)findViewById(R.id.editTextSignPWCF);
        editTextUniv = (EditText)findViewById(R.id.editTextSignUniv);
        editTextField = (EditText)findViewById(R.id.editTextSignField);
        editTextEmail = (EditText)findViewById(R.id.editTextSignEmail);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupGender);

        buttonCancle = (Button)findViewById(R.id.buttonCancle);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                finish();
            }
        });


    }
}
