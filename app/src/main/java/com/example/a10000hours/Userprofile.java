package com.example.a10000hours;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import Database.DBHelper;
import Database.AppDBMaster;

public class Userprofile extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;

    public static final String EXTRA_USERID = "send user id";
    public static final String EXTRA_PASSWORD = "send user password";
    public static final String EXTRA_EMAIL = "send email2";
    public static final String EXTRA_USERNAME = "send email";
    TextView txt_Email;
    Button deleteButton,editButton;
    DBHelper dbh;
    String Email,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        dbh = new DBHelper(this);
        Intent intent = getIntent();
        Email = intent.getStringExtra(SignIn.EXTRA_EMAIL);
        deleteButton = findViewById(R.id.btn_delete);
        editButton = findViewById(R.id.btn_edit);

        display(Email);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               editProfile();
            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AlertDialog.Builder abuilder = new AlertDialog.Builder(Userprofile.this);
               abuilder.setMessage("Do You Want to Remove this Account!!!")
                       .setCancelable(false)
                       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               deleteUser();
                           }
                       })
                       .setNegativeButton("No", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.cancel();
                           }
                       });
               AlertDialog alert = abuilder.create();
               alert.setTitle("Alert!!!");
               alert.show();

            }
        });


    }

    public void deleteUser(){
        int result = dbh.deleteUser(Email);

        if (result == 1){
            Toast.makeText(getApplicationContext(),"Deleted User",Toast.LENGTH_LONG).show();
            LoginPage();
        }else{
            Toast.makeText(getApplicationContext(),"Deleting is  Unsuccess",Toast.LENGTH_LONG).show();
            LoginPage();
        }
    }
    public void LoginPage(){
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }
   public void display(String Email){

        TextView userText1 = (TextView)findViewById(R.id.displayId);
        TextView userText2 = (TextView)findViewById(R.id.displayUsername);
        TextView userText3 = (TextView)findViewById(R.id.displayEmail);
        TextView userText  = (TextView)findViewById(R.id.displayUser);
       Cursor cursor = dbh.readData(Email);
       if(cursor.getCount()==0){
           Toast.makeText(getApplicationContext(),"halo",Toast.LENGTH_LONG).show();
          return;
       }
         StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            userText.setText(cursor.getString(1).toString());
            userText3.setText(cursor.getString(2).toString());
            userText2.setText(cursor.getString(1).toString());
           userText1.setText(cursor.getString(1).toString());

        }


    }
    public void editProfile(){
        Intent intent = new Intent(this,editUserProfile.class);

        Cursor cursor = dbh.readData(Email);
        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){

            intent.putExtra(EXTRA_USERID,cursor.getString(0).toString());
            intent.putExtra(EXTRA_PASSWORD,cursor.getString(3).toString());
            intent.putExtra(EXTRA_USERNAME,cursor.getString(1).toString());
            intent.putExtra(EXTRA_EMAIL,cursor.getString(2).toString());

            startActivity(intent);

        }
    }

  @Override
  public void onBackPressed() {
      super.onBackPressed();
      Intent intent = new Intent(this, MainActivity.class);
      startActivity(intent);
  }

}
