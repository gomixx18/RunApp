package com.example.runapp.runapp;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GPS;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class Mapa extends AppCompatActivity implements LocationListener {
    private GoogleMap googleMap;
    public static LatLng current;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected double latitude,longitude;
    protected boolean gps_enabled,network_enabled;
    private static final long updateDistancia = 20;
    private static final long updateTiempo = 1000 * 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                updateTiempo,
                updateDistancia, this);

        List<String> providers = locationManager.getProviders(true);
        Location l = null;

        for (int i = 0; i < providers.size(); i++) {
            l = locationManager.getLastKnownLocation(providers.get(i));
            Toast.makeText(Mapa.this, "Tiempo Transcurrido: " + providers.size(),
                    Toast.LENGTH_SHORT).show();
            if (l != null) {
                latitude = l.getLatitude();
                longitude = l.getLongitude();
                Toast.makeText(Mapa.this, "Tiempo Transcurrido: " + latitude +" y " + longitude,
                        Toast.LENGTH_SHORT).show();
                break;
            }
        }
        current = new LatLng(latitude,longitude);
        final LatLng sj = new LatLng(9.9271,-84.082);
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().
                    findFragmentById(R.id.map)).getMap();

        }
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(current, 15));


        if(CronoActivity.puntosLat.size() > 0  &&  CronoActivity.puntosLong.size() > 0 )
        pintar(CronoActivity.puntosLat, CronoActivity.puntosLong);


    }


    public void pintar(ArrayList<Double> puntosLat , ArrayList<Double> puntosLong ){

int j = 0;
        for(int i = 0 ; i < puntosLat.size() - 1 ;i++) {
            j = i+1;
            PolylineOptions line =
                    new PolylineOptions().add(new LatLng(puntosLat.get(i),puntosLong.get(i)) ,new LatLng(puntosLat.get(j),puntosLong.get(j))  )
                            .width(5).color(Color.RED);

            googleMap.addPolyline(line);

        }

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
}
