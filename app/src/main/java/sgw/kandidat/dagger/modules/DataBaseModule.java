package sgw.kandidat.dagger.modules;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;
import sgw.kandidat.database.DBSQLiteHelper;
import sgw.kandidat.database.TablesPresenterClass;

@Module
public class DataBaseModule {

    private final static String TAG = DataBaseModule.class.getSimpleName();

    @Inject
    public DataBaseModule(){

    }

    @Provides
    public boolean saveToDB(Context context, String name, int age, int stazh,
                            int nayavn_vo, int nayavn_vp, int nayavn_dz, int nayavn_dk,
                            int nayavn_dv, int kilk_inm, String email) {
        SQLiteDatabase database = new DBSQLiteHelper(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAME, name);
        values.put(TablesPresenterClass.Kandidat.COLUMN_AGE, age);
        values.put(TablesPresenterClass.Kandidat.COLUMN_EMAIL, email);
        values.put(TablesPresenterClass.Kandidat.COLUMN_STAZH, stazh);
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAYAVNVO, nayavn_vo);
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAYAVNVP, nayavn_vp);
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDZ, nayavn_dz);
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDK, nayavn_dk);
        values.put(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDV, nayavn_dv);
        values.put(TablesPresenterClass.Kandidat.COLUMN_KILKINM, kilk_inm);

        Log.d(TAG, "name="+name);
        Log.d(TAG,"age = "+String .valueOf(age));
        Log.d(TAG, "email = " + email);
        Log.d(TAG,"stazh = "+String .valueOf(stazh));
        Log.d(TAG,"nayavn_vo = "+String .valueOf(nayavn_vo));
        Log.d(TAG,"nayavn_vp = "+String .valueOf(nayavn_vp));
        Log.d(TAG,"nayavn_dz = "+String .valueOf(nayavn_dz));
        Log.d(TAG,"nayavn_dk = "+String .valueOf(nayavn_dk));
        Log.d(TAG,"nayavn_dv = "+String .valueOf(nayavn_dv));
        Log.d(TAG,"kilk_inm = "+String .valueOf(kilk_inm));


        long newRowId = database.insert(TablesPresenterClass.Kandidat.TABLE_NAME, null, values);
        Log.d(TAG,"The new row Id is " + newRowId);

        return true;
    }


    @Provides
    public int [] readFromDB(Context context, String name) {
       int [] data = new int[8];

        SQLiteDatabase database = new DBSQLiteHelper(context).getReadableDatabase();
        Cursor cursor;
        cursor = database.rawQuery( "select "+
                TablesPresenterClass.Kandidat.COLUMN_AGE + ", " +
                TablesPresenterClass.Kandidat.COLUMN_STAZH + ", " +
                TablesPresenterClass.Kandidat.COLUMN_NAYAVNVO + ", "+
                TablesPresenterClass.Kandidat.COLUMN_NAYAVNVP + ", "+
                TablesPresenterClass.Kandidat.COLUMN_NAYAVNDZ + ", " +
                TablesPresenterClass.Kandidat.COLUMN_NAYAVNDK + ", " +
                TablesPresenterClass.Kandidat.COLUMN_NAYAVNDV + ", " +
                        TablesPresenterClass.Kandidat.COLUMN_KILKINM + " " +
                        "from " + TablesPresenterClass.Kandidat.TABLE_NAME + " WHERE " +
                TablesPresenterClass.Kandidat.COLUMN_NAME + " = ? ", new String[] {name});
        cursor.moveToFirst();
        Log.d(TAG, String.valueOf(cursor.getCount()));
        data[0]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_AGE));
        data[1]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_STAZH));
        data[2]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_NAYAVNVO));
        data[3]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_NAYAVNVP));
        data[4]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDZ));
        data[5]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDK));
        data[6]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_NAYAVNDV));
        data[7]=cursor.getInt(cursor.getColumnIndexOrThrow(TablesPresenterClass.Kandidat.COLUMN_KILKINM));
        cursor.close();
        database.close();
        return  data;

    }


    @Provides
    public boolean deleteFromDB(Context context,String name){
        SQLiteDatabase database = new DBSQLiteHelper(context).getWritableDatabase();
        long rowId = database.delete(TablesPresenterClass.Kandidat.TABLE_NAME,
                TablesPresenterClass.Kandidat.COLUMN_NAME + " = ? " ,new String[] {name});
        Log.d(TAG,"The deleted row count is " + rowId);
        database.close();
        return true;

    }
}