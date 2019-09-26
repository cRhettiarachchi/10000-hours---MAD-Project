package com.example.a10000hours;

import android.content.Intent;
import android.os.Bundle;
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

    private ArrayList<String> testPNames = new ArrayList<>();
    private ArrayList<String> testHours = new ArrayList<>();
    private List<String> AllTasks = new  ArrayList<>();
    private List<String> AllTimes = new  ArrayList<>();
    private List<Integer> AllIcons = new  ArrayList<>();
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_projects);

        dbHelper = new DBHelper(this);
        AllTasks = dbHelper.getAllTaskNames();
        AllTimes = dbHelper.getAllTotalTimes();
        AllIcons = dbHelper.getAllTaskImages();

        testPNames.add("robotics");
        testPNames.add("mobile apps");
        testPNames.add("Web Development");
        testPNames.add("watching tutorials");
        testPNames.add("play chess");

        testHours.add("10.5");
        testHours.add("20.4");
        testHours.add("9.8");
        testHours.add("1.5");
        testHours.add("17.3");

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("All Projects");
        navigateBar();
        projectInfo();
        initRecyclerView2();
    }

    private void initRecyclerView2() {
        //Log.d(TAG,"initRecyclerView2 methoed called");
        RecyclerView infoRecyclerView = findViewById(R.id.proInfoRV);
        ProjectInfoRVAdapter infoAdapter = new ProjectInfoRVAdapter(this,AllTasks,AllTimes,AllIcons);
        infoRecyclerView.setAdapter(infoAdapter);
        infoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void projectInfo() {

        //ImageView proInfo = (ImageView) findViewById(R.id.imageView1);

        //proInfo.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {

         //       Intent intent = new Intent(AllProjects.this, ProjectInfo.class);
           //     startActivity(intent);
            //}
        //});

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
