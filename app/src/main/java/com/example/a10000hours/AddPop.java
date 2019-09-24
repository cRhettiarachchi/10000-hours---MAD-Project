package com.example.a10000hours;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

import androidx.appcompat.app.AppCompatActivity;

public class AddPop extends AppCompatActivity {

    TextView taskName;
    EditText time_txt, description_text;
    DBHelper db;
    String description, TaskName;
    double time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.7));

        addClick();
        grabIntent();

        db = new DBHelper(this);
    }

    private void addClick(){
        Button btn = findViewById(R.id.addRecordBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get date from user
                time_txt = findViewById(R.id.time_txt);
                description_text = findViewById(R.id.description_text);

                // Add data to String variables
                description = description_text.getText().toString();
                time = Double.parseDouble(time_txt.getText().toString());
                if(db.addRecord("22/01", time, description, TaskName)){
                    Intent intent = new Intent(AddPop.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Data insert Fail", Toast.LENGTH_SHORT).show();
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
