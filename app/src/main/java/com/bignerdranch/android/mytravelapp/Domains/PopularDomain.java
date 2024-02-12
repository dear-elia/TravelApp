package com.bignerdranch.android.mytravelapp.Domains;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title;
    private String location;
    private String description;
    private int bed;
    private boolean guide;
    private double score;
    private String pic;
    private boolean wifi;
    private int price;

    public PopularDomain(String title, String location, String description, int bed, boolean guide, double score, String pic, boolean wifi, int price) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.bed = bed;
        this.guide = guide;
        this.score = score;
        this.pic = pic;
        this.wifi = wifi;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getBed() {
        return bed;
    }

    public boolean isGuide() {
        return guide;
    }

    public double getScore() {
        return score;
    }

    public String getPic() {
        return pic;
    }

    public boolean isWifi() {
        return wifi;
    }
}
