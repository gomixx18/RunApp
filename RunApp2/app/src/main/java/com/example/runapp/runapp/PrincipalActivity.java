package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.runapp.runapp.Modelo.GestorBD;

public class PrincipalActivity extends AppCompatActivity {

    public final GestorBD gestorBD = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.principal);




        Thread timer = new Thread() {
            //El nuevo Thread exige el metodo run
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                } finally {

                    if(gestorBD.numero_Filas("BD_RunApp_Usuario") == 0)
                        startActivity(new Intent(PrincipalActivity.this, Inicio.class));
                    else
                        startActivity(new Intent(PrincipalActivity.this, Inicio.class));

                    finish();
                }
            }
        };

        timer.start();
    }
    }

