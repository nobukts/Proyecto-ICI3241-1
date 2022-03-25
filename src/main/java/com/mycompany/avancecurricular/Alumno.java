package com.mycompany.avancecurricular;
import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private ArrayList<String> mallaCurricular;
    private ArrayList<String> ramosAprobados;
    private ArrayList<String>  ramosActuales;
    private ArrayList<String> ramosFaltantes;
    private int cantCreditos;

    public Alumno(){
        
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public ArrayList<String> getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(ArrayList<String> mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

    public ArrayList<String> getRamosAprobados() {
        return ramosAprobados;
    }

    public void setRamosAprobados(ArrayList<String> ramosAprobados) {
        this.ramosAprobados = ramosAprobados;
    }

    public ArrayList<String> getRamosActuales() {
        return ramosActuales;
    }

    public void setRamosActuales(ArrayList<String> ramosActuales) {
        this.ramosActuales = ramosActuales;
    }

    public ArrayList<String> getRamosFaltantes() {
        return ramosFaltantes;
    }

    public void setRamosFaltantes(ArrayList<String> ramosFaltantes) {
        this.ramosFaltantes = ramosFaltantes;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setCantCreditos(int cantCreditos) {
        this.cantCreditos = cantCreditos;
    }
    
}
