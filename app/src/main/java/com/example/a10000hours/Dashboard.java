package com.example.a10000hours;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.adapter.HistoryListAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Database.DBHelper;
=======
>>>>>>> 8f14c7cdcb94c8066f859ea6911be84565c47bf2

public class Dashboard extends AppCompatActivity {

    private Button buttonAddGoal;
    private ImageButton deleteGoal;
    private ImageView imageEdit;
    static String id;

    private ArrayList<String> hoursArray = new ArrayList<>();
    private ArrayList<String> dateArray = new ArrayList<>();

    DBHelper db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        db = new DBHelper(this);

        cursor = db.viewAllRecords();

        display();
//        displayRecords();

        buttonAddGoal = findViewById(R.id.button2);
        deleteGoal = findViewById(R.id.btnDeleteGoal);
//        imageEdit = findViewById(R.id.imageView25);

        buttonAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGoal();
            }
        });

//        imageEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                editGoal();
//            }
//        });

        deleteGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteGoal();
            }
        });

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");
    }

    public void display(){

        TextView userText1 = (TextView)findViewById(R.id.goalHoursView);
        TextView userText2 = (TextView)findViewById(R.id.dashboardProjectName);
        TextView userText3 = (TextView)findViewById(R.id.dashboardDueDate);

        Cursor cursor = db.viewGoal();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"Error reading data",Toast.LENGTH_LONG).show();
            return;
        }

        while(cursor.moveToNext()){
            userText1.setText(cursor.getString(2).toString());
            userText2.setText(cursor.getString(1).toString());
            userText3.setText(cursor.getString(3).toString());
            this.id = cursor.getString(0).toString();
        }
    }

    public void displayRecords(){

        TextView userText1 = (TextView)findViewById(R.id.noRecordsView);

        Cursor cursor = db.noRecords();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"Error reading data",Toast.LENGTH_LONG).show();
            return;
        }

        while(cursor.moveToNext()){
            userText1.setText(cursor.getString(1).toString());

        }
    }

    public void deleteGoal(){
        Cursor cursor = db.viewGoal();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"Error reading data",Toast.LENGTH_LONG).show();
            return;
        }

        while(cursor.moveToNext()) {
            this.id = cursor.getString(1).toString();

            int result = db.deleteUser(this.id);

            if (result == 1) {
                Toast.makeText(getApplicationContext(), "Deleted User", Toast.LENGTH_LONG).show();
                dashboard();
            } else {
                Toast.makeText(getApplicationContext(), "Deleting is  Unsuccess", Toast.LENGTH_LONG).show();
                dashboard();
            }
        }
    }

    public void addGoal() {
        Intent intent = new Intent(this, AddGoal.class);
        startActivity(intent);
    }

//    public void editGoal() {
//        Intent intent = new Intent(this, EditGoal.class);
//        startActivity(intent);
//    }

    public void dashboard() {
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
    }
}
