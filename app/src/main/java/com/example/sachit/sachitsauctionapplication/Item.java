package com.example.sachit.sachitsauctionapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


public class Item {


    private String name;


    private String description;


    private String bidPrice;


    private String buyNowPrice;

    private String itemId;


    public Item(String name, String description, String bidPrice, String buyNowPrice) {
        this.name = name;
        this.description = description;
        this.bidPrice = bidPrice;
        this.buyNowPrice = buyNowPrice;
        //this.itemId = itemId;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(String buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return getName() + " " + getBidPrice() + " " +
                getBuyNowPrice() + " " + getDescription();
    }

}
