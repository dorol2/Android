package com.example.dorol.saverestore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView countTextView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
            countTextView.setText("현재 개수=" + count);
        }

        TextView titleTextView = findViewById(R.id.title);
        titleTextView.setText("주문");

        TextView pizzaTextView = findViewById(R.id.pizza_textview);
        pizzaTextView.setText("피자");

        TextView spaghettiTextView = findViewById(R.id.spaghetti_textview);
        spaghettiTextView.setText("스파게티");

        countTextView = findViewById(R.id.count_textview);
        countTextView.setText("현재 개수=" + count);

        Button increaseButton = findViewById(R.id.increase_button);
        increaseButton.setText("증가");
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countTextView.setText("현재 개수=" + count);
            }
        });

        Button decreaseButton = findViewById(R.id.decrease_button);
        decreaseButton.setText("감소");
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                countTextView.setText("현재 개수=" + count);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

}
