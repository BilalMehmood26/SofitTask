package com.example.sofittaskapp.model;

public class Service {

    private String mText,mTextTwo,mTextThree,mTextFour;
    private int imageUrl, secondImage,thirdImage,fourthImage;

    public Service(String mText, String mTextTwo, String mTextThree, String mTextFour, int imageUrl, int secondImage, int thirdImage, int fourthImage) {
        this.mText = mText;
        this.mTextTwo = mTextTwo;
        this.mTextThree = mTextThree;
        this.mTextFour = mTextFour;
        this.imageUrl = imageUrl;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourthImage = fourthImage;
    }

    public String getmTextTwo() {
        return mTextTwo;
    }

    public void setmTextTwo(String mTextTwo) {
        this.mTextTwo = mTextTwo;
    }

    public String getmTextThree() {
        return mTextThree;
    }

    public void setmTextThree(String mTextThree) {
        this.mTextThree = mTextThree;
    }

    public String getmTextFour() {
        return mTextFour;
    }

    public void setmTextFour(String mTextFour) {
        this.mTextFour = mTextFour;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(int secondImage) {
        this.secondImage = secondImage;
    }

    public int getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(int thirdImage) {
        this.thirdImage = thirdImage;
    }

    public int getFourthImage() {
        return fourthImage;
    }

    public void setFourthImage(int fourthImage) {
        this.fourthImage = fourthImage;
    }
}
