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
        //mMap.setMyLocationEnabled(true);


        //LatLng coordenadas = new LatLng(9.9354495,-84.1026813);
        //CameraUpdate ubicacion=
        //CameraUpdateFactory.newLatLng(coordenadas);
        //CameraUpdate zoom=CameraUpdateFactory.zoomTo(15);

        //Criteria criteria = new Criteria();
        //LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //String provider = locationManager.getBestProvider(criteria, false);
        // Location location = locationManager.getLastKnownLocation(provider);

        //double lat =  location.getLatitude();
        //double lng = location.getLongitude();

        // LatLng coordenadas = new LatLng(lat, lng);
        //CameraUpdate ubicacion=
        //        CameraUpdateFactory.newLatLng(coordenadas);
        // CameraUpdate zoom=CameraUpdateFactory.zoomTo(2);


        // mMap.moveCamera(ubicacion);
        //mMap.animateCamera(zoom);

        Criteria criteria = new Criteria();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(criteria, false);

        Location location;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
                }else{
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            }
        }else{
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }


        double lat =  location.getLatitude();
        double lng = location.getLongitude();

        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate ubicacion= CameraUpdateFactory.newLatLng(coordenadas);
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(18);

        mMap.moveCamera(ubicacion);
        mMap.animateCamera(zoom);
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
