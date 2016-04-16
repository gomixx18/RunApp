package com.example.runapp.runapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GPS;

import java.util.ArrayList;
import java.util.List;

public class CronoActivity extends AppCompatActivity implements LocationListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);



        start = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);
        Crono = (Chronometer) findViewById(R.id.chronometer);
        stop.setClickable(false);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                updateTiempo,
                updateDistancia,this);

        List<String> providers = locationManager.getProviders(true);


        for (int i = 0; i < providers.size(); i++) {
            l = locationManager.getLastKnownLocation(providers.get(i));
            if (l != null) {
                latitud = l.getLatitude();
                longitud = l.getLongitude();
                break;
            }
        }
        isGPSEnabled = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);


        isNetworkEnabled = locationManager
                .isProviderEnabled(LocationManager.NETWORK_PROVIDER);

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
                if(isGPSEnabled){
                Crono.setText("00:00:00");
                Crono.setBase(SystemClock.elapsedRealtime());
                stop.setClickable(true);
                Crono.start();

                }
                else {

                    muestraAlerta();
                }
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Crono.stop();
                tiempoTranscurrido();
                stop.setClickable(false);
                turnGPSOff();
                resultad = Crono.getText().toString();
                startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
                finish();
            }
        });

    }

    private void tiempoTranscurrido() {
        elapsedMillis = SystemClock.elapsedRealtime() - Crono.getBase();

        int segundos = (int) (elapsedMillis / 1000) % 60;
        int minuto = (int) ((elapsedMillis / (aMinutos)) % 60);

        int hora = (int) ((elapsedMillis / (aHoras)));
        int millis = (int) elapsedMillis % 1000;
        String tiempo =  String.format("%02d:%02d:%02d:%03d"
                , hora, minuto, segundos, millis);
        Toast.makeText(CronoActivity.this, "Tiempo Transcurrido: " + tiempo,
                Toast.LENGTH_SHORT).show();
    }

    private void muestraAlerta() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Habilitar Localización")
                .setMessage("Su GPS está apagado.\nEncienda su GPS")
                .setCancelable(true)
                .setPositiveButton("Fin", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        startActivity(new Intent(CronoActivity.this, CronoActivity.class));
                        finish();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {

                    }


                })
                .setNeutralButton("Configuración",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(myIntent);

                        isGPSEnabled = locationManager
                                .isProviderEnabled(LocationManager.GPS_PROVIDER);
                    }


                });

        dialog.show();
    }


    @Override
    public void onLocationChanged(Location location) {
    if(location!= null){
        if(l.getLatitude() != location.getLatitude()) {
            puntosLat.add(location.getLatitude());
            puntosLong.add(location.getLongitude());

            Toast.makeText(CronoActivity.this, "LAT" + location.getLatitude() + "LONG" + location.getLongitude(),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(CronoActivity.this, "POS vector" + puntosLong.size(),
                    Toast.LENGTH_SHORT).show();
            distancia += updateDistancia;

            Toast.makeText(CronoActivity.this, "POS vector" + distancia,
                    Toast.LENGTH_SHORT).show();
        }


    }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }


    private void turnGPSOff(){
        String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if(provider.contains("gps")){ //if gps is enabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            sendBroadcast(poke);
        }
    }

    public static double distancia = 0;
    Chronometer Crono;
    Button start,stop;
    public static final long aMinutos = 60000;
    public static final long aHoras = 3600000;
    public static long elapsedMillis;
    public static String resultad;
    LocationManager locationManager;
    public static boolean isGPSEnabled = false;
    public static boolean isNetworkEnabled = false;
    private static final long updateDistancia = 5;
    private static final long updateTiempo = 1000 * 1;
    double latitud;
    double longitud;
    Location l = null;
    public static ArrayList<Double> puntosLat = new ArrayList<>();
    public static ArrayList<Double> puntosLong = new ArrayList<>();
}


