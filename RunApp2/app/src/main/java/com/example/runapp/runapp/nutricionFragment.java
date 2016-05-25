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

    array.size();
    //
    generaTexto(a,b,c);
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


    public void generaTexto(TextView a , TextView b ,TextView c){
        int num1=0;
        int num2=7;
        leerFicheroRaw();
        Random randomno = new Random();

        a.setText(array.get(randomno.nextInt(7)));

        //int numAleatorio = (int) Math.floor(Math.random() * (num1 - (num2 + 1)) + (num2));
        b.setText(array.get(randomno.nextInt(7)));

        //int numAleatorio = (int) Math.floor(Math.random() * (num1 - (num2 + 1)) + (num2));
        c.setText(array.get(randomno.nextInt(7)));
    }
}


