package com.example.ishanpant.timepickerdemo;

import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import static android.R.attr.format;


public class TimePickAct extends AppCompatActivity {
    private TimePicker timePicker;
    private TextView time_pick_text;
    private Button showTimeInTextView;
    private Calendar calendar;
    private int hour,min;
    private String format = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pick);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
        time_pick_text = (TextView) findViewById(R.id.time_pick_text);
        showTimeInTextView = (Button) findViewById(R.id.showTimeInTextView);
        calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        showTime(hour,min);
        showTimeInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time_pick_text.setText(new StringBuilder().append(hour).append(" : ").append(min)
                        .append(" ").append(format));
            }
        });
    }

    public void setTime(View view) {
        int hour = timePicker.getCurrentHour();
        int min = timePicker.getCurrentMinute();
        showTime(hour,min);
    }

    public void showTime(int hour, int min) {
        if (hour == 0) {
            hour += 12;
            format = "AM";
        } else if (hour == 12) {
            format = "PM";
        } else if (hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }
    }
}
