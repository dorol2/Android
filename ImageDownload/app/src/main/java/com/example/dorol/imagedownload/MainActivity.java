package com.example.dorol.imagedownload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button downloadButton = findViewById(R.id.download_button);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final EditText urlEditText = findViewById(R.id.urlEditText);
                            final ImageView imageView = findViewById(R.id.imageview);
                            URL url = new URL(urlEditText.getText().toString());
                            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                            httpURLConnection.connect();
                            InputStream inputStream = httpURLConnection.getInputStream();

                            final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            imageView.post(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(bitmap);
                                }
                            });
                        } catch (Exception e) {
                            Toast.makeText(getBaseContext(), "Image downloaded error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                t.start();
            }
        });
    }
}
