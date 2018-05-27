package com.example.jeonwon.binteum;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class PopUpDetailActivity extends AppCompatActivity {
    TextView textViewNum, textViewName, textViewTime, textViewProf, textViewLang, textViewGrade, textViewType, textViewTarget, textViewUniv;
    Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams= new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_popup_detail);

        buttonOK = (Button)findViewById(R.id.buttonDetailOK);

        textViewNum = (TextView) findViewById(R.id.textViewNum);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        textViewProf = (TextView) findViewById(R.id.textViewProfessor);
        textViewLang = (TextView) findViewById(R.id.textViewLang);
        textViewGrade = (TextView) findViewById(R.id.textViewGrade);
        textViewType = (TextView) findViewById(R.id.textViewType);
        textViewTarget = (TextView) findViewById(R.id.textViewTarget);
        textViewUniv = (TextView) findViewById(R.id.textViewUniv);

        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("Lecture");

        textViewNum.setText(data[1]);
        textViewName.setText(data[2]);
        textViewTime.setText(data[3]);
        textViewProf.setText(data[10]);
        textViewLang.setText(data[11]);
        textViewGrade.setText(data[12]);
        textViewType.setText(data[13]);
        textViewTarget.setText(data[14]);
        textViewUniv.setText(data[16]);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
