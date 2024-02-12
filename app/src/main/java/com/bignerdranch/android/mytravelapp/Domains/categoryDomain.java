package com.bignerdranch.android.mytravelapp.Domains;

public class categoryDomain {
    private String title;
    private String picPath;

    public categoryDomain(String title, String picPath) {
        this.title = title;
        this.picPath = picPath;
    }

    public String getTitle() {
        return title;
    }

    public String getPicPath() {
        return picPath;
    }

}
