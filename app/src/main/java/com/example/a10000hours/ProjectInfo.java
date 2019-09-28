package com.example.a10000hours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import Database.DBHelper;

public class ProjectInfo extends AppCompatActivity {

    private static final String TAG = "ProjectInfo";
    private static String TaskName, totalTime;
    private static Double total;
    private static int taskIcon;
    ImageView mainIcon;
    TextView proName,totHours;
    DBHelper dbHelper;
    static double TOTAL;
    Cursor cursorTime;
    int del;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_info);

        mainIcon = findViewById(R.id.taskIcon);
        proName = findViewById(R.id.taskName);
        totHours = findViewById(R.id.totalHours);

        TaskName = getIntent().getStringExtra("Task_Name");
        dbHelper = new DBHelper(this);
        setValues();
        navigateBar();

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Project Info");
    }

    private void setValues(){
        taskIcon = dbHelper.getAproject(TaskName);
        cursorTime = dbHelper.viewAllRecords();
        totalTime = "0.0";
        TOTAL = 0;

        while (cursorTime.moveToNext()){
            String mHistory_titles = cursorTime.getString(1);
            String mHistory_time = cursorTime.getString(3);

            Log.d(TAG, "2nd task name is:"+mHistory_titles);
            Log.d(TAG, "2nd task name's time is:"+mHistory_time);

            if(TaskName.equals(mHistory_titles)){
                double value = Double.parseDouble(mHistory_time);
                TOTAL = TOTAL + value;
                Log.d(TAG,"Inside 2nd while Loop,total is:"+TOTAL);
            }

        }
        cursorTime.close();

        totalTime = Double.toString(TOTAL);

        proName.setText(TaskName);
        mainIcon.setImageResource(taskIcon);
        totHours.setText(totalTime);

    }

    public void deleteProject(View view){
        del = dbHelper.deleteTask(TaskName);
        Intent intentD = new Intent(this, MainActivity.class);
        startActivity(intentD);
    }

    public void editProject(View view){
        Intent intentX = new Intent(this, EditProject.class);
        intentX.putExtra("Task_Name", TaskName);
        startActivity(intentX);
    }

    private void navigateBar() {

        ImageView home = (ImageView) findViewById(R.id.homeImage);
        ImageView allProjects = (ImageView) findViewById(R.id.allProjectsImg);
        ImageView addProjects = (ImageView) findViewById(R.id.newProjectImg);
        ImageView userAcc = (ImageView) findViewById(R.id.homeImage);
        ImageView dashboard = (ImageView) findViewById(R.id.dashboardImg);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(ProjectInfo.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        allProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(ProjectInfo.this, AllProjects.class);
                startActivity(intent2);
            }
        });

        addProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(ProjectInfo.this, createProject.class);
                startActivity(intent3);
            }
        });

        userAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(ProjectInfo.this, userAccount.class);
                startActivity(intent4);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(ProjectInfo.this, Dashboard.class);
                startActivity(intent5);
            }
        });

    }

}
