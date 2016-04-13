package com.example.runapp.runapp.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class GestorBD extends SQLiteOpenHelper {


    public GestorBD(Context context) {
        super(context, nombreBD, null, VERSIONBD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String crea_Usuario =
                "create table " + nombre_tabla_Us + " ( " +
                        cID_Us + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        nombreUs + " VARCHAR, " +
                        apellidoUs + " VARCHAR, " +
                        usernameUs + " VARCHAR, " +
                        emailUs + " VARCHAR, " +
                        edadUs + " INTEGER, " +
                        pesoUs + " REAL, " +
                        estaturaUs + " REAL);" ;


        String crea_Valoracion =
                "create table " + nombre_tabla_Valoracion + " ( " +
                        cID_Valoracion + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        cantidad_Estrellas + " INTEGER, " +
                        calificacion_Valoracion + " VARCHAR);";


        String crea_Recorrido =
                "create table " + nombre_tabla_Recorrido + " ( " +
                        cID_Recorrido + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        fecha_Recorrido + " VARCHAR, " +
                        distancia_Recorrido + " REAL, " +
                        tiempo_Recorrido + " REAL, " +
                        valoracion_Recorrido + " INTEGER, " +
                        "FOREIGN KEY("+ valoracion_Recorrido +")" +
                        " REFERENCES BD_RunApp_Valoracion(ID));";

        db.execSQL(crea_Usuario);
        db.execSQL(crea_Valoracion);
        db.execSQL(crea_Recorrido);
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }





    public boolean insertarUsuario(Usuario user) {

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(nombreUs, user.getNombreUs());
            contentValues.put(apellidoUs, user.getApellidoUs());
            contentValues.put(usernameUs, user.getUsernameUs());
            contentValues.put(emailUs, user.getEmailUs());
            contentValues.put(edadUs, user.getEdadUs());
            contentValues.put(pesoUs, user.getPesoUs());
            contentValues.put(estaturaUs, user.getEstaturaUs());

            db.insert(nombre_tabla_Us, null, contentValues);

            db.close();

            return true;

        }catch (SQLiteException s){
            mensajeError = s.getMessage();
            return false;
        }
    }




    // Número de filas de una tabla

    public int numero_Filas(String tabla){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, tabla);
        return numRows;
    }




    // Retorna en una lista todos los registros de una columna, en este caso
    // todos los registros de la columna "Nombre".

    public ArrayList<String> getAllUsers() {
        ArrayList<String> array_list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            array_list.add(res.getString(res.getColumnIndex("Nombre")));
            res.moveToNext();
        }
        return array_list;
    }


    public String getUsername(){

        String username = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario Where ID = 1", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            username = res.getString(res.getColumnIndex("Username"));
            res.moveToNext();
        }

        return username;
    }




    public String getMensajeError(){

        return mensajeError;
    }




    // ==========================================================================
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


    public String mensajeError;


}
