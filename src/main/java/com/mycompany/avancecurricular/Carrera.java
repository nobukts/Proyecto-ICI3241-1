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

    /**
     * Metodo que agrega un alumno a la lista de alumnos y al mapa de alumnos
     * @param al Objeto de la clase Alumno
     * @return boolean
     */
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

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del nombre
     * @param nombreAlumno String que contiene el nombre del alumno a eliminar
     * @return boolean
     */
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

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del rut
     * @param rutAlumno Entero que contiene el rut del alumno a eliminar
     * @return boolean
     */
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

    /**
     * Metodo que muestra la informacion de la lista de alumnos almacenados de la carrera
     */
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

    /**
     * Metodo que agrega un ramo a la malla curricular de la carrera
     * @param nuevoRamo Objeto de la clase ramo que se va a agregar a la malla curricular
     * @return boolean
     */
    public boolean agregarRamoMalla(Ramo nuevoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(nuevoRamo.getCodigoRamo())){
                return false;
            }
        }

        mallaCurricular.add(nuevoRamo);
        return true;
    }

    /**
     * Metodo para agregar un ramo que no pertenece a la malla curricular a un alumno
     * @param nombreAlumno String que contiene el nombre del alumno que se le quiere añadir el ramo
     * @param nuevoRamo Objeto de la clase Ramo que se va agregar al alumno
     * @return boolean
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno)){
            if(mapaAlumnos.get(nombreAlumno).verificarRamo(nuevoRamo.getCodigoRamo())){
                return mapaAlumnos.get(nombreAlumno).agregarRamoOpcional(nuevoRamo);
            } 
        }

        return false;
    }
    
    /**
     * Metodo que actualiza el estado de un ramo que posee el alumno
     * @param nombreAlumno String que contiene el nombre del alumno a buscar
     * @param codigoRamo String que contiene el codigo del ramo a cambiar
     * @param estadoRamo Entero que contiene uno de los 3 estados que puede tener un ramo
     * @return boolean
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        return mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
    }

    /**
     * Metodo que muestra los ramos impartidos por la carrera, con su respectiva informacion
     */
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

    /**
     * Metodo que verifica si el alumno se encuentra dentro de la carrera
     * @param nombreAlumno String que contiene el nombre del alumno que se desea verificar
     * @return boolean
     */
    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }
    
    public boolean buscarRamo(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).mostrarInformacion();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que permite editar el nombre de un alumno
     * @param nombreAlumno String que contiene el nombre del alumno para realizar la busqueda
     * @param nuevoNombreAlumno String que contiene el nuevo nombre del alumno
     * @return boolean
     */
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
    
    /**
     * Metodo que permite editar el nombre de un ramo de la malla curricular
     * @param codigoRamo String que contiene el codigo del ramo que se desea cambiar su informacion
     * @param nuevoNombreRamo String que contiene el nuevo nombre del ramo
     * @return boolean
     */
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
    
    /**
     * Metodo que verifica si un ramo se encuentra entre la malla curricular de la carera
     * @param codigoRamo String que contiene el codigo del ramo que estamos verificando
     * @return boolean
     */
    public boolean verificarRamo(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                return false;
            }
            
        }
        return true;
    }
}
