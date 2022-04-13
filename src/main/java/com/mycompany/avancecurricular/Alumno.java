package com.mycompany.avancecurricular;

import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private int cantidadCreditos;
    private int rut;
    private ArrayList<Ramo> ramosAprobados;
    private ArrayList<Ramo> ramosActuales;
    private ArrayList<Ramo> ramosPorCursar;

    public Alumno(String nombreAlumno, int rut){
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void mostrarAlumno(){
        System.out.println("Nombre: " + this.nombreAlumno + " Rut: " + this.rut);
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }
    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    public int getCantidadCreditos() {
        return cantidadCreditos;
    }
    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }
}
