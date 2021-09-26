package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.hrb.adapters.AddRoomAdapter;
import com.example.hrb.models.RoomDetail;

import java.util.ArrayList;

public class ViewRoomActivity extends AppCompatActivity {
    private ListView roomList;
    AddRoomAdapter adapter=null;
    ArrayList<RoomDetail> rooms;
    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_details);

        Intent intent = getIntent();
        roomList = findViewById(R.id.roomList);
        rooms=new ArrayList<>();
        adapter=new AddRoomAdapter(this,R.layout.view_room_card,rooms);
        roomList.setAdapter(adapter);
        db=new DBHelper(this);
        Cursor cursor=AddRoomActivity.DB.getRooms();
        rooms.clear();
        while(cursor.moveToFirst()){
            try {
                System.out.println(cursor.getString(1));
                int id=cursor.getInt(0);
                String roomType=cursor.getString(1);
                String roomTitle = cursor.getString(2);;
                String roomNumber = cursor.getString(3);
                String numOfBeds = cursor.getString(4);;
                String numOfAdults = cursor.getString(5);;
                String numOfChildren = cursor.getString(6);;
                String roomFare = cursor.getString(7);;
                String discription = cursor.getString(8);;
                boolean bed = cursor.getInt(9)>0;;
                boolean babySitting = cursor.getInt(10)>0;;
                boolean wifi = cursor.getInt(11)>0;;
                boolean laundry = cursor.getInt(12)>0;

                rooms.add(new RoomDetail(id,roomType,roomTitle,roomNumber,numOfBeds,numOfAdults,numOfChildren,roomFare,discription,bed,babySitting,wifi,laundry));
            }catch (Exception e){
                e.printStackTrace();
            }
            adapter.notifyDataSetChanged();
        }


    }
    public void onClickBack(View view) {
        finish();
    }
    public void onClickViewRoomSingle(View view) {
        Intent intent = new Intent(this, ViewRoomSingle.class);
        startActivity(intent);
    }

    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}