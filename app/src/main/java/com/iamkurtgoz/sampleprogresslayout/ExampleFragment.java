package com.iamkurtgoz.sampleprogresslayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.iamkurtgoz.sampleprogresslayout.R;

public class ExampleFragment extends BaseFragment {

    public static ExampleFragment newInstance(){
        return new ExampleFragment();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_example;
    }

    @Override
    public boolean getOrientationLock() {
        return true;
    }

    private Button btnLoading, btnLoadingWithText, btnEmpty, btnMessage1, btnMessage2, btnMessage3;

    @Override
    public void init(Bundle savedInstanceState) {
        btnLoading = (Button) getActivity().findViewById(R.id.fragment_example_btnLoading);
        btnLoadingWithText = (Button) getActivity().findViewById(R.id.fragment_example_btnLoadingWithText);
        btnEmpty = (Button) getActivity().findViewById(R.id.fragment_example_btnEmpty);
        btnMessage1 = (Button) getActivity().findViewById(R.id.fragment_example_btnMessage1);
        btnMessage2 = (Button) getActivity().findViewById(R.id.fragment_example_btnMessage2);
        btnMessage3 = (Button) getActivity().findViewById(R.id.fragment_example_btnMessage3);
    }

    @Override
    public void registerHandlers() {
        setBtnLoadingClick();
        setBtnLoadingWithTextClick();
        setBtnEmptyClick();
        setBtnMessage1Click();
        setBtnMessage2Click();
        setBtnMessage3Click();
    }

    private void setBtnLoadingClick(){
        btnLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setContent();
                    }
                }, 5000);
            }
        });
    }

    private void setBtnLoadingWithTextClick(){
        btnLoadingWithText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLoading("Loading.. Please Wait");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setContent();
                    }
                }, 5000);
            }
        });
    }

    private void setBtnEmptyClick(){
        btnEmpty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTextMessage("Error connection. Please try again later.");
            }
        });
    }

    private void setBtnMessage1Click(){
        btnMessage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessageWithLottie(
                        R.raw.error_lottie,
                        "Error Data",
                        "Please try again later."
                );
            }
        });
    }

    private void setBtnMessage2Click(){
        btnMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessageWithLottie(
                        R.raw.error_lottie,
                        "Error Data",
                        "Please try again later.",
                        "Try Again",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setLoading();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        setContent();
                                    }
                                }, 2500);
                            }
                        }
                );
            }
        });
    }

    private void setBtnMessage3Click(){
        btnMessage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMessageWithLottie(
                        R.raw.network_error_lottie,
                        "Error Connection",
                        "Connection error. Check your connection.",
                        "Try Again",
                        "Cancel",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setLoading();
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        setContent();
                                    }
                                }, 2500);
                            }
                        }, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setContent();
                            }
                        }
                );
            }
        });
    }
}
