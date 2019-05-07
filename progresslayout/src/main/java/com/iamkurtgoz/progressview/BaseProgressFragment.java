package com.iamkurtgoz.progressview;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseProgressFragment extends Fragment {

    /**
     * VARIABLES
     */
    private View mProgressContainer;
    private ProgressBar progressBar;
    private TextView progressBarTextTitle;

    private View mProgressMessageContainer;
    private ImageView progressMessageImgHeader;
    private TextView progressMessageTextTitle, progressMessageTextMessage;
    private Button progressMessageButtonCancel, progressMessageButtonConfirm;

    private View mContentContainer;
    private View mContentView;
    private TextView textMessage;

    private boolean isLoadingShow;
    private boolean isContentShow;
    private boolean isTextMessageShow;
    private boolean isMessageShow;

    public BaseProgressFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initalizeContentViews();
    }

    @Override
    public void onDestroyView() {
        isContentShow = false;
        isTextMessageShow = false;
        mProgressContainer = mContentContainer = mContentView = textMessage = null;
        super.onDestroyView();
    }

    /**
     * SET CONTENT VIEW
     * @param layoutResId
     */
    public void setContentView(int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View contentView = layoutInflater.inflate(layoutResId, null);
        setContentView(contentView);
    }

    public void setContentView(View view) {
        initalizeContentViews();
        if (view == null) {
            throw new IllegalArgumentException("Content view can't be null");
        }
        if (mContentContainer instanceof ViewGroup) {
            ViewGroup contentContainer = (ViewGroup) mContentContainer;
            if (mContentView == null) {
                contentContainer.addView(view);
            } else {
                int index = contentContainer.indexOfChild(mContentView);
                // replace content view
                contentContainer.removeView(mContentView);
                contentContainer.addView(view, index);
            }
            mContentView = view;
            setContent();
        } else {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
    }

    /**
     * GET & SET
     */

    public View getContentView() {
        return mContentView;
    }

    public boolean isLoadingShow() {
        return isLoadingShow;
    }

    public boolean isContentShow() {
        return isContentShow;
    }

    public boolean isTextMessageShow() {
        return isTextMessageShow;
    }

    public boolean isMessageShow() {
        return isMessageShow;
    }

    /**
     * EMPTY TEXT
     */

    public void setTextMessage(int resId) {
        setTextMessage(getString(resId));
    }

    public void setTextMessage(CharSequence text){
        initalizeContentViews();
        textMessage.setText(text);
        textMessage.setVisibility(View.VISIBLE);
        mContentView.setVisibility(View.GONE);

        isLoadingShow = false;
        isContentShow = false;
        isTextMessageShow = true;
        isMessageShow = false;
    }


    /**
     * LOADING
     */

    public void setLoading(CharSequence text){
        loading(text);
    }

    public void setLoading(){
        loading("");
    }


    private void loading(CharSequence text){
        initalizeContentViews();
        if (isLoadingShow) {
            return;
        }
        isLoadingShow = true;
        isContentShow = false;
        isTextMessageShow = false;
        isMessageShow = false;

        if (text != null && !text.toString().trim().isEmpty()){
            progressBarTextTitle.setVisibility(View.VISIBLE);
            progressBarTextTitle.setText(text);
        } else {
            progressBarTextTitle.setVisibility(View.GONE);
        }

        mContentContainer.setVisibility(View.GONE);
        mProgressMessageContainer.setVisibility(View.GONE);
        mProgressContainer.setVisibility(View.VISIBLE);
    }

    /**
     * CONTENT
     * @param
     */

    public void setContent(){
        initalizeContentViews();
        if (isContentShow) {
            return;
        }
        isLoadingShow = false;
        isContentShow = true;
        isTextMessageShow = false;
        isMessageShow = false;

        mContentContainer.setVisibility(View.VISIBLE);
        mProgressContainer.setVisibility(View.GONE);
        mProgressMessageContainer.setVisibility(View.GONE);
    }

    /**
     * MESSAGE
     */

    public void setMessage(String title, String message){
        message(-1, title, message, "", "", null, null);
    }

    public void setMessage(String title, String message, String confirmText, View.OnClickListener confirmListener){
        message(-1, title, message, confirmText, "", confirmListener, null);
    }

    public void setMessage(String title, String message, String confirmText, String cancelText, View.OnClickListener confirmListener, View.OnClickListener cancelListener){
        message(-1, title, message, confirmText, cancelText, confirmListener, cancelListener);
    }

    public void setMessage(int headerResource, String title, String message){
        message(headerResource, title, message, "", "", null, null);
    }

    public void setMessage(int headerResource, String title, String message, String confirmText, View.OnClickListener confirmListener){
        message(headerResource, title, message, confirmText, "", confirmListener, null);
    }

    public void setMessage(int headerResource, String title, String message, String confirmText, String cancelText, View.OnClickListener confirmListener, View.OnClickListener cancelListener){
        message(headerResource, title, message, confirmText, cancelText, confirmListener, cancelListener);
    }

    private void message(int headerResource, String title, String message, String confirmText, String cancelText, View.OnClickListener confirmListener, View.OnClickListener cancelListener){
        if (isMessageShow) {
            return;
        }
        if (headerResource != -1){
            progressMessageImgHeader.setImageResource(headerResource);
            progressMessageImgHeader.setVisibility(View.VISIBLE);
        } else {
            progressMessageImgHeader.setVisibility(View.GONE);
        }

        progressMessageTextTitle.setText(title);
        progressMessageTextMessage.setText(message);

        if (confirmText != null && !confirmText.trim().isEmpty() && confirmListener != null){
            progressMessageButtonConfirm.setText(confirmText);
            progressMessageButtonConfirm.setOnClickListener(confirmListener);
            progressMessageButtonConfirm.setVisibility(View.VISIBLE);
        } else {
            progressMessageButtonConfirm.setVisibility(View.GONE);
        }

        if (cancelText != null && !cancelText.trim().isEmpty() && cancelListener != null){
            progressMessageButtonCancel.setText(cancelText);
            progressMessageButtonCancel.setOnClickListener(cancelListener);
            progressMessageButtonCancel.setVisibility(View.VISIBLE);
        } else {
            progressMessageButtonCancel.setVisibility(View.GONE);
        }

        mProgressMessageContainer.setVisibility(View.VISIBLE);
        mProgressContainer.setVisibility(View.GONE);
        mContentContainer.setVisibility(View.GONE);

        isLoadingShow = false;
        isContentShow = false;
        isTextMessageShow = false;
        isMessageShow = true;
    }






    /**
     * Initialization views.
     */
    private void initalizeContentViews() {
        if (mContentContainer != null && mProgressContainer != null) {
            return;
        }
        View root = getView();
        if (root == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        initalizeProgressViews(root);
        initalizeMessageViews(root);
        initalizeContainerViews(root);
        initalizeTextMessage(root);

        isContentShow = true;
        // We are starting without a content, so assume we won't
        // have our data right away and start with the progress indicator.
        if (mContentView == null) {
            setLoading();
        }
    }

    private void initalizeProgressViews(View root){
        mProgressContainer = root.findViewById(R.id.progress_container);
        progressBar = root.findViewById(R.id.progressBar);
        progressBarTextTitle = root.findViewById(R.id.progressBar_textTitle);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        if (mProgressContainer == null) {
            throw new RuntimeException("Your content must have a ViewGroup whose id attribute is 'R.id.progress_container'");
        }
    }

    private void initalizeMessageViews(View root){
        mProgressMessageContainer = root.findViewById(R.id.progress_message);
        progressMessageImgHeader = root.findViewById(R.id.progress_message_imgHeader);
        progressMessageTextTitle = root.findViewById(R.id.progress_message_textTitle);
        progressMessageTextMessage = root.findViewById(R.id.progress_message_textMessage);
        progressMessageButtonCancel = root.findViewById(R.id.progress_message_btnCancel);
        progressMessageButtonConfirm = root.findViewById(R.id.progress_message_btnConfirm);
        if (mProgressMessageContainer == null) {
            throw new RuntimeException("Your content must have a ViewGroup whose id attribute is 'R.id.progress_message'");
        }
    }

    private void initalizeContainerViews(View root){
        mContentContainer = root.findViewById(R.id.content_container);
        if (mContentContainer == null) {
            throw new RuntimeException("Your content must have a ViewGroup whose id attribute is 'R.id.content_container'");
        }
    }

    private void initalizeTextMessage(View root){
        textMessage = root.findViewById(R.id.textMessage);
        textMessage.setVisibility(View.GONE);
    }
}