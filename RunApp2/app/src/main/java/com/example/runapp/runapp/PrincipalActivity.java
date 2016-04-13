package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.runapp.runapp.Modelo.GestorBD;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.principal);


        GestorBD gb = new GestorBD(this);
        Thread timer = new Thread() {
            //El nuevo Thread exige el metodo run
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                } finally {

                    startActivity(new Intent(PrincipalActivity.this, CronoActivity.class));
                    finish();
                }
            }
        };

        timer.start();
    }
    }

