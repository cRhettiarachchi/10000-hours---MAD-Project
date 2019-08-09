package com.example.a10000hours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    private Button buttonAddGoal;
    private ImageView imageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        buttonAddGoal = findViewById(R.id.button2);
        imageEdit = findViewById(R.id.imageView25);

        buttonAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGoal();
            }
        });
        imageEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGoal();
            }
        });
    }

    public void addGoal() {
        Intent intent = new Intent(this, AddGoal.class);
        startActivity(intent);
    }

    public void editGoal() {
        Intent intent = new Intent(this, EditGoal.class);
        startActivity(intent);
    }
}
