package com.example.touki.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by touki on 7/26/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="history.db";
    public static final String TABLE_HISTORIES="histories";
    public static final String COLOUMN_ID="id";
    public static final String COLOUMN_HISTORY="history";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String query= "CREATE TABLE " + TABLE_HISTORIES +"(" + COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_HISTORY + " TEXT " + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS" + TABLE_HISTORIES);
        onCreate(db);
    }

    public void addHistory(History histo)

    {

        ContentValues values = new ContentValues();

        values.put(COLOUMN_HISTORY,histo.get_history());

        SQLiteDatabase db= getWritableDatabase();

        db.insert(TABLE_HISTORIES,null,values);

        db.close();

    }

    public void deleteHistory(String histo){

        SQLiteDatabase db =getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_HISTORIES + " WHERE " + COLOUMN_HISTORY + "=\"" + histo + "\";");

    }
    public String databasetostring(int i){

        String dbString="";

        SQLiteDatabase db= getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_HISTORIES + " WHERE "+i;

        Cursor c =db.rawQuery(query,null);

        c.moveToFirst();

        while (!c.isAfterLast())

        {

            if(c.getString(c.getColumnIndex("history"))!=null)

            {

                dbString+= c.getString(c.getColumnIndex("history"));

                dbString+="\n";

            }

            c.moveToNext();

        }

        db.close();

        return dbString;

    }
}
