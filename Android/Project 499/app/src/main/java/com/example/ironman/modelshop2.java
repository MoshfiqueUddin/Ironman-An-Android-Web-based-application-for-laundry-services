package com.example.ironman;

public class modelshop2 {
    String shopName,address,email;

    public modelshop2() {
    }

    public modelshop2(String shopName, String address, String email) {
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
