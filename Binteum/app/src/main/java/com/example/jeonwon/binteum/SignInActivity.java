package com.example.jeonwon.binteum;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SignInActivity extends AppCompatActivity {

    EditText editTextID, editTextPW, editTextPWCF, editTextUniv, editTextField, editTextEmail, editTextName;
    RadioGroup radioGroup;
    Button buttonCancle, buttonSignIn;
    SharedPreferences myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_signin);

        myInfo = getSharedPreferences("myInfo", MODE_PRIVATE);
        SharedPreferences.Editor editor = myInfo.edit();

        editTextID = (EditText)findViewById(R.id.editTextSignID);
        editTextPW= (EditText)findViewById(R.id.editTextSignPW);
        editTextPWCF= (EditText)findViewById(R.id.editTextSignPWCF);
        editTextUniv = (EditText)findViewById(R.id.editTextSignUniv);
        editTextField = (EditText)findViewById(R.id.editTextSignField);
        editTextName = (EditText)findViewById(R.id.editTextSignName);
        editTextEmail = (EditText)findViewById(R.id.editTextSignEmail);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroupGender);
        final String[] gender = {null};
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (radioGroup.getId()){
                    case R.id.radioButtonMan:
                        gender[0] = "MAN";
                        break;
                    case R.id.radioButtonWoman:
                        gender[0] = "WOMAN";
                        break;
                }
            }
        });

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
                User user = new User();
                user.setID(editTextID.getText().toString());
                user.setPW(editTextPW.getText().toString());
                user.setUNIV(editTextUniv.getText().toString());
                user.setFIELD(editTextField.getText().toString());
                user.setEMAIL(editTextEmail.getText().toString());
                user.setNAME(editTextName.getText().toString());
                user.setGENDER(gender[0]);
                MainActivity.dbHelper.addUser(user);
                finish();
            }
        });


    }
}
