package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AdminRoomUpdateActivity extends AppCompatActivity {

    EditText roomType,roomTitle,roomNumber,numOfBeds,numOfAdults, numOfChildren, roomFare,discription ;
    CheckBox bed,babySitting,wifi,laundry;
    String room,room_title,room_type,room_number_field,num_of_beds_field,num_of_adult_field,num_of_children_field,
            fare_field,discription_field;
    Button update;
    public  static DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_room_update);



        roomType =  (EditText)findViewById(R.id.RoomType);
        roomTitle = (EditText) findViewById(R.id.Title_Room);
        roomNumber = (EditText) findViewById(R.id.RoomNumber);
        numOfBeds = (EditText) findViewById(R.id.NoBeds);
        numOfAdults = (EditText) findViewById(R.id.MaxAdults);
        numOfChildren = (EditText) findViewById(R.id.MaxChildren);
        roomFare =  (EditText) findViewById(R.id.RoomFare);
        discription =  (EditText) findViewById(R.id.RoomDescription);
        bed =  (CheckBox) findViewById(R.id.simpleCheckBox1);
        babySitting =  (CheckBox) findViewById(R.id.simpleCheckBox2);
        wifi =  (CheckBox) findViewById(R.id.simpleCheckBox3);
        laundry =  (CheckBox) findViewById(R.id.simpleCheckBox4);

        update =  (Button) findViewById(R.id.update);

        getAndSetIntentData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB = new DBHelper(AdminRoomUpdateActivity.this);
                DB.updateRoom(room,
                        roomType.getText().toString().trim(),
                        roomTitle.getText().toString().trim(),
                        roomNumber.getText().toString().trim(),
                        numOfBeds.getText().toString().trim(),
                        numOfAdults.getText().toString().trim(),
                        numOfChildren.getText().toString().trim(),
                        roomFare.getText().toString().trim(),
                        discription.getText().toString().trim(),
                        bed.isChecked(),
                        babySitting.isChecked(),
                        wifi.isChecked(),
                        laundry.isChecked()



                );
            }
        });
    }

    void getAndSetIntentData(){

        if(getIntent().hasExtra("room") && getIntent().hasExtra("room_title")
                && getIntent().hasExtra("room_type")
                &&getIntent().hasExtra("room_number_field")&&getIntent().hasExtra("num_of_beds_field")
                && getIntent().hasExtra("num_of_adult_field")
                && getIntent().hasExtra("num_of_children_field") && getIntent().hasExtra("fare_field")
                && getIntent().hasExtra("discription_field") ){
            room = getIntent().getStringExtra("room");
            System.out.println(room);
            room_title = getIntent().getStringExtra("room_title");
            room_type = getIntent().getStringExtra("room_type");
            room_number_field = getIntent().getStringExtra("room_number_field");
            num_of_beds_field = getIntent().getStringExtra("num_of_beds_field");
            num_of_adult_field = getIntent().getStringExtra("num_of_adult_field");
            num_of_children_field = getIntent().getStringExtra("num_of_children_field");
            fare_field = getIntent().getStringExtra("fare_field");
            discription_field = getIntent().getStringExtra("discription_field");

            roomTitle.setText(room_title);
            roomType.setText(room_type);
            roomNumber.setText(room_number_field);
            numOfBeds.setText(num_of_beds_field);
            numOfAdults.setText(num_of_adult_field);
            numOfChildren.setText(num_of_children_field);
            roomFare.setText(fare_field);

            discription.setText(discription_field);





        }else{
            Toast.makeText(this, "No data...",Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickViewRoomAdmin(View view) {
        Intent intent = new Intent(this, ViewRoomAdmin.class);
        startActivity(intent);
    }
}