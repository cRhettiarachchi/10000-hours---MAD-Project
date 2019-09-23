package com.example.a10000hours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class AllProjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_projects);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("All Projects");
        navigateBar();
        projectInfo();
    }

    private void projectInfo() {

        ImageView proInfo = (ImageView) findViewById(R.id.imageView1);

        proInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AllProjects.this, ProjectInfo.class);
                startActivity(intent);
            }
        });

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
