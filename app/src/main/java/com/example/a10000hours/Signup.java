package com.example.a10000hours;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import Database.DBHelper;

public class Signup extends AppCompatActivity {

    EditText txt_userName, txt_password,txt_email;
    DBHelper db;
    MainActivity mainActivity;
    String userName,password,email;
    private Button addUser;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Sign up");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        txt_userName = findViewById(R.id.txtUserName);
        txt_email = findViewById(R.id.txtEmail);
        txt_password = findViewById(R.id.txtPassword);
        addUser = findViewById(R.id.btnAdd);
        db = new DBHelper(this);



        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
        awesomeValidation.addValidation(this, R.id.txtUserName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.usernameerror);
        awesomeValidation.addValidation(this, R.id.txtEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this,R.id.txtPassword,regexPassword,R.string.passworderror);


        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               userName = txt_userName.getText().toString();
               password = txt_password.getText().toString();
               email = txt_email.getText().toString();

             if(awesomeValidation.validate()){
   /*              if ((userName.equals(""))||(email.equals(""))||(password.equals("")))
                 {
                     Toast.makeText(getApplicationContext(),"Filed must Filled",Toast.LENGTH_LONG).show();
                 }*/

                 boolean result = db.addUser(userName, password, email);

                 if (result) {
                     Toast.makeText(getApplicationContext(), "Registered success", Toast.LENGTH_LONG).show();
                     userProfile();
                 } else {
                     Toast.makeText(getApplicationContext(), "Error in Registering", Toast.LENGTH_LONG).show();
                 }

             }

               else {
                 Toast.makeText(getApplicationContext(), "Filled must filled", Toast.LENGTH_LONG).show();
               }

            }
        });

    }

    public void  userProfile(){
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }



}