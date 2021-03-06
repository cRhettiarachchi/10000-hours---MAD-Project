package com.example.a10000hours;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.adapter.ProjectInfoRVAdapter;
import java.util.ArrayList;
import java.util.List;

import Database.DBHelper;

public class AllProjects extends AppCompatActivity {

    private static final String TAG = "AllProjects";
    private List<Integer> AllTaskIDs = new  ArrayList<>();
    private List<String> AllTasks = new  ArrayList<>();
    private List<String> AllTimes = new  ArrayList<>();
    private List<Integer> AllIcons = new  ArrayList<>();
    DBHelper dbHelper;
    Cursor cursor,cursorTime;
    static double TOTAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_projects);

        dbHelper = new DBHelper(this);
        cursor = dbHelper.getAllTasks();
        cursorTime = dbHelper.viewAllRecords();

        while (cursor.moveToNext()){
            AllTaskIDs.add(cursor.getInt(0));
            String taskName = cursor.getString(1);
            AllTasks.add(taskName);
            AllIcons.add(cursor.getInt(2));

            TOTAL = 0.0;
            cursorTime = dbHelper.viewAllRecords();

            while (cursorTime.moveToNext()){
                String mHistory_titles = cursorTime.getString(1);
                String mHistory_time = cursorTime.getString(3);

                if(taskName.equals(mHistory_titles)){
                    double value = Double.parseDouble(mHistory_time);
                    TOTAL = TOTAL + value;
                    Log.d(TAG,"Inside 2nd while Loop,total is:"+TOTAL);
                }

            }
            cursorTime.close();
            AllTimes.add(Double.toString(TOTAL));
        }

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("All Projects");
        navigateBar();
        InitRecyclerView();
    }

    private void InitRecyclerView() {
        RecyclerView infoRecyclerView = findViewById(R.id.proInfoRV);
        ProjectInfoRVAdapter infoAdapter = new ProjectInfoRVAdapter(this,AllTaskIDs,AllTasks,AllTimes,AllIcons);
        infoRecyclerView.setAdapter(infoAdapter);
        infoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void navigateBar() {

        ImageView home = (ImageView) findViewById(R.id.homeImage);
        ImageView allProjects = (ImageView) findViewById(R.id.allProjectsImg);
        ImageView addProjects = (ImageView) findViewById(R.id.newProjectImg);
        ImageView userAcc = (ImageView) findViewById(R.id.userAccImg);
        ImageView dashboard = (ImageView) findViewById(R.id.dashboardImg);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(AllProjects.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        allProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(AllProjects.this, AllProjects.class);
                startActivity(intent2);
            }
        });

        addProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(AllProjects.this, createProject.class);
                startActivity(intent3);
            }
        });


        userAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(AllProjects.this, userAccount.class);
                startActivity(intent4);
            }
        });

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(AllProjects.this, Dashboard.class);
                startActivity(intent5);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.showHistory:
                startActivity(new Intent(this, History.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
