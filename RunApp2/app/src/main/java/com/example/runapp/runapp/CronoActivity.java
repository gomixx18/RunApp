package com.example.runapp.runapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
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

import com.example.runapp.runapp.Modelo.GPS;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class CronoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);
        start = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);
        Crono = (Chronometer) findViewById(R.id.chronometer);
        stop.setClickable(false);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);



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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    muestraAlerta();
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                        if (ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        } else {
                            locationManager.removeUpdates(locationListener);
                        }
                    } else {
                        locationManager.removeUpdates(locationListener);
                    }

                    l = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                    Crono.setText("00:00:00");
                    Crono.setBase(SystemClock.elapsedRealtime());
                    stop.setClickable(true);

                    if(l!=null){


                    locationListener = new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {

                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {
                            if (isGPSEnabled) {
                                Crono.start();
                                start.setClickable(false);
                            }
                        }

                        @Override
                        public void onProviderDisabled(String provider) {

                        }


                    };
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                        if (ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(CronoActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                            return;
                        } else {
                            locationManager.requestLocationUpdates(
                                    LocationManager.GPS_PROVIDER,
                                    updateTiempo,
                                    updateDistancia, locationListener);
                        }
                    } else {
                        locationManager.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                updateTiempo,
                                updateDistancia, locationListener);
                    }

                }else{
                        Toast.makeText(CronoActivity.this, "no entre ",
                                Toast.LENGTH_SHORT).show();
                        muestraAlerta();
                    }
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Crono.stop();
                tiempoTranscurrido();
                stop.setClickable(false);
                resultad = Crono.getText().toString();
                startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
                finish();
            }
        });

    }



    @Override
    protected void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            } else {
                locationManager.removeUpdates(locationListener);
            }
        } else {
            locationManager.removeUpdates(locationListener);
        }


    }
    @Override
    protected void onResume() {
        super.onResume();
        isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

    }

    private void muestraAlerta() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Habilitar Localización")
                .setMessage("Su GPS está apagado.\nEncienda su GPS")
                .setCancelable(true)
                .setPositiveButton("Configuración", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                    }


                });


        dialog.show();
    }

    public void tiempoTranscurrido() {
        elapsedMillis = SystemClock.elapsedRealtime() - Crono.getBase();

        int segundos = (int) (elapsedMillis / 1000) % 60;
        int minuto = (int) ((elapsedMillis / (aMinutos)) % 60);

        int hora = (int) ((elapsedMillis / (aHoras)));
        int millis = (int) elapsedMillis % 1000;
        String tiempo = String.format("%02d:%02d:%02d:%03d"
                , hora, minuto, segundos, millis);
        Toast.makeText(CronoActivity.this, "Tiempo Transcurrido: " + tiempo,
                Toast.LENGTH_SHORT).show();
    }


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


