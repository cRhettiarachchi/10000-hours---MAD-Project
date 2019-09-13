package com.example.a10000hours;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10000hours.adapter.HistoryListAdapter;

import java.util.ArrayList;

public class History extends AppCompatActivity {


    private ArrayList<String> mHistory_dates = new ArrayList<>();
    private ArrayList<String> mHistory_titles = new ArrayList<>();
    private ArrayList<String> mHistory_time = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("History");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d("", "working Init Bitmaps");

        int i = 0;
        while(i < 100){
            mHistory_dates.add("11/05");
            mHistory_titles.add("Android : " + i);
            mHistory_time.add("4.00 hrs");
            i++;
        }


        initRecycleView();

    }

    private void initRecycleView(){
        Log.d("", "initRecyclerView working");
        RecyclerView recyclerView = findViewById(R.id.history_recyclerView);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter(this, mHistory_dates, mHistory_titles, mHistory_time);
        recyclerView.setAdapter(historyListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
