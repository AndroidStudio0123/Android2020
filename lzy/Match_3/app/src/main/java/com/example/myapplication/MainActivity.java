package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView dqny;
    private TextView dqsj;
    private TextView szsj;
    private Button button1;
    private TextView rqsz;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initid();
        initsj();

    }

    private void initid() {
        dqny = (TextView) findViewById(R.id.dqny);
        dqsj = (TextView) findViewById(R.id.dqsj);
        szsj = (TextView) findViewById(R.id.szsj);
        button1 = (Button) findViewById(R.id.button1);
        rqsz = (TextView) findViewById(R.id.rqsz);
        button2 = (Button) findViewById(R.id.button2);
    }


    private void initsj() {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minue = calendar.get(Calendar.MINUTE);
        int secand = calendar.get(Calendar.SECOND);
        dqny.setText(year+"年"+(month+1)+"月"+day+"日");
        dqsj.setText(hour+":"+minue+":"+secand);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        rqsz.setText(year+"年"+(month+1)+"月"+day+"日");
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        szsj.setText(hour+":"+minue);
                    }
                },hour,minue,true);
                timePickerDialog.show();
            }
        });
    }


}