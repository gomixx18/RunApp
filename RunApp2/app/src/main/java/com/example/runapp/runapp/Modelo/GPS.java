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

import com.example.runapp.runapp.CronoActivity;

public class GPS extends Service implements LocationListener {

    private final Context mContext;

    public GPS(Context mContext) {
        this.mContext = mContext;
        obtenerLocalizacion();
    }

    public Location obtenerLocalizacion() {
        locationManager = (LocationManager) mContext
                .getSystemService(LOCATION_SERVICE);

        habilitaGPS = locationManager
                .isProviderEnabled(LocationManager.GPS_PROVIDER);



        if (habilitaGPS) {
            if (lugar == null) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            updateTiempo,
                            updateDistancia, this);

                    if (locationManager != null) {
                        lugar = locationManager
                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if (lugar != null) {
                            latitud = lugar.getLatitude();
                            longitud = lugar.getLongitude();
                        }
                    }
                }

            }
        }
        return lugar;
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


    public void showSettingsAlert(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);


        alertDialog.setTitle("GPS is settings");


        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");


        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });


        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertDialog.show();
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
    private static final long updateTiempo = 1000 * 60 * 1;
    Location lugar;
    double latitud;
    double longitud;
    public static boolean habilitaGPS = false;
    boolean habilitaNetwork = false;
    boolean Location = false;
}



