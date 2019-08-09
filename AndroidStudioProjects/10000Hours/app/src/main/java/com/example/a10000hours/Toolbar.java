package com.example.a10000hours;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Toolbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_bar);
        try{
            getActionBar().setHomeButtonEnabled(true);
        }catch (Exception e){
            System.out.println("exception");
        }

    }
}
