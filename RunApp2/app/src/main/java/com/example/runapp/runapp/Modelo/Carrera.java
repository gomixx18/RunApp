package com.example.runapp.runapp.Modelo;

import com.prolificinteractive.materialcalendarview.CalendarDay;

/**
 * Created by Bryan on 31/5/2016.
 */
public class Carrera {
    private String nombreCarrera;
    private String kms;
    private CalendarDay fecha;
    private String costo;
    private String ubicacion;

    public Carrera(String nombreCarrera, String kms, CalendarDay fecha, String costo, String ubicacion ){
        this.nombreCarrera = nombreCarrera;
        this.kms =kms;
        this.fecha = fecha;
        this.costo = costo;
        this.ubicacion = ubicacion;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public String getKms() {
        return kms;
    }

    public CalendarDay getFecha() {
        return fecha;
    }

    public String getCosto() {
        return costo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Nombre Carrera: "+this.getNombreCarrera()+"\n");
        s.append("km: "+this.getKms()+"\n");
        s.append("fecha: "+ this.getFecha().getDay()+"/"+this.getFecha().getMonth()+"/"+this.getFecha().getYear()+"\n");
        s.append("Lugar: "+this.getUbicacion()+"\n");
        s.append("Costo: "+this.getCosto());
        return s.toString();
    }
}
