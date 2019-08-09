package com.example.a10000hours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddGoal extends AppCompatActivity {

    private Button buttonAddGoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        this.buttonAddGoal = findViewById(R.id.button5);

        buttonAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGoal();
            }
        });
    }

    public void addGoal(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
