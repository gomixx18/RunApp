package com.example.runapp.runapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class mapaRecorrido extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_recorrido);
        SupportMapFragment mapa = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapa.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        pintar(mMap);



    }

    public void pintar(GoogleMap googleMap){
        for(int i = 0; i < CronoActivity.puntosLat.size() -1 ;i++) {
            PolylineOptions line =
                    new PolylineOptions().add(new LatLng(CronoActivity.puntosLat.get(i),CronoActivity.puntosLong.get(i)),
                            new LatLng(CronoActivity.puntosLat.get(i + 1),CronoActivity.puntosLong.get(i +1 )))
                            .width(5).color(Color.RED);

            googleMap.addPolyline(line);
        }
    }
}
