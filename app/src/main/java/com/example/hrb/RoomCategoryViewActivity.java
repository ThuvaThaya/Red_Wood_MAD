package com.example.hrb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

import com.example.hrb.adapters.RoomCategoryViewAdapter;
import com.example.hrb.models.RoomCategoryDetail;

public class RoomCategoryViewActivity extends AppCompatActivity {
    private ListView categoryListView;
    private ArrayList<RoomCategoryDetail> categoryArrayList;
    private RoomCategoryViewAdapter RoomCategoryViewAdapter;

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

    }

    public ArrayList<RoomCategoryDetail> getData() {
        ArrayList<RoomCategoryDetail> RoomCategoryDetailList = new ArrayList<>();
        RoomCategoryDetail b1 = new RoomCategoryDetail("Room 1", "Description 1");
        RoomCategoryDetail b2 = new RoomCategoryDetail("Room 2", "Description 2");
        RoomCategoryDetail b3 = new RoomCategoryDetail("Room 3", "Description 3");
        RoomCategoryDetail b4 = new RoomCategoryDetail("Room 4", "Description 4");
        RoomCategoryDetail b5 = new RoomCategoryDetail("Room 5", "Description 5");
        RoomCategoryDetail b6 = new RoomCategoryDetail("Room 6", "Description 6");
        RoomCategoryDetail b7 = new RoomCategoryDetail("Room 7", "Description 7");
        RoomCategoryDetail b8 = new RoomCategoryDetail("Room 8", "Description 8");
        RoomCategoryDetail b9 = new RoomCategoryDetail("Room 9", "Description 9");
        Collections.addAll(RoomCategoryDetailList, b1, b2, b3, b4, b5, b6, b7, b8, b9);

        return RoomCategoryDetailList;
    }

    public void onClickBack(View view) {
        finish();
    }
}
