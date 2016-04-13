package com.example.runapp.runapp;

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
        findViewById(R.id.btnAnterior).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroFit.this, RegistroPass.class));
            }
        });
        findViewById(R.id.btnRegistrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String age, pes, estatur;

                EditText textoEdad = (EditText)findViewById(R.id.editEdad);
                age = textoEdad.getText().toString();
                edad = Integer.parseInt(age);

                EditText textoPeso = (EditText)findViewById(R.id.editPeso);
                pes = textoPeso.getText().toString();
                peso = Float.parseFloat(pes);

                EditText textoEstatura = (EditText)findViewById(R.id.editEstatura);
                estatur = textoEstatura.getText().toString();
                estatura = Float.parseFloat(estatur);


                saveUser(new Usuario(
                        ActividadMain.getNombre(),
                        ActividadMain.getApellido(),
                        ActividadMain.getUsername(),
                        ActividadMain.getEmail(),
                        edad,
                        peso,
                        estatura));

                startActivity(new Intent(RegistroFit.this, Inicio.class));
            }
        });
    }


    public static int getEdad() {
        return edad;
    }

    public static float getPeso() {
        return peso;
    }

    public static float getEstatura() {
        return estatura;
    }



    public void saveUser(Usuario user){

        boolean exito = gestorBD.insertarUsuario(user);

        if(exito){
            Toast.makeText(this, "Datos guardados exitosamente", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,gestorBD.getMensajeError(),Toast.LENGTH_LONG).show();
    }




    private static int edad;
    private static float peso;
    private static float estatura;
    public final GestorBD gestorBD = new GestorBD(this);
}
