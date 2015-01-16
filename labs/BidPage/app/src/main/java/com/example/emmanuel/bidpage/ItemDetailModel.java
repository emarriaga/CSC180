package com.example.emmanuel.bidpage;

import java.util.Observable;

public class ItemDetailModel extends Observable {
    private int id;
    public void setId(int id) {
        this.id = id;
        setChanged();
        notifyObservers();
    }
    public int getId() {
        return id;
    }
    private String name;
    public void setName(String name) {
        this.name = name;
        setChanged();
        notifyObservers();
    }
    public String getName() {
        return name;
    }
    private String shortDescription;
    public void setShortDescription(String description) {
        this.shortDescription = description;
        setChanged();
        notifyObservers();
    }
    public String getShortDescription() {
        return shortDescription;
    }
    private String longDescription;
    public void setLongDescription(String description) {
        this.longDescription = description;
        setChanged();
        notifyObservers();
    }
    public String getLongDescription() {
        return longDescription;
    }
    private int currentBid;
    public void setCurrentBid(int amount) {
        this.currentBid = amount;
        setChanged();
        notifyObservers();
    }
    public int getCurrentBid() {
        return currentBid;
    }
}
