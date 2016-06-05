package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;
import com.example.runapp.runapp.Modelo.claseStatic;

public class ResultadosActivity extends AppCompatActivity {
    RatingBar ratingBar;
    String valoracion="1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView tiempo = (TextView) findViewById(R.id.tiempoResultado);
        TextView distancia = (TextView) findViewById(R.id.distanciaRes);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setFocusable(false);

        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadosActivity.this, CronoActivity.class));
                finish();
            }
        });

        findViewById(R.id.btnImgMapa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadosActivity.this, Mapa.class));
            }
        });

        if(claseStatic.valor == 1){

            tiempo.setText(CronoActivity.resultad);
            String distanciaString = String.valueOf(String.format("%.2f",claseStatic.Distancia));
            distancia.setText(distanciaString);
            insertarRecorrido(distanciaString, claseStatic.tiempo);
        }

        else{ // Sin GPS
            Toast.makeText(getApplicationContext(), claseStatic.tiempo, Toast.LENGTH_LONG).show();
            tiempo.setText(claseStatic.tiempo);
            distancia.setText("0.0");
            insertarRecorrido("0", claseStatic.tiempo);
            findViewById(R.id.btnImgMapa).setClickable(false);
        }

        ratingBar.setRating(Float.parseFloat(valoracion));

    }


    public void insertarRecorrido(String distance, String time){
        obtenerValoracion(distance, time);

        boolean exito = gestorBD.insertarRecorrido(distance,time,valoracion);

        if(exito){
            //Toast.makeText(this, "Recorrido insertado", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,gestorBD.getMensajeError(),Toast.LENGTH_LONG).show();
    }

    public String obtenerValoracion(String distancia, String tiempo){

        if(distancia != "0" ){
              //  if(Double.parseDouble(distancia) == 0)
        }
        return valoracion;
    }


    public final GestorBD gestorBD = new GestorBD(this);
}
