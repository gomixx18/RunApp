package com.example.runapp.runapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static boolean valor = true;
    public static boolean valor2 = true;
    public static boolean valor3 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.na);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, incioDrawer.class));
                finish();
            }
        });

        findViewById(R.id.fragment).setVisibility(View.GONE);
        findViewById(R.id.fragment2).setVisibility(View.GONE);
        findViewById(R.id.fragment3).setVisibility(View.GONE);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        findViewById(R.id.nutri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor) {
                    findViewById(R.id.fragment).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment).setMinimumHeight(200);
                    valor = false;

                } else {
                    findViewById(R.id.fragment).setVisibility(View.GONE);
                    findViewById(R.id.fragment).setMinimumHeight(0);
                    valor = true;
                }
            }
        });

        findViewById(R.id.cal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor2) {
                    findViewById(R.id.fragment2).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment2).setMinimumHeight(200);
                    valor2 = false;

                } else {
                    findViewById(R.id.fragment2).setVisibility(View.GONE);
                    findViewById(R.id.fragment2).setMinimumHeight(0);
                    valor2 = true;
                }
            }
        });

        findViewById(R.id.car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor3) {
                    findViewById(R.id.fragment3).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment3).setMinimumHeight(200);
                    valor3 = false;

                } else {
                    findViewById(R.id.fragment3).setVisibility(View.GONE);
                    findViewById(R.id.fragment3).setMinimumHeight(0);
                    valor3 = true;
                }
            }
        });

    }

}
