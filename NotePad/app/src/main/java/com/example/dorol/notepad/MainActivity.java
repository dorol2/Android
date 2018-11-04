package com.example.dorol.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(new SingleTouchView(this, null)); //SingleTouchView
        setContentView(new MultiTouchView(this, null)); //MultiTouchView
        //setContentView(new MyImageView(this)); //MyImageView
    }
}
