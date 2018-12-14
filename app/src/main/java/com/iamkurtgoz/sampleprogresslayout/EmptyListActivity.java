package com.iamkurtgoz.sampleprogresslayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamkurtgoz.progressview.ProgressView;
import com.iamkurtgoz.progressview.models.EmptyListModel;
import com.iamkurtgoz.progressview.models.NetworkModel;

public class EmptyListActivity extends AppCompatActivity {

    private ProgressView progressView;
    private EditText editTitle, editSubTitle, editButtonText;
    private Button btnStartLottie, btnStartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_list);
        init();
        registerHandlers();
    }

    private void init(){
        progressView = (ProgressView) findViewById(R.id.progressLayout);
        editTitle = (EditText) findViewById(R.id.activity_empty_list_editTitle);
        editSubTitle = (EditText) findViewById(R.id.activity_empty_list_editSubTitle);
        editButtonText = (EditText) findViewById(R.id.activity_empty_list_editButtonText);
        btnStartLottie = (Button) findViewById(R.id.activity_empty_list_btnStartLottie);
        btnStartImage = (Button) findViewById(R.id.activity_empty_list_btnStartImage);
    }

    private void registerHandlers(){
        setBtnStartLottie();
        setBtnStartImage();
    }

    private void setBtnStartLottie(){
        btnStartLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmptyListModel emptyListModel = new EmptyListModel();
                emptyListModel.setLottieResource(R.raw.empty_list);
                emptyListModel.setTitle(editTitle.getText().toString());
                emptyListModel.setSubTitle(editSubTitle.getText().toString());
                emptyListModel.setBtnText(editButtonText.getText().toString());
                progressView.emptyListView(true).pushEmptyListView(emptyListModel, new View.OnClickListener() {
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
                EmptyListModel emptyListModel = new EmptyListModel();
                emptyListModel.setImageResource(R.drawable.empty_list_error);
                emptyListModel.setTitle(editTitle.getText().toString());
                emptyListModel.setSubTitle(editSubTitle.getText().toString());
                emptyListModel.setBtnText(editButtonText.getText().toString());
                progressView.emptyListView(false).pushEmptyListView(emptyListModel, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressView.pushContent();
                    }
                });
            }
        });
    }
}

