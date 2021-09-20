package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    //menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClickBooking(View view) {
        Intent intent = new Intent(this, BookingActivity.class);
        startActivity(intent);
    }

    public void onClickPayment(View view) {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }

    public void onClickBookingDetails(View view) {
        Intent intent = new Intent(this, BookingDetailsActivity.class);
        startActivity(intent);
    }

    public void onClickBookingDetailsAdmin(View view) {
        Intent intent = new Intent(this, BookingDetailsAdminActivity.class);
        startActivity(intent);
    }
    public void onClickLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
    public void onClickRoomCategoryView(View view) {
        Intent intent = new Intent(this, RoomCategoryViewActivity.class);
        startActivity(intent);
    }
    public void onClickCreateRoomCategory(View view) {
        Intent intent = new Intent(this, CreateRActivity.class);
        startActivity(intent);
    }
    public void onClickAddRoom(View view) {
        Intent intent = new Intent(this, AddRoomActivity.class);
        startActivity(intent);
    }
    public void onClickViewRoomOne(View view) {
        Intent intent = new Intent(this, ViewRoomActivity.class);
        startActivity(intent);
    }
    public void onClickViewRoomAdmin(View view) {
        Intent intent = new Intent(this, ViewRoomAdmin.class);
        startActivity(intent);
    }
    public void onClickViewRoomSingle(View view) {
        Intent intent = new Intent(this, ViewRoomSingle.class);
        startActivity(intent);
    }
    public void onClickProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void onClickEmployeeDetails(View view) {
        Intent intent = new Intent(this, EmployeeDetailsActivity.class);
        startActivity(intent);
    }
    public void onClickAddEmployee(View view) {
        Intent intent = new Intent(this, AddEmployeeActivity.class);
        startActivity(intent);
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}