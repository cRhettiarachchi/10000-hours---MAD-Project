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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

public class createProject extends AppCompatActivity {

    EditText projectName;
    ImageView projectImage1,projectImage2,projectImage3,projectImage4;
    ImageView projectImage5,projectImage6,projectImage7,projectImage8;
    ImageView projectImage9,projectImage10,projectImage11,projectImage12;
    ImageView projectImage13,projectImage14,projectImage15,projectImage16;
    String name;
    static String icon = "@drawable/icon1";
    Button saveBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);


        projectName = findViewById(R.id.proName);
        db = new DBHelper(this);

        projectImage1 = findViewById(R.id.tIcon1);
        projectImage2 = findViewById(R.id.tIcon2);
        projectImage3 = findViewById(R.id.tIcon3);
        projectImage4 = findViewById(R.id.tIcon4);
        projectImage5 = findViewById(R.id.tIcon5);
        projectImage6 = findViewById(R.id.tIcon6);
        projectImage7 = findViewById(R.id.tIcon7);
        projectImage8 = findViewById(R.id.tIcon8);
        projectImage9 = findViewById(R.id.tIcon9);
        projectImage10 = findViewById(R.id.tIcon10);
        projectImage11 = findViewById(R.id.tIcon11);
        projectImage12 = findViewById(R.id.tIcon12);
        projectImage13 = findViewById(R.id.tIcon13);
        projectImage14 = findViewById(R.id.tIcon14);
        projectImage15 = findViewById(R.id.tIcon15);
        projectImage16 = findViewById(R.id.tIcon16);


        projectImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon1";
                Toast.makeText(getApplicationContext(),"Icon 1 selected",Toast.LENGTH_LONG).show();
            }
        });

        projectImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon2";
                Toast.makeText(getApplicationContext(),"Icon 2 selected",Toast.LENGTH_LONG).show();
            }
        });

        projectImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon3";
                Toast.makeText(getApplicationContext(),"Icon 3 selected",Toast.LENGTH_LONG).show();
            }
        });

        projectImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon4";
                Toast.makeText(getApplicationContext(),"Icon 4 selected",Toast.LENGTH_LONG).show();
            }
        });

        projectImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon5";
                Toast.makeText(getApplicationContext(),"Icon 5 selected",Toast.LENGTH_LONG).show();
            }
        });

        projectImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon6";
                Toast.makeText(getApplicationContext(),"Icon 6 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon7";
                Toast.makeText(getApplicationContext(),"Icon 7 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon9";
                Toast.makeText(getApplicationContext(),"Icon 9 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon10";
                Toast.makeText(getApplicationContext(),"Icon 10 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon11";
                Toast.makeText(getApplicationContext(),"Icon 11 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon12";
                Toast.makeText(getApplicationContext(),"Icon 12 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon13";
                Toast.makeText(getApplicationContext(),"Icon 13 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon14";
                Toast.makeText(getApplicationContext(),"Icon 14 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon15";
                Toast.makeText(getApplicationContext(),"Icon 15 selected",Toast.LENGTH_LONG).show();

            }
        });

        projectImage16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon = "@drawable/icon16";
                Toast.makeText(getApplicationContext(),"Icon 16 selected",Toast.LENGTH_LONG).show();

            }
        });


        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Record");
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

    public void saveProject(View view){

        name = projectName.getText().toString();
        //icon = projectImage.getText().toString();
        //icon = "testing.png";

        boolean result = db.addTask(name,icon);

        if(result){
            Toast.makeText(getApplicationContext(),"Adding Success",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }


    }


}

