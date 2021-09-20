package com.example.hrb.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.hrb.R;
import com.example.hrb.models.BookingDetail;

import java.util.ArrayList;

public class AdminBookingDetailsAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<BookingDetail> bookingDetailsList;

    public AdminBookingDetailsAdapter(Context context, ArrayList<BookingDetail> bookingDetailsList) {
        this.context = context;
        this.bookingDetailsList = bookingDetailsList;
    }

    @Override
    public int getCount() {
        return bookingDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookingDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = View.inflate(context, R.layout.booking_detail_card_admin, null);
        }

        TextView bookingTitletTextView = (TextView) convertView.findViewById(R.id.bookingTitleTextView);
        TextView bookingDescriptionTextView = (TextView) convertView.findViewById(R.id.bookingDescriptionTextView);
        TextView paymentDescriptionTextView = (TextView) convertView.findViewById(R.id.paymentTextView);
        Button deleteBtn = (Button) convertView.findViewById(R.id.deleteButton);

        BookingDetail bookingDetail = bookingDetailsList.get(position);
        bookingTitletTextView.setText(bookingDetail.getBookingTitle());
        bookingDescriptionTextView.setText(bookingDetail.getBookingDescription());
        paymentDescriptionTextView.setText(bookingDetail.getPaymentDescription());



        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logic of delete button
            }
        });

        return convertView;
    }
}

