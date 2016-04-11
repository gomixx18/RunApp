package com.example.runapp.runapp.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelpe extends SQLiteOpenHelper {


    /*public SQLiteHelpe(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombreBD, null, VERSIONBD);
    }*/


    public SQLiteHelpe(Context context) {
        super(context, nombreBD, null, VERSIONBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

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
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




    // Base de Datos
    private static final int VERSIONBD = 1;
    public static final String nombreBD = "BD_RunApp.db";

    // Tabla Usuario
    public static String nombre_tabla_Us= "BD_RunApp_Usuario";
    public static String cID_Us = "ID";
    public static String nombreUs = "Nombre";
    public static String apellidoUs = "Apellido";
    public static String usernameUs = "Username";
    public static String emailUs= "Email";
    public static String edadUs= "Edad";
    public static String pesoUs= "Peso";
    public static String estaturaUs= "Estatura";

    // Tabla Valoraciones
    public static String nombre_tabla_Valoracion= "BD_RunApp_Valoracion";
    public static String cID_Valoracion = "ID";
    public static String cantidad_Estrellas = "Numero_Estrellas";
    public static String calificacion_Valoracion = "Calificacion";

    // Tabla Recorridos
    public static String nombre_tabla_Recorrido= "BD_RunApp_Recorrido";
    public static String cID_Recorrido = "ID";
    public static String fecha_Recorrido = "Fecha_Recorrido";
    public static String distancia_Recorrido = "Distancia_Recorrida";
    public static String tiempo_Recorrido = "Tiempo_Recorrido";
    public static String valoracion_Recorrido = "Valoracion_Recorrido";


}
