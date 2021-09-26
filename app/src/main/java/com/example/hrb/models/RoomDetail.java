package com.example.hrb.models;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.hrb.R;

public class RoomDetail {
    private int roomId ;
    private  String roomType;
    private String roomTitle;
    private  String roomNumber;
    private  String numOfBeds ;
    private  String numOfAdults;
    private  String numOfChildren;
    private String roomFare ;
    private String discription ;
    private  boolean bed ;
    private boolean babySitting;
    private  boolean wifi ;
    private  boolean laundry;

    public RoomDetail() {
    }

    public RoomDetail(int roomId,String roomType, String roomTitle, String roomNumber, String numOfBeds, String numOfAdults, String numOfChildren, String roomFare, String discription, boolean bed, boolean babySitting, boolean wifi, boolean laundry) {
        this.roomId=roomId;
        this.roomType = roomType;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
        this.numOfBeds = numOfBeds;
        this.numOfAdults = numOfAdults;
        this.numOfChildren = numOfChildren;
        this.roomFare = roomFare;
        this.discription = discription;
        this.bed = bed;
        this.babySitting = babySitting;
        this.wifi = wifi;
        this.laundry = laundry;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(String numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public String getNumOfAdults() {
        return numOfAdults;
    }

    public void setNumOfAdults(String numOfAdults) {
        this.numOfAdults = numOfAdults;
    }

    public String getNumOfChildren() {
        return numOfChildren;
    }

    public void setNumOfChildren(String numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    public String getRoomFare() {
        return roomFare;
    }

    public void setRoomFare(String roomFare) {
        this.roomFare = roomFare;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isBed() {
        return bed;
    }

    public void setBed(boolean bed) {
        this.bed = bed;
    }

    public boolean isBabySitting() {
        return babySitting;
    }

    public void setBabySitting(boolean babySitting) {
        this.babySitting = babySitting;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }
}
