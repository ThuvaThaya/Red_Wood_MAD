package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_ractivity);
        Intent intent = getIntent();
    }

    public void onClickBack(View view) {
        finish();
    }
    public void onClickRoomCategoryView(View view) {
        Intent intent = new Intent(this, RoomCategoryViewActivity.class);
        startActivity(intent);
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}