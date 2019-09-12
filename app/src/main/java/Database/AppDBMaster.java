package Database;

import android.provider.BaseColumns;

public final class AppDBMaster {

    private AppDBMaster(){}

    protected static class User implements BaseColumns{
        protected static final String TABLE_NAME = "user";
        protected static final String COLOMN_NAME_USERNAME = "username";
        protected static final String COLOMN_NAME_PASSWORD = "password";
        protected static final String COLOMN_PROFILE_PIC = "profile_pic";
    }

    protected static class Tasks implements BaseColumns{
        protected static final String TABLE_NAME = "tasks";
        protected static final String COLOMN_TASK_NAME = "name";
        protected static final String ICON_NAME = "icon_name";
        protected static final String COLOMN_TASK_DATE = "date";
    }

    protected static class Records implements BaseColumns{
        protected static final String TABLE_NAME = "records";
        protected static final String TASK_ID = "task_id";
        protected static final String COLOMN_RECORD_DESCRIPTION = "description";
        protected static final String COLOMN_RECORD_DATE = "date";
        protected static final String COLOMN_RECORD_TIME = "time";
    }


}
