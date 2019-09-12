package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABSE_NAME = "timetrack.db";


    public DBHelper(Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String Task_Table = "CREATE TABLE " + AppDBMaster.Tasks.TABLE_NAME + " (" +
                AppDBMaster.Tasks._ID + " INTEGER PRIMARY KEY, " +
                AppDBMaster.Tasks.COLOMN_TASK_NAME + " TEXT, " +
                AppDBMaster.Tasks.COLOMN_TASK_DATE + " TEXT);";

        String Records_Table = "CREATE TABLE " + AppDBMaster.Records.TABLE_NAME + " (" +
                AppDBMaster.Records.TASK_ID + " INTEGER PRIMARY KEY, " +
                AppDBMaster.Records.TASK_ID + " INTEGER, " +
                AppDBMaster.Records.COLOMN_RECORD_DATE + " TEXT, " +
                AppDBMaster.Records.COLOMN_RECORD_TIME + " LONG, " +
                AppDBMaster.Records.COLOMN_RECORD_DESCRIPTION + " TEXT);";

        String Users_Table= "CREATE TABLE "+ AppDBMaster.User.TABLE_NAME+" ("+
                UserMaster.User._ID+" INTEGER PRIMARY KEY,"+
                UserMaster.User.COLUMN_NAME_USERNAME+ " TEXT,"+
                UserMaster.User.COLUMN_NAME_EMAIL+ " TEXT,"+
                UserMaster.User.COLUMN_NAME_PASSWORD+ " TEXT);";

        sqLiteDatabase.execSQL(Task_Table);
        sqLiteDatabase.execSQL(Records_Table);
        sqLiteDatabase.execSQL(Users_Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
