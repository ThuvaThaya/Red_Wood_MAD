package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import com.example.hrb.adapters.RoomCategoryViewAdapter;
import com.example.hrb.models.RoomCategoryDetail;

public class RoomCategoryViewActivity extends AppCompatActivity {
    private ListView categoryListView;
    private ArrayList<RoomCategoryDetail> categoryArrayList;
    private RoomCategoryViewAdapter RoomCategoryViewAdapter;
    TextView AddRoomCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_category_view);

        // get intend with button press on previous activity
        Intent intent = getIntent();

        categoryListView = findViewById(R.id.roomCategoryListView);
        categoryArrayList = getData();
        RoomCategoryViewAdapter = new RoomCategoryViewAdapter(RoomCategoryViewActivity.this, categoryArrayList);
        categoryListView.setAdapter(RoomCategoryViewAdapter);
        AddRoomCategory = findViewById(R.id.AddRoomCategory);
        AddRoomCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddRoomCatergory();
            }
        });

    }

    public ArrayList<RoomCategoryDetail> getData() {
        ArrayList<RoomCategoryDetail> RoomCategoryDetailList = new ArrayList<>();
        RoomCategoryDetail b1 = new RoomCategoryDetail("Room 1", "Description 1");
        RoomCategoryDetail b2 = new RoomCategoryDetail("Room 2", "Description 2");
        RoomCategoryDetail b3 = new RoomCategoryDetail("Room 3", "Description 3");

        Collections.addAll(RoomCategoryDetailList, b1, b2, b3);

        return RoomCategoryDetailList;
    }

    public void onClickBack(View view) {
        finish();
    }
    public void AddRoomCatergory(){
        Intent intent = new Intent(this, CreateRActivity.class);
        startActivity(intent);
    }
    public void onClickHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
