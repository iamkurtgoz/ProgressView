package com.iamkurtgoz.progressview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.iamkurtgoz.progressview.views.EmptyListView;
import com.iamkurtgoz.progressview.views.ErrorView;
import com.iamkurtgoz.progressview.views.LoadingView;
import com.iamkurtgoz.progressview.views.NetworkView;
import com.iamkurtgoz.progressview.views.PermissionView;

public class ProgressView extends ViewUtils {

    private Context baseContext;
    private View VIEW_LOADING, VIEW_ERROR, VIEW_NETWORK, VIEW_EMPTY_LIST, VIEW_PERMISSION;

    public ProgressView(Context context) {
        super(context);
        this.baseContext = context;
    }

    public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.baseContext = context;
    }

    @Override
    public void init(Context context, AttributeSet attributeSet) {
        VIEW_LOADING = getLayoutView(R.layout.progress_loading_layout, VIEWS.LOADING);
        VIEW_ERROR = getLayoutView(R.layout.progress_error_layout, VIEWS.ERROR);
        VIEW_NETWORK = getLayoutView(R.layout.progress_network_layout, VIEWS.NETWORK);
        VIEW_EMPTY_LIST = getLayoutView(R.layout.progress_empty_list_layout, VIEWS.EMPTY_LIST);
        VIEW_PERMISSION = getLayoutView(R.layout.progress_permission_layout, VIEWS.PERMISSION);

        addView(VIEW_LOADING, 0);
        addView(VIEW_ERROR, 1);
        addView(VIEW_NETWORK, 2);
        addView(VIEW_EMPTY_LIST, 3);
        addView(VIEW_PERMISSION, 4);
        pushContent();
    }

    private void hideViews(){
        hideAllView(VIEW_LOADING, VIEW_ERROR, VIEW_NETWORK, VIEW_EMPTY_LIST, VIEW_PERMISSION);
    }

    public void pushContent(){
        hideViews();
    }

    public NetworkView networkView(boolean withLottie){
        hideViews();
        return NetworkView.with(VIEW_NETWORK, withLottie);
    }

    public ErrorView errorView(boolean withLottie){
        hideViews();
        return ErrorView.with(VIEW_ERROR, withLottie);
    }

    public EmptyListView emptyListView(boolean withLottie){
        hideViews();
        return EmptyListView.with(VIEW_EMPTY_LIST, withLottie);
    }

    public PermissionView permissionView(boolean withLottie){
        hideViews();
        return PermissionView.with(baseContext, VIEW_PERMISSION, withLottie);
    }

    public LoadingView pushLoading(){
        hideViews();
        return LoadingView.with(VIEW_LOADING);
    }
}
