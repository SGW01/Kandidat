package sgw.kandidat.database;

import android.provider.BaseColumns;

public class TablesPresenterClass {

    private TablesPresenterClass() {

    }

    public static class Kandidat implements BaseColumns {
        public static final String TABLE_NAME = "kandidat";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_STAZH = "stazh";
        public static final String COLUMN_NAYAVNVO = "nayavn_vo";
        public static final String COLUMN_NAYAVNVP = "nayavn_vp";
        public static final String COLUMN_NAYAVNDZ = "nayavn_dz";
        public static final String COLUMN_NAYAVNDK = "nayavn_dk";
        public static final String COLUMN_NAYAVNDV = "nayavn_dv";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_KILKINM = "kilk_inm";


        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_AGE + " INTEGER, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_STAZH + " INTEGER, "+
                COLUMN_NAYAVNVO + " INTEGER, " +
                COLUMN_NAYAVNVP + " INTEGER, " +
                COLUMN_NAYAVNDZ + " INTEGER, " +
                COLUMN_NAYAVNDK + " INTEGER, " +
                COLUMN_NAYAVNDV + " INTEGER, " +
                COLUMN_KILKINM + " INTEGER" + ")";
    }

    public static class Ocinka implements BaseColumns {
        public static final String TABLE_NAME = "ocinka";
        public static final String COLUMN_BAL_AGE = "bal_age";
        public static final String COLUMN_BAL_STAZH = "bal_stazh";
        public static final String COLUMN_BAL_NAYAVNVO = "bal_nayavn_vo";
        public static final String COLUMN_BAL_NAYAVNVP = "bal_nayavn_vp";
        public static final String COLUMN_BAL_NAYAVNDZ = "bal_nayavn_dz";
        public static final String COLUMN_BAL_NAYAVNDK = "bal_nayavn_dk";
        public static final String COLUMN_BAL_NAYAVNDV = "bal_nayavn_dv";
        public static final String COLUMN_BAL_KILKINM = "bal_kilk_inm";


        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BAL_AGE + " INTEGER, " +
                COLUMN_BAL_STAZH + " INTEGER, "+
                COLUMN_BAL_NAYAVNVO + " INTEGER, " +
                COLUMN_BAL_NAYAVNVP + " INTEGER, " +
                COLUMN_BAL_NAYAVNDZ + " INTEGER, " +
                COLUMN_BAL_NAYAVNDK + " INTEGER, " +
                COLUMN_BAL_NAYAVNDV + " INTEGER, " +
                COLUMN_BAL_KILKINM + " INTEGER" + ")";
    }

}