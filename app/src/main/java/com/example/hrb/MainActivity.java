package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Define ActionBar object
//        ActionBar actionBar;
//        actionBar = getSupportActionBar();

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
//        ColorDrawable colorDrawable
//                = new ColorDrawable(Color.parseColor("#ffffff"));

        // Set BackgroundDrawable
//        actionBar.setBackgroundDrawable(colorDrawable);
        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(2000);  //Delay of 10 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(MainActivity.this,
                            MenuActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();


    }

}