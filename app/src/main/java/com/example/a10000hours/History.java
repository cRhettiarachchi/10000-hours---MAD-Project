package com.example.a10000hours;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.adapter.HistoryListAdapter;

import java.util.ArrayList;
import Database.DBHelper;

public class History extends AppCompatActivity {


    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();
    private ArrayList<Integer> mHistory_id = new ArrayList<>();

    // Initialize db variable
    DBHelper db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("History");

        db = new DBHelper(this);

        cursor = db.viewAllRecords();

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d("", "working Init Bitmaps");

//        int i = 0;
//        while(i < 100){
//            mHistory_dates.add("11/05");
//            mHistory_titles.add("Android : " + i);
//            mHistory_time.add("4.00 hrs");
//            i++;
//        }

        while (cursor.moveToNext()){
            mHistory_id.add(cursor.getInt(0));
            mHistory_dates.add(cursor.getString(2));
            mHistory_titles.add(cursor.getString(1));
            mHistory_time.add(cursor.getString(3));
        }

        initRecycleView();

    }

    private void initRecycleView(){
        Log.d("", "initRecyclerView working");
        RecyclerView recyclerView = findViewById(R.id.history_recyclerView);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(this, mHistory_dates, mHistory_titles, mHistory_time, mHistory_id);
        recyclerView.setAdapter(historyListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.delete_history:
                startActivity(new Intent(this, DeleteHistory.class));
                return true;
            case R.id.edit_history:
                startActivity(new Intent(this, EditHistory.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
