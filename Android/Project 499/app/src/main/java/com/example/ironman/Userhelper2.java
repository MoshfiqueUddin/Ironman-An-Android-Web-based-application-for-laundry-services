package com.example.ironman;

public class Userhelper2 {
    String name;
    String email;
    String age;

    public Userhelper2() {

    }

    public Userhelper2(String name, String email, String age) {
        this.name = name;
        this.email = email;
        this.age = age;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
