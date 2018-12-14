package com.iamkurtgoz.progressview.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.iamkurtgoz.progressview.R;
import com.iamkurtgoz.progressview.models.EmptyListModel;

public class LoadingView {

    private View rootView;
    private LottieAnimationView lottieAnimationView;
    private TextView textTitle;

    public static LoadingView with(View rootView){
        return new LoadingView(rootView);
    }

    public LoadingView(View rootView){
        this.rootView = rootView;
        rootView.setVisibility(View.VISIBLE);
        rootView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        rootView.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;

        lottieAnimationView = (LottieAnimationView) rootView.findViewById(R.id.progress_loading_lottieView);
        textTitle = (TextView) rootView.findViewById(R.id.progress_loading_textTitle);
    }

    public void pushEmptyListView(String title){
        setAnimationView(R.raw.loading_lottie);
        if (title == null || title.equalsIgnoreCase("")){
            textTitle.setVisibility(View.GONE);
        } else {
            textTitle.setText(title);
        }
    }

    public void pushEmptyListView(int lottieResource, String title){
        setAnimationView(lottieResource);
        if (title == null || title.equalsIgnoreCase("")){
            textTitle.setVisibility(View.GONE);
        } else {
            textTitle.setText(title);
        }
    }

    private void setAnimationView(int resource){
        lottieAnimationView.setVisibility(View.VISIBLE);
        lottieAnimationView.setAnimation(resource);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
    }
}
