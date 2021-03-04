package com.example.demo1.controller;

public class User {

    private String userName;
    private String displayName;

    public User() {
    }

    public User(String userName, String displayName) {
        this.userName = userName;
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
