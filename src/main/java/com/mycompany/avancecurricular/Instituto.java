package com.mycompany.avancecurricular;

import java.util.ArrayList;
import java.io.*;

public class Instituto {
    private ArrayList<Carrera> listaCarreras;
    
    public Instituto(){
        listaCarreras = new ArrayList<>();
    }
    
    public boolean agregarCarrera(Carrera nuevaCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nuevaCarrera.getNombreCarrera().equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return false;
            }
        }
        
        listaCarreras.add(nuevaCarrera);
        return true;
    }
    
    public boolean eliminarCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean agregarAlumno(Alumno al, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).verificarAlumnos(al.getNombreAlumno())){
                return false;
            }
        }

        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).agregarAlumno(al);
            }
        }
        
        return false;
    }
    
    public boolean eliminarAlumno(int rut, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(rut);
            } 
        }
        return false;
    }
    
    public boolean eliminarAlumno(String nombreAlumno, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(nombreAlumno);
            } 
        }
        return false;
    }
    
    public void mostrarListaAlumnos(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                listaCarreras.get(i).mostrarListaAlumnos();
                return;
            }
        }
        System.out.println("La carrera no esta ingresada");
    }
    
    public boolean agregarRamoActual(String nombreAlumno, Ramo nuevoRamo, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).agregarRamoActual(nombreAlumno, nuevoRamo);
            }
        }
        return false;
    }
    
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).actualizarRamo(nombreAlumno, codigoRamo, estadoRamo);
            }
        }
        return false;
    }
    
    public void mostrarRamosCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                listaCarreras.get(i).mostrarRamosCarrera();
                return;
            }
        }
        System.out.println("La carrera no esta ingresada");
    }
    
    public void mostrarCarreras(){
        //Escribir en el archivo
        try{
            FileWriter archivo = new FileWriter("todasLasCarreras.txt");
            for (int i = 0; i < listaCarreras.size(); i++) {
                archivo.write("Carrera: " + listaCarreras.get(i).getNombreCarrera() + " Alumnos: " + listaCarreras.get(i).getCantidadAlumnos() + "\n");
            }
            archivo.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        //Escribir en pantalla
        for (int i = 0; i < listaCarreras.size(); i++) {
            System.out.println("Carrera: " + listaCarreras.get(i).getNombreCarrera() + " Alumnos: " + listaCarreras.get(i).getCantidadAlumnos());
        }
    }
    
    public boolean buscarRamo(String nombreRamo){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).buscarRamo(nombreRamo)){
                return true;
            }
        }
        return false;
    }
    
    public boolean editarCarrera(String nombreCarrera, String nuevoNombreCarrera){
         for(int i = 0; i < listaCarreras.size(); i++){
            
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.get(i).setNombreCarrera(nuevoNombreCarrera);
                return true;
            }
        }
        return false;
    }

    public boolean editarAlumno(String nombreCarrera, String nombreAlumno, String nuevoNombreAlumno){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                if(listaCarreras.get(i).editarAlumno(nombreAlumno, nuevoNombreAlumno)) return true;
            }
        }
        return false;
    }

    public boolean editarRamo(String nombreCarrera, String nombreAlumno, String nombreRamo, String nuevoNombreRamo){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                if(listaCarreras.get(i).editarRamo(nombreAlumno, nombreRamo, nuevoNombreRamo)) return true;
            }
        }
        return false;
    }
}
