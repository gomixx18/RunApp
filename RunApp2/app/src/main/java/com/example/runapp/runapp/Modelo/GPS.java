package com.example.runapp.runapp.Modelo;


import android.Manifest;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.example.runapp.runapp.CronoActivity;

import java.util.List;

public class GPS extends Service implements LocationListener {

    private final Context mContext;

    public GPS(Context mContext) {
        this.mContext = mContext;
        obtenerLocalizacion();
    }

    public Location obtenerLocalizacion() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                updateTiempo,
                updateDistancia,this);

        List<String> providers = locationManager.getProviders(true);
        Location l = null;

        for (int i = 0; i < providers.size(); i++) {
            l = locationManager.getLastKnownLocation(providers.get(i));
            if (l != null) {
                latitud = l.getLatitude();
                longitud = l.getLongitude();

                break;
            }
        }

        habilitaGPS = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);

            return l;
    }

    @Override
    public void onLocationChanged(Location location) {



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

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




    public double Latitud(){
        if(lugar != null){
            latitud = lugar.getLatitude();
        }
        return latitud;
    }


    public double Longitud(){
        if(lugar != null){
            longitud = lugar.getLongitude();
        }
        return longitud;
    }

    protected LocationManager locationManager;
    private static final long updateDistancia = 20;
    private static final long updateTiempo = 1000 * 5;
    Location lugar;
    double latitud;
    double longitud;

    public static boolean habilitaGPS = false;
    boolean habilitaNetwork = false;
    boolean Location = false;
}



