package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room);
        Intent intent = getIntent();
    }
    public void onClickBack(View view) {
        finish();
    }
    public void onClickViewRoomSingle(View view) {
        Intent intent = new Intent(this, ViewRoomSingle.class);
        startActivity(intent);
    }
}