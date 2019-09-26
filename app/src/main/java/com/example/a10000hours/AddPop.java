package com.example.a10000hours;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddPop extends AppCompatActivity {

    TextView taskName, displayDate;
    EditText time_txt, description_text;
    DBHelper db;
    String description, TaskName, dateFull, dateNoYear;
    Button btn;
    double time;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.7));

        // Get date from user
        time_txt = findViewById(R.id.time_txt);
        description_text = findViewById(R.id.description_text);
        displayDate = findViewById(R.id.add_record_date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFull = simpleDateFormat.format(calendar.getTime());

        displayDate.setText(dateFull);

        addClick();
        grabIntent();
        db = new DBHelper(this);
    }

    private void addClick(){
        btn = findViewById(R.id.addRecordBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add data to String variables

                // validate count
                int validate = time_txt.getText().toString().trim().length();

                if(validate != 0){
                    description = description_text.getText().toString();
                    time = Double.parseDouble(time_txt.getText().toString());

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                    dateNoYear = simpleDateFormat.format(calendar.getTime());

                    if(db.addRecord(dateNoYear, time, description, TaskName)){
                        onBackPressed();
                    }else {
                        Toast.makeText(getApplicationContext(), "Data insert Fail", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    time_txt.setError("Enter the time");
                }

            }
        });
    }

    private void grabIntent(){
        if(getIntent().hasExtra("Task_Name")){
            TaskName = getIntent().getStringExtra("Task_Name");
            setTaskName(TaskName);
        }else{
            Log.d("notWorking", "no intent to be found");
        }
    }

    private void setTaskName(String name){
        taskName = findViewById(R.id.add_record_task_name);
        taskName.setText(name);
    }
}
