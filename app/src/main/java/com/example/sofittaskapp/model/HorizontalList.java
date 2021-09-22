package com.example.sofittaskapp.model;

public class HorizontalList {

    private String mText;
    private String imageUrl;

    public HorizontalList(String mText, String imageUrl) {
        this.mText = mText;
        this.imageUrl = imageUrl;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
