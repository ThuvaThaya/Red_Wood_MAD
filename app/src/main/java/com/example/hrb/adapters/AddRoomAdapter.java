package com.example.hrb.adapters;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hrb.R;
import com.example.hrb.models.RoomDetail;

import java.util.ArrayList;

public class AddRoomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<RoomDetail> roomList;

    public AddRoomAdapter(Context context, int layout, ArrayList<RoomDetail> roomList) {
        this.context = context;
        this.layout = layout;
        this.roomList = roomList;
    }

    @Override
    public int getCount() {
        return roomList.size();
    }

    @Override
    public Object getItem(int position) {
        return roomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView room_title,room_type,room_number_field,num_of_adult_field,num_of_beds_field,num_of_children_field,fare_field,discription_field;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder viewHolder=new ViewHolder();
        if(row==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            row = View.inflate(context, layout, null);
            row=inflater.inflate(layout,null);

            viewHolder.room_title=row.findViewById(R.id.room_title);
            viewHolder.room_type=row.findViewById(R.id.RoomType);
            viewHolder.room_number_field=row.findViewById(R.id.room_number_field);
            viewHolder.num_of_adult_field=row.findViewById(R.id.num_of_adult_field);
            viewHolder.num_of_beds_field=row.findViewById(R.id.num_of_beds_field);
            viewHolder.num_of_children_field=row.findViewById(R.id.num_of_children_field);
            viewHolder.fare_field=row.findViewById(R.id.fare_field);
            viewHolder.discription_field=row.findViewById(R.id.discription_field);
            row.setTag(viewHolder);



        }else {
            RoomDetail room=roomList.get(position);

            viewHolder.room_title.setText(room.getRoomTitle());
            viewHolder.room_type.setText(room.getRoomType());
            viewHolder.room_number_field.setText(room.getRoomNumber());
            viewHolder.num_of_adult_field.setText(room.getNumOfAdults());
            viewHolder.num_of_beds_field.setText(room.getNumOfBeds());
            viewHolder.num_of_children_field.setText(room.getNumOfChildren());
            viewHolder.fare_field.setText(room.getRoomFare());
            viewHolder.discription_field.setText(room.getDiscription());


        }
        return row;
    }
}