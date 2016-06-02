package com.example.runapp.runapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.runapp.runapp.Modelo.GestorBD;
import com.google.android.gms.plus.model.people.Person;

import java.util.ArrayList;

public class VerRecorridos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_recorridos);

        inicializarTabla();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_recorridos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView fecha = new TextView(this);
            fecha.setText(arreglo[0]);
            /*fecha.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));*/

            fecha.setGravity(Gravity.CENTER_HORIZONTAL);

            float scale = getResources().getDisplayMetrics().density;
            int dp20 = (int) (20*scale + 0.5f);
            int dp16 = (int) (16*scale + 0.5f);
            fecha.setPadding(0, dp20, 0, dp16);
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
            tiempo.setPadding(0, dp20, 0, dp16);
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
            /*LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int dp5 = (int) (5*scale + 0.5f);
            layoutParams.setMargins(dp5, 0, 0, 0);*/

            /*LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(5, 0, 0, 0);

            fecha.setLayoutParams(llp);
            distancia.setLayoutParams(llp);
            tiempo.setLayoutParams(llp);
            valoracion.setLayoutParams(llp);*/
            /*valoracion.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
            valoracion.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);*/

            row.addView(fecha);
            row.addView(distancia);
            row.addView(tiempo);
            row.addView(valoracion);

            tablaLayout.addView(row);
        }
    }




    public final GestorBD gestorBD = new GestorBD(this);
}
