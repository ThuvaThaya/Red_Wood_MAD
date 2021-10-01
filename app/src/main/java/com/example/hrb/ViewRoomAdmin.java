package com.example.hrb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hrb.adapters.AddRoomAdapter;
import com.example.hrb.adapters.AdminAddRoomAdapter;
import com.example.hrb.adapters.AdminBookingAdapter;

import java.util.ArrayList;

public class ViewRoomAdmin extends AppCompatActivity {

    RecyclerView recyclearView1;
    DBHelper myDB;
    private ArrayList<String> roomId ,roomType, roomTitle,roomNumber, numOfBeds,
            numOfAdults,numOfChildren,roomFare,discription ;
    private ArrayList<Boolean> bed,babySitting,wifi,laundry;
    AdminAddRoomAdapter adminRoomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_room_admin);
        recyclearView1 = findViewById(R.id.recyclerview1);
        myDB = new DBHelper(ViewRoomAdmin.this);
        roomId = new ArrayList<>();

        roomType = new ArrayList<>();
        roomTitle = new ArrayList<>();
        roomNumber = new ArrayList<>();
        numOfBeds = new ArrayList<>();
        numOfAdults = new ArrayList<>();
        numOfChildren = new ArrayList<>();

        roomFare = new ArrayList<>();
        discription = new ArrayList<>();

        storeDataInArrays();
        adminRoomAdapter = new AdminAddRoomAdapter(ViewRoomAdmin.this,this,roomId,
                roomType, roomTitle,roomNumber,
                numOfBeds, numOfAdults, numOfChildren, roomFare, discription);
        System.out.println(adminRoomAdapter);
        recyclearView1.setAdapter(adminRoomAdapter);
        recyclearView1.setLayoutManager(new LinearLayoutManager(ViewRoomAdmin.this));
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.getRooms();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){




                roomId.add(cursor.getString(0));
                roomType.add(cursor.getString(1));
                roomTitle.add(cursor.getString(2));
                roomNumber.add(cursor.getString(3));
                numOfBeds.add(cursor.getString(4));

                numOfAdults.add(cursor.getString(5));
                numOfChildren.add(cursor.getString(6));
                roomFare.add(cursor.getString(7));
                discription.add(cursor.getString(8));

            }
        }
    }


    public void onClickBack(View view) {
        finish();
    }
    public void onClickAddRoom(View view) {
        Intent intent = new Intent(this, AddRoomActivity.class);
        startActivity(intent);
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}