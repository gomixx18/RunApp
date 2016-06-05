package com.example.runapp.runapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.runapp.runapp.Modelo.claseStatic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class tipscarrera extends Fragment {
    ArrayList<String> array;
    String array2[];
    int cont = 0;
    public tipscarrera() {

        array = new ArrayList<>();
        array2 = new String [12];
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tipscarrera, container, false);

        TextView a = (TextView) v.findViewById(R.id.textViewcarrera);
        TextView b = (TextView) v.findViewById(R.id.textViewcarrera2);
        TextView c = (TextView) v.findViewById(R.id.textViewcarrera3);
        leerFicheroRaw();
        generaTexto(a, b, c, array.size() - 1);

        v.findViewById(R.id.vert2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                claseStatic.valorTIPs = 1;
                startActivity(new Intent(getActivity(), tipsCompletos.class));
            }
        });

        return v;
    }

    private void leerFicheroRaw() {
        InputStream flujo = null;
        BufferedReader lector;
        try {
            flujo = getResources().openRawResource(R.raw.carreratips);

            lector = new BufferedReader(new InputStreamReader(flujo));

            String texto = lector.readLine();
            while (texto != null) {

                texto = lector.readLine();
                array.add(texto);
                array2[cont] = texto;
                cont++;
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



