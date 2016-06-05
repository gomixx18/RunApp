package com.example.runapp.runapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity  {
    private GoogleMap googleMap;
    public static LatLng current;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected double latitude, longitude;
    protected boolean gps_enabled, network_enabled;
    private static final long updateDistancia = 20;
    private static final long updateTiempo = 1000 * 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        findViewById(R.id.volverres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mapa.this, ResultadosActivity.class));
                finish();
            }
        });


        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().
                    findFragmentById(R.id.map)).getMap();

        }


        if(CronoActivity.puntosLat.size() > 0  &&  CronoActivity.puntosLong.size() > 0 ){

            int tam = CronoActivity.puntosLat.size();
            final LatLng milugar  = new LatLng(CronoActivity.puntosLat.get(tam-1),CronoActivity.puntosLong.get(tam-1));
            final LatLng milugarIncio  = new LatLng(CronoActivity.puntosLat.get(0),CronoActivity.puntosLong.get(0));

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
           googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(milugarIncio, 15));

            googleMap.addMarker(new MarkerOptions()
                    .anchor(0.0f, 1.0f)
                    .position(milugar))
                    .setTitle("Punto Final");

            googleMap.addMarker(new MarkerOptions()
                    .anchor(0.0f, 1.0f)
                    .position(milugarIncio))
                    .setTitle("Punto Inicual");

            pintar(CronoActivity.puntosLat, CronoActivity.puntosLong);
        }


    }


    public void pintar(ArrayList<Double> puntosLat , ArrayList<Double> puntosLong){

        int j = 0;
        for(int i = 0 ; i < puntosLat.size() - 1 ;i++) {
            j = i+1;
            PolylineOptions line =
                    new PolylineOptions().add(new LatLng(puntosLat.get(i),puntosLong.get(i)) ,new LatLng(puntosLat.get(j),puntosLong.get(j))  )
                            .width(5).color(Color.RED);

            googleMap.addPolyline(line);

        }

    }


}
