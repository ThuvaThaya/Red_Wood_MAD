package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.hrb.adapters.AdminBookingDetailsAdapter;
import com.example.hrb.adapters.BookingDetailsAdapter;
import com.example.hrb.models.BookingDetail;

import java.util.ArrayList;
import java.util.Collections;

public class BookingDetailsAdminActivity extends AppCompatActivity {
    private ListView bookingListView;
    private ArrayList<BookingDetail> bookingDetailsList;
    private AdminBookingDetailsAdapter bookingDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details_admin);

        // get intend with button press on previous activity
        Intent intent = getIntent();

        bookingListView = findViewById(R.id.bookingDetailsList);
        bookingDetailsList = getData();
        bookingDetailsAdapter = new AdminBookingDetailsAdapter(BookingDetailsAdminActivity.this, bookingDetailsList);
        bookingListView.setAdapter(bookingDetailsAdapter);

    }

    public ArrayList<BookingDetail> getData(){
        ArrayList<BookingDetail> bookingDetailsList = new ArrayList<>();
        BookingDetail b1 = new BookingDetail("Booking 1", "Description 1", "HB");
        BookingDetail b2 = new BookingDetail("Booking 2", "Description 2", "FB");
        BookingDetail b3 = new BookingDetail("Booking 3", "Description 3", "FB");
        BookingDetail b4 = new BookingDetail("Booking 4", "Description 4", "HB");
        BookingDetail b5 = new BookingDetail("Booking 5", "Description 5", "HB");
        BookingDetail b6 = new BookingDetail("Booking 6", "Description 6", "FB");
        BookingDetail b7 = new BookingDetail("Booking 7", "Description 7", "HB");
        BookingDetail b8 = new BookingDetail("Booking 8", "Description 8", "FB");
        BookingDetail b9 = new BookingDetail("Booking 9", "Description 9", "HB");
        Collections.addAll(bookingDetailsList, b1,b2,b3, b4,b5,b6,b7,b8,b9);

        return bookingDetailsList;
    }

    public void onClickBack(View view) {
        finish();
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}