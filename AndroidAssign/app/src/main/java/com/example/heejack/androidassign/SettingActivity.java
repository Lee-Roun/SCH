package com.example.heejack.androidassign;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    private static final int REQ_UNIV = 996;
    private static final int REQ_FIELD = 996;

    TextView id, name, gender, univ, field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        id = (TextView)findViewById(R.id.textViewID);
        name = (TextView)findViewById(R.id.textViewName);
        gender = (TextView)findViewById(R.id.textViewGender);
        univ = (TextView)findViewById(R.id.textViewUniv);
        field = (TextView)findViewById(R.id.textViewField);

        //Preference 불러와서 사용자 정보 저장
        final SharedPreferences myInfo = getSharedPreferences("myInfo", MODE_PRIVATE);
        id.setText(myInfo.getString("ID","NO LOGIN"));
        name.setText(myInfo.getString("NAME","NO LOGIN"));
        gender.setText(myInfo.getString("GENDER","NO LOGIN"));
        univ.setText(myInfo.getString("UNIV","NO LOGIN"));
        field.setText(myInfo.getString("FIELD","NO LOGIN"));

        //TextView 리스너
        univ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, PopUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("VALUE", "UNIV");
                intent.putExtra("UNIV", myInfo.getString("UNIV", ""));
                startActivityForResult(intent, REQ_UNIV);

            }
        });
        field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, PopUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.putExtra("VALUE", "FIELD");
                intent.putExtra("FIELD", myInfo.getString("FIELD", ""));
                startActivityForResult(intent, REQ_FIELD);

            }
        });


        SharedPreferences.Editor editor = myInfo.edit();
        editor.putBoolean("LOGINCHK", false);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




    }
}
