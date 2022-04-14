package com.mycompany.avancecurricular;

public class Ramo {
    private String nombreRamo;
    private String codigoRamo;
    private int cantidadCreditos;
    private int cantidadAlumnos;

    public Ramo(String nombreRamo, String codigoRamo, int cantidadCreditos){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoRamo = codigoRamo;
        this.nombreRamo = nombreRamo;
        cantidadAlumnos = 0;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getNombreRamo() {
        return nombreRamo;
    }
    public void setNombreRamo(String nombreRamo) {
        this.nombreRamo = nombreRamo;
    }
    public String getCodigoRamo() {
        return codigoRamo;
    }
    public void setCodigoRamo(String codigoRamo) {
        this.codigoRamo = codigoRamo;
    }
    public int getCantidadCreditos() {
        return cantidadCreditos;
    }
    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public void aumentarCantidadAlumnos(){
        cantidadAlumnos++;
    }
}