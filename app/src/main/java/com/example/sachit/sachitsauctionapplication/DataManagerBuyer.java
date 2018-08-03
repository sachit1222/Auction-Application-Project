package com.example.sachit.sachitsauctionapplication;

import java.util.ArrayList;

class DataManagerBuyer {
    private static final DataManagerBuyer ourInstance = new DataManagerBuyer();

    static DataManagerBuyer getInstance() {

        return ourInstance;
    }


    private ArrayList<String> items;
    private DataManagerBuyer() {


        items = new ArrayList<>();


    }

    public ArrayList<String> getItems() {
        return items;
    }
    public void addItems(String item){
        items.add(item);
    }
    public void removeItem(int itemIndex){
        items.remove(itemIndex);
    }
}
