package com.mycompany.avancecurricular;

import java.util.*;

public class Carrera {
    private String nombreCarrera;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Ramo> listaRamos;
    
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        listaRamos = new ArrayList<>();
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
        return true;
    }
    
    public boolean eliminarAlumno(String nombreAlumno){
        if(listaAlumnos.isEmpty()) return false;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                mapaAlumnos.remove(nombreAlumno);
                listaAlumnos.remove(i);
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

    public boolean agregarRamoActual(String nombreAlumno, Ramo nuevoRamo){
        if(!mapaAlumnos.get(nombreAlumno).agregarRamoActual(nuevoRamo)){
            return false;
        }

        for (int i = 0; i < listaRamos.size(); i++) {
            if(listaRamos.get(i).getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                listaRamos.get(i).aumentarCantidadAlumnos();
                return true;
            }
        }

        listaRamos.add(nuevoRamo);
        listaRamos.get(listaRamos.size()-1).aumentarCantidadAlumnos();
        return true;
    }
    
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        return mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
    }

    public void mostrarRamosCarrera(){
        if(listaRamos.isEmpty()){
            System.out.println("No se ha ingresado ningun ramo de la carrera");
            return;
        }
        
        System.out.println("Ramos de la carrera " + nombreCarrera);
        for (int i = 0; i < listaRamos.size(); i++) {
            listaRamos.get(i).mostrarInformacion();
        }
    }
}
