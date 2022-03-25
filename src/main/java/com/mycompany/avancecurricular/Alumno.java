package com.mycompany.avancecurricular;
import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private ArrayList<Ramo> mallaCurricular;
    private ArrayList<Ramo> ramosAprobados;
    private ArrayList<Ramo>  ramosActuales;
    private ArrayList<Ramo> ramosFaltantes;
    private int cantCreditos;

    public Alumno(){
        
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public ArrayList<Ramo> getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(ArrayList<Ramo> mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

    public ArrayList<Ramo> getRamosAprobados() {
        return ramosAprobados;
    }

    public void setRamosAprobados(ArrayList<Ramo> ramosAprobados) {
        this.ramosAprobados = ramosAprobados;
    }

    public ArrayList<Ramo> getRamosActuales() {
        return ramosActuales;
    }

    public void setRamosActuales(ArrayList<Ramo> ramosActuales) {
        this.ramosActuales = ramosActuales;
    }

    public ArrayList<Ramo> getRamosFaltantes() {
        return ramosFaltantes;
    }

    public void setRamosFaltantes(ArrayList<Ramo> ramosFaltantes) {
        this.ramosFaltantes = ramosFaltantes;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setCantCreditos(int cantCreditos) {
        if(cantCreditos < 0) cantCreditos *= -1;
        this.cantCreditos = cantCreditos;
    }

}
