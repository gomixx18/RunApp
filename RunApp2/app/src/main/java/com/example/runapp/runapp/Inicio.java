package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.runapp.runapp.Modelo.GestorBD;

public class Inicio extends AppCompatActivity {

    public final GestorBD gestorBD = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // Extraer el username para mostrar mensaje de Bienvenid@
        TextView etiquetaBienvenido = (TextView) findViewById(R.id.txtBienvenida);
        String username = gestorBD.getUsername();
        etiquetaBienvenido.setText("Bienvenid@ " + username);

        findViewById(R.id.btnStartRecorrido).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Inicio.this, CronoActivity.class));
            }
        });
        findViewById(R.id.btnVerRecorridos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Inicio.this, VerRecorridos.class));
            }
        });
        findViewById(R.id.btnCambiarDatos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Inicio.this, CambiarDatos.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
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
}
