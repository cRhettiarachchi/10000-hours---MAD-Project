package Database;
// sasika-final

import android.provider.BaseColumns;

public final class AppDBMaster {

    public AppDBMaster() {
    }

    protected static class User implements BaseColumns{

        protected static final String TABLE_NAME = "users";
        protected static final String COLUMN_NAME_USERNAME = "username";
        protected static final String COLUMN_NAME_EMAIL = "email";
        protected static final String COLUMN_NAME_PASSWORD = "password";
    }
    protected static class Tasks implements BaseColumns{
        protected static final String TABLE_NAME = "tasks";
        protected static final String COLOMN_TASK_NAME = "name";
        protected static final String ICON_NAME = "icon_name";
        protected static final String COLOMN_TASK_TIME = "total_time";
    }

    protected static class Records implements BaseColumns{
        protected static final String TABLE_NAME = "records";
        protected static final String TASK_ID = "task_id";
        protected static final String COLOMN_RECORD_DESCRIPTION = "description";
        protected static final String COLOMN_RECORD_DATE = "date";
        protected static final String COLOMN_RECORD_TIME = "time";
    }
}
