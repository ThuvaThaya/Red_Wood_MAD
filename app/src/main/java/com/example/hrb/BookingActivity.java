package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BookingActivity extends AppCompatActivity {

    EditText chkInDateEditTxt,chkInTimeEditTxt,chkOutDateEditTxt,chkOutTimeEditTxt,noOfRoomsEditTxt,
            emailEditTxt;
    EditText mobileEditTxt;
    private TextView discountEditTxt,fareEditTxt;
    private Button btnBook, btnCancel;
    private Spinner roomTitleEditTxt;
    DBHelper DB;

    String [] room_title ={"Single", "Double","Triple", "Quad", "King", "Queen"};
    double value;
    int quantity;
    double totalValue;
    double discountValue;

    String selectRoomTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        chkInDateEditTxt =  (EditText)findViewById(R.id.chkInDateEditTxt);
        chkInTimeEditTxt = (EditText) findViewById(R.id.chkInTimeEditTxt);
        chkOutDateEditTxt = (EditText) findViewById(R.id.chkOutDateEditTxt);
        chkOutTimeEditTxt = (EditText) findViewById(R.id.chkOutTimeEditTxt);
        noOfRoomsEditTxt = (EditText) findViewById(R.id.noOfRoomsEditTxt);
        mobileEditTxt = (EditText) findViewById(R.id.mobileEditTxt);
        emailEditTxt =  (EditText) findViewById(R.id.emailEditTxt);
        roomTitleEditTxt = findViewById(R.id.roomTitleEditTxt);
        discountEditTxt = (TextView) findViewById(R.id.discountEditTxt);
        fareEditTxt = (TextView)findViewById(R.id.fareEditTxt);
        btnBook = (Button) findViewById(R.id.btnBook);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,room_title);
        roomTitleEditTxt.setAdapter(adapter);

        roomTitleEditTxt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
             selectRoomTitle = room_title [position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        noOfRoomsEditTxt.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View view, int i, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){

                    Log.d("onItemSelected: ",selectRoomTitle);
                    quantity = Integer.parseInt(noOfRoomsEditTxt.getText().toString());
                    if(selectRoomTitle.equals("Single")){
                        value = 5000;
                        if(quantity > 5){
                            discountValue = (value * 0.05);
                            totalValue = (value * quantity) - discountValue;
                        }else{
                            totalValue = (value * quantity);
                        }

                    }else if(selectRoomTitle.equals("Double")){
                        value = 3000;
                        if(quantity > 5){
                            discountValue = (value * 0.05);
                            totalValue = (value * quantity) - discountValue;
                        }else{
                            totalValue = (value * quantity);
                        }

                    }else if(selectRoomTitle.equals("Triple")){
                        value = 10000;
                        if(quantity > 5){
                            discountValue = (value * 0.05);
                            totalValue = (value * quantity) - discountValue;
                        }
                        else{
                            totalValue = (value * quantity);
                        }

                    }else if(selectRoomTitle.equals("Quad")){
                        value = 12000;
                        if(quantity > 5){
                            discountValue = (value * 0.05);
                            totalValue = (value * quantity) - discountValue;
                        }
                        else{
                            totalValue = (value * quantity);
                        }

                    }
                    else if(selectRoomTitle.equals("King")){
                        value = 15000;
                        if(quantity > 5){
                            discountValue = (value * 0.20);
                            totalValue = (value * quantity) - discountValue;
                        }
                        else{
                            totalValue = (value * quantity);
                        }

                    }
                    else if(selectRoomTitle.equals("Queen")){
                        value = 12000;
                        if(quantity > 5){
                            discountValue = (value * 0.20);
                            totalValue = (value * quantity) - discountValue;
                        }
                        else{
                            totalValue = (value * quantity);
                        }

                    }
                    else{
                        try {
                            throw new Exception("user not selected");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    discountEditTxt.setText("Discout:"+String.valueOf(discountValue));
                    fareEditTxt.setText("Total:"+String.valueOf(totalValue));
                    return true;
                }
                return false;
            }
        });
        btnBook = (Button) findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(chkInDateEditTxt.getText().toString().trim());
                System.out.println(chkInTimeEditTxt.getText().toString().trim());
                System.out.println(chkOutDateEditTxt.getText().toString().trim());
                System.out.println(chkOutTimeEditTxt.getText().toString().trim());
                System.out.println(roomTitleEditTxt.getSelectedItem().toString());
                System.out.println(noOfRoomsEditTxt.getText().toString());
                System.out.println(mobileEditTxt.getText().toString().trim());
                System.out.println(emailEditTxt.getText().toString().trim());
                System.out.println(discountEditTxt.getText().toString().trim());
                System.out.println(fareEditTxt.getText().toString().trim());
                DBHelper DB = new DBHelper(BookingActivity.this);
                    DB.insertBookingData(
                            chkInDateEditTxt.getText().toString().trim(),
                            chkInTimeEditTxt.getText().toString().trim(),
                            chkOutDateEditTxt.getText().toString().trim(),
                            chkOutTimeEditTxt.getText().toString().trim(),
                            roomTitleEditTxt.getSelectedItem().toString(),
                            noOfRoomsEditTxt.getText().toString().trim(),
                            mobileEditTxt.getText().toString().trim(),
                            emailEditTxt.getText().toString().trim(),
                            discountEditTxt.getText().toString().trim(),
                            fareEditTxt.getText().toString().trim()

                    );
                Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                startActivity(intent);

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