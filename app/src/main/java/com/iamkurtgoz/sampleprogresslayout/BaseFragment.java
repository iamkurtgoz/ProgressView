package com.iamkurtgoz.sampleprogresslayout;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.iamkurtgoz.progressview.BaseProgressFragment;

public abstract class BaseFragment extends BaseProgressFragment {

    private final boolean isDebug = BuildConfig.DEBUG;

    public abstract int getLayoutID();
    public abstract boolean getOrientationLock();
    public abstract void init(Bundle savedInstanceState);
    public abstract void registerHandlers();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getOrientationLock()){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        setContentView(getLayoutID());
        init(savedInstanceState);
        registerHandlers();
    }

    public boolean getDebug(){
        return isDebug;
    }
}
