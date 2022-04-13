package com.mycompany.avancecurricular;

import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private ArrayList<Ramo> ramosAprobados;
    private ArrayList<Ramo> ramosActuales;
    private ArrayList<Ramo> ramosPorCursar;
    private int cantidadCreditos;

    public Alumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }

    public void mostrarAlumno(){
        System.out.println(this.nombreAlumno);
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
