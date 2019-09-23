package com.example.a10000hours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Database.DBHelper;

public class editUserProfile extends AppCompatActivity{
    DBHelper dbh;
    String Email,Username,Userid,Password,UserName,EmailUI,UserID,PasswordUser;
    EditText editTextEmail,textName1,editTextName,editTextName2;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_userprofile);

          dbh = new DBHelper(this);
        Intent intent = getIntent();

           Email = intent.getStringExtra(Userprofile.EXTRA_EMAIL);
           Username = intent.getStringExtra(Userprofile.EXTRA_USERNAME);
           Userid = intent.getStringExtra(Userprofile.EXTRA_USERID);
           Password = intent.getStringExtra(Userprofile.EXTRA_PASSWORD);

        update = findViewById(R.id.btn_update);
        EditText editTextEmail = (EditText)findViewById(R.id.displayEmail);
        TextView textName1 = (TextView) findViewById(R.id.displayUser);
        EditText editTextName = (EditText)findViewById(R.id.displayUsername);
        EditText editTextPass = (EditText)findViewById(R.id.displayPass);
        textName1.setText(Username);
        editTextEmail.setText(Email);
        editTextName.setText(Username);
        editTextPass.setText(Password);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInfo();
            }
        });

    }

    public void updateInfo(){
        EditText email = findViewById(R.id.displayEmail);
        EditText username = findViewById(R.id.displayUsername);
        EditText password = findViewById(R.id.displayPass);

        EmailUI =  email.getText().toString();
        UserName = username.getText().toString();
        PasswordUser = password.getText().toString();
        UserID = Userid.toString();


       int result = dbh.updateUser(UserID,UserName,EmailUI,PasswordUser);


        if(result > 0){
            Toast.makeText(getApplicationContext(),"Updating Success",Toast.LENGTH_LONG).show();
            LoginPage();

        }else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }

    }
    public void LoginPage(){
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }

}
