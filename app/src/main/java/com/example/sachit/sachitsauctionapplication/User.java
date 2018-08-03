package com.example.sachit.sachitsauctionapplication;

import java.util.ArrayList;

public class User {

    private String email;
    private String name;
    private String location;
    private String userId;
    private int balance;
    private ArrayList<String> itemsBought;
    private ArrayList<String> itemsSold;

    public User(String email, String name, String location, int balance, ArrayList<String> itemsBought, ArrayList<String> itemsSold) {
        this.email = email;
        this.name = name;
        this.location = location;
        this.balance = balance;
        this.itemsBought = itemsBought;
        this.itemsSold = itemsSold;
    }

    public User(String email, String name, String location, int balance, String userId) {
        this.email = email;
        this.name = name;
        this.location = location;
        this.balance = balance;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<String> getItemsBought() {
        return itemsBought;
    }

    public ArrayList<String> getItemsSold() {
        return itemsSold;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setItemsBought(ArrayList<String> itemsBought) {
        this.itemsBought = itemsBought;
    }

    public void setItemsSold(ArrayList<String> itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "Email='" + email + '\'' +
                ", Name='" + name + '\'' +
                ", " +
                "Location='" + location + '\'' +
                ", Balance=" + balance +
                ", ItemsBought=" + itemsBought +
                ", ItemsSold=" + itemsSold +
                '}';
    }
}
