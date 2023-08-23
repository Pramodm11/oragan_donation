package com.example.madfinal;
import android.content.ContentValues;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends  SQLiteOpenHelper  {

    public DBHelper(Context context) {super(context, "Spinner1.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table user1(name1 TEXT primary key,spinner TEXT, spinner1 TEXT, spinner2 TEXT,dob1 TEXT,contact1 TEXT,address1 TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists user1");
    }
    public Boolean insertuserdata(String name1,String spinner, String spinner1, String spinner2,String dob1, String contact1,String address1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name1", name1);
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("spinner2", spinner2);
        contentValues.put("dob1", dob1);
        contentValues.put("contact1", contact1);
        contentValues.put("address1", address1);
        long result=DB.insert("user1", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String name1,String spinner, String spinner1, String spinner2,String dob1, String contact1,String address1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name1", name1);
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("spinner2", spinner2);
        contentValues.put("dob1", dob1);
        contentValues.put("contact1", contact1);
        contentValues.put("address1", address1);
        Cursor cursor = DB.rawQuery("Select * from user1 where name1 = ?", new String[]{name1});
        if (cursor.getCount() > 0) {
            long result = DB.update("user1", contentValues, "name1=?", new String[]{name1});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean deletedata (String name1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user1 where name1 = ?", new String[]{name1});
        if (cursor.getCount() > 0) {
            long result = DB.delete("user1", "name1=?", new String[]{name1});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user1", null);
        return cursor;
    }


    public Cursor getdata1() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from user1 where spinner = ?", new String[]{GlobalVariable.message});
        return cursor;
    }
}


