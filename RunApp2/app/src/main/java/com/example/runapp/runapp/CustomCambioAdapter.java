package com.example.runapp.runapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by iknox27 on 31/05/16.
 */
public class CustomCambioAdapter extends PagerAdapter {
    ArrayList<String> f = new ArrayList<String>();// list of file paths
    File[] listFile;

    public int imagenes[] = { R.drawable.ponador1,
    R.drawable.gelpkayano,
    R.drawable.supernovaseis,
    R.drawable.pronador2
    };


    public int imagenes2[] = { R.drawable.neutra2,
            R.drawable.neutra3,
            R.drawable.nuetra1,
            R.drawable.neutra4
    };

    public int imagenes3[] = { R.drawable.supi1,
            R.drawable.supi2,
            R.drawable.supi3,
            R.drawable.supi3
    };

    private Context context;
    private LayoutInflater inflater;
    private int number;

    public CustomCambioAdapter(Context context, int number){
        this.context = context;
        this.setNumber(number);
        getFromSdcard();
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

        TextView textv2 = (TextView) v.findViewById(R.id.cambioletra2);
         if(this.getNumber() == 0){
             int cant = imagenes.length-1;
            ima.setImageResource(imagenes[position]);
             textv.setText("Imagen " + (position + 1) + " de " + imagenes.length);
        }
        if(this.getNumber() == 1){
            int cant = imagenes2.length-1;
            ima.setImageResource(imagenes2[position]);
            textv.setText("Imagen " + (position + 1) + " de " + imagenes2.length);

        }
        if(this.getNumber() == 2){
            ima.setImageResource(imagenes3[position]);
            textv.setText("Imagen " + (position + 1)+ " de " + imagenes3.length );
        }

        if(this.getNumber() == 3) {
            if (position < f.size()) {
                Bitmap myBitmap = BitmapFactory.decodeFile(f.get(position));
                ima.setImageBitmap(myBitmap);
                textv.setText("Imagen " + (position + 1) + " de " + (f.size()));
                textv2.setText(listFile[position].getName());
            }
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


    public void getFromSdcard()
    {
        File file= new File(android.os.Environment.getExternalStorageDirectory(),"runappImagenes");

        if (file.isDirectory())
        {
            listFile = file.listFiles();


            for (int i = 0; i < listFile.length; i++)
            {

                f.add(listFile[i].getAbsolutePath());

            }
        }
    }
}
