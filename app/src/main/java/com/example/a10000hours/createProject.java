package com.example.a10000hours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class createProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);

//        navigateBar();
    }

//    private void navigateBar() {
//
//        ImageView home = (ImageView) findViewById(R.id.homeImage);
//        ImageView allProjects = (ImageView) findViewById(R.id.allProjectsImg);
//        ImageView addProjects = (ImageView) findViewById(R.id.newProjectImg);
//        //    ImageView userAcc = (ImageView) findViewById(R.id.homeImage);
//        //    ImageView settings = (ImageView) findViewById(R.id.homeImage);
//
//
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent1 = new Intent(createProject.this, MainActivity.class);
//                startActivity(intent1);
//            }
//        });
//
//        allProjects.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent2 = new Intent(createProject.this, AllProjects.class);
//                startActivity(intent2);
//            }
//        });
//
//        addProjects.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent3 = new Intent(createProject.this, createProject.class);
//                startActivity(intent3);
//            }
//        });

        /*
        userAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4 = new Intent(createProject.this, AllProjects.class);
                startActivity(intent4);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent5 = new Intent(createProject.this, AllProjects.class);
                startActivity(intent5);
            }
        });

        */
//    }

}
