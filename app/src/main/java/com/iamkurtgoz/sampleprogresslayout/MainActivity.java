package com.iamkurtgoz.sampleprogresslayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iamkurtgoz.progressview.ProgressView;

public class MainActivity extends AppCompatActivity {

    private Button btnNetworkError, btnError, btnEmptyList, btnPermission, btnLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerHandlers();
    }

    private void init(){
        btnNetworkError = (Button) findViewById(R.id.activity_main_btnNetworkError);
        btnError = (Button) findViewById(R.id.activity_main_btnError);
        btnEmptyList = (Button) findViewById(R.id.activity_main_btnEmptyList);
        btnPermission = (Button) findViewById(R.id.activity_main_btnPermission);
        btnLoading = (Button) findViewById(R.id.activity_main_btnLoading);
    }

    private void registerHandlers(){
        setBtnNetworkErrorClick();
        setBtnErrorClick();
        setBtnEmptyListClick();
        setBtnPermissionClick();
        setBtnLoadingClick();

    }

    private void setBtnNetworkErrorClick(){
        btnNetworkError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NetworkErrorActivity.class));
            }
        });
    }

    private void setBtnErrorClick(){
        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ErrorActivity.class));
            }
        });
    }

    private void setBtnEmptyListClick(){
        btnEmptyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EmptyListActivity.class));
            }
        });
    }

    private void setBtnPermissionClick(){
        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PermissionActivity.class));
            }
        });
    }

    private void setBtnLoadingClick(){
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoadingActivity.class));
            }
        });
    }
}
