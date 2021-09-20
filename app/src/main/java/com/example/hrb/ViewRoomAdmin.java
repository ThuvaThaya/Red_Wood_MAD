package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewRoomAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_admin);
        Intent intent = getIntent();
    }
    public void onClickBack(View view) {
        finish();
    }
    public void onClickAddRoom(View view) {
        Intent intent = new Intent(this, AddRoomActivity.class);
        startActivity(intent);
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}