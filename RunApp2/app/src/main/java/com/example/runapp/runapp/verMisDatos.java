package com.example.runapp.runapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.runapp.runapp.Modelo.GestorBD;

public class verMisDatos extends AppCompatActivity {

    public final GestorBD gestorBD = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mis_datos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.na);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(verMisDatos.this, incioDrawer.class));
                finish();
            }
        });

        EditText nombre = (EditText)findViewById(R.id.editNombreMostrar);
        nombre.setText(gestorBD.getNombre());

        EditText username = (EditText)findViewById(R.id.editUserMostrar);
        username.setText(gestorBD.getUsername());

        EditText correo = (EditText)findViewById(R.id.editEmailMostrar);
        correo.setText(gestorBD.getEmail());

        EditText edad = (EditText)findViewById(R.id.editEdadMostrar);
        edad.setText(gestorBD.getEdad() + " años");

        EditText peso = (EditText)findViewById(R.id.editPesoMostrar);
        peso.setText(gestorBD.getPeso());

        EditText estatura = (EditText)findViewById(R.id.editEstaturaMostrar);
        estatura.setText(gestorBD.getEstatura());

    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(verMisDatos.this, incioDrawer.class));
    }

}
