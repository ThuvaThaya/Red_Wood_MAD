package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {
    //this is the login page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
    }

    public void onClickBack(View view) {
        finish();
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity2.class);
        startActivity(intent);
    }
    public void onClickViewRoomOne(View view) {
        Intent intent = new Intent(this, ViewRoomActivity.class);
        startActivity(intent);
    }
    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}