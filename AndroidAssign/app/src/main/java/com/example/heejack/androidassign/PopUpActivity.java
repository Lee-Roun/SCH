package com.example.heejack.androidassign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class PopUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        EditText editText = (EditText)findViewById(R.id.editTextContent);

        Intent intent = getIntent();

        String value = intent.getStringExtra("VALUE");

        switch (value){
            case "UNIV":
                editText.setHint(intent.getStringExtra("UNIV"));

                break;
            case "FIELD":
                editText.setHint(intent.getStringExtra("FIELD"));

                break;
        }









    }
}
