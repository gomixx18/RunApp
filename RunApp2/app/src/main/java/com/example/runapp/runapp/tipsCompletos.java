package com.example.runapp.runapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.runapp.runapp.Modelo.claseStatic;

public class tipsCompletos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_completos);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        if(claseStatic.valorTIPs ==1) {

            textView5.setText("Tips de Carrera");
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, claseStatic.valuesCArrera);
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }else{
            textView5.setText("Tips de Nutricion");
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, claseStatic.values);
            ListView listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }

        findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(tipsCompletos.this, MainActivity.class));
            }
        });
    }
}
