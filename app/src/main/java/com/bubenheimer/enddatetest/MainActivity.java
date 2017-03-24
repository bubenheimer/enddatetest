package com.bubenheimer.enddatetest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        long cur = cal.getTimeInMillis();
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        //Next line triggers exception
        datePicker.setMinDate(cur);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(final DatePicker view, final int year, final int monthOfYear, final int dayOfMonth) {
            }
        });
        //Workaround
//        cal.clear();
//        cal.set(year, month, dayOfMonth);
//        long calMin = cal.getTimeInMillis();
//        datePicker.setMinDate(calMin);
    }
}
