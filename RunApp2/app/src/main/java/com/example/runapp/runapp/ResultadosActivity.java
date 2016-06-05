package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;
import com.example.runapp.runapp.Modelo.claseStatic;

import java.sql.Time;
import java.util.Date;

public class ResultadosActivity extends AppCompatActivity {
    RatingBar ratingBar;
    String valoracion = "0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        TextView tiempo = (TextView) findViewById(R.id.tiempoResultado);
        TextView distancia = (TextView) findViewById(R.id.distanciaRes);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setFocusable(false);

        ratingBar.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadosActivity.this, CronoActivity.class));
                finish();
            }
        });

        findViewById(R.id.btnImgMapa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultadosActivity.this, Mapa.class));
            }
        });

        if(claseStatic.valor == 1){

            tiempo.setText(CronoActivity.resultad);
            String distanciaString = String.valueOf(String.format("%.2f",claseStatic.Distancia));
            distancia.setText(distanciaString);
            insertarRecorrido(distanciaString, claseStatic.tiempo);
        }

        else{ // Sin GPS
            Toast.makeText(getApplicationContext(), claseStatic.tiempo, Toast.LENGTH_LONG).show();
            tiempo.setText(claseStatic.tiempo);
            distancia.setText("0.0");
            insertarRecorrido("0", claseStatic.tiempo);
            findViewById(R.id.btnImgMapa).setClickable(false);
        }

        ratingBar.setRating(Float.parseFloat(valoracion));

    }


    public void insertarRecorrido(String distance, String time){
        obtenerValoracion(distance);

        boolean exito = gestorBD.insertarRecorrido(distance,time,valoracion);

        if(exito){
            //Toast.makeText(this, "Recorrido insertado", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this,gestorBD.getMensajeError(),Toast.LENGTH_LONG).show();
    }






    public String obtenerValoracion(String distancia){

        Date tiempoRecorrido = claseStatic.fechaStatic;

        float distanciaEnNumero = Float.parseFloat(distancia);


        if(distanciaEnNumero > 0.0 ){ // si activó el GPS...

            if(distanciaEnNumero > 0 && distanciaEnNumero <= 5){

                if(tiempoRecorrido.getTime() >= vectorDe0_A_5[0].getTime()
                        && tiempoRecorrido.getTime() <= vectorDe0_A_5[1].getTime()){

                    // 5 estrellas
                    valoracion = "5";
                }
                else if(tiempoRecorrido.getTime() >= vectorDe0_A_5[2].getTime()
                        && tiempoRecorrido.getTime() <= vectorDe0_A_5[3].getTime()){

                    // 4 estrellas
                    valoracion = "4";
                }
                else if(tiempoRecorrido.getTime() >= vectorDe0_A_5[4].getTime()
                        && tiempoRecorrido.getTime() <= vectorDe0_A_5[5].getTime()){

                    // 3 estrellas
                    valoracion = "3";
                }
                else if(tiempoRecorrido.getTime() >= vectorDe0_A_5[6].getTime()
                        && tiempoRecorrido.getTime() <= vectorDe0_A_5[7].getTime()){

                    // 2 estrellas
                    valoracion = "2";
                }
                else if(tiempoRecorrido.getTime() >= vectorDe0_A_5[8].getTime()
                        && tiempoRecorrido.getTime() <= vectorDe0_A_5[9].getTime()){

                    // 1 estrella
                    valoracion = "1";
                }

            }







            // ===================================================================
            if(distanciaEnNumero > 5 && distanciaEnNumero <= 10){
                if(tiempoRecorrido.getTime() >= vector5a10[0].getTime()
                        && tiempoRecorrido.getTime() <= vector5a10[1].getTime()){

                    // 5 estrellas
                    valoracion = "5";

                }else if(tiempoRecorrido.getTime() >= vector5a10[2].getTime()
                        && tiempoRecorrido.getTime() <= vector5a10[3].getTime()){

                    // 4 estrellas
                    valoracion = "4";
                }
                else if(tiempoRecorrido.getTime() >= vector5a10[4].getTime()
                        && tiempoRecorrido.getTime() <= vector5a10[5].getTime()){

                    // 3 estrellas
                    valoracion = "3";
                }
                else if(tiempoRecorrido.getTime() >= vector5a10[6].getTime()
                        && tiempoRecorrido.getTime() <= vector5a10[7].getTime()){

                    // 2 estrellas
                    valoracion = "2";
                }
                else if(tiempoRecorrido.getTime() >= vector5a10[8].getTime()
                        && tiempoRecorrido.getTime() <= vector5a10[9].getTime()){

                    // 1 estrellas
                    valoracion = "1";
                }

            }








            // ===================================================================

            if(distanciaEnNumero > 10 && distanciaEnNumero <= 21.098){
                if(tiempoRecorrido.getTime() >= vector10a21[0].getTime()
                        && tiempoRecorrido.getTime() <= vector10a21[1].getTime()){

                    // 5 estrellas
                    valoracion = "5";

                }else if(tiempoRecorrido.getTime() >= vector10a21[2].getTime()
                        && tiempoRecorrido.getTime() <= vector10a21[3].getTime()){

                    // 4 estrellas
                    valoracion = "4";
                }
                else if(tiempoRecorrido.getTime() >= vector10a21[4].getTime()
                        && tiempoRecorrido.getTime() <= vector10a21[5].getTime()){

                    // 3 estrellas
                    valoracion = "3";
                }
                else if(tiempoRecorrido.getTime() >= vector10a21[6].getTime()
                        && tiempoRecorrido.getTime() <= vector10a21[7].getTime()){

                    // 2 estrellas
                    valoracion = "2";
                }
                else if(tiempoRecorrido.getTime() >= vector10a21[8].getTime()
                        && tiempoRecorrido.getTime() <= vector10a21[9].getTime()){

                    // 1 estrellas
                    valoracion = "1";
                }
            }








            // ===================================================================

            if(distanciaEnNumero > 21 && distanciaEnNumero <= 42.195){
                if(tiempoRecorrido.getTime() >= vector21a40[0].getTime()
                        && tiempoRecorrido.getTime() <= vector21a40[1].getTime()){

                    // 5 estrellas
                    valoracion = "5";

                }else if(tiempoRecorrido.getTime() >= vector21a40[2].getTime()
                        && tiempoRecorrido.getTime() <= vector21a40[3].getTime()){

                    // 4 estrellas
                    valoracion = "4";
                }
                else if(tiempoRecorrido.getTime() >= vector21a40[4].getTime()
                        && tiempoRecorrido.getTime() <= vector21a40[5].getTime()){

                    // 3 estrellas
                    valoracion = "3";
                }
                else if(tiempoRecorrido.getTime() >= vector21a40[6].getTime()
                        && tiempoRecorrido.getTime() <= vector21a40[7].getTime()){

                    // 2 estrellas
                    valoracion = "2";
                }
                else if(tiempoRecorrido.getTime() >= vector21a40[8].getTime()
                        && tiempoRecorrido.getTime() <= vector21a40[9].getTime()){

                    // 1 estrellas
                    valoracion = "1";
                }
            }


        }


        return valoracion;
    }




    public final GestorBD gestorBD = new GestorBD(this);



    // Vectores de tiempo para las distancias recorridas

    // Entre 0 y 5 km
    public Date[] vectorDe0_A_5 =
            new Date[]{new Date(0,0,0,0,15,0), new Date(0,0,0,0,18,0),
            new Date(0,0,0,0,18,1), new Date(0,0,0,0,22,0),
            new Date(0,0,0,0,22,1), new Date(0,0,0,0,28,0),
            new Date(0,0,0,0,28,1), new Date(0,0,0,0,32,0),
            new Date(0,0,0,0,32,1), new Date(0,0,0,0,40,0)

            };


    // Entre 5 y 10 km
    public Date vector5a10[] =
            new Date[] { new Date(0,0,0,0,32,0) , new Date(0,0,0,0,38,30),
            new Date(0,0,0,0,38,31) , new Date(0,0,0,0,46,0),
            new Date(0,0,0,0,46,1) , new Date(0,0,0,0,55,0),
            new Date(0,0,0,0,55,1) , new Date(0,0,0,1,5,0),
            new Date(0,0,0,1,5,1) , new Date(0,0,0,1,16,0)
    };



    // Entre 10 y 21 km
    public Date [] vector10a21 =
            new Date[]{ new Date(0,0,0,1,10,0),new Date(0,0,0,1,19,0),
            new Date(0,0,0,1,19,1),new Date(0,0,0,1,29,0),
            new Date(0,0,0,1,29,1),new Date(0,0,0,1,44,0),
            new Date(0,0,0,1,44,1),new Date(0,0,0,2,4,0),
                    new Date(0,0,0,2,4,1), new Date(0,0,0,2,45,0),
    };



    // Entre 21 y 42 km
    public Date vector21a40[] =
            new Date[] { new Date(0,0,0,2,30,0) , new Date(0,0,0,2,50,0),
            new Date(0,0,0,2,50,1) , new Date(0,0,0,3,10,0),
            new Date(0,0,0,3,10,1) , new Date(0,0,0,3,40,0),
            new Date(0,0,0,3,40,1) , new Date(0,0,0,4,30,0),
            new Date(0,0,0,4,30,1) , new Date(0,0,0,4,45,0)
    };
}
