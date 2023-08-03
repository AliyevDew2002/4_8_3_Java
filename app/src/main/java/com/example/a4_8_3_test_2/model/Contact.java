package com.example.a4_8_3_test_2.model;

import java.io.Serializable;

public class Contact implements Serializable {
    int photo;
    String name,number,manzil;

    public Contact(int photo, String number, String name,String manzil) {
        this.photo = photo;
        this.number = number;
        this.name = name;
        this.manzil=manzil;
    }

    public int getPhoto() {
        return photo;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public String getManzil() {
        return manzil;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }


}
