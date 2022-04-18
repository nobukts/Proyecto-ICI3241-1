package com.mycompany.avancecurricular;

import java.util.*;
import java.io.*;

public class Carrera {
    private String nombreCarrera;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Ramo> listaRamos;
    private int cantidadAlumnos;
    
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        listaRamos = new ArrayList<>();
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

        //Escribir en el archivo
        try{
            FileWriter archivo = new FileWriter("listaAlumnosXCarrera.txt");
            archivo.write("Lista de los alumnos en " + this.nombreCarrera + ":\n");
            for (int i = 0; i < listaAlumnos.size(); i++) {
                listaAlumnos.get(i).mostrarAlumno(archivo);
            }
            archivo.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        //Escribir en pantalla
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
        
        //Escribir en el archivo
        try{
            FileWriter archivo = new FileWriter("ramosXCarrera.txt");
            archivo.write("Ramos de la carrera " + nombreCarrera + "\n");
            for (int i = 0; i < listaRamos.size(); i++) {
                listaRamos.get(i).mostrarInformacion(archivo);
            }
            archivo.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        //Escribir por pantalla
        System.out.println("Ramos de la carrera " + nombreCarrera);
        for (int i = 0; i < listaRamos.size(); i++) {
            listaRamos.get(i).mostrarInformacion();
        }
    }

    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }
}
