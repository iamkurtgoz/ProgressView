package com.iamkurtgoz.sampleprogresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iamkurtgoz.progressview.ProgressView;

public class LoadingActivity extends AppCompatActivity {

    private ProgressView progressView;
    private Button btnLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        init();
        registerHandlers();
    }

    private void init(){
        progressView = (ProgressView) findViewById(R.id.progressLayout);
        btnLoading = (Button) findViewById(R.id.activity_loading_btnStart);
    }

    private void registerHandlers(){
        setBtnLoadingClick();
    }

    private void setBtnLoadingClick(){
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressView.pushLoading().pushEmptyListView("Loading. Please Wait!");
            }
        });
    }
}
