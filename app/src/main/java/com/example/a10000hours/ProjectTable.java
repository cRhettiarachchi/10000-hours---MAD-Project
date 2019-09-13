package com.example.a10000hours;

import android.provider.BaseColumns;

public final class ProjectTable {

    ProjectTable(){}

    public static class Project implements BaseColumns{
        public static final String TABLE_NAME = "project";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ICON = "icon";
        public static final String COLUMN_NAME_TOTALHOURS = "totalhours";

    }

}
