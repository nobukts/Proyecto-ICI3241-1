package com.mycompany.avancecurricular;

import java.util.*;

public class Carrera {
    private String nombreCarrera;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Ramo> mallaCurricular;
    private int cantidadAlumnos;
    
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        mallaCurricular = new ArrayList<>();
        cantidadAlumnos = 0;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public boolean agregarAlumno(Alumno al){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == al.getRut()) return false;
        } 
        listaAlumnos.add(al);
        mapaAlumnos.put(al.getNombreAlumno(), al);
        listaAlumnos.get(listaAlumnos.size() - 1).copiarMalla(mallaCurricular);
        cantidadAlumnos++;
        return true;
    }
    
    public boolean eliminarAlumno(String nombreAlumno){
        if(listaAlumnos.isEmpty()) return false;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                mapaAlumnos.remove(nombreAlumno);
                listaAlumnos.remove(i);
                cantidadAlumnos--;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarAlumno(int rutAlumno){
        if(listaAlumnos.isEmpty()) return false;

        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == rutAlumno){
                mapaAlumnos.remove(listaAlumnos.get(i).getNombreAlumno());
                listaAlumnos.remove(i);
                cantidadAlumnos--;
                return true;
            }
        }
        return false;
    }

    public void mostrarListaAlumnos(){
        if(listaAlumnos.isEmpty()){
            System.out.println("No hay alumnos matriculados");
            return;
        }
        System.out.println("Lista de los alumnos en " + this.nombreCarrera + ":");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            listaAlumnos.get(i).mostrarAlumno();
        }
    }

    public boolean agregarRamoMalla(Ramo nuevoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                return false;
            }
        }

        mallaCurricular.add(nuevoRamo);
        return true;
    }

    public boolean agregarRamoActual(String nombreAlumno, Ramo nuevoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno)){
            if(mapaAlumnos.get(nombreAlumno).verificarRamo(nuevoRamo.getCodigoRamo())){
                return mapaAlumnos.get(nombreAlumno).agregarRamoActual(nuevoRamo);
            } 
        }

        return false;
    }
    
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        return mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
    }

    public void mostrarRamosCarrera(){
        if(mallaCurricular.isEmpty()){
            System.out.println("No se ha ingresado ningun ramo de la carrera");
            return;
        }

        System.out.println("Ramos de la carrera " + nombreCarrera);
        for (int i = 0; i < mallaCurricular.size(); i++) {
            mallaCurricular.get(i).mostrarInformacion();
        }
    }

    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }
    
    public boolean buscarRamo(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                return true;
            }
        }
        return false;
    }
    
    public boolean editarAlumno(String nombreAlumno, String nuevoNombreAlumno){
        if(listaAlumnos.isEmpty()) return false;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                Alumno al = mapaAlumnos.get(nombreAlumno);
                mapaAlumnos.remove(nombreAlumno);
                al.setNombreAlumno(nuevoNombreAlumno);
                mapaAlumnos.put(nuevoNombreAlumno, al);
                listaAlumnos.get(i).setNombreAlumno(nuevoNombreAlumno);
                return true;
            }
        }
        return false;
    }
    
    public boolean editarRamo(String codigoRamo, String nuevoNombreRamo){
        if(mallaCurricular.isEmpty()) return false;
        for(int i = 0; i < listaAlumnos.size(); i++){
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).setNombreRamo(nuevoNombreRamo);
                return true;
            }
        }
        return false;
    }
}
