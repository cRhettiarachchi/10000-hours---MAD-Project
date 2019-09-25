package com.example.a10000hours;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import Database.DBHelper;

public class createProject extends AppCompatActivity {

    EditText projectName;
    ImageView projectImage;
    String name,icon;
    Button saveBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);


        projectName = findViewById(R.id.proName);
        //projectImage = findViewById(R.id.proName);
        //saveBtn = findViewById(R.id.saveBtn);
        db = new DBHelper(this);

        Toolbar toolbar = findViewById(R.id.historyToolbar);
        setSupportActionBar(toolbar);
        setTitle("Add Record");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;

            case R.id.showHistory:
                startActivity(new Intent(this, History.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveProject(View view){

        name = projectName.getText().toString();
        //icon = projectImage.getText().toString();
        icon = "testing.png";

        boolean result = db.addTask(name,icon);

        if(result){
            Toast.makeText(getApplicationContext(),"Adding Success",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
        }


    }


}


//////////////////////////////////////////////////////////////////////////////////////////////
/*
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_marginTop="30dp"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/cardView">

        <TextView
            android:id="@+id/textView13"
            android:layout_width="match_parent"
            android:layout_height="@dimen/choseIconSize"
            android:background="#FFFFFF"
            android:gravity="center|left"
            android:paddingLeft="20dp"
            android:text="Chose Icon"
            android:textSize="24sp" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorHeaderFooter"
            android:orientation="horizontal"
            android:paddingTop="@dimen/LinearPadding"
            android:paddingBottom="@dimen/LinearPadding">

            <ImageView
                android:id="@+id/imageView8"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon1" />

            <ImageView
                android:id="@+id/imageView3"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon2" />

            <ImageView
                android:id="@+id/imageView10"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon3" />

            <ImageView
                android:id="@+id/projectImage"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon4" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorHeaderFooter"
            android:orientation="horizontal"
            android:paddingBottom="@dimen/LinearPadding">

            <ImageView
                android:id="@+id/imageView12"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon5" />

            <ImageView
                android:id="@+id/imageView13"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon6" />

            <ImageView
                android:id="@+id/imageView14"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon7" />

            <ImageView
                android:id="@+id/imageView15"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon8" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorHeaderFooter"
            android:orientation="horizontal"
            android:paddingBottom="@dimen/LinearPadding">

            <ImageView
                android:id="@+id/imageView16"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon9" />

            <ImageView
                android:id="@+id/imageView17"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon10" />

            <ImageView
                android:id="@+id/imageView18"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon11" />

            <ImageView
                android:id="@+id/imageView19"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon12" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/colorHeaderFooter"
            android:orientation="horizontal"
            android:paddingBottom="@dimen/LinearPadding">

            <ImageView
                android:id="@+id/imageView20"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon13" />

            <ImageView
                android:id="@+id/imageView21"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon14" />

            <ImageView
                android:id="@+id/imageView22"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon15" />

            <ImageView
                android:id="@+id/imageView23"
                android:layout_width="@dimen/selectImageSize"
                android:layout_height="@dimen/selectImageSize"
                android:layout_weight="1"
                app:srcCompat="@drawable/icon16" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="@dimen/BottomLinearHeight"
            android:background="@color/colorHeaderFooter"
            android:orientation="horizontal">

            <Button
                android:id="@+id/saveBtn"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_gravity="center"
                android:layout_marginLeft="@dimen/marginBtn"
                android:layout_marginRight="@dimen/marginBtn"
                android:layout_weight="1"
                android:background="@drawable/buttonstyle2"
                android:onClick="saveProject"
                android:text="@string/done" />
       </LinearLayout>

    </LinearLayout>

 */