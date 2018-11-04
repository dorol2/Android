package com.example.dorol.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button callButton = findViewById(R.id.call);
        callButton.setText("전화걸기");
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });

        Button mapButton = findViewById(R.id.map);
        mapButton.setText("지도보기");
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });

        Button webButton = findViewById(R.id.web);
        webButton.setText("웹브라우저");
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });

        Button contactButton = findViewById(R.id.contact);
        contactButton.setText("연락처보기");
        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick(v);
            }
        });
    }

    private void OnClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.web:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                break;
            case R.id.call:
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+82)12345789"));
                break;
            case R.id.map:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:37.30,127.2?z=10"));
                break;
            case R.id.contact:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
            default:
                Log.e("Error", "Error");

        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
