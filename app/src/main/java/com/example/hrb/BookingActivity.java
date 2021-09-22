package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {

    EditText chkInDateEditTxt,chkInTimeEditTxt,chkOutDateEditTxt,chkOutTimeEditTxt,roomTitleEditTxt,noOfRoomsEditTxt,
            mobileEditTxt,emailEditTxt,discountEditTxt,fareEditTxt;
    Button btnBook, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
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