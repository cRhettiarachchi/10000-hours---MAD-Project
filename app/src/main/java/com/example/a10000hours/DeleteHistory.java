package com.example.a10000hours;

import android.content.Intent;
import android.database.Cursor;
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

import com.example.a10000hours.adapter.DeleteHistoryAdapter;
import Database.DBHelper;

import java.util.ArrayList;

public class DeleteHistory extends AppCompatActivity {

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
        setContentView(R.layout.activity_delete_history);

        // ----------------------------------------------//
        // Custom Toolbar Properties
        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Delete History");

        db = new DBHelper(this);

        cursor = db.viewAllRecords(); // read all records from the database

        initImageBitmaps();

    }

    private void initImageBitmaps() {
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
            RecyclerView recyclerView = findViewById(R.id.delete_history_recyclerView);
            DeleteHistoryAdapter deleteHistoryAdapter = new DeleteHistoryAdapter(this, mHistory_dates, mHistory_titles, mHistory_time, mHistory_id);
            recyclerView.setAdapter(deleteHistoryAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            Intent intent = new Intent(this, History.class);
            startActivity(intent);
        }

        @Override
            public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.delete_history_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){

                case android.R.id.home:
                    NavUtils.navigateUpFromSameTask(this);
                    return true;

                case R.id.done:
                    startActivity(new Intent(this, History.class));
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
}
