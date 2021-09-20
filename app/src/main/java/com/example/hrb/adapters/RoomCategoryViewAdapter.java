package com.example.hrb.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.hrb.R;
import com.example.hrb.models.RoomCategoryDetail;
import java.util.ArrayList;

public class RoomCategoryViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<RoomCategoryDetail> RoomCategoryDetailList;

    public RoomCategoryViewAdapter(Context context, ArrayList<RoomCategoryDetail> RoomCategoryDetailList) {
        this.context = context;
        this.RoomCategoryDetailList = RoomCategoryDetailList;
    }

    @Override
    public int getCount() {
        return RoomCategoryDetailList.size();
    }

    @Override
    public Object getItem(int position) {
        return RoomCategoryDetailList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = View.inflate(context, R.layout.room_category_card, null);
        }

        TextView RoomCategoryTitletTextView = (TextView) convertView.findViewById(R.id.RoomCategoryTitleTextView);
        TextView RoomDescriptionTextView = (TextView) convertView.findViewById(R.id.RoomDescriptionTextView);
        Button editBtn = (Button) convertView.findViewById(R.id.roomCategoryDeleteButton);
        Button deleteBtn = (Button) convertView.findViewById(R.id.roomCategoryEditButton);

        RoomCategoryDetail roomCategoryDetail = RoomCategoryDetailList.get(position);

        RoomCategoryTitletTextView.setText(roomCategoryDetail.getCategoryName());
        RoomDescriptionTextView.setText(roomCategoryDetail.getCategoryDescription());

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logic of edit button click
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // logic of delete button
            }
        });

        return convertView;
    }
}
