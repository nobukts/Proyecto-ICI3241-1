package com.mycompany.avancecurricular;

import java.util.*;

public class Carrera {
    private String nombreCarrera;
    private HashMap<String, Alumno> mapaAlumnos = new HashMap<>();
    private ArrayList<Alumno> listaAlumnos = new ArrayList<>();
    
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public void agregarAlumno(String nombreAlumno){
        Alumno nuevoAlumno = new Alumno(nombreAlumno);
        mapaAlumnos.put(nombreAlumno, nuevoAlumno);
        listaAlumnos.add(nuevoAlumno);
    }

    public void mostrarListaAlumnos(){
        if(listaAlumnos.size() == 0){
            System.out.println("No hay alumnos matriculados");
            return;
        }

        System.out.println("Lista de los alumnos en " + this.nombreCarrera + ":");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            listaAlumnos.get(i).mostrarAlumno();
        }
    }
}
