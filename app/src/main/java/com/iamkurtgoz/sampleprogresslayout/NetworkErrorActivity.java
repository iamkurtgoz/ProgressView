package com.iamkurtgoz.sampleprogresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamkurtgoz.progressview.ProgressView;
import com.iamkurtgoz.progressview.models.NetworkModel;

public class NetworkErrorActivity extends AppCompatActivity {

    private ProgressView progressView;
    private EditText editTitle, editSubTitle, editButtonText;
    private Button btnStartLottie, btnStartImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_error);
        init();
        registerHandlers();
    }

    private void init(){
        progressView = (ProgressView) findViewById(R.id.progressLayout);
        editTitle = (EditText) findViewById(R.id.activity_network_error_editTitle);
        editSubTitle = (EditText) findViewById(R.id.activity_network_error_editSubTitle);
        editButtonText = (EditText) findViewById(R.id.activity_network_error_editButtonText);
        btnStartLottie = (Button) findViewById(R.id.activity_network_error_btnStartLottie);
        btnStartImage = (Button) findViewById(R.id.activity_network_error_btnStartImage);
    }

    private void registerHandlers(){
        setBtnStartLottie();
        setBtnStartImage();
    }

    private void setBtnStartLottie(){
        btnStartLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkModel networkModel = new NetworkModel();
                networkModel.setLottieResource(R.raw.error_lottie);
                networkModel.setTitle(editTitle.getText().toString());
                networkModel.setSubTitle(editSubTitle.getText().toString());
                networkModel.setBtnText(editButtonText.getText().toString());
                progressView.networkView(true).pushLostNetwork(networkModel, new View.OnClickListener() {
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
                NetworkModel networkModel = new NetworkModel();
                networkModel.setImageResource(R.drawable.network_error_image);
                networkModel.setTitle(editTitle.getText().toString());
                networkModel.setSubTitle(editSubTitle.getText().toString());
                networkModel.setBtnText(editButtonText.getText().toString());
                progressView.networkView(false).pushLostNetwork(networkModel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressView.pushContent();
                    }
                });
            }
        });
    }
}
