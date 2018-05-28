package com.example.jeonwon.binteum;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
                User user = MainActivity.dbHelper.checkUser(editTextID.getText().toString());
                if(editTextID.getText().toString().equals(user.getID()) && editTextPW.getText().toString().equals(user.getPW())){
                    editor.putBoolean("LOGINCHK", true);
                    editor.putString("ID", editTextID.getText().toString());
                    editor.putString("PW", user.getPW().toString());
                    editor.putString("NAME", user.getNAME().toString());
                    editor.putString("GENDER", user.getGENDER().toString());
                    editor.putString("UNIV", user.getUNIV().toString());
                    editor.putString("FIELD", user.getFIELD().toString());
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
