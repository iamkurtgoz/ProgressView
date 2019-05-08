package com.iamkurtgoz.sampleprogresslayout;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        registerHandlers();
    }

    private void init(){
        btnFragment = (Button) findViewById(R.id.activity_main_btnFragment);
    }

    private void registerHandlers(){
        setBtnFragmentClick();
    }

    private void setBtnFragmentClick(){
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ActivityFragment.class));
            }
        });
    }
}
