package com.example.hrb.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrb.AdminBookingUpdateActivity;
import com.example.hrb.R;

import java.util.ArrayList;


public class AdminBookingAdapter extends RecyclerView.Adapter<AdminBookingAdapter.MyViewHolder> {
    private  Context context;
    private  ArrayList Booking_id;
    private  ArrayList check_in_date;
    private  ArrayList check_in_time;
    private  ArrayList check_out_date;
    private  ArrayList check_out_time;
    private ArrayList room_type;
    private ArrayList number_of_room;
    private ArrayList email;
    private ArrayList number;
    private ArrayList discount;
    private ArrayList fare;
    Activity activity;

    public AdminBookingAdapter(Activity activity, Context context, ArrayList Booking_id, ArrayList check_in_date, ArrayList check_in_time, ArrayList check_out_date, ArrayList check_out_time, ArrayList room_type, ArrayList number_of_room, ArrayList email, ArrayList number, ArrayList discount, ArrayList fare){
        this.activity=activity;
        this.context = context;
        this.Booking_id = Booking_id;
        this.check_in_date = check_in_date;
        this.check_in_time = check_in_time;
        this.check_out_date = check_out_date;
        this.check_out_time = check_out_time;
        this.room_type = room_type;
        this.number_of_room = number_of_room;
        this.number = number;
        this.discount = discount;
        this.fare = fare;
        this.email = email;

    }

    @NonNull
    @Override
    public AdminBookingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.booking_detail_card, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.Booking_id_txt.setText(String.valueOf(Booking_id.get(position)));
        holder.check_in_date_txt.setText(String.valueOf(check_in_date.get(position)));
        holder.check_in_time_txt.setText(String.valueOf(check_in_time.get(position)));
        holder.check_out_date_txt.setText(String.valueOf(check_out_date.get(position)));
        holder.check_out_time_txt.setText(String.valueOf(check_out_time.get(position)));
        holder.room_type_txt.setText(String.valueOf(room_type.get(position)));
        holder.number_of_room_txt.setText(String.valueOf(number_of_room.get(position)));
        holder.number_txt.setText(String.valueOf(number.get(position)));
        holder.discount_txt.setText(String.valueOf(discount.get(position)));
        holder.fare_txt.setText(String.valueOf(fare.get(position)));
        holder.email_txt.setText(String.valueOf(email.get(position)));
//       holder.mainLayout.setOnClickListener((view) -> {
        holder.mainLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AdminBookingUpdateActivity.class);
                intent.putExtra("id", String.valueOf(Booking_id.get(position)));
                intent.putExtra("check_in_date", String.valueOf(check_in_date.get(position)));
                intent.putExtra("check_in_time", String.valueOf(check_in_time.get(position)));
                intent.putExtra("check_out_date", String.valueOf(check_out_date.get(position)));
                intent.putExtra("check_out_time", String.valueOf(check_out_time.get(position)));
                intent.putExtra("room_type", String.valueOf(number_of_room.get(position)));
                intent.putExtra("number", String.valueOf(number.get(position)));
                intent.putExtra("discount", String.valueOf(discount.get(position)));
                intent.putExtra("fare", String.valueOf(fare.get(position)));
                intent.putExtra("email", String.valueOf(email.get(position)));
                activity.startActivityForResult(intent, 1);
            }




        });
    }

    @Override
    public int getItemCount() {
        return Booking_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Booking_id_txt, check_in_date_txt,check_out_date_txt, check_in_time_txt,check_out_time_txt, room_type_txt, number_of_room_txt, email_txt, number_txt, discount_txt, fare_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Booking_id_txt = itemView.findViewById(R.id.book_id);
            check_in_date_txt = itemView.findViewById(R.id.chckInDate);
            check_in_time_txt = itemView.findViewById(R.id.textView65);
            check_out_date_txt = itemView.findViewById(R.id.chckOutDate);
            check_out_time_txt = itemView.findViewById(R.id.textView21);
            email_txt = itemView.findViewById(R.id.textemail);
            room_type_txt = itemView.findViewById(R.id.chckInTime);
            number_of_room_txt = itemView.findViewById(R.id.noOfRooms);
            number_txt = itemView.findViewById(R.id.textNumber);
            discount_txt = itemView.findViewById(R.id.textDiscount);
            fare_txt = itemView.findViewById(R.id.textFare);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
