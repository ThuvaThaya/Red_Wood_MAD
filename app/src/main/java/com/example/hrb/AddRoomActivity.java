package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        Intent intent = getIntent();
    }

    public void onClickBack(View view) {
        finish();
    }
    public void onClickViewRoomAdmin(View view) {
        Intent intent = new Intent(this, ViewRoomAdmin.class);
        startActivity(intent);
    }
}