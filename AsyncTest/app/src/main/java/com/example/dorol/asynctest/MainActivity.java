package com.example.dorol.asynctest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgress = findViewById(R.id.progress_bar);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CounterTask().execute(0);
            }
        });
    }

    class CounterTask extends AsyncTask<Integer, Integer, Integer> {
        protected void onPreExecute() {
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            while (mProgressStatus < 100) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                mProgressStatus++;
                publishProgress(mProgressStatus);
            }
            return mProgressStatus;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mProgress.setProgress(mProgressStatus);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgress.setProgress(mProgressStatus);
        }
    }
}

