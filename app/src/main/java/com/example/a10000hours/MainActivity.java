package com.example.a10000hours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import Database.DBHelper;

import com.example.a10000hours.adapter.HomeRVAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_EMAIL =
            "send email";

    boolean doubleBackToExitPressedOnce = false;

    private ArrayList<String> testPNames = new ArrayList<>();
    private ArrayList<String> testHours = new ArrayList<>();
    private List<String> FromDatabase = new  ArrayList<>();
    DBHelper dbHelper;
    Boolean test;
    int del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        //test = dbHelper.addTask("testWeb",R.drawable.icon1);
        //test = dbHelper.addTask("watchTv",R.drawable.icon2);
        //test = dbHelper.addTask("SpringBoot",R.drawable.icon3);
        //test = dbHelper.addTask("mobileApp",R.drawable.icon4);
        //test = dbHelper.addTask("CyberSecurity",R.drawable.icon5);
        //del = dbHelper.deleteTask("testWeb");
        FromDatabase = dbHelper.getAllTaskNames();

        Toast.makeText(getApplicationContext(),"adding Success",Toast.LENGTH_LONG).show();

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("10000 Hours");

        navigateBar();

        //------------------------
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

        initRecyclerView();
        //initRecyclerView2();

    }

    private void initRecyclerView() {
        //Log.d(TAG,"initRecyclerView methoed called");
        RecyclerView recyclerView = findViewById(R.id.homeRecyclerView);
        HomeRVAdapter homeRVAdapter = new HomeRVAdapter(this,FromDatabase);
        recyclerView.setAdapter(homeRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toolbar toolbar = findViewById(R.id.historyToolbar);
//        setSupportActionBar(toolbar);
//        setTitle("10000 Hours");
//
//
//        navigateBar();
////        addActivity();
//
//        //------------------------
//        testPNames.add("robotics");
//        testPNames.add("mobile apps");
//        testPNames.add("Web Development");
//        testPNames.add("watching tutorials");
//        testPNames.add("play chess");
//
//        initRecyclerView();
//
//    }
//
//
//    private void initRecyclerView() {
//        //Log.d(TAG,"initRecyclerView methoed called");
//        RecyclerView recyclerView = findViewById(R.id.homeRecyclerView);
//        HomeRVAdapter homeRVAdapter = new HomeRVAdapter(this,testPNames);
//        recyclerView.setAdapter(homeRVAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

    private void navigateBar() {

        ImageView home = (ImageView) findViewById(R.id.homeImage);
        ImageView allProjects = (ImageView) findViewById(R.id.allProjectsImg);
        ImageView addProjects = (ImageView) findViewById(R.id.newProjectImg);
        ImageView userAcc = (ImageView) findViewById(R.id.userAccImg);
        ImageView dashboard = (ImageView) findViewById(R.id.dashboardImg);



        allProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainActivity.this, AllProjects.class);
                startActivity(intent2);
            }
        });

        addProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3 = new Intent(MainActivity.this, createProject.class);
                startActivity(intent3);
            }
        });


        userAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(MainActivity.this, Userprofile.class);
                startActivity(intent4);
            }
        });


        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(MainActivity.this, Dashboard.class);
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

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(a);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
