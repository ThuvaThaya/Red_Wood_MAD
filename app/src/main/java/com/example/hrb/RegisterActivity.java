package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {
    //This is register activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Intent intent = getIntent();
    }

    public void onClickBack(View view) {
        finish();
    }
    public void onClickLogin(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}