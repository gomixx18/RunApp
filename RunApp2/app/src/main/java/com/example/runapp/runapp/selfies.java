package com.example.runapp.runapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;



public class selfies extends AppCompatActivity {
    ViewPager viewPager;
    CustomCambioAdapter customCambioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfies);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.na);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selfies.this, incioDrawer.class));
                finish();
            }
        });

        viewPager = (ViewPager) findViewById(R.id.tennisV1);
        customCambioAdapter= new CustomCambioAdapter(selfies.this, 3);
        viewPager.setAdapter(customCambioAdapter);


    }



}
