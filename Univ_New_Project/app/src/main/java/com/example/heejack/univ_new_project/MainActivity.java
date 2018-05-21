package com.example.heejack.univ_new_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btnWrite1, btnWrite2, btnEnd, btnOK;
    TextView txtView1;

    Random  random = new Random();

    int r, count;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btnEnd = (Button) findViewById(R.id.buttonFinish);
        btnWrite1 = (Button) findViewById(R.id.buttonSimple);
        btnWrite2 = (Button) findViewById(R.id.buttonInput);

        btnEnd.setOnClickListener(this);
        btnWrite1.setOnClickListener(this);
        btnWrite2.setOnClickListener(this);



//내부 익명 클래스
        btnWrite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        btnWrite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "단순출력", Toast.LENGTH_LONG).show();
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "종료", Toast.LENGTH_LONG).show();
            }
        });


    }
    */
//액티비티 자체
    @Override
    public void onClick(View view) {
        /*
        switch (view.getId()) {
            case R.id.buttonSimple:
                Toast.makeText(MainActivity.this, "단순출력", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonInput:
                if(editText.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "내용을 입력하세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.buttonFinish:
                Toast.makeText(MainActivity.this, "종료", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.buttonOK:*/
                int result = Integer.parseInt(editText.getText().toString());
                if(editText.getText().toString().equals("")){
                    txtView1.setText("결과 : 입력된 내용이 없습니다.");
                }
                else if(result >1000 || result <500){
                    txtView1.setText("결과 : 입력한 값이 500~1000을 벗어났습니다");
                }
                else if(result == r){
                    txtView1.setText("결과 : "+count+" 번 째에 맞추셨습니다!!");
                }
                else if(result > r){
                    txtView1.setText("결과 : "+result +" 보다 작은 값입니다.");
                    count++;
                }
                else if(result < r){
                    txtView1.setText("결과 : "+result+" 보다 큰 값입니다.");
                    count++;
                }
                /*
            default:
                break;
        }
        */
    }
    /*
    //애부 클래스
    class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.buttonSimple:
                    Toast.makeText(MainActivity.this, "단순출력", Toast.LENGTH_LONG).show();
                case R.id.buttonInput:
                    Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_LONG).show();
                case R.id.buttonFinish:
                    Toast.makeText(MainActivity.this, "종료", Toast.LENGTH_LONG).show();

            }
        }
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex2);

        r = random.nextInt(501)+500;
        count =0;

        Toast.makeText(MainActivity.this, Integer.toString(r), Toast.LENGTH_SHORT).show();

        editText = (EditText)findViewById(R.id.editText2);
        btnOK = (Button)findViewById(R.id.buttonOK);
        txtView1 = (TextView)findViewById(R.id.textViewResult);


        btnOK.setOnClickListener(this);


    }


}