package com.example.hrb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Red_Wood.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Booking_Details(BookID INTEGER PRIMARY KEY AUTOINCREMENT, check_in_date TEXT, room_title Text, check_in_time TEXT,check_out_time TEXT,check_out_date TEXT, number_of_rooms TEXT, email TEXT, number INTEGER )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Booking_Details");

    }
    public Boolean insertBookingData(String check_in_date, String check_out_date,String check_in_time, String check_out_time, String room_title, String  no_of_rooms,String number, String email )
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("check_in_date", check_in_date);
        contentValues.put("check_in_time", check_in_time);
        contentValues.put("check_out_date", check_out_date);
        contentValues.put("check_out_time", check_out_time);
        contentValues.put("room_title", room_title);
        contentValues.put("number_of_rooms", no_of_rooms);
        contentValues.put("number", number);
        contentValues.put("email", email);
        long result = DB.insert("Booking_Details", null, contentValues);
        if(result==-1) {
            return false;
        }else {
            return true;
        }


    }
    public Cursor getBookingData()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Booking_Details", null );
        return cursor;
    }
}
