package com.example.runapp.runapp.Modelo;


public class Usuario {
    public Usuario(String nombre, String apellido, String username, String email,
                   int edad, float peso, float estatura){

        this.nombreUs = nombre;
        this.apellidoUs = apellido;
        this.usernameUs = username;
        this.emailUs = email;
        this.edadUs = edad;
        this.pesoUs = peso;
        this.estaturaUs = estatura;
    }


    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getApellidoUs() {
        return apellidoUs;
    }

    public void setApellidoUs(String apellidoUs) {
        this.apellidoUs = apellidoUs;
    }

    public String getUsernameUs() {
        return usernameUs;
    }

    public void setUsernameUs(String usernameUs) {
        this.usernameUs = usernameUs;
    }

    public String getEmailUs() {
        return emailUs;
    }

    public void setEmailUs(String emailUs) {
        this.emailUs = emailUs;
    }

    public int getEdadUs() {
        return edadUs;
    }

    public void setEdadUs(int edadUs) {
        this.edadUs = edadUs;
    }

    public float getPesoUs() {
        return pesoUs;
    }

    public void setPesoUs(float pesoUs) {
        this.pesoUs = pesoUs;
    }

    public float getEstaturaUs() {
        return estaturaUs;
    }

    public void setEstaturaUs(float estaturaUs) {
        this.estaturaUs = estaturaUs;
    }


    private String nombreUs;
    private String apellidoUs;
    private String usernameUs;
    private String emailUs;
    private int edadUs;
    private float pesoUs;
    private float estaturaUs;
}

