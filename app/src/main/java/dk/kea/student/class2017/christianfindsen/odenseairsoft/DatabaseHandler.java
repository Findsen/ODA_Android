package dk.kea.student.class2017.christianfindsen.odenseairsoft;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christian Findsen on 12-06-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "medlem.db";
    public static final String TABLE_NAME    = "medlems_table";
    public static final String COL_1         = "ID";
    public static final String COL_2         = "FORNAVN";
    public static final String COL_3         = "EFTERNAVN";
    public static final String COL_4         = "ADRESSE";
    public static final String COL_5         = "TELEFON";
    public static final String COL_6         = "EMAIL";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + " ("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT,"+COL_2+" TEXT,"+COL_3+" TEXT, "+COL_4+" TEXT,"+COL_5+" INTEGER, "+COL_6+" TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String address, String number,String email )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,address);
        contentValues.put(COL_5,number);
        contentValues.put(COL_6,email);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }
}
