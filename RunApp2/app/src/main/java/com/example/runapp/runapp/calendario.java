package com.example.runapp.runapp;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.EventDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Collection;


/**
 * A simple {@link Fragment} subclass.
 */
public class calendario extends Fragment {
    MaterialCalendarView calendar;


    public calendario() {

     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendario, container, false);
        calendar = (MaterialCalendarView) v.findViewById(R.id.calendarView);
        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Toast.makeText(widget.getContext(),date.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //initializeCalendar(calendar,v);
        Collection<CalendarDay> dias = new ArrayList<>();
        dias.add(new CalendarDay(2016,4,29));
        dias.add(new CalendarDay(2016,4,14));
        dias.add(new CalendarDay(2016,4,10));
        EventDecorator decorator = new EventDecorator(Color.RED,dias);
        calendar.addDecorator(decorator);
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


