package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

//this is home
public class HomeActivity extends AppCompatActivity {

    CardView Room;
    CardView RoomCategory;
    CardView Booking;
    CardView Employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Room = findViewById(R.id.cardRoom);
        Room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Room();
            }
        });
        RoomCategory =findViewById(R.id.cardRoomCategory);
        RoomCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomCategory();
            }
        });
        Booking = findViewById(R.id.cardBooking);
        Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookingAdmin();
            }
        });
        Employee=findViewById(R.id.cardEmployee);
        Employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmployeeDetails();
            }
        });
        Intent intent = getIntent();
    }
    public void onClickBack(View view) {
        finish();
    }
    public void Room(){
        Intent intent = new Intent(this,ViewRoomAdmin.class);
        startActivity(intent);
    }
    public void RoomCategory(){
        Intent intent = new Intent(this,RoomCategoryViewActivity.class);
        startActivity(intent);
    }
    public void BookingAdmin(){
        Intent intent = new Intent(this,BookingDetailsAdminActivity.class);
        startActivity(intent);
    }
    public void EmployeeDetails(){
        Intent intent = new Intent(this,EmployeeDetailsActivity.class);
        startActivity(intent);
    }
}
