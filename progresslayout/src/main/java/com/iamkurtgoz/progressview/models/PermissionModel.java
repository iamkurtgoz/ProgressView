package com.iamkurtgoz.progressview.models;

import com.iamkurtgoz.progressview.R;

public class PermissionModel {

    private int lottieResource = R.raw.permission_lottie;
    private int imageResource = R.drawable.error_image;
    private String title, subTitle, btnText;
    private String[] mPermissions;

    public PermissionModel(){

    }

    public int getLottieResource() {
        return lottieResource;
    }

    public void setLottieResource(int lottieResource) {
        this.lottieResource = lottieResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
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

    public String[] getmPermissions() {
        return mPermissions;
    }

    public void setmPermissions(String... mPermissions) {
        this.mPermissions = new String[mPermissions.length];
        byte i = 0;
        for (String s: mPermissions){
            this.mPermissions[i] = s;
            i++;
        }
    }
}
