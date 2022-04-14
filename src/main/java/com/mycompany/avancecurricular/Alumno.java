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
        ramosActuales = new ArrayList<>();
        ramosAprobados = new ArrayList<>();
        ramosPorCursar = new ArrayList<>();
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
        for (int i = 0; i < ramosAprobados.size(); i++) {
            ramoAuxiliar = ramosAprobados.get(i);
            if (ramoAuxiliar.getNombreRamo().equalsIgnoreCase(nuevoRamo.getNombreRamo()) || ramoAuxiliar.getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                return false;
            }
        }

        for (int i = 0; i < ramosActuales.size(); i++) {
            ramoAuxiliar = ramosActuales.get(i);
            if (ramoAuxiliar.getNombreRamo().equalsIgnoreCase(nuevoRamo.getNombreRamo()) || ramoAuxiliar.getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                return false;
            }
        }

        ramosActuales.add(nuevoRamo);

        for (int i = 0; i < ramosPorCursar.size(); i++) {
            ramoAuxiliar = ramosPorCursar.get(i);
            if (ramoAuxiliar.getNombreRamo().equalsIgnoreCase(nuevoRamo.getNombreRamo()) || ramoAuxiliar.getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                ramosPorCursar.remove(i);
            }
        }
        return true;
    }
}
