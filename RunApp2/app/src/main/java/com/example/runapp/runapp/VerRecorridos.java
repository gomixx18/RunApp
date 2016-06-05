package com.example.runapp.runapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.runapp.runapp.Modelo.GestorBD;

import java.util.ArrayList;

public class VerRecorridos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_recorridos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.na);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VerRecorridos.this, incioDrawer.class));
                finish();
            }
        });

        inicializarTabla();

    }



    @Override
    public void onBackPressed() {
        startActivity(new Intent(VerRecorridos.this, incioDrawer.class));
    }



    public void inicializarTabla(){

        // Se obtienen todos los recorridos de la Base de Datos
        ArrayList<String[]> list_recorridos = gestorBD.obtenerRecorridos();

        // Se agregan las filas de recorridos dinámicamente
        TableLayout tablaLayout = (TableLayout) findViewById(R.id.tablaRecorridos);
        for (int i = 0; i < list_recorridos.size(); i++) {

            String[] arreglo = new String[4];
            arreglo = list_recorridos.get(i);
            TableRow row= new TableRow(this);

            TextView fecha = new TextView(this);
            fecha.setText(arreglo[0]);

            fecha.setGravity(Gravity.CENTER_HORIZONTAL);

            float scale = getResources().getDisplayMetrics().density;
            int dp20 = (int) (20*scale + 0.5f);
            int dp16 = (int) (16*scale + 0.5f);
            int dp5 = (int) (5*scale + 0.5f);
            int dp13 = (int) (13*scale + 0.5f);
            fecha.setPadding(dp5, dp20, 0, dp16);
            fecha.setFocusable(false);
            fecha.setTextColor(Color.BLACK);
            fecha.setTypeface(null, Typeface.BOLD);
            fecha.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);


            TextView distancia = new TextView(this);
            distancia.setText(arreglo[1] + " km");
            distancia.setGravity(Gravity.CENTER_HORIZONTAL);
            distancia.setPadding(0, dp20, 0, dp16);
            distancia.setFocusable(false);
            distancia.setTextColor(Color.BLACK);
            distancia.setTypeface(null, Typeface.BOLD);
            distancia.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);


            TextView tiempo = new TextView(this);
            tiempo.setText(arreglo[2]);
            tiempo.setGravity(Gravity.CENTER_HORIZONTAL);
            tiempo.setPadding(dp13, dp20, 0, dp16);
            tiempo.setFocusable(false);
            tiempo.setTextColor(Color.BLACK);
            tiempo.setTypeface(null, Typeface.BOLD);
            tiempo.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);


            TextView valoracion = new TextView(this);
            valoracion.setText(arreglo[3]);
            valoracion.setGravity(Gravity.CENTER_HORIZONTAL);
            valoracion.setPadding(0, dp20, 0, dp16);
            valoracion.setFocusable(false);
            valoracion.setTextColor(Color.BLACK);
            valoracion.setTypeface(null, Typeface.BOLD);
            valoracion.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);


            row.addView(fecha);
            row.addView(distancia);
            row.addView(tiempo);
            row.addView(valoracion);

            tablaLayout.addView(row);
        }
    }




    public final GestorBD gestorBD = new GestorBD(this);

}
