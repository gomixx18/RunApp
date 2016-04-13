package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActividadMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_main);
        findViewById(R.id.btnSiguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText textoName = (EditText)findViewById(R.id.editNombre);
                nombre = textoName.getText().toString();

                EditText textoApellido = (EditText)findViewById(R.id.editApellido);
                apellido = textoApellido.getText().toString();

                EditText textoUsername = (EditText)findViewById(R.id.editUser);
                username = textoUsername.getText().toString();

                EditText textoEmail = (EditText)findViewById(R.id.editCorreo);
                email = textoEmail.getText().toString();

                startActivity(new Intent(ActividadMain.this, RegistroPass.class));
            }
        });

    }


    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }


    private static String nombre;
    private static String apellido;
    private static String username;
    private static String email;
}
