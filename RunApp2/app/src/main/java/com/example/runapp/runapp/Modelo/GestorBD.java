package com.example.runapp.runapp.Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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


    // Retorna el username del usuario
    public String getUsername(){

        String username = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            username = res.getString(res.getColumnIndex("Username"));
            res.moveToNext();
        }

        return username;
    }



    // Retorna el nombre + apellido del usuario
    public String getNombre(){

        String username = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            username = res.getString(res.getColumnIndex("Nombre"));
            username += " " + res.getString(res.getColumnIndex("Apellido"));
            res.moveToNext();
        }

        return username;
    }


    public String getMensajeError(){

        return mensajeError;
    }



    // Retorna la estatura del usuario
    public String getEmail(){

        String email = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            email = res.getString(res.getColumnIndex("Email"));
            res.moveToNext();
        }

        return email;
    }



    // Retorna la edad del usuario
    public String getEdad(){

        String edad = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            edad = res.getString(res.getColumnIndex("Edad"));
            res.moveToNext();
        }

        return edad;
    }




    // Retorna el peso del usuario
    public String getPeso(){

        String peso = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            peso = res.getString(res.getColumnIndex("Peso"));
            res.moveToNext();
        }

        return peso;
    }



    // Retorna la estatura del usuario
    public String getEstatura(){

        String estatura = "";
        ArrayList<String> array_list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Usuario", null );

        res.moveToFirst();

        while(!res.isAfterLast()){
            estatura = res.getString(res.getColumnIndex("Estatura"));
            res.moveToNext();
        }

        return estatura;
    }



    // actualiza edad del usuario
    public boolean actualizaEdad(String edad){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(edadUs, edad);
            db.update(nombre_tabla_Us, valor, "ID=1", null);
            return true;

        }catch (SQLiteException s){
            mensajeError = s.getMessage();
            return false;
        }
    }


    // actualiza peso del usuario
    public boolean actualizaPeso(String peso){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(pesoUs, peso);
            db.update(nombre_tabla_Us, valor, "ID=1", null);
            return true;

        }catch (SQLiteException s){
            mensajeError = s.getMessage();
            return false;
        }
    }


    // actualiza estatura del usuario
    public boolean actualizaEstatura(String estatura){
        try{
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valor = new ContentValues();
            valor.put(estaturaUs, estatura);
            db.update(nombre_tabla_Us, valor, "ID=1", null);
            return true;

        }catch (SQLiteException s){
            mensajeError = s.getMessage();
            return false;
        }
    }


    public boolean insertarRecorrido(String distancia, String tiempo) {


        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            Date diaAcual = new Date();
            String fechaConFormato = dateformat.format(diaAcual);
            contentValues.put(fecha_Recorrido, fechaConFormato);

            contentValues.put(distancia_Recorrido, distancia);
            contentValues.put(tiempo_Recorrido, tiempo);
            contentValues.put(valoracion_Recorrido, "0");

            db.insert(nombre_tabla_Recorrido, null, contentValues);

            db.close();

            return true;

        }catch (SQLiteException s){
            mensajeError = s.getMessage();
            return false;
        }
    }






    public ArrayList<String[]> obtenerRecorridos() {
        ArrayList<String[]> array_list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT *FROM BD_RunApp_Recorrido", null );
        res.moveToFirst();

        while(!res.isAfterLast()){
            String[] arreglo = new String[4];
            arreglo[0] = res.getString(res.getColumnIndex("Fecha_Recorrido"));
            arreglo[1] = res.getString(res.getColumnIndex("Distancia_Recorrida"));
            arreglo[2] = res.getString(res.getColumnIndex("Tiempo_Recorrido"));
            arreglo[3] = res.getString(res.getColumnIndex("Valoracion_Recorrido"));

            array_list.add(arreglo);
            res.moveToNext();
        }
        return array_list;
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
