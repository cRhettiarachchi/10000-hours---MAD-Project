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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.a10000hours.adapter.HomeRVAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> testPNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("10000 Hours");

        navigateBar();
//        addActivity();

        //------------------------
        testPNames.add("robotics");
        testPNames.add("mobile apps");
        testPNames.add("Web Development");
        testPNames.add("watching tutorials");
        testPNames.add("play chess");

        initRecyclerView();


    }

    private void initRecyclerView() {
        //Log.d(TAG,"initRecyclerView methoed called");
        RecyclerView recyclerView = findViewById(R.id.homeRecyclerView);
        HomeRVAdapter homeRVAdapter = new HomeRVAdapter(this,testPNames);
        recyclerView.setAdapter(homeRVAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addActivity(){
        startActivity(new Intent(MainActivity.this, AddPop.class));
    /*    ImageView addBtn = (ImageView) findViewById(R.id.exId1);
        ImageView addBtn1 = (ImageView) findViewById(R.id.exId4);
        ImageView addBtn2= (ImageView) findViewById(R.id.exId3);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddPop.class));
            }
        });

        addBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddPop.class));
            }
        });

        addBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddPop.class));
            }
        }); */
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

                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

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

                Intent intent4 = new Intent(MainActivity.this, userAccount.class);
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
}
