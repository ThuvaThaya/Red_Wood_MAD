package com.example.hrb.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrb.AdminBookingUpdateActivity;
import com.example.hrb.AdminRoomUpdateActivity;
import com.example.hrb.DBHelper;
import com.example.hrb.R;

import java.util.ArrayList;

public class AdminAddRoomAdapter extends RecyclerView.Adapter<AdminAddRoomAdapter.MyViewHolder> {
    private Context context;

    private ArrayList roomId ;
    private  ArrayList roomType;
    private ArrayList roomTitle;
    private  ArrayList roomNumber;
    private  ArrayList numOfBeds ;
    private  ArrayList numOfAdults;
    private  ArrayList numOfChildren;
    ;
    private ArrayList roomFare ;
    private ArrayList discription ;
    private  ArrayList bed ;
    private ArrayList babySitting;
    private  ArrayList wifi ;
    private  ArrayList laundry;
    Activity activity;
    DBHelper Db;
    public AdminAddRoomAdapter(Activity activity, Context context, ArrayList roomId, ArrayList roomType, ArrayList roomTitle, ArrayList roomNumber, ArrayList numOfBeds, ArrayList numOfAdults, ArrayList numOfChildren, ArrayList roomFare, ArrayList discription){
        this.activity=activity;
        this.context = context;
        this.roomId = roomId;
        this.roomType = roomType;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
        this.numOfBeds = numOfBeds;

        this.numOfAdults = numOfAdults;
        this.numOfChildren = numOfChildren;
        this.roomFare = roomFare;
        this.discription = discription;


    }

    @NonNull
    @Override
    public AdminAddRoomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_room_card, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

//        holder.room.setText(String.valueOf(roomId.get(position)));
        holder.room_title.setText(String.valueOf(roomTitle.get(position)));
        holder.room_type.setText(String.valueOf(roomType.get(position)));
        holder.room_number_field.setText(String.valueOf(roomNumber.get(position)));
        holder.num_of_beds_field.setText(String.valueOf(numOfBeds.get(position)));

//        holder.room_number_field.setText(String.valueOf(number_of_room.get(position)));
        holder.num_of_adult_field.setText(String.valueOf(numOfAdults.get(position)));
        holder.num_of_children_field.setText(String.valueOf(numOfChildren.get(position)));
        holder.fare_field.setText(String.valueOf(roomFare.get(position)));
        holder.discription_field.setText(String.valueOf(discription.get(position)));
//       holder.mainLayout.setOnClickListener((view) -> {
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Db=new DBHelper(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete ?");
                builder.setMessage("Are you sure you want to delete ?");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DBHelper myDB = new DBHelper(context);
                        myDB.deleteRoom(String.valueOf(roomId.get(position)));
                        activity.finish();

                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }

        });
        holder.btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AdminRoomUpdateActivity.class);
                intent.putExtra("room", String.valueOf(roomId.get(position)));
                intent.putExtra("room_title", String.valueOf(roomTitle.get(position)));
                intent.putExtra("room_type", String.valueOf(roomType.get(position)));
                intent.putExtra("room_number_field", String.valueOf(roomNumber.get(position)));
                intent.putExtra("num_of_beds_field", String.valueOf(numOfBeds.get(position)));

                intent.putExtra("num_of_adult_field", String.valueOf(numOfAdults.get(position)));
                intent.putExtra("num_of_children_field", String.valueOf(numOfChildren.get(position)));
                intent.putExtra("fare_field", String.valueOf(roomFare.get(position)));
                intent.putExtra("discription_field", String.valueOf(discription.get(position)));
                activity.startActivityForResult(intent, 1);
            }




        });
    }

    @Override
    public int getItemCount() {
        return roomId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView room, room_title,room_type, room_number_field,num_of_adult_field, num_of_beds_field, num_of_children_field, fare_field, discription_field;
        LinearLayout mainLayout;
        Button btnDelete,btnUpdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.room);
            room_title = itemView.findViewById(R.id.room_title);
            room_type = itemView.findViewById(R.id.room_type);
            room_number_field = itemView.findViewById(R.id.room_number_field);
            num_of_adult_field = itemView.findViewById(R.id.num_of_adult_field);
            num_of_beds_field=itemView.findViewById(R.id.num_of_beds_field);
            num_of_children_field = itemView.findViewById(R.id.num_of_children_field);


            fare_field = itemView.findViewById(R.id.fare_field);
            discription_field = itemView.findViewById(R.id.discription_field);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            btnDelete=itemView.findViewById(R.id.btnDelete);
            btnUpdate=itemView.findViewById(R.id.btnUpdate);
        }
    }
}