package com.example.runapp.runapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;

public class incioDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final GestorBD gestorBD = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incio_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String username = gestorBD.getUsername();
        String username1 = gestorBD.getNombre();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);

        TextView name = (TextView)header.findViewById(R.id.nombre);
        TextView usuario = (TextView)header.findViewById(R.id.usuario);
        name.setText(username1);
        usuario.setText(username);


        findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(incioDrawer.this, CronoActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.question)
                    .setTitle("¿Cerrar RunApp?")
                    .setMessage("¿Está seguro que desea salir de RunApp?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            incioDrawer.super.onBackPressed();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.verDatos) {
            startActivity(new Intent(incioDrawer.this, verMisDatos.class));
            finish();

        } else if (id == R.id.verRecorridos) {
            startActivity(new Intent(incioDrawer.this, VerRecorridos.class));
            finish();
        } else if (id == R.id.cambiarDatos) {
            startActivity(new Intent(incioDrawer.this, CambiarDatos.class));
            finish();
        } else if (id == R.id.verTips) {
            startActivity(new Intent(incioDrawer.this, MainActivity.class));
            finish();
        } else if (id == R.id.acercaDeId) {
            startActivity(new Intent(incioDrawer.this, AcercaDeActivity.class));
            finish();

        }else if (id == R.id.selfies) {
            startActivity(new Intent(incioDrawer.this, selfies.class));
            finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
