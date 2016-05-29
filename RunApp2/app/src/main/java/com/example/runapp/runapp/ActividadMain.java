package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActividadMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_main);

        // En el caso de que esté en RegistroFit y oprime "Anterior",
        // se vuelven a cargar los datos (nombre, apellido, etc.) que digitó antes.
        if(!(nombre.equals("")) && !(apellido.equals("")) &&
                !(username.equals("")) && !(email.equals(""))){

            EditText textoName = (EditText)findViewById(R.id.editNombre);
            textoName.setText(nombre);

            EditText textoApellido = (EditText)findViewById(R.id.editApellido);
            textoApellido.setText(apellido);

            EditText textoUsername = (EditText)findViewById(R.id.editUser);
            textoUsername.setText(username);

            EditText textoEmail = (EditText)findViewById(R.id.editCorreo);
            textoEmail.setText(email);
        }


        findViewById(R.id.btnSiguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean datosCorrectos = true;

                EditText textoName = (EditText)findViewById(R.id.editNombre);
                nombre = textoName.getText().toString();

                EditText textoApellido = (EditText)findViewById(R.id.editApellido);
                apellido = textoApellido.getText().toString();

                EditText textoUsername = (EditText)findViewById(R.id.editUser);
                username = textoUsername.getText().toString();

                EditText textoEmail = (EditText)findViewById(R.id.editCorreo);
                email = textoEmail.getText().toString();

                // =====================================================================
                // Se validan que los datos estén completos:
                if(nombre.equals("")){
                    datosCorrectos = false;
                    Toast.makeText(ActividadMain.this, "El nombre es un dato requerido",
                            Toast.LENGTH_SHORT).show();
                }

                if(datosCorrectos){
                    if(apellido.equals("")){
                        datosCorrectos = false;
                        Toast.makeText(ActividadMain.this, "El apellido es un dato requerido",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                if(datosCorrectos){
                    if(username.equals("")){
                        datosCorrectos = false;
                        Toast.makeText(ActividadMain.this, "El nombre de usuario es un dato requerido",
                                Toast.LENGTH_SHORT).show();
                    }
                }


                if(datosCorrectos) {

                    if(!(email.equals(""))) {

                        // Verificar que el email esté bien escrito:
                        // Se define el patrón que debe seguir usando una expresión regular:
                        String patron_Email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                        Pattern patron = Pattern.compile(patron_Email);
                        Matcher asociador = patron.matcher(email);

                        if (asociador.matches()) {  // si el email es correcto...
                            startActivity(new Intent(ActividadMain.this, RegistroFit.class));
                        } else {
                            Toast.makeText(ActividadMain.this, "Formato de correo electrónico incorrecto",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ActividadMain.this, "El correo electrónico es un dato requerido",
                                Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }


    public static String getNombre() {
        return nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static String getUsername() {
        return username;
    }

    public static String getEmail() {
        return email;
    }


    private static String nombre = "";
    private static String apellido = "";
    private static String username = "";
    private static String email = "";
}
