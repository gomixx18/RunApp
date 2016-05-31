package com.example.runapp.runapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class nutricionFragment extends Fragment {

    ArrayList<String> array;
    public nutricionFragment() {
        array = new ArrayList<>();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

    View v = inflater.inflate(R.layout.fragment_nutricion, container, false);

    TextView a = (TextView) v.findViewById(R.id.textView);
    TextView b = (TextView) v.findViewById(R.id.textView20);
    TextView c = (TextView) v.findViewById(R.id.textView18);
        leerFicheroRaw();

    //
    generaTexto(a,b,c,array.size()-1);
    return v;

}

    private void leerFicheroRaw() {
        InputStream flujo = null;
        BufferedReader lector;
        try {
            flujo = getResources().openRawResource(R.raw.tips);

            lector = new BufferedReader(new InputStreamReader(flujo));

            String texto = lector.readLine();
            while (texto != null) {

                texto = lector.readLine();
                array.add(texto);
            }
        } catch (Exception ex) {
            Log.e("ivan", "Error al leer fichero desde recurso raw");
        } finally {
            try {
                if (flujo != null)
                    flujo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


   /* public void generaTexto(TextView a , TextView b ,TextView c, int valor){
        boolean si = false; boolean si2 = false;

        Random randomno = new Random();
        int valor1 = randomno.nextInt(valor);
        a.setText(array.get(valor1));

        Random randomno2 = new Random();
        int valor2;
        do{

         valor2 = randomno2.nextInt(valor);
            if(valor2 != valor1){
                si = true;
            }
        }while(!si);

        if(si)
        b.setText(array.get(valor2));

        int valor3 = randomno.nextInt(valor);
        do{
            valor3 = randomno.nextInt(valor);
            if(valor3 != valor1 && valor2 !=valor3){
                si2 = true;
            }
        }while(si2);

        if(!si2)
        c.setText(array.get(valor3));
    }*/


    public void generaTexto(TextView a, TextView b, TextView c, int valor) {


        Random randomno = new Random();
        int valor1 = randomno.nextInt(valor);
        a.setText(array.get(valor1));

        int valor2;
        do {
            valor2 = randomno.nextInt(valor);
        } while (valor1 == valor2);
        b.setText(array.get(valor2));

        int valor3;
        do {
            valor3 = randomno.nextInt(valor);
    } while (valor1 == valor3 ||  valor3 == valor2);
        c.setText(array.get(valor3));
    }

}



