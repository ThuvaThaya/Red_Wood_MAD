package com.example.hrb.models;

public class BookingDetail {
    private String bookingTitle;
    private String bookingDescription;
    private String paymentDescription;

    public BookingDetail() {
    }

    public BookingDetail(String bookingTitle, String bookingDescription, String paymentDescription) {
        this.bookingTitle = bookingTitle;
        this.bookingDescription = bookingDescription;
        this.paymentDescription = paymentDescription;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    public void setPaymentDescription(String paymentDescription) {
        this.paymentDescription = paymentDescription;
    }
}