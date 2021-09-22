package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookingActivity extends AppCompatActivity {

    EditText chkInDateEditTxt,chkInTimeEditTxt,chkOutDateEditTxt,chkOutTimeEditTxt,roomTitleEditTxt,noOfRoomsEditTxt,
            mobileEditTxt,emailEditTxt,discountEditTxt,fareEditTxt;
    Button btnBook, btnCancel;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        chkInDateEditTxt =  (EditText)findViewById(R.id.chkInDateEditTxt);
        chkInTimeEditTxt = (EditText) findViewById(R.id.chkInTimeEditTxt);
        chkOutDateEditTxt = (EditText) findViewById(R.id.chkOutDateEditTxt);
        chkOutTimeEditTxt = (EditText) findViewById(R.id.chkOutTimeEditTxt);
        roomTitleEditTxt = (EditText) findViewById(R.id.roomTitleEditTxt);
        noOfRoomsEditTxt = (EditText) findViewById(R.id.noOfRoomsEditTxt);
        mobileEditTxt = (EditText) findViewById(R.id.mobileEditTxt);
        emailEditTxt =  (EditText) findViewById(R.id.emailEditTxt);

        btnBook = (Button) findViewById(R.id.btnBook);
        DB = new DBHelper(this);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chek_in_date = chkInDateEditTxt.getText().toString();
                String check_in_time = chkInTimeEditTxt.getText().toString();
                String check_out_date = chkOutDateEditTxt.getText().toString();
                String check_out_time = chkOutTimeEditTxt.getText().toString();
                String room_title = roomTitleEditTxt.getText().toString();
                String number_of_rooms = noOfRoomsEditTxt.getText().toString();
                String number = noOfRoomsEditTxt.getText().toString();
                String email = emailEditTxt.getText().toString();

                Boolean checkInsertData = DB.insertBookingData(chek_in_date,check_in_time,check_out_date,check_out_time,room_title,number_of_rooms,number,email);
                if(checkInsertData == true)
                    Toast.makeText(BookingActivity.this,"Booking has been made sucessfully",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(BookingActivity.this,"Error occured",Toast.LENGTH_LONG).show();

            }
        });





        Intent intent = getIntent();
    }

    public void onClickBack(View view) {
        finish();


    }
    public void onClickPayment(View view) {
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);
    }
    public void onClickViewRoomSingle(View view) {
        Intent intent = new Intent(this, ViewRoomSingle.class);
        startActivity(intent);
    }


}