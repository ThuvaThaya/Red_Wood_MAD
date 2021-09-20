package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewRoomSingle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_single);
        Intent intent = getIntent();
    }
    public void onClickBack(View view) {
        finish();
    }
    public void onClickBooking(View view) {
        Intent intent = new Intent(this, BookingActivity.class);
        startActivity(intent);
    }

    public void onClickRoom(View view) {
        Intent intent = new Intent(this, ViewRoomActivity.class);
        startActivity(intent);
    }
}