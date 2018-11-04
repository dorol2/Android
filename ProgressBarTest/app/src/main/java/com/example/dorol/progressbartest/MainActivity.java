package com.example.dorol.progressbartest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private static final int PROGRESS = 0x1;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress = findViewById(R.id.progress_bar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(mProgressStatus < 100) {
                    try { Thread.sleep(1000); }
                    catch (InterruptedException e) {
                        mProgressStatus = i++;

                        mProgress.post(new Runnable() {
                            @Override
                            public void run() {
                                mProgress.setProgress(mProgressStatus);
                            }
                        });
                    }
                }
            }
        }).start();
    }
}
