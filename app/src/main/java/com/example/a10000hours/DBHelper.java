package com.example.a10000hours;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "tenThousandHours.db";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE = "CREATE TABLE "+ ProjectTable.Project.TABLE_NAME+" (" +
                ProjectTable.Project.COLUMN_NAME_NAME +" TEXT PRIMARY KEY," +
                ProjectTable.Project.COLUMN_NAME_ICON +" TEXT," +
                ProjectTable.Project.COLUMN_NAME_TOTALHOURS +" REAL)";


        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
