package com.example.runapp.runapp;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.ArrayCarreras;
import com.example.runapp.runapp.Modelo.Carrera;
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
        //initializeCalendar(calendar,v);
        Collection<CalendarDay> dias = new ArrayList<>();
        final ArrayCarreras carreras = new ArrayCarreras();
        carreras.llenarCarreras();
        EventDecorator decorator = new EventDecorator(Color.RED,carreras.getFechas());
        calendar.addDecorator(decorator);
        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                if(carreras.buscarCarreraFecha(date) != null) {
                    Dialogo(calendar, carreras.buscarCarreraFecha(date));
                }
                else{
                    Log.e("Error","No se encontro!");
                }
            }
        });
        return v;
    }


    public void Dialogo(View view,Carrera carrera){


        AlertDialog.Builder builder1 = new AlertDialog.Builder(view.getContext());
        builder1.setTitle("Información de la carrera");
        builder1.setMessage(carrera.toString());
        builder1.setPositiveButton("Aceptar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    } });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    };

}


