package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";

    private static final String DATABSE_NAME = "timetrack.db";

    public DBHelper(Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d(TAG,"DBoncreate methoed called");

        String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AppDBMaster.Tasks.TABLE_NAME;


        String Users_Table = "CREATE TABLE "+ AppDBMaster.User.TABLE_NAME+" ("+
                AppDBMaster.User._ID+" INTEGER PRIMARY KEY,"+
                AppDBMaster.User.COLUMN_NAME_USERNAME+ " TEXT,"+
                AppDBMaster.User.COLUMN_NAME_EMAIL+ " TEXT,"+
                AppDBMaster.User.COLUMN_NAME_PASSWORD+ " TEXT);";

        String Task_Table = "CREATE TABLE " + AppDBMaster.Tasks.TABLE_NAME + " (" +
                AppDBMaster.Tasks._ID + " INTEGER PRIMARY KEY, " +
                AppDBMaster.Tasks.COLOMN_TASK_NAME + " TEXT, " +
                AppDBMaster.Tasks.ICON_NAME + " TEXT, " +
                AppDBMaster.Tasks.COLOMN_TASK_TIME + " REAL);";

        String Records_Table = "CREATE TABLE " + AppDBMaster.Records.TABLE_NAME + " (" +
                AppDBMaster.Records.TASK_ID + " INTEGER PRIMARY KEY, " +
                //AppDBMaster.Records.TASK_ID + " INTEGER, " +
                AppDBMaster.Records.COLOMN_RECORD_DATE + " TEXT, " +
                AppDBMaster.Records.COLOMN_RECORD_TIME + " LONG, " +
                AppDBMaster.Records.COLOMN_RECORD_DESCRIPTION + " TEXT);";

                db.execSQL(SQL_DELETE_ENTRIES);
                //db.execSQL(Users_Table);
                db.execSQL(Task_Table);
                //db.execSQL(Records_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean addUser(String username,String password,String email){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AppDBMaster.User.COLUMN_NAME_USERNAME,username);
        values.put(AppDBMaster.User.COLUMN_NAME_EMAIL,email);
        values.put(AppDBMaster.User.COLUMN_NAME_PASSWORD,password);

        long reault = db.insert(AppDBMaster.User.TABLE_NAME,null,values);

        if (reault > 0){
            return true;
        }else{
            return false;
        }


    }

    public boolean checkUser(String username,String password){
        String[] columns = {AppDBMaster.User._ID};
        SQLiteDatabase db = getReadableDatabase();
        String selection = AppDBMaster.User.COLUMN_NAME_EMAIL + "=?" +
                " and " + AppDBMaster.User.COLUMN_NAME_PASSWORD + "=?";
        String[] selectionArgs = {username , password};
        Cursor cursor = db.query(AppDBMaster.User.TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        db.close();

        if (count>0){
            return true;
        }else{
            return false;
        }
    }

    public int deleteUser(String email){
        SQLiteDatabase db = getReadableDatabase();

        String select = AppDBMaster.User.COLUMN_NAME_EMAIL+" Like ? ";
        String[] selectionArgs = {email};

        int result = db.delete(AppDBMaster.User.TABLE_NAME,select,selectionArgs);

        if (result > 0){
            return 1;
        }else{
            return -1;
        }
    }

    public Cursor readData(String email){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {AppDBMaster.User._ID, AppDBMaster.User.COLUMN_NAME_USERNAME, AppDBMaster.User.COLUMN_NAME_EMAIL, AppDBMaster.User.COLUMN_NAME_PASSWORD};
        String select = AppDBMaster.User.COLUMN_NAME_EMAIL+" Like ? ";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(AppDBMaster.User.TABLE_NAME,columns,select,selectionArgs,null,null,null);

        return cursor;



    }

    public int updateUser(String UserIdU,String nameU, String emailU,String passwordU){
        SQLiteDatabase db = getReadableDatabase();



        ContentValues values = new ContentValues();
        values.put(AppDBMaster.User.COLUMN_NAME_EMAIL,emailU);
        values.put(AppDBMaster.User.COLUMN_NAME_USERNAME,nameU);
        values.put(AppDBMaster.User.COLUMN_NAME_PASSWORD,passwordU);

        String select = AppDBMaster.User._ID + " LIKE ? ";
        String[] selectionArgs = {UserIdU};

        int count = db.update(
                AppDBMaster.User.TABLE_NAME,
                values,
                select,
                selectionArgs
        );

        return count;
    }


    //start dna ==================================================================================================================
    public boolean addTask(String taskName,String iconName){

        float totalTime = 0;

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(AppDBMaster.Tasks.COLOMN_TASK_NAME,taskName);
        values.put(AppDBMaster.Tasks.COLOMN_TASK_TIME,totalTime);
        values.put(AppDBMaster.Tasks.ICON_NAME,iconName);

        long result = db.insert(AppDBMaster.Tasks.TABLE_NAME,null,values);

        if (result > 0){
            return true;
        }else{
            return false;
        }
    }

    public int deleteTask(String name){
        SQLiteDatabase db = getReadableDatabase();

        String select = AppDBMaster.Tasks.COLOMN_TASK_NAME+" Like ? ";
        String[] selectionArgs = {name};

        int result = db.delete(AppDBMaster.Tasks.TABLE_NAME,select,selectionArgs);

        if (result > 0){
            return 1;
        }else{
            return -1;
        }
    }


    public List getAllTaskNames(){

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {AppDBMaster.User._ID,
                AppDBMaster.Tasks.COLOMN_TASK_NAME};

        Cursor cursor = db.query(AppDBMaster.Tasks.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        List taskNames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String taskName = cursor.getString(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.COLOMN_TASK_NAME));
            taskNames.add(taskName);
        }
        cursor.close();


        return taskNames;
    }

    public List getAllTaskImages(){

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {AppDBMaster.User._ID,
                AppDBMaster.Tasks.ICON_NAME};

        Cursor cursor = db.query(AppDBMaster.Tasks.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        List iconNames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String taskName = cursor.getString(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.COLOMN_TASK_NAME));
            iconNames.add(taskName);
        }
        cursor.close();


        return iconNames;
    }

    public List getAllTotalTimes(){

        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {AppDBMaster.User._ID,
                AppDBMaster.Tasks.COLOMN_TASK_TIME};

        Cursor cursor = db.query(AppDBMaster.Tasks.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        List totalTime = new ArrayList<>();
        while(cursor.moveToNext()) {
            String taskName = cursor.getString(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.COLOMN_TASK_NAME));
            totalTime.add(taskName);
        }
        cursor.close();

        return totalTime;
    }

    //end dna ===========================================================================================================================



}
