package com.example.a10000hours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class userAccount extends AppCompatActivity {

    private Button button;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("User Accounts");


        button =(Button) findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignuppage();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignInPage();
            }
        });
    }
    public  void openSignuppage()
    {
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void openSignInPage()
    {
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }
}
