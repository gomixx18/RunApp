package com.example.runapp.runapp.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by iknox27 on 31/03/16.
 */
public class SQLiteHelpe extends SQLiteOpenHelper {

    private static final int VERSIONBD = 1;
    public static final String nombreBD = "baseCorre.db";

    public static String cID = "ID";
    public static String NombreUs = "Nombre";
    public static String estaturaUs= "Estatura";
    public static String PesoUs= "Peso";
    public static String EdadUs= "Edad";
    public static String usuario= "Usuario";





    public SQLiteHelpe(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombreBD, null, VERSIONBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table" +  usuario + " ( " + cID + "INETEGER PRIMARY KEY AUTOINCREMENT," + NombreUs + " VARCHAR, "
            + estaturaUs + " NUMERIC," + PesoUs + " NUMERIC," + EdadUs + "INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
