package com.example.a10000hours;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import Database.DBHelper;

public class SignIn extends AppCompatActivity {
    public static final String EXTRA_EMAIL =
            "send email";
    EditText txt_Email,txt_password;
    String email,password;
    Button btn_signIn;
    DBHelper db;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Sign in");

        db = new DBHelper(this);
        txt_Email = findViewById(R.id.email);
        txt_password = findViewById(R.id.password);
        btn_signIn = findViewById(R.id.signin);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassowrd();
            }
        });

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = txt_Email.getText().toString().trim();
                password = txt_password.getText().toString().trim();
                Boolean res = db.checkUser(email,password);

                if (res == true){
                    Toast.makeText(getApplicationContext(),"Successfully Login",Toast.LENGTH_LONG).show();
                    userProfile();
                }else{
                    Toast.makeText(getApplicationContext(),"Login error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void resetPassowrd(){
        Intent intent = new Intent(this,ResetPassword.class);
        startActivity(intent);
    }

    public void userProfile(){
        Intent intent = new Intent(this,Userprofile.class);
        intent.putExtra(EXTRA_EMAIL,email);

        startActivity(intent);
    }
}
