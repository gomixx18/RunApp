package com.example.runapp.runapp.Modelo;

import android.util.Log;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Bryan on 31/5/2016.
 */
public class ArrayCarreras {

    private Collection<CalendarDay> fechas;
    private ArrayList<Carrera> carreras;

    public ArrayCarreras(){
        carreras = new ArrayList<>();
        fechas = new ArrayList<>();
    }

    public Carrera getCarrera(Carrera carrera){
        int index = carreras.indexOf(carrera);
        return carreras.get(index);
    }

    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
        fechas.add(carrera.getFecha());
    }

    public Collection<CalendarDay> getFechas(){
        return fechas;
    }

    public Carrera buscarCarreraFecha(CalendarDay fecha){
        for(int i = 0; i < carreras.size();i++){
            Carrera aux = carreras.get(i);
            if(aux.getFecha().toString().equals(fecha.toString())){
                Log.e("fecha",aux.toString());
                return aux;

            }

        }
        return null;
    }

    public void llenarCarreras(){
        agregarCarrera(new Carrera("Mi Meta Lafise","5k-10k", new CalendarDay(2016,4,22),"₵12000","Pavas"));
        agregarCarrera(new Carrera("TNF Endurance Challenge","10-21-50-80 km", new CalendarDay(2016,4,27),"$55,$125","Pavas"));
        agregarCarrera(new Carrera("Iririá","5-10 km", new CalendarDay(2016,4,29),"₵10000","San José"));
        agregarCarrera(new Carrera("Lapathon Jungle Race","5-10 km", new CalendarDay(2016,5,4),"₵11000-₵13000","Puerto Jimenez"));
        agregarCarrera(new Carrera("La Leche","5-10 km", new CalendarDay(2016,5,5),"₵15000","Coronado"));
        agregarCarrera(new Carrera("Olympic Day Run","10km", new CalendarDay(2016,5,12),"₵10000-₵15000","Por definir"));
        agregarCarrera(new Carrera("La Gran Manzana","8-16 km", new CalendarDay(2016,5,11),"₵15000","Tíbas"));
        agregarCarrera(new Carrera("Lapathon Jungle Race","5-10 km", new CalendarDay(2016,5,4),"₵11000-₵13000","San José"));
        agregarCarrera(new Carrera("Maraton San josé","21 km", new CalendarDay(2016,5,19),"₵11000-₵13000","San José"));
        agregarCarrera(new Carrera("Correcaminos","5-10 km ", new CalendarDay(2016,6,2),"₵15000-₵18000","Curridabat"));
        agregarCarrera(new Carrera("Corriendo por nuestros pacientes","9 km", new CalendarDay(2016,6,10),"₵13000","Turrialba"));
        agregarCarrera(new Carrera("Grecia Run","5-10 km", new CalendarDay(2016,6,3),"₵8000-₵12000","Grecia"));
        agregarCarrera(new Carrera("Liga Run","5.5-10 km", new CalendarDay(2016,6,25),"₵12000","Alajuela"));
        agregarCarrera(new Carrera("Correr es Crecer","10 km", new CalendarDay(2016,6,21),"₵10000","Alajuela"));
    }
}
