package com.iamkurtgoz.sampleprogresslayout;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iamkurtgoz.progressview.PermissionCallBack;
import com.iamkurtgoz.progressview.ProgressView;
import com.iamkurtgoz.progressview.models.ErrorModel;
import com.iamkurtgoz.progressview.models.PermissionModel;

public class PermissionActivity extends AppCompatActivity {

    private ProgressView progressView;
    private EditText editTitle, editSubTitle, editButtonText;
    private Button btnStartLottie, btnStartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        init();
        registerHandlers();
    }

    private void init(){
        progressView = (ProgressView) findViewById(R.id.progressLayout);
        editTitle = (EditText) findViewById(R.id.activity_permission_editTitle);
        editSubTitle = (EditText) findViewById(R.id.activity_permission_editSubTitle);
        editButtonText = (EditText) findViewById(R.id.activity_permission_editButtonText);
        btnStartLottie = (Button) findViewById(R.id.activity_permission_btnStartLottie);
        btnStartImage = (Button) findViewById(R.id.activity_permission_btnStartImage);
    }

    private void registerHandlers(){
        setBtnStartLottie();
        setBtnStartImage();
    }

    private void setBtnStartLottie(){
        btnStartLottie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setmPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                permissionModel.setLottieResource(R.raw.permission_lottie);
                permissionModel.setTitle(editTitle.getText().toString());
                permissionModel.setSubTitle(editSubTitle.getText().toString());
                permissionModel.setBtnText(editButtonText.getText().toString());
                progressView.permissionView(true).pushPermissionAllow(permissionModel, new PermissionCallBack() {
                    @Override
                    public void onPermissionResult(boolean allPermissionAllow) {
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
                PermissionModel permissionModel = new PermissionModel();
                permissionModel.setmPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                permissionModel.setImageResource(R.drawable.error_image);
                permissionModel.setTitle(editTitle.getText().toString());
                permissionModel.setSubTitle(editSubTitle.getText().toString());
                permissionModel.setBtnText(editButtonText.getText().toString());
                progressView.permissionView(false).pushPermissionAllow(permissionModel, new PermissionCallBack() {
                    @Override
                    public void onPermissionResult(boolean allPermissionAllow) {
                        progressView.pushContent();
                    }
                });
            }
        });
    }
}

