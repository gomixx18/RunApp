package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.runapp.runapp.Modelo.GestorBD;

public class CambiarDatos extends AppCompatActivity {


    public final GestorBD gestorBD = new GestorBD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);

        // Al iniciar la actividad, seteamos los campos con los valores
        // que hay en la BD de edad, peso y estatura.

        EditText edad = (EditText)findViewById(R.id.editEdad);
        edad.setText(gestorBD.getEdad());

        EditText peso = (EditText)findViewById(R.id.editPeso);
        peso.setText(gestorBD.getPeso());

        EditText estatura = (EditText)findViewById(R.id.editEstatura);
        estatura.setText(gestorBD.getEstatura());

        findViewById(R.id.btnCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CambiarDatos.this, incioDrawer.class));
            }
        });


        findViewById(R.id.btnGuarda).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean sonNumeros = true;

                EditText edad = (EditText)findViewById(R.id.editEdad);
                String campoEdad = edad.getText().toString();

                EditText peso = (EditText) findViewById(R.id.editPeso);
                String campoPeso = peso.getText().toString();

                EditText estatura = (EditText) findViewById(R.id.editEstatura);
                String campoEstatura = estatura.getText().toString();


                // En cada try-catch se va a comprobar si es un número
                // lo que se digitó.

                try{
                    Integer.parseInt(campoEdad);

                }catch(NumberFormatException exception){
                    sonNumeros = false;
                    Toast.makeText(CambiarDatos.this, "La edad debe ser un dato numérico",
                            Toast.LENGTH_SHORT).show();
                }


                if(sonNumeros) {
                    try {
                        Float.parseFloat(campoPeso);

                    } catch (NumberFormatException exception) {
                        sonNumeros = false;
                        Toast.makeText(CambiarDatos.this, "El peso debe ser un dato numérico",
                                Toast.LENGTH_SHORT).show();
                    }
                }



                if(sonNumeros) {
                    try {
                        Float.parseFloat(campoEstatura);

                    } catch (NumberFormatException exception) {
                        sonNumeros = false;
                        Toast.makeText(CambiarDatos.this, "La estatura debe ser un dato numérico",
                                Toast.LENGTH_SHORT).show();
                    }
                }


                if(sonNumeros) {
                    if (gestorBD.actualizaEdad(campoEdad) &&
                            gestorBD.actualizaPeso(campoPeso) &&
                            gestorBD.actualizaEstatura(campoEstatura)) {

                        Toast.makeText(CambiarDatos.this, "Datos actualizados exitosamente",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(CambiarDatos.this, incioDrawer.class));
                    } else {

                        Toast.makeText(CambiarDatos.this, "No se pudieron actualizar los datos",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cambiar_datos, menu);
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
}
