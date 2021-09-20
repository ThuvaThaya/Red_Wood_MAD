package com.example.hrb.models;

public class RoomCategoryDetail {
    private String CategoryName;
    private String CategoryDescription;

    public RoomCategoryDetail() {
    }

    public RoomCategoryDetail(String CategoryName, String CategoryDescription) {
        this.CategoryName = CategoryName;
        this.CategoryDescription = CategoryDescription;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setBookingTitle(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public String getCategoryDescription() {
        return CategoryDescription;
    }

    public void setCategoryDescription(String CategoryDescription) {
        this.CategoryDescription = CategoryDescription;
    }
}
