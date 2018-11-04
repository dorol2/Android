package com.example.dorol.timepicker;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView timeTextView;
    private Calendar calendar;
    private String format = "";
    private Button selectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);
        timeTextView = findViewById(R.id.timeTextView);
        calendar = Calendar.getInstance();
        selectButton = findViewById(R.id.selectButton);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        showTime(hour, min);//처음 현재시간을 나타내도록 show한다.

        selectButton.setText("선택");
        selectButton.setOnClickListener(new View.OnClickListener() {
            // 버튼 클릭시 텍스트가 변경되도록
            @Override
            public void onClick(View v) {
                displayTime(v);
            }
        });
    }

    public void displayTime(View view) {
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        showTime(hour, min);
    }

    public void showTime(int hour, int min) {
        if(hour == 0) {
            hour += 12;
            format = "AM";
        } else if(hour == 12) {
            format = "PM";
        } else if(hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        timeTextView.setText(new StringBuilder().append(hour).append(" : ").append(min).append(" ").append(format));

    }
}
