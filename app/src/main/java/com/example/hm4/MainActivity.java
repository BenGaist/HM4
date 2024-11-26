package com.example.hm4;

import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button timebtn;
    TextView timeTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         timebtn = findViewById(R.id.timeBtn);
         timeTxt = findViewById(R.id.dateTxt);

        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog();
            }
        });

    }

    private void showTimePickerDialog(){
    Calendar calender = Calendar.getInstance();
    int currentHour = calender.get(Calendar.HOUR_OF_DAY);
    int currentMin = calender.get(Calendar.MINUTE);

    TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int currentHour, int currentMin) {
            String time = String.format("%02d:%02d", currentHour, currentMin);
            timeTxt.setText("Selected Time: " + time);
        }
    },
            currentHour, currentMin, true // true for 24-hour format
    );

    timePickerDialog.show();

}

}