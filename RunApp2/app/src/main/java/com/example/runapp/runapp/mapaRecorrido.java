package com.example.runapp.runapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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

public class mapaRecorrido extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_recorrido);
        SupportMapFragment mapa = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapa.getMapAsync(this);
        mMap = mapa.getMap();



    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Costa Rica and move the camera
        LatLng sanJose = new LatLng(9.93, -84.10);
        mMap.addMarker(new MarkerOptions().position(sanJose).title("Marker in Costa Rica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sanJose));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        //mMap.setMyLocationEnabled(true);

        Criteria criteria = new Criteria();
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = locationManager.getBestProvider(criteria, false);
       // Location location = locationManager.getLastKnownLocation(provider);

        //double lat =  location.getLatitude();
        //double lng = location.getLongitude();

       // LatLng coordenadas = new LatLng(lat, lng);
        //CameraUpdate ubicacion=
        //        CameraUpdateFactory.newLatLng(coordenadas);
        CameraUpdate zoom=CameraUpdateFactory.zoomTo(2);

       // mMap.moveCamera(ubicacion);
        mMap.animateCamera(zoom);
    }
}
