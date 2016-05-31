package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tiposdetennis extends AppCompatActivity {
    ViewPager viewPager;
    CustomCambioAdapter customCambioAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiposdetennis);

        Button MiBoton2 = (Button) findViewById(R.id.pronador);
        Button MiBoton3 = (Button) findViewById(R.id.supipronador);
        Button MiBoton4 = (Button) findViewById(R.id.normal);
        Button MiBoton5 = (Button) findViewById(R.id.btnvolveratips);
        viewPager = (ViewPager) findViewById(R.id.tennisV);

        MiBoton2.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View arg0) {
                customCambioAdapter= new CustomCambioAdapter(tiposdetennis.this, 0);
                viewPager.setAdapter(customCambioAdapter);
            }

        });

        MiBoton3.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View arg0) {
                customCambioAdapter= new CustomCambioAdapter(tiposdetennis.this, 1);
                viewPager.setAdapter(customCambioAdapter);
            }

        });

        MiBoton4.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View arg0) {
                customCambioAdapter= new CustomCambioAdapter(tiposdetennis.this, 2);
                viewPager.setAdapter(customCambioAdapter);
            }

        });

        MiBoton5.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View arg0) {
                Intent intento = new Intent(tiposdetennis.this, MainActivity.class);
                startActivity(intento);
                finish();
            }

        });




    }
}
