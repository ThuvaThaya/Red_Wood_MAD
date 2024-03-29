package com.example.hrb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TABLE_NAME="Booking_Details";


    private Context context;

    public DBHelper(Context context) {
        super((Context) context, "Red_Wood.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Booking_Details(BookID INTEGER PRIMARY KEY AUTOINCREMENT, check_in_date TEXT, room_title Text, check_in_time TEXT,check_out_time TEXT,check_out_date TEXT, number_of_rooms TEXT, email TEXT, number INTEGER, discount INTEGER, fare INTEGER )");
//        DB.execSQL("create Table Room_Category(Cat_IDINTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, Description TEXT)");
        DB.execSQL("create Table Room_Details(RoomID INTEGER PRIMARY KEY AUTOINCREMENT, roomType TEXT, roomTitle Text, roomNumber TEXT,numOfBeds TEXT,numOfAdults TEXT, numOfChildren TEXT, roomFare TEXT, discription TEXT, bed BOOLEAN, babySitting BOOLEAN,wifi BOOLEAN,laundry BOOLEAN )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Booking_Details");
        DB.execSQL("drop Table if exists Users");
        DB.execSQL("drop Table if exists Room_Category");
        DB.execSQL("drop Table if exists Room_Details");
        onCreate(DB);

    }

    //add functions for room add
    void addRoom(String roomType,String roomTitle,String roomNumber,String numOfBeds,String numOfAdults,String numOfChildren,String roomFare,String discription,Boolean bed,Boolean babySitting,Boolean wifi,Boolean laundry ){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roomType", roomType);
        contentValues.put("roomTitle", roomTitle);
        contentValues.put("roomNumber", roomNumber);
        contentValues.put("numOfBeds", numOfBeds);
        contentValues.put("numOfAdults", numOfAdults);
        contentValues.put("numOfChildren", numOfChildren);
        contentValues.put("roomFare", roomFare);
        contentValues.put("discription", discription);
        contentValues.put("bed", bed);
        contentValues.put("babySitting", babySitting);
        contentValues.put("wifi", wifi);
        contentValues.put("laundry", laundry);


        long result = DB.insert("Room_Details", null, contentValues);
        if(result==-1) {
            Toast.makeText(context,"Error occured",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"room has been added successfully",Toast.LENGTH_LONG).show();
        }
    }

    void updateRoom(String roomId,String roomType,String roomTitle,String roomNumber,String numOfBeds,String numOfAdults,String numOfChildren,String roomFare,String discription,Boolean bed,Boolean babySitting,Boolean wifi,Boolean laundry ){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roomType", roomType);
        contentValues.put("roomTitle", roomTitle);
        contentValues.put("roomNumber", roomNumber);
        contentValues.put("numOfBeds", numOfBeds);
        contentValues.put("numOfAdults", numOfAdults);
        contentValues.put("numOfChildren", numOfChildren);
        contentValues.put("roomFare", roomFare);
        contentValues.put("discription", discription);
        contentValues.put("bed", bed);
        contentValues.put("babySitting", babySitting);
        contentValues.put("wifi", wifi);
        contentValues.put("laundry", laundry);


        long result = DB.update("Room_Details",  contentValues,"RoomID=?",new String[]{roomId});
        if(result==-1) {
            Toast.makeText(context,"Error occured",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context,"room has been updated successfully",Toast.LENGTH_LONG).show();
        }
    }

    public void deleteRoom(String roomId){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Room_Details", "RoomID=?", new String[]{roomId});
        if (result == -1) {
            Toast.makeText(context,"Failed to Delete", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor getRooms()
    {
        String query = "SELECT * FROM Room_Details" ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        System.out.println(cursor.getCount());
        return cursor;
    }

    //Add function for booking details
    void insertBookingData(String check_in_date, String check_out_date, String check_in_time,
                           String check_out_time, String room_title, String no_of_rooms, String number,
                           String email, String discount, String fare) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("check_in_date", check_in_date);
        contentValues.put("check_in_time", check_in_time);
        contentValues.put("check_out_date", check_out_date);
        contentValues.put("check_out_time", check_out_time);
        contentValues.put("room_title", String.valueOf(room_title));
        contentValues.put("number_of_rooms", no_of_rooms);
        contentValues.put("number", number);
        contentValues.put("email", email);
        contentValues.put("discount", discount);
        contentValues.put("fare", fare);

        long result = DB.insert("Booking_Details", null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Booking has been made sucessfully", Toast.LENGTH_LONG).show();


        }
    }

    public Boolean checkUsername(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Users where name = ?", new String[]{name});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM Booking_Details" ;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }


    public Boolean insertCategory(String name, String Description)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("Description", Description);

        long res = DB.insert("Room_Category", null,contentValues);
        if (res == -1){
            return false;
        }
        else {
            return true;
        }
    }

    void updateBooking(String Booking_id, String check_in_date, String check_in_time, String check_out_date,
                       String check_out_time, String number_of_room, String email, String number, String room_type,
                       String discount,String fare){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(check_in_date,check_in_date);
        cv.put(check_in_time,check_in_time);
        cv.put(check_out_date,check_out_date);
        cv.put(check_out_time,check_out_time);
        cv.put(number_of_room,number_of_room);
        cv.put(number,number);
        cv.put(room_type,room_type);
        cv.put(email,email);
        cv.put(discount,discount);
        cv.put(fare,fare);

        long result = db.update("Booking_Details", cv,"COLUMN_ID=?", new String[]{Booking_id});
        if (result == -1) {
            Toast.makeText(context,"Failed to Updated", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteOneRow(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "COLUMN_ID=?", new String[]{ID});
        if (result == -1) {
            Toast.makeText(context,"Failed to Deleted", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }

}