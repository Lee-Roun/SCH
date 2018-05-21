package com.example.heejack.androidassign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class MainActivity extends AppCompatActivity {
    private static final int REQESTCODE = 687;
    public static DBHelper dbHelper;
    FloatingActionButton floatingActionButton;
    private ListView listViewLecture, listViewMyLecture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewLecture = (ListView)findViewById(R.id.listViewAllLecture);


        if (dbHelper == null) {
            dbHelper = new DBHelper(getApplicationContext(), "LECTURE", null, 1);
            Excel();
            Toast.makeText(this, "DB생성 성공", Toast.LENGTH_SHORT).show();
        }

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, REQESTCODE);
            }
        });


    }

    public void Excel() {
        Workbook workbook = null;
        Sheet sheet = null;
        try {
            InputStream inputStream = getBaseContext().getResources().getAssets().open("lecture.xlsx");
            workbook = Workbook.getWorkbook(inputStream);
            sheet = workbook.getSheet(0);
            int MaxColumn = 10, RowStart = 1, RowEnd = sheet.getColumn(1).length - 1, ColumnStart = 0, ColumnEnd = sheet.getRow(1).length;

            String[] strings = new String[10];
            for (int row = RowStart; row <= RowEnd; row++) {
                for (int Column = ColumnStart; Column <= ColumnEnd; Column++) {
                    strings[Column] = sheet.getCell(row, Column).getContents();
                }
                Lecture lecture = new Lecture(strings);
                dbHelper.add(lecture);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (BiffException e2) {
            e2.printStackTrace();
        } finally {

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuProfile:
                //프로필 눌렀을때
                Toast.makeText(this, "설정", Toast.LENGTH_SHORT).show();

                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
