package com.example.hrb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AdminBookingUpdateActivity extends AppCompatActivity {
    EditText bookingID,chkInDateEditTxt1,chkInTimeEditTxt1,chkOutDateEditTxt1,chkOutTimeEditTxt1,noOfRoomsEditTxt1,
            emailEditTxt1,roomTitleEditTxt1;
    EditText mobileEditTxt1;
    EditText discountEditTxt1,fareEditTxt1;
    Button btnUpdate, btnDelete;
    String id, check_in_date, check_in_time, check_out_time,check_out_date, no_of_room, e_mail, number, discount, fare, room_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_booking_update);
        chkInDateEditTxt1 = findViewById(R.id.chkInDateEditTxt1);
        chkInTimeEditTxt1 = findViewById(R.id.chkOutTimeEditTxt1);
        chkOutDateEditTxt1 = findViewById(R.id.chkOutDateEditTxt1);
        chkOutTimeEditTxt1 = findViewById(R.id.chkOutTimeEditTxt1);
        noOfRoomsEditTxt1 = findViewById(R.id.noOfRoomsEditTxt1);
        emailEditTxt1= findViewById(R.id.emailEditTxt1);
        mobileEditTxt1= findViewById(R.id.mobileEditTxt1);
        discountEditTxt1=findViewById(R.id.discountEditTxt1);
        roomTitleEditTxt1=findViewById(R.id.roomTitleEditTxt1);
        fareEditTxt1=findViewById(R.id.fareEditTxt1);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(e_mail);
        }

        btnUpdate.setOnClickListener((view) -> {
            DBHelper myDB = new DBHelper(AdminBookingUpdateActivity.this);
            check_in_date = chkInDateEditTxt1.getText().toString().trim();
            check_in_time   = chkInTimeEditTxt1.getText().toString().trim();
            check_out_date = chkOutDateEditTxt1.getText().toString().trim();
            check_out_time= chkOutTimeEditTxt1.getText().toString().trim();
            no_of_room = noOfRoomsEditTxt1.getText().toString().trim();
            e_mail= emailEditTxt1.getText().toString().trim();
            number= mobileEditTxt1.getText().toString().trim();
            discount = discountEditTxt1.getText().toString().trim();
            fare= fareEditTxt1.getText().toString().trim();
            room_type = roomTitleEditTxt1.getText().toString().trim();
            myDB.updateBooking(id, check_in_date, check_in_time,
                    check_out_time,check_out_date, no_of_room, e_mail, number, discount, fare, room_type);
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

    }
    //    && getIntent().hasExtra("cabintype")
    void getAndSetIntentData(){
        if(getIntent().hasExtra("BookID") && getIntent().hasExtra("check_in_date")
                && getIntent().hasExtra("check_in_time")
                &&getIntent().hasExtra("check_out_date")&&getIntent().hasExtra("check_out_time")
                && getIntent().hasExtra("room_title")
                && getIntent().hasExtra("number_of_rooms") && getIntent().hasExtra("email")
                && getIntent().hasExtra("number") && getIntent().hasExtra("discount")
                && getIntent().hasExtra("fare")){
            id = getIntent().getStringExtra("BookID");
            check_in_date = getIntent().getStringExtra("check_in_date");
            check_in_time = getIntent().getStringExtra("check_in_time");
            check_out_date = getIntent().getStringExtra("check_out_date");
            check_out_time = getIntent().getStringExtra("check_out_time");
            room_type = getIntent().getStringExtra("room_title");
            no_of_room = getIntent().getStringExtra("no_of_room");
            e_mail = getIntent().getStringExtra("email");
            number = getIntent().getStringExtra("number");
            discount = getIntent().getStringExtra("discount");
            fare = getIntent().getStringExtra("fare");
            chkInDateEditTxt1.setText(check_in_date);
            chkInTimeEditTxt1.setText(check_in_time);
            chkOutDateEditTxt1.setText(check_out_date);
            chkOutTimeEditTxt1.setText(check_out_time);
            noOfRoomsEditTxt1.setText(no_of_room);
            emailEditTxt1.setText(e_mail);
            mobileEditTxt1.setText(number);
            roomTitleEditTxt1.setText(room_type);
            discountEditTxt1.setText(discount);
            fareEditTxt1.setText(fare);
        }else{
            Toast.makeText(this, "No data...",Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete ?");
        builder.setMessage("Are you sure you want to delete ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DBHelper myDB = new DBHelper(AdminBookingUpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}