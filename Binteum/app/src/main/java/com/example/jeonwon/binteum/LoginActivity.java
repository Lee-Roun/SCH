package com.example.jeonwon.binteum;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HeeJack on 2018-05-23.
 */

public class LoginActivity extends AppCompatActivity {

    Button buttonCancle, buttonLogIn, buttonSignIn;
    EditText editTextID, editTextPW;
    SharedPreferences myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myInfo = getSharedPreferences("myInfo", MODE_PRIVATE);
        final SharedPreferences.Editor editor = myInfo.edit();

        editTextID = (EditText)findViewById(R.id.editTextID);
        editTextPW = (EditText)findViewById(R.id.editTextPW);

        buttonCancle = (Button)findViewById(R.id.buttonCancle);
        buttonLogIn = (Button)findViewById(R.id.buttonLogin);
        buttonSignIn = (Button)findViewById(R.id.buttonSignIn);

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextID.getText().toString().equals("test") && editTextPW.getText().toString().equals("0000")){
                    editor.putBoolean("LOGINCHK", true);
                    editor.putString("ID", editTextID.getText().toString());
                    editor.putString("PW", "0000");
                    editor.putString("NAME", "이정원");
                    editor.putString("GENDER", "남자");
                    editor.putString("UNIV", "계명대");
                    editor.putString("FIELD", "컴퓨터공학과");
                    editor.commit();
                    Toast.makeText(LoginActivity.this, "환영합니다!", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(LoginActivity.this);

                    alertBuilder.setTitle("확인");
                    alertBuilder.setMessage("ID 또는 PW를 확인해주세요")
                            .setCancelable(false)
                            .setPositiveButton("확인",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });

                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();
                }
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
