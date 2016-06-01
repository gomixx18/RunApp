package com.example.runapp.runapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static boolean valor = true;
    public static boolean valor2 = true;
    public static boolean valor3 = true;
    public static boolean valor4 = true;
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
        findViewById(R.id.fragment4).setVisibility(View.GONE);




        findViewById(R.id.nutri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor) {
                    findViewById(R.id.fragment).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment).setMinimumHeight(300);
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
                    findViewById(R.id.fragment2).setMinimumHeight(300);
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
                    findViewById(R.id.fragment3).setMinimumHeight(300);
                    valor3 = false;

                } else {
                    findViewById(R.id.fragment3).setVisibility(View.GONE);
                    findViewById(R.id.fragment3).setMinimumHeight(0);
                    valor3 = true;
                }
            }
        });



        findViewById(R.id.tennis).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valor4) {
                    findViewById(R.id.fragment4).setVisibility(View.VISIBLE);
                    findViewById(R.id.fragment4).setMinimumHeight(300);
                    valor4 = false;

                } else {
                    findViewById(R.id.fragment4).setVisibility(View.GONE);
                    findViewById(R.id.fragment4).setMinimumHeight(0);
                    valor4 = true;
                }
            }
        });


        }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, incioDrawer.class));
    }

}
