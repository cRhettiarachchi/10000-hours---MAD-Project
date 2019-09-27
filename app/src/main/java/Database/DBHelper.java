package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    private static final String DATABSE_NAME = "timetrack.db";
    public DBHelper(Context context) {
        super(context, DATABSE_NAME, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String Users_Table = "CREATE TABLE "+ AppDBMaster.User.TABLE_NAME+" ("+
                AppDBMaster.User._ID+" INTEGER PRIMARY KEY,"+
                AppDBMaster.User.COLUMN_NAME_USERNAME+ " TEXT,"+
                AppDBMaster.User.COLUMN_NAME_EMAIL+ " TEXT,"+
                AppDBMaster.User.COLUMN_NAME_PASSWORD+ " TEXT);";

        String Task_Table = "CREATE TABLE " + AppDBMaster.Tasks.TABLE_NAME + " (" +
                AppDBMaster.Tasks._ID + " INTEGER PRIMARY KEY, " +
                AppDBMaster.Tasks.COLOMN_TASK_NAME + " TEXT, " +
                AppDBMaster.Tasks.ICON_NAME + " INTEGER, " +
                AppDBMaster.Tasks.COLOMN_TASK_TIME + " REAL);";

//        AppDBMaster.Records.TASK_ID + " INTEGER",
        String Records_Table = "CREATE TABLE " + AppDBMaster.Records.TABLE_NAME + " (" +
                AppDBMaster.Records._ID + " INTEGER PRIMARY KEY," +
                AppDBMaster.Tasks.COLOMN_TASK_NAME + " TEXT," +
                AppDBMaster.Records.COLOMN_RECORD_DATE + " TEXT," +
                AppDBMaster.Records.COLOMN_RECORD_TIME + " LONG," +
                AppDBMaster.Records.COLOMN_RECORD_DESCRIPTION + " TEXT);";

        String Goal_Table = "CREATE TABLE " + AppDBMaster.Goals.TABLE_NAME + " (" +
                AppDBMaster.Goals._ID + " INTEGER PRIMARY KEY," +
                AppDBMaster.Goals.COLUMN_GOAL_PROJECT_NAME + " TEXT," +
                AppDBMaster.Goals.COLUMN_GOAL_HOURS + " TEXT," +
                AppDBMaster.Goals.COLUMN_GOAL_DUE_DATE + " TEXT);";

                db.execSQL(Users_Table);
                db.execSQL(Task_Table);
                db.execSQL(Records_Table);
                db.execSQL(Goal_Table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String Records_Table = "CREATE TABLE " + AppDBMaster.Records.TABLE_NAME + " (" +
                AppDBMaster.Records._ID + " INTEGER PRIMARY KEY," +
                AppDBMaster.Tasks.COLOMN_TASK_NAME + " TEXT," +
                AppDBMaster.Records.COLOMN_RECORD_DATE + " TEXT," +
                AppDBMaster.Records.COLOMN_RECORD_TIME + " LONG," +
                AppDBMaster.Records.COLOMN_RECORD_DESCRIPTION + " TEXT);";

        db.execSQL(Records_Table);

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

    // ----------------------------------------------------------------- //
    // Records Queries //
    public boolean addRecord(String date, double time, String description, String taskName){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AppDBMaster.Records.COLOMN_RECORD_DATE, date);
        values.put(AppDBMaster.Tasks.COLOMN_TASK_NAME, taskName);
        values.put(AppDBMaster.Records.COLOMN_RECORD_TIME, time);
        values.put(AppDBMaster.Records.COLOMN_RECORD_DESCRIPTION, description);

        long result = db.insert(AppDBMaster.Records.TABLE_NAME, null, values);
        if(result > 0){
            return true;
        }else{
            return false;
        }

    }

    public Cursor viewAllRecords(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AppDBMaster.Records.TABLE_NAME, null);
        if(cursor.getCount() > 0){
            Log.d("notEmpty", "not working");
            return cursor;
        }else{
            Log.d("database_empty", "not working");
            return cursor;
        }
    }

    public boolean updateTimeRecord(Integer id, double time){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppDBMaster.Records.COLOMN_RECORD_TIME, time);

        String selection = AppDBMaster.Records._ID + " LIKE ?";
        String[] SelectionArgs = {id.toString()};

        int update = db.update(
                AppDBMaster.Records.TABLE_NAME,
                contentValues,
                selection,
                SelectionArgs
        );

        if(update > 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean deleteRecord(Integer id){
        SQLiteDatabase db = getReadableDatabase();

        String selection = AppDBMaster.Records._ID + " LIKE ? ";
        String[] selectionArgs = {id.toString()};

        int i = db.delete(AppDBMaster.Records.TABLE_NAME, selection, selectionArgs);

        if(i > 0){
            return true;
        }else{
            return false;
        }
    }

    // -------------------------------------------------------------------- //

    //start dna ==================================================================================================================
    public boolean addTask(String taskName,int iconName){

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

        List<Integer> iconNames = new ArrayList<>();
        while(cursor.moveToNext()) {
            //String taskImages = cursor.getString(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.COLOMN_TASK_NAME));
            int taskImages = cursor.getInt(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.ICON_NAME));
            iconNames.add(taskImages);
        }
        cursor.close();


        return iconNames;
    }

    public List getAllTotalTimes(){

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

        List totalTime = new ArrayList<>();
        while(cursor.moveToNext()) {
            String Time = cursor.getString(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.COLOMN_TASK_TIME));
            totalTime.add(Time);
        }
        cursor.close();

        return totalTime;
    }

    public Cursor getAllTasks(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AppDBMaster.Tasks.TABLE_NAME, null);
        if(cursor.getCount() > 0){
            Log.d(TAG, "Table is not empty");
            return cursor;
        }else{
            Log.d(TAG, "Table is empty");
            return cursor;
        }
    }

    public int getAproject(String name){
        SQLiteDatabase db = getReadableDatabase();
        int taskImages = 0;

        String[] columns = {AppDBMaster.Tasks.ICON_NAME,
                AppDBMaster.Tasks.COLOMN_TASK_TIME};

        String select = AppDBMaster.Tasks.COLOMN_TASK_NAME+" Like ? ";
        String[] selectionArgs = {name};

        Cursor cursor = db.query(AppDBMaster.Tasks.TABLE_NAME,columns,select,selectionArgs,null,null,null);

        while(cursor.moveToNext()) {
            taskImages = cursor.getInt(cursor.getColumnIndexOrThrow(AppDBMaster.Tasks.ICON_NAME));
        }
        cursor.close();


        return taskImages;
    }

    public boolean updateTask(String projectName, String newName,int icon){

        if(projectName.equals(newName)){
            return false;
        }

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppDBMaster.Tasks.COLOMN_TASK_NAME, newName);
        contentValues.put(AppDBMaster.Tasks.ICON_NAME, icon);

        String selection = AppDBMaster.Tasks.COLOMN_TASK_NAME + " LIKE ?";
        String[] SelectionArgs = {projectName};

        int update = db.update(
                AppDBMaster.Tasks.TABLE_NAME,
                contentValues,
                selection,
                SelectionArgs
        );

        if(update > 0){
            return true;
        }else{
            return false;
        }

    }

    //end dna ===========================================================================================================================


    //Codes by SM

    //Add goal
    public boolean addGoal ( String ProjectName, String Hours, String Date ) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(AppDBMaster.Goals.COLUMN_GOAL_PROJECT_NAME, ProjectName);
        values.put(AppDBMaster.Goals.COLUMN_GOAL_HOURS, Hours);
        values.put(AppDBMaster.Goals.COLUMN_GOAL_DUE_DATE, Date);

        long result = db.insert(AppDBMaster.Goals.TABLE_NAME,null, values);

        if ( result > 0 ) {
            return true;
        } else {
            return false;
        }
    }

    //View goal
    public Cursor viewGoal() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + AppDBMaster.Goals.TABLE_NAME, null);

        return cursor;
    }

    public Cursor noRecords() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT COUNT(" + AppDBMaster.Records.TASK_ID +")" + "FROM" + AppDBMaster.Records.TABLE_NAME, null);
        return cursor;
    }

    public int deleteGoal(String id){
        SQLiteDatabase db = getReadableDatabase();

        String select = AppDBMaster.Goals.COLUMN_GOAL_HOURS+" Like ? ";
        String[] selectionArgs = {id};

        int result = db.delete(AppDBMaster.Goals.TABLE_NAME, select, selectionArgs);

        if ( result > 0 ){
            return 1;
        } else {
            return -1;
        }
    }
}
