package com.example.ironman;

public class itemhelper {
    String itemname;
    String itemprice;

    public itemhelper() {
    }

    public itemhelper(String itemname, String itemprice) {
        this.itemname = itemname;
        this.itemprice = itemprice;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }
}
