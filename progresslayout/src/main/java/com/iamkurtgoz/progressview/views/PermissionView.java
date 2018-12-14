package com.iamkurtgoz.progressview.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.animation.content.Content;
import com.iamkurtgoz.progressview.PermissionCallBack;
import com.iamkurtgoz.progressview.R;
import com.iamkurtgoz.progressview.models.EmptyListModel;
import com.iamkurtgoz.progressview.models.PermissionModel;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.List;

public class PermissionView {

    private Context context;
    private View rootView;
    private LottieAnimationView lottieAnimationView;
    private ImageView imgView;
    private TextView textTitle, textSubTitle;
    private Button btnOk;

    private boolean withLottie = true;
    private String[] mPermissions;
    private PermissionCallBack permissionCallBack;

    public static PermissionView with(Context context, View rootView, boolean withLottie){
        return new PermissionView(context, rootView, withLottie);
    }

    public PermissionView(Context context, View rootView, boolean withLottie){
        this.context = context;
        this.rootView = rootView;
        this.withLottie = withLottie;
        rootView.setVisibility(View.VISIBLE);
        rootView.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        rootView.getLayoutParams().height = LinearLayout.LayoutParams.MATCH_PARENT;

        lottieAnimationView = (LottieAnimationView) rootView.findViewById(R.id.progress_permission_lottieView);
        imgView = (ImageView) rootView.findViewById(R.id.progress_permission_imgView);
        textTitle = (TextView) rootView.findViewById(R.id.progress_permission_textTitle);
        textSubTitle = (TextView) rootView.findViewById(R.id.progress_permission_textSubTitle);
        btnOk = (Button) rootView.findViewById(R.id.progress_permission_btnOk);

        lottieAnimationView.setVisibility(View.GONE);
        imgView.setVisibility(View.GONE);
    }

    public void pushPermissionAllow(String[] mPermissions, PermissionCallBack permissionCallBack){
        this.permissionCallBack = permissionCallBack;
        this.mPermissions = mPermissions;
        setAnimationView(withLottie ? R.raw.permission_lottie : R.drawable.error_image);
        btnOk.setOnClickListener(permissionClick);
    }

    public void pushPermissionAllow(PermissionModel model, PermissionCallBack permissionCallBack){
        this.permissionCallBack = permissionCallBack;
        this.mPermissions = model.getmPermissions();
        setAnimationView(withLottie ? model.getLottieResource() : model.getImageResource());
        textTitle.setText(model.getTitle());
        textSubTitle.setText(model.getSubTitle());
        btnOk.setText(model.getBtnText());
        btnOk.setOnClickListener(permissionClick);
    }

    public void pushPermissionAllow(int resource, String[] mPermissions, String title, String subtitle, String btnText, PermissionCallBack permissionCallBack){
        this.permissionCallBack = permissionCallBack;
        this.mPermissions = mPermissions;
        setAnimationView(resource);
        textTitle.setText(title);
        textSubTitle.setText(subtitle);
        btnOk.setText(btnText);
        btnOk.setOnClickListener(permissionClick);
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

    View.OnClickListener permissionClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Dexter.withActivity(((Activity) context))
                    .withPermissions(mPermissions)
                    .withListener(new MultiplePermissionsListener() {
                        @Override
                        public void onPermissionsChecked(MultiplePermissionsReport report) {
                            permissionCallBack.onPermissionResult(report.areAllPermissionsGranted());
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();
        }
    };

}
