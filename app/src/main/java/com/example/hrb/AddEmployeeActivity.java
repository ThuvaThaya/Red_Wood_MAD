package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddEmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        Intent intent = getIntent();
    }
    public void onClickBack(View view) {
        finish();
    }

    public void onClickEmployeeDetails(View view) {
        Intent intent = new Intent(this, EmployeeDetailsActivity.class);
        startActivity(intent);
    }
}