package com.iamkurtgoz.progressview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public abstract class ViewUtils extends LinearLayout {

    private LayoutInflater progressLayoutInflater;

    public ViewUtils(Context context) {
        super(context);
        buildInit(context, null);
    }

    public ViewUtils(Context context, AttributeSet attrs) {
        super(context, attrs);
        buildInit(context, attrs);
    }

    private void buildInit(Context context, AttributeSet attributeSet){
        progressLayoutInflater = LayoutInflater.from(getContext());
        init(context, attributeSet);
    }

    public abstract void init(Context context, AttributeSet attributeSet);


    /**
     * View return functions
     * @param id
     * @param tag
     * @return
     */

    public View getLayoutView(int id, String tag) {
        View view = progressLayoutInflater.inflate(id, null, false);
        view.setTag(tag);
        view.setVisibility(View.GONE);
        return view;
    }

    public void hideAllView(View... views){
        for (View view : views){
            view.setVisibility(GONE);
        }
    }
}
