package com.example.runapp.runapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;
import com.example.runapp.runapp.Modelo.Usuario;

public class RegistroFit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_fit);

        // En el caso de que digite datos, se devuelva a ActividadMain y cuando quiera
        // volver a RegistroFit, debe estar edad, peso y estatura como los dejó.

        if(!(edad.equals(""))) {
            EditText textoEdad = (EditText)findViewById(R.id.editEdad);
            textoEdad.setText(edad);
        }


        if(!(peso.equals(""))) {
            EditText textoPeso = (EditText) findViewById(R.id.editPeso);
            textoPeso.setText(peso);
        }


        if(!(estatura.equals(""))) {
            EditText textoEstatura = (EditText) findViewById(R.id.editEstatura);
            textoEstatura.setText(estatura);
        }




        findViewById(R.id.btnAnterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText textoEdad = (EditText) findViewById(R.id.editEdad);
                edad = textoEdad.getText().toString();

                EditText textoPeso = (EditText) findViewById(R.id.editPeso);
                peso = textoPeso.getText().toString();

                EditText textoEstatura = (EditText) findViewById(R.id.editEstatura);
                estatura = textoEstatura.getText().toString();

                startActivity(new Intent(RegistroFit.this, ActividadMain.class));
                finish();
                ActividadMain.actividadDatosPersonales.finish();
            }
        });

        findViewById(R.id.btnRegistrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean sonNumeros = true;
                int edadTemporal = 0;
                float pesoTemporal = 0, estaturaTemporal = 0;

                EditText textoEdad = (EditText) findViewById(R.id.editEdad);
                edad = textoEdad.getText().toString();

                EditText textoPeso = (EditText) findViewById(R.id.editPeso);
                peso = textoPeso.getText().toString();

                EditText textoEstatura = (EditText) findViewById(R.id.editEstatura);
                estatura = textoEstatura.getText().toString();


                // En cada try-catch se va a comprobar si es un número
                // lo que se digitó.

                try {
                    Integer.parseInt(edad);
                    edadTemporal = Integer.parseInt(edad);
                    if(edadTemporal > 100){
                        Toast.makeText(RegistroFit.this, "La edad esta errónea",
                                Toast.LENGTH_SHORT).show();
                    }

                } catch (NumberFormatException exception) {
                    sonNumeros = false;
                    Toast.makeText(RegistroFit.this, "La edad debe ser un dato numérico",
                            Toast.LENGTH_SHORT).show();
                }


                if (sonNumeros) {
                    try {
                        Float.parseFloat(peso);
                        pesoTemporal = Float.parseFloat(peso);
                        if(pesoTemporal > 300){
                            Toast.makeText(RegistroFit.this, "El peso es incorrecto",
                                    Toast.LENGTH_SHORT).show();
                            sonNumeros =false;
                        }

                    } catch (NumberFormatException exception) {
                        sonNumeros = false;
                        Toast.makeText(RegistroFit.this, "El peso debe ser un dato numérico",
                                Toast.LENGTH_SHORT).show();
                        sonNumeros = false;
                    }
                }


                if (sonNumeros) {
                    try {
                        Float.parseFloat(estatura);
                        estaturaTemporal = Float.parseFloat(estatura);
                        if(estaturaTemporal > 3.0){
                            Toast.makeText(RegistroFit.this, "La estatura es incorrecta",
                                    Toast.LENGTH_SHORT).show();
                            sonNumeros = false;
                        }
                    } catch (NumberFormatException exception) {
                        sonNumeros = false;
                        Toast.makeText(RegistroFit.this, "La estatura debe ser un dato numérico",
                                Toast.LENGTH_SHORT).show();
                    }
                }


                if (sonNumeros) {
                    saveUser(new Usuario(
                            ActividadMain.getNombre(),
                            ActividadMain.getApellido(),
                            ActividadMain.getUsername(),
                            ActividadMain.getEmail(),
                            edadTemporal,
                            pesoTemporal,
                            estaturaTemporal));

                    startActivity(new Intent(RegistroFit.this, incioDrawer.class));
                    finish();
                    ActividadMain.actividadDatosPersonales.finish();
                }
            }
        });
    }


    public static String getEdad() {
        return edad;
    }

    public static String getPeso() {
        return peso;
    }

    public static String getEstatura() {
        return estatura;
    }



    public void saveUser(Usuario user){

        boolean exito = gestorBD.insertarUsuario(user);

        if(exito){
            Toast.makeText(this, "Registro completado exitosamente", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,gestorBD.getMensajeError(),Toast.LENGTH_LONG).show();
    }




    private static String edad = "";
    private static String peso = "";
    private static String estatura = "";
    public final GestorBD gestorBD = new GestorBD(this);
}
