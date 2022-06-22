package com.example.rider;

public class Orderhelper {
    String item1,item1price,item2,item2price,item3,item3price;
    public Orderhelper() {

    }

    public Orderhelper(String item1, String item1price, String item2, String item2price, String item3, String item3price) {
        this.item1 = item1;
        this.item1price = item1price;
        this.item2 = item2;
        this.item2price = item2price;
        this.item3 = item3;
        this.item3price = item3price;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem1price() {
        return item1price;
    }

    public void setItem1price(String item1price) {
        this.item1price = item1price;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem2price() {
        return item2price;
    }

    public void setItem2price(String item2price) {
        this.item2price = item2price;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem3price() {
        return item3price;
    }

    public void setItem3price(String item3price) {
        this.item3price = item3price;
    }
}
