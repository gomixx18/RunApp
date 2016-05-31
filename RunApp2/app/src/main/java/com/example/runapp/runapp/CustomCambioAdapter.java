package com.example.runapp.runapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by iknox27 on 31/05/16.
 */
public class CustomCambioAdapter extends PagerAdapter {

    public int imagenes[] = { R.drawable.adidasboost,
    R.drawable.gelpkayano,
    R.drawable.supernovaseis };


    public int imagenes2[] = { R.drawable.fitness,
            R.drawable.fitness_sunset,
            R.drawable.supernovaseis };

    private Context context;
    private LayoutInflater inflater;
    private int number;
    public CustomCambioAdapter(Context context, int number){
        this.context = context;
        this.setNumber(number);


    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.cambio_imagen,container,false);
        ImageView ima = (ImageView) v.findViewById(R.id.cambioImagen);
        TextView textv = (TextView) v.findViewById(R.id.cambioLetra);

         if(this.getNumber() == 0){
             int cant = imagenes.length-1;
            ima.setImageResource(imagenes[position]);
             textv.setText("Imagen " + (position + 1) + " de " + imagenes.length);
        }
        if(this.getNumber() == 1){
            int cant = imagenes2.length-1;
            ima.setImageResource(imagenes2[position]);
            textv.setText("Imagen " + (position + 1)+ " de " + imagenes2.length);

        }
        if(this.getNumber() == 2){
            ima.setImageResource(imagenes[position]);
            textv.setText("Imagen " + position + " de " + imagenes.length );
        }


        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
