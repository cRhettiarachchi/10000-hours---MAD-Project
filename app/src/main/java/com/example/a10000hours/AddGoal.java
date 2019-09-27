package com.example.a10000hours;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import Database.DBHelper;
=======
>>>>>>> 8f14c7cdcb94c8066f859ea6911be84565c47bf2


public class AddGoal extends AppCompatActivity {

    private Button buttonAddGoal;

    EditText txt_name, long_goal, txt_date;
    DBHelper db;
    MainActivity mainActivity;
    String name, goal, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Goals");

        this.buttonAddGoal = findViewById(R.id.btnAddGoal);
        this.txt_name = findViewById(R.id.goalProjectName);
        this.long_goal = findViewById(R.id.goalHours);
        this.txt_date = findViewById(R.id.goalDate);
        this.db = new DBHelper(this);


        buttonAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = txt_name.getText().toString();
                goal = long_goal.getText().toString();
                date = txt_date.getText().toString();

                boolean result = db.addGoal(name, goal, date);

                if (result) {
                    Toast.makeText(getApplicationContext(), "Goal added", Toast.LENGTH_LONG).show();
                    dashboard();
                } else {
                    Toast.makeText(getApplicationContext(), "Error in adding goal", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void dashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}
