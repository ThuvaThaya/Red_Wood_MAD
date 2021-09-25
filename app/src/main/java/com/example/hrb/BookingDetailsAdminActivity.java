package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hrb.adapters.AdminBookingAdapter;

import java.util.ArrayList;
public class BookingDetailsAdminActivity extends AppCompatActivity {
    RecyclerView recyclearView;
    DBHelper myDB;
    ArrayList<String > Booking_id, check_in_date, check_in_time,check_out_date,check_out_time, room_type, number_of_room, email, number, discount, fare;
    AdminBookingAdapter adminBookingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details_admin);
        recyclearView = findViewById(R.id.recyclerview);

        myDB = new DBHelper(BookingDetailsAdminActivity.this);
        Booking_id = new ArrayList<>();
        check_in_date = new ArrayList<>();
        check_in_time = new ArrayList<>();
        check_out_date = new ArrayList<>();
        check_out_time = new ArrayList<>();
        room_type = new ArrayList<>();
        number_of_room = new ArrayList<>();
        email = new ArrayList<>();
        number = new ArrayList<>();
        discount = new ArrayList<>();
        fare = new ArrayList<>();

        storeDataInArrays();

        adminBookingAdapter = new AdminBookingAdapter(BookingDetailsAdminActivity.this,Booking_id, check_in_date, check_in_time,check_out_date,check_out_time, room_type, number_of_room, email, number, discount, fare);
        recyclearView.setAdapter(adminBookingAdapter);
        recyclearView.setLayoutManager(new LinearLayoutManager(BookingDetailsAdminActivity.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                Booking_id.add(cursor.getString(0));
                check_in_date.add(cursor.getString(1));
                check_in_time.add(cursor.getString(2));
                check_out_date.add(cursor.getString(3));
                check_out_time.add(cursor.getString(4));
                room_type.add(cursor.getString(5));
                number_of_room.add(cursor.getString(6));
                email.add(cursor.getString(7));
                number.add(cursor.getString(8));
                discount.add(cursor.getString(9));
                fare.add(cursor.getString(10));
            }
        }
    }

    public void onClickBack(View view) {
        finish();
    }
//    public void onClickHome(View view) {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
}