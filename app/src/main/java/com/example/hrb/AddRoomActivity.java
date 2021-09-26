package com.example.hrb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddRoomActivity extends AppCompatActivity {

    EditText roomType,roomTitle,roomNumber,numOfBeds,numOfAdults, numOfChildren, roomFare,discription ;
    CheckBox bed,babySitting,wifi,laundry;
    ImageView roomImage;
    Button choose,add;
    public  static DBHelper DB;

    final int REQUEST_CODE_GALLERY=999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        DB = new DBHelper(this);

        roomType =  (EditText)findViewById(R.id.RoomType);
        roomTitle = (EditText) findViewById(R.id.Title_Room);
        roomNumber = (EditText) findViewById(R.id.RoomNumber);
        numOfBeds = (EditText) findViewById(R.id.NoBeds);
        numOfAdults = (EditText) findViewById(R.id.MaxAdults);
        numOfChildren = (EditText) findViewById(R.id.MaxChildren);
        roomFare =  (EditText) findViewById(R.id.RoomFare);
        discription =  (EditText) findViewById(R.id.RoomDescription);
        bed =  (CheckBox) findViewById(R.id.simpleCheckBox1);
        babySitting =  (CheckBox) findViewById(R.id.simpleCheckBox2);
        wifi =  (CheckBox) findViewById(R.id.simpleCheckBox3);
        laundry =  (CheckBox) findViewById(R.id.simpleCheckBox4);
        roomImage =  (ImageView) findViewById(R.id.ImageRoom);
        choose =  (Button) findViewById(R.id.btnChoose);
        add =  (Button) findViewById(R.id.btnRoomAdd);


        //
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        AddRoomActivity.this,
                        new String[]  {Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PackageManager.PERMISSION_GRANTED
                );
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB.addRoom(
                        roomType.getText().toString().trim(),
                        roomTitle.getText().toString().trim(),
                        roomNumber.getText().toString().trim(),
                        numOfBeds.getText().toString().trim(),
                        numOfAdults.getText().toString().trim(),
                        numOfChildren.getText().toString().trim(),
                        roomFare.getText().toString().trim(),
                        discription.getText().toString().trim(),
                        bed.isChecked(),
                        babySitting.isChecked(),
                        wifi.isChecked(),
                        laundry.isChecked()



                );
                roomType.setText("");
                roomTitle.setText("");
                roomNumber.setText("");
                numOfBeds.setText("");
                numOfAdults.setText("");
                numOfChildren.setText("");
                roomFare.setText("");
                discription.setText("");
                bed.setChecked(false);
                babySitting.setChecked(false);
                wifi.setChecked(false);
                laundry.setChecked(false);




            }
        });






        Intent intent = getIntent();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.println("uuuu");
        if(requestCode==0){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }else{
                Toast.makeText(getApplicationContext(), "can't access the gallery", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case REQUEST_CODE_GALLERY:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(
                            selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
                    System.out.println(yourSelectedImage);
                }
        }
    }

    public void onClickBack(View view) {

        finish();
    }
    public void onClickViewRoomAdmin(View view) {
        Intent intent = new Intent(this, ViewRoomActivity.class);
        startActivity(intent);
    }
}