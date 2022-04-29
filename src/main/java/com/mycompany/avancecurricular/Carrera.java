package com.mycompany.avancecurricular;

import java.io.*;
import java.util.*;

public class Carrera {
    private String nombreCarrera;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Ramo> mallaCurricular;
    private int cantidadAlumnos;
    
    /**
     * Constructor vacio que inicializa las colecciones de la clase
     */
    public Carrera(){
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        mallaCurricular = new ArrayList<>();
    }

    /**
     * Constructor de la clase carrera
     * @param nombreCarrera String que contiene el nombre de la carrera
     */
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        mallaCurricular = new ArrayList<>();
        cantidadAlumnos = 0;
    }

    //------------GETTERS
    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    //------------SETTERS
    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    /**
     * Metodo que agrega un alumno a la lista de alumnos y al mapa de alumnos
     * @param al Objeto de la clase Alumno
     * @return boolean Verdadero si el alumno se pudo matricular y falso si ya se encontraba matriculado
     */
    public boolean matricularAlumno(Alumno al){
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
     * @return boolean Verdadero si se pudo eliminar con exito al alumno y falso si no se pudo eliminarlo
     */
    public boolean eliminarAlumno(String nombreAlumno){
        if(listaAlumnos.isEmpty()) return false;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                mapaAlumnos.remove(nombreAlumno);
                listaAlumnos.remove(i);
                listaAlumnos.get(i).decrementarAlumnos();
                cantidadAlumnos--;
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del rut
     * @param rutAlumno Entero que contiene el rut del alumno a eliminar
     * @return boolean Verdadero si se pudo eliminar con exito al alumno y falso si no se pudo eliminarlo
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
     * @return boolean Verdadero si se pudo agregar el ramo a la malla y falso si no se pudo agregar
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
     * @return boolean Verdadero si se pudo agregar el ramo a los ramos del alumno y falso si no se pudo agregar
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno)){
            if(mapaAlumnos.get(nombreAlumno).verificarRamo(nuevoRamo.getCodigoRamo())){
                System.out.println("El ramo no se encuentra repetido");
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
     * @return boolean Verdadero si se pudo actualizar el estado del ramo y falso si no se pudo realizar
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
     * @return boolean Verdadero si contiene al alumno y falso si no lo contiene
     */
    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }
    
    /**
     * Metodo que busca la informacion de un ramo de la malla curricular
     * @param codigoRamo String que contiene el codigo del ramo que se desea buscar
     * @return boolean Verdadero si se encontro el ramo y falso si no se encuentra
     */
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
     * @return boolean Verdadero si se pudo editar el alumno y falso si no se logro editar
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
     * @return boolean Verdadero si se pudo editar el ramo y falso si no se logro editar 
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
     * @return boolean Verdadero si no se encuentra el ramo en la malla y falso, si se encuentra
     */
    public boolean verificarRamo(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                return false;
            }
            
        }
        return true;
    }

    /**
     * Metodo que en caso de encontrar un ramo con el codigo señalado, lo elimina de la malla curricular
     * @param codigoRamo String que contiene el codigo del ramo a eliminar
     * @return boolean Verdadero si se puedo eliminar el ramo, falso si no se pudo eliminar
     */
    public boolean eliminarRamo(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++){
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para escribir en el archivo reporte.txt los datos de los alumnos
     * @param archivo FileWriter que contiene el nombre del archivo en donde se escribirá la información
     */
    public void reporteAlumno(FileWriter archivo){
        try{
            for(int i = 0 ; i < listaAlumnos.size() ; i++){
                Alumno al = listaAlumnos.get(i);
                archivo.write(String.format("%20s %13d %19d",al.getNombreAlumno(),al.getRut(), al.getCantidadCreditos()) + "\n");;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para escribir en el archivo reporte.txt los datos de los ramos
     * @param archivo FileWriter que contiene el nombre del archivo en donde se escribirá la información
     * @param aux boolean sirve para saber si se imprime el primer ramo o no
     */
    public void reporteRamo(FileWriter archivo, boolean aux){
        try{
            //True si se imprime el primer ramo, False si no es el primer ramo
            if(aux){
                Ramo rm = mallaCurricular.get(0);
                archivo.write(String.format("%14s %13s %29d",rm.getCodigoRamo(), rm.getNombreRamo(), rm.getCantidadAlumnos()) + "\n");
            }else{
                for(int i = 1 ; i < mallaCurricular.size() ; i++){
                    Ramo rm = mallaCurricular.get(i);
                    archivo.write(String.format("%34s %13s %29d",rm.getCodigoRamo(),rm.getNombreRamo(), rm.getCantidadAlumnos()) + "\n");
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

