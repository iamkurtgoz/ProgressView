package com.iamkurtgoz.progressview.models;

import com.iamkurtgoz.progressview.R;

public class CustomModel {

    private int lottieResource = R.raw.error_lottie;
    private int imageResource = R.drawable.error_image;
    private String title, subTitle, btnText;

    public CustomModel(){

    }

    public int getLottieResource() {
        return lottieResource;
    }

    public void setLottieResource(int lottieResource) {
        this.lottieResource = lottieResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }
}
