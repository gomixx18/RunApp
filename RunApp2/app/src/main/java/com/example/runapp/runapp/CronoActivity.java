package com.example.runapp.runapp;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class CronoActivity extends AppCompatActivity {

    Chronometer Crono;
    Button start,stop;
    public static final long aMinutos = 60000;
    public static final long aHoras = 3600000;
    public static long elapsedMillis;
    public static String resultad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crono);



        start = (Button) findViewById(R.id.button2);
        stop = (Button) findViewById(R.id.button3);
        Crono = (Chronometer) findViewById(R.id.chronometer);
        stop.setClickable(false);


        Crono.setText("00:00:00");
        Crono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer cArg) {
                long elapsedMillis = SystemClock.elapsedRealtime() - cArg.getBase();
                int h = (int) (elapsedMillis / 3600000);
                int m = (int) (elapsedMillis - h * 3600000) / 60000;
                int s = (int) (elapsedMillis - h * 3600000 - m * 60000) / 1000;
                String hh = h < 10 ? "0" + h : h + "";
                String mm = m < 10 ? "0" + m : m + "";
                String ss = s < 10 ? "0" + s : s + "";
                resultad = hh + ":" + mm + ":" + ss;
                cArg.setText(hh + ":" + mm + ":" + ss);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Crono.setText("00:00:00");
                Crono.setBase(SystemClock.elapsedRealtime());
                stop.setClickable(true);
                Crono.start();
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Crono.stop();
                tiempoTranscurrido();
                stop.setClickable(false);
                resultad = Crono.getText().toString();
                startActivity(new Intent(CronoActivity.this, ResultadosActivity.class));
            }
        });

    }

    private void tiempoTranscurrido() {
        elapsedMillis = SystemClock.elapsedRealtime() - Crono.getBase();

        int segundos = (int) (elapsedMillis / 1000) % 60;
        int minuto = (int) ((elapsedMillis / (aMinutos)) % 60);

        int hora = (int) ((elapsedMillis / (aHoras)));
        int millis = (int) elapsedMillis % 1000;
        String tiempo =  String.format("%02d:%02d:%02d:%03d"
                , hora, minuto, segundos, millis);
        Toast.makeText(CronoActivity.this, "Tiempo Transcurrido: " + tiempo,
                Toast.LENGTH_SHORT).show();
    }

}
