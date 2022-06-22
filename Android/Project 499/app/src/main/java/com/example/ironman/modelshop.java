package com.example.ironman;

public class modelshop
{
    String name,service,address,purl;
    modelshop()
    {

    }
    public modelshop(String name, String service, String address, String purl) {
        this.name = name;
        this.service = service;
        this.address = address;
        this.purl = purl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
