package com.iamkurtgoz.progressview.views;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.iamkurtgoz.progressview.R;
import com.iamkurtgoz.progressview.models.NetworkModel;

public class NetworkView {

    private View rootView;
    private LottieAnimationView lottieAnimationView;
    private ImageView imgView;
    private TextView textTitle, textSubTitle;
    private Button btnOk;

    private boolean withLottie = true;

    public static NetworkView with(View rootView, boolean withLottie){
        return new NetworkView(rootView, withLottie);
    }

    public NetworkView(View rootView, boolean withLottie){
        this.rootView = rootView;
        this.withLottie = withLottie;
        rootView.setVisibility(View.VISIBLE);
        rootView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        rootView.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;

        lottieAnimationView = (LottieAnimationView) rootView.findViewById(R.id.progress_network_layout_lottieView);
        imgView = (ImageView) rootView.findViewById(R.id.progress_network_layout_imgView);
        textTitle = (TextView) rootView.findViewById(R.id.progress_network_layout_textTitle);
        textSubTitle = (TextView) rootView.findViewById(R.id.progress_network_layout_textSubTitle);
        btnOk = (Button) rootView.findViewById(R.id.progress_network_layout_btnOk);

        lottieAnimationView.setVisibility(View.GONE);
        imgView.setVisibility(View.GONE);
    }

    public void pushLostNetwork(View.OnClickListener onClickListener){
        setAnimationView(withLottie ? R.raw.network_error_lottie : R.drawable.network_error_image);
        btnOk.setOnClickListener(onClickListener);
    }

    public void pushLostNetwork(NetworkModel model, View.OnClickListener onClickListener){
        setAnimationView(withLottie ? model.getLottieResource() : model.getImageResource());
        textTitle.setText(model.getTitle());
        textSubTitle.setText(model.getSubTitle());
        btnOk.setText(model.getBtnText());
        btnOk.setOnClickListener(onClickListener);
    }

    public void pushLostNetwork(int resource, String title, String subtitle, String btnText, View.OnClickListener onClickListener){
        setAnimationView(resource);
        textTitle.setText(title);
        textSubTitle.setText(subtitle);
        btnOk.setText(btnText);
        btnOk.setOnClickListener(onClickListener);
    }

    private void setAnimationView(int resource){
        if (withLottie){
            lottieAnimationView.setVisibility(View.VISIBLE);
            imgView.setVisibility(View.GONE);
            lottieAnimationView.setAnimation(resource);
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.playAnimation();
        } else {
            imgView.setVisibility(View.VISIBLE);
            lottieAnimationView.setVisibility(View.GONE);
            imgView.setImageResource(resource);
        }
    }
}