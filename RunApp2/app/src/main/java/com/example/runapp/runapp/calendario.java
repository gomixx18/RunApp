package com.example.runapp.runapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class calendario extends Fragment {
    CalendarView calendar;


    public calendario() {

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);
        calendar = (CalendarView) v.findViewById(R.id.calendarView);
        initializeCalendar(calendar,v);
        return v;
    }


    public void initializeCalendar(CalendarView calendar, final View v) {





        calendar.setSelectedWeekBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));


        calendar.setUnfocusedMonthDateColor(getResources().getColor(R.color.colorPrimaryDark));


        calendar.setWeekSeparatorLineColor(getResources().getColor(R.color.colorAccent));


        calendar.setSelectedDateVerticalBar(R.color.colorAccent);


        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {


            @Override

            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {

                Toast.makeText(v.getContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();

            }

        });

    }

}


