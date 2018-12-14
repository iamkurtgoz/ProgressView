package com.iamkurtgoz.sampleprogresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamkurtgoz.progressview.ProgressView;
import com.iamkurtgoz.progressview.models.ErrorModel;
import com.iamkurtgoz.progressview.models.NetworkModel;

public class ErrorActivity extends AppCompatActivity {

    private ProgressView progressView;
    private EditText editTitle, editSubTitle, editButtonText;
    private Button btnStartLottie, btnStartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        init();
        registerHandlers();
    }

    private void init(){
        progressView = (ProgressView) findViewById(R.id.progressLayout);
        editTitle = (EditText) findViewById(R.id.activity_error_editTitle);
        editSubTitle = (EditText) findViewById(R.id.activity_error_editSubTitle);
        editButtonText = (EditText) findViewById(R.id.activity_error_editButtonText);
        btnStartLottie = (Button) findViewById(R.id.activity_error_btnStartLottie);
        btnStartImage = (Button) findViewById(R.id.activity_error_btnStartImage);
    }

    private void registerHandlers(){
        setBtnStartLottie();
        setBtnStartImage();
    }

    private void setBtnStartLottie(){
        btnStartLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErrorModel errorModel = new ErrorModel();
                errorModel.setLottieResource(R.raw.error_lottie);
                errorModel.setTitle(editTitle.getText().toString());
                errorModel.setSubTitle(editSubTitle.getText().toString());
                errorModel.setBtnText(editButtonText.getText().toString());
                progressView.errorView(true).pushError(errorModel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressView.pushContent();
                    }
                });
            }
        });
    }

    private void setBtnStartImage(){
        btnStartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ErrorModel errorModel = new ErrorModel();
                errorModel.setImageResource(R.drawable.error_image);
                errorModel.setTitle(editTitle.getText().toString());
                errorModel.setSubTitle(editSubTitle.getText().toString());
                errorModel.setBtnText(editButtonText.getText().toString());
                progressView.errorView(false).pushError(errorModel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressView.pushContent();
                    }
                });
            }
        });
    }
}
