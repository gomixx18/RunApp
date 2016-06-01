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
import android.location.LocationProvider;
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

public class CronoActivity extends claseStatic implements LocationListener {


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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            } else {
                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        updateTiempo,
                        updateDistancia, CronoActivity.this);
            }
        } else {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    updateTiempo,
                    updateDistancia, CronoActivity.this);
        }


        Toast.makeText(CronoActivity.this, "Aca estoy",
                Toast.LENGTH_SHORT).show();
        l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (l != null) {
            latitud = l.getLatitude();
            longitud = l.getLongitude();
            actual = l;
        }

        isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (claseStatic.valor == 1) {
                    start.setClickable(false);
                    muestraAlerta2();


                } else {
                    start.setClickable(false);
                    muestraAlerta2();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Crono.stop();
                tiempoTranscurrido();
                stop.setClickable(false);
                claseStatic.Distancia = "" + distancia;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                        return;
                    } else {
                        locationManager.removeUpdates(CronoActivity.this);
                    }
                } else {
                    locationManager.removeUpdates(CronoActivity.this);
                }

                    startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
                    finish();
            }
            });
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
        alertDialog.setTitle("   La sesion iniciara en\n");

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
            {   alertDialog.hide();
                Crono.setText("00:00:00");
                Crono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer cArg) {
                        long elapsedMillis = SystemClock.elapsedRealtime() - cArg.getBase();
                        int h = (int) (elapsedMillis / 3600000);
                        int m = (int) (elapsedMillis - h * 3600000) / 60000;
                        int s = (int) (elapsedMillis - h * 3600000 - m * 60000) / 1000;
                        String hh = h < 10 ? "0" + h : h + "";
                        String mm = m < 10 ? "0" + m : m + "";
                        String ss = s < 10 ? "0" + s : s + "";
                        resultad = hh + ":" + mm + ":" + ss;
                        cArg.setText(hh + ":" + mm + ":" + ss);
                    }
                });
                time = SystemClock.elapsedRealtime();
                Crono.setBase(time);
                Crono.start();
            }
        }.start();
 }


public void tiempoTranscurrido() {
        elapsedMillis = SystemClock.elapsedRealtime() - Crono.getBase();

        int segundos = (int) (elapsedMillis / 1000) % 60;
        int minuto = (int) ((elapsedMillis / (aMinutos)) % 60);

        int hora = (int) ((elapsedMillis / (aHoras)));

        String tiempo = String.format("%02d:%02d:%02d"
                , hora, minuto, segundos);

        claseStatic.tiempo = tiempo;
    }



    @Override
    public void onLocationChanged(Location location) {
        if (location != null && location.getTime() >= time && time == 0) {
            if(this.actual != null) {

                if (actual.getLatitude() != location.getLatitude() && actual.getLongitude() != location.getLongitude()) {
                    puntosLat.add(location.getLatitude());
                    puntosLong.add(location.getLongitude());

                    Toast.makeText(CronoActivity.this, "LAT" + location.getLatitude() + "LONG" + location.getLongitude(),
                            Toast.LENGTH_SHORT).show();
                    Toast.makeText(CronoActivity.this, "POS vector" + puntosLong.size(),
                            Toast.LENGTH_SHORT).show();
                    CalculeDistancia(actual, location);
                    actual = location;

                }

            } else  this.actual = location;
        }
    }


    public void CalculeDistancia(Location viejo,Location actual)
    {

        distancia += (viejo.distanceTo(actual)/1000);
        TextView a = (TextView) findViewById(R.id.textView16);
        a.setText(""+distancia);

    }



    @Override
    public void onProviderDisabled(final String pProvider) {

    }

    @Override
    public void onProviderEnabled(final String pProvider) {

    }

    @Override
    public void onStatusChanged(final String pProvider, final int pStatus, final Bundle pExtras) {
        switch(pStatus) {
            case LocationProvider.AVAILABLE:
                val = pStatus;
                break;
            case LocationProvider.OUT_OF_SERVICE:
                val = pStatus;
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                val = pStatus;
                break;
        }
    }





static int val = 0;
    long time = 0;
    CountDownLatch latch;
    LocationListener mLocationListener;
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




