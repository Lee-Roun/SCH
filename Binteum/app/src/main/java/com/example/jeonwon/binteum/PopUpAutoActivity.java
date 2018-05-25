package com.example.jeonwon.binteum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class PopUpAutoActivity extends AppCompatActivity {
    TextView textViewMonStart, textViewMonEnd, textViewThuStart, textViewThuEnd, textViewWedStart, textViewWedEnd, textViewThrStart, textViewThrEnd, textViewFriStart, textViewFriEnd;
    Button buttonCancle, buttonSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);
        setContentView(R.layout.activity_popup_auto);

        buttonCancle = (Button)findViewById(R.id.button2);
        buttonSet = (Button)findViewById(R.id.button);

        buttonCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textViewMonStart = (TextView) findViewById(R.id.textViewMonStart);
        textViewMonEnd = (TextView) findViewById(R.id.textViewMonEnd);
        textViewThuStart = (TextView) findViewById(R.id.textViewThuStart);
        textViewThuEnd = (TextView) findViewById(R.id.textViewThuEnd);
        textViewWedStart = (TextView) findViewById(R.id.textViewWedStart);
        textViewWedEnd = (TextView) findViewById(R.id.textViewWedEnd);
        textViewThrStart = (TextView) findViewById(R.id.textViewThrStart);
        textViewThrEnd = (TextView) findViewById(R.id.textViewThrEnd);
        textViewFriStart = (TextView) findViewById(R.id.textViewFriStart);
        textViewFriEnd = (TextView) findViewById(R.id.textViewFriEnd);

        textViewMonStart.setOnClickListener(new onClickListener());
        textViewMonEnd.setOnClickListener(new onClickListener());
        textViewThuStart.setOnClickListener(new onClickListener());
        textViewThuEnd.setOnClickListener(new onClickListener());
        textViewWedStart.setOnClickListener(new onClickListener());
        textViewWedEnd.setOnClickListener(new onClickListener());
        textViewThrStart.setOnClickListener(new onClickListener());
        textViewThrEnd.setOnClickListener(new onClickListener());
        textViewFriStart.setOnClickListener(new onClickListener());
        textViewFriEnd.setOnClickListener(new onClickListener());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    public class onClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            DateDialog dateDialog = new DateDialog(PopUpAutoActivity.this);

            switch (view.getId()) {
                case R.id.textViewMonStart:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewMonStart.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewMonEnd:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewMonEnd.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewThuStart:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewThuStart.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewThuEnd:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewThuEnd.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewWedStart:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewWedStart.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewWedEnd:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewWedEnd.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewThrStart:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewThrStart.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewThrEnd:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewThrEnd.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewFriStart:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewFriStart.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
                case R.id.textViewFriEnd:
                    dateDialog.setDateDialogListener(new DateDialog.DateDialogListener() {
                        @Override
                        public void OnDateValidate(String time) {
                            textViewFriEnd.setText(time);
                        }
                    });
                    dateDialog.show();
                    break;
            }
        }

    }
}

