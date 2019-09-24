package com.example.a10000hours;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddPop extends AppCompatActivity {

    TextView taskName;

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
    }

    private void addClick(){
        Button btn = findViewById(R.id.addRecordBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddPop.this, MainActivity.class));
            }
        });
    }

    private void grabIntent(){
        if(getIntent().hasExtra("Task_Name")){
            String TaskName = getIntent().getStringExtra("Task_Name");
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
