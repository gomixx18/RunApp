package com.example.runapp.runapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;


import com.example.runapp.runapp.Modelo.claseStatic;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CronoActivity extends claseStatic {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);
        start = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);
        Crono = (Chronometer) findViewById(R.id.chronometer);
        stop.setClickable(false);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            muestraAlerta1();
        }

        Crono.setText("00:00:00");




        if(claseStatic.valor == 1){
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                }
            });
            stop.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Crono.stop();
                    tiempoTranscurrido();
                    stop.setClickable(false);
                    resultad = Crono.getText().toString();
                    claseStatic.tiempo = resultad;
                    startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
                    finish();
                }
            });
        }else{

            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    muestraAlerta2();

                }
            });

            stop.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Crono.stop();
                    tiempoTranscurrido();
                    stop.setClickable(false);

                    startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
                    finish();
                }
            });
        }



    }





    public void muestraAlerta1() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Habilitar Localización")
                .setMessage("Su GPS está apagado.\nEncienda su GPS")
                .setCancelable(true)
                .setPositiveButton("Configuración", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        claseStatic.valor =1;
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        claseStatic.valor = 0;
                    }


                });


        dialog.show();
    }

    public void muestraAlerta2() {
        final AlertDialog alertDialog = new AlertDialog.Builder(CronoActivity.this).create();
        alertDialog.setTitle("La sesion iniciara en\n");

        final TextView v = new TextView(CronoActivity.this);
        v.setClickable(false);
        v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        v.setTextColor(getResources().getColor(R.color.azul));
        v.setTextSize(72);
        alertDialog.setView(v);
        alertDialog.show();

        new CountDownTimer(6000, 1000)
        { @Override public void onTick(long millisUntilFinished) {
                v.setText("" + millisUntilFinished/1000);
                alertDialog.setView(v);
            }

            @Override public void onFinish()
            { alertDialog.hide();

            }
        }.start();

        Crono.start();

    }

    public void tiempoTranscurrido() {
        elapsedMillis = SystemClock.elapsedRealtime() - Crono.getBase();

        int segundos = (int) (elapsedMillis / 1000) % 60;
        int minuto = (int) ((elapsedMillis / (aMinutos)) % 60);

        int hora = (int) ((elapsedMillis / (aHoras)));
        int millis = (int) elapsedMillis % 1000;
        String tiempo = String.format("%02d:%02d:%02d:%03d"
                , hora, minuto, segundos, millis);

        claseStatic.tiempo = tiempo;
    }



    long duracion = 5000;
    CountDownLatch latch;
    LocationListener locationListener;
    public static double distancia = 0;
    Chronometer Crono;
    Button start,stop;
    public static final long aMinutos = 60000;
    public static final long aHoras = 3600000;
    public static long elapsedMillis;
    public static String resultad;
    LocationManager locationManager;
    Location actual;
    public static boolean isGPSEnabled = false;
    public static boolean isNetworkEnabled = false;
    private static final long updateDistancia = 5;
    private static final long updateTiempo = 1000 * 1;
    double latitud;
    double longitud;
    Location l = null;
    public static ArrayList<Double> puntosLat = new ArrayList<>();
    public static ArrayList<Double> puntosLong = new ArrayList<>();
    AlertDialog alert = null;

}


