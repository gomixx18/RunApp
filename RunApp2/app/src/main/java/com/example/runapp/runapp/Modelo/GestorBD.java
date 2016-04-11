package com.example.runapp.runapp.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

<<<<<<< HEAD:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/SQLiteHelpe.java
/**
 * Created by iknox27 on 31/03/16.
 */
public class SQLiteHelpe extends SQLiteOpenHelper {
=======

public class GestorBD extends SQLiteOpenHelper {
>>>>>>> origin/master:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/GestorBD.java

    private static final int VERSIONBD = 1;
    public static final String nombreBD = "baseCorre.db";

<<<<<<< HEAD:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/SQLiteHelpe.java
    public static String cID = "ID";
    public static String NombreUs = "Nombre";
    public static String estaturaUs= "Estatura";
    public static String PesoUs= "Peso";
    public static String EdadUs= "Edad";
    public static String usuario= "Usuario";





    public SQLiteHelpe(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
=======
    /*public GestorBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombreBD, null, VERSIONBD);
    }*/


    public GestorBD(Context context) {
>>>>>>> origin/master:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/GestorBD.java
        super(context, nombreBD, null, VERSIONBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
<<<<<<< HEAD:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/SQLiteHelpe.java
            db.execSQL("create table" +  usuario + " ( " + cID + "INETEGER PRIMARY KEY AUTOINCREMENT," + NombreUs + " VARCHAR, "
            + estaturaUs + " NUMERIC," + PesoUs + " NUMERIC," + EdadUs + "INTEGER);");
=======

        String crea_Usuario =
                "create table" + nombre_tabla_Us + " ( " +
                    cID_Us + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    nombreUs + " VARCHAR, " +
                    apellidoUs + " VARCHAR, " +
                    usernameUs + " VARCHAR, " +
                    emailUs + " VARCHAR, " +
                    edadUs + " INTEGER, " +
                    pesoUs + " REAL, " +
                    estaturaUs + " REAL);" ;


        String crea_Valoracion =
                "create table" + nombre_tabla_Valoracion + " ( " +
                    cID_Valoracion + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    cantidad_Estrellas + " INTEGER, " +
                    calificacion_Valoracion + " VARCHAR);";


        String crea_Recorrido =
                "create table" + nombre_tabla_Recorrido + " ( " +
                        cID_Recorrido + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        fecha_Recorrido + " VARCHAR, " +
                        distancia_Recorrido + " REAL, " +
                        tiempo_Recorrido + " REAL, " +
                        "FOREIGN KEY("+ valoracion_Recorrido +")" +
                            " REFERENCES BD_RunApp_Valoracion(ID)";


            db.execSQL(crea_Usuario);
            db.execSQL(crea_Valoracion);
            db.execSQL(crea_Recorrido);
 // hola
        // Abi se la come
        //hh
>>>>>>> origin/master:RunApp2/app/src/main/java/com/example/runapp/runapp/Modelo/GestorBD.java
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
