package com.mycompany.avancecurricular;

import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private int cantidadCreditos;
    private int rut;
    private ArrayList<Ramo> ramosAlumno;

    public Alumno(String nombreAlumno, int rut){
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        ramosAlumno = new ArrayList<>();
    }

    public void mostrarAlumno(){
        System.out.println("Nombre: " + this.nombreAlumno + " Rut: " + this.rut);
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
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

    public boolean agregarRamoActual(Ramo nuevoRamo){
        Ramo ramoAuxiliar;
        for (int i = 0; i < ramosAlumno.size(); i++) {
            ramoAuxiliar = ramosAlumno.get(i);
            if(ramoAuxiliar.getEstadoRamo() == 1 || ramoAuxiliar.getEstadoRamo() == 2){
                return false;
            }
        }
        
        nuevoRamo.setEstadoRamo(1);
        ramosAlumno.add(nuevoRamo);
        return true;
    }
    
    public boolean actualizarRamo(String codigoRamo, int estadoRamo){
        Ramo ramoAuxiliar;
        
        for (int i = 0; i < ramosAlumno.size(); i++) {
            ramoAuxiliar = ramosAlumno.get(i);
            if(ramoAuxiliar.getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                return ramoAuxiliar.actualizarRamo(estadoRamo);
            }
        }
        return false;
    }
}
