package com.example.ironmanshops;

import android.os.Bundle;

public class user {
    public String shopName, address, email;

    public user() {
    }

    public user(String shopName, String address, String email) {
        this.shopName = shopName;
        this.address = address;
        this.email = email;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
