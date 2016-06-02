package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;
import com.example.runapp.runapp.Modelo.claseStatic;

public class ResultadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView tiempo = (TextView) findViewById(R.id.tiempoResultado);
        TextView distancia = (TextView) findViewById(R.id.distanciaRes);


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

        if(claseStatic.valor == 1){   // Con GPS
            tiempo.setText(CronoActivity.resultad);
            distancia.setText(claseStatic.Distancia);
            insertarRecorrido(claseStatic.Distancia, "0");
        }
        else{ // Sin GPS
            Toast.makeText(getApplicationContext(), claseStatic.tiempo, Toast.LENGTH_LONG).show();
            tiempo.setText(claseStatic.tiempo);
            distancia.setText("0.0");
            insertarRecorrido("0", claseStatic.tiempo);
            findViewById(R.id.btnImgMapa).setClickable(false);
        }
    }


    public void insertarRecorrido(String distance, String time){

        boolean exito = gestorBD.insertarRecorrido(distance, time);

        if(exito){
            Toast.makeText(this, "Recorrido insertado", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,gestorBD.getMensajeError(),Toast.LENGTH_LONG).show();
    }


    public final GestorBD gestorBD = new GestorBD(this);
}
