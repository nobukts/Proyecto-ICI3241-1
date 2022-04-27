package com.mycompany.avancecurricular;

import java.io.*;
import java.util.ArrayList;

public class Instituto {
    private ArrayList<Carrera> listaCarreras;
    
    public Instituto(){
        listaCarreras = new ArrayList<>();
    }
    
    /**
     * Metodo que agrega una carrera del ramo, e ingresa la malla curricular del mismo
     * @param nuevaCarrera Objeto de la clase carrera
     * @return boolean
     * @throws IOException
     */

    public boolean agregarCarrera(Carrera nuevaCarrera) throws IOException{
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nuevaCarrera.getNombreCarrera().equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return false;
            }
        }

        listaCarreras.add(nuevaCarrera);
        System.out.println("Ahora ingrese la malla curricular de la carrera");
        System.out.println("===============================================");
        
        while(true){
            BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el nombre del ramo, para terminar ingrese \"NO\"");
            String nombreRamo = lectorGeneral.readLine();
            if(nombreRamo.equalsIgnoreCase("no")) break;
            System.out.println("Ingrese el codigo del ramo (Formato XXX000)");
            String codigoRamo = lectorGeneral.readLine();
            System.out.println("Ingrese la cantidad de creditos");
            int cantCreditos = Integer.parseInt(lectorGeneral.readLine());
            System.out.println(("Ingrese el estado del ramo (0 = no cursado o 1 = cursando)"));
            int estadoRamo = Integer.parseInt(lectorGeneral.readLine());

            if(nuevaCarrera.verificarRamo(codigoRamo)) nuevaCarrera.agregarRamoMalla(new Ramo(nombreRamo, codigoRamo, cantCreditos, estadoRamo));
            else System.out.println("El ramo ya se encuentra ingresado");
        }

        return true;
    }

    /**
     * Metodo que busca y elimina una carrera del instituto
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si es que se elimino la carrera y falso si no se pudo eliminar
     */
    
    public boolean eliminarCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Metodo que agrega un alumno a una carreara
     * @param al Objeto de la clase alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo agregar al alumno y  falso si no se pudo agregar
     */

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
    /**
     * Metodo para eliminar a un alumno a traves de su rut y la carrera en la cual esta matriculado
     * @param rut Entero que contiene el rut del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean
     */
    public boolean eliminarAlumno(int rut, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(rut);
            } 
        }
        return false;
    }
    
    /**
     * Metodo para eliminar a un alumno a traves del nombre y la carrera en la cual esta matriculado
     * @param nombreAlumno String que contiene el nombre del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean
     */
    public boolean eliminarAlumno(String nombreAlumno, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(nombreAlumno);
            } 
        }
        return false;
    }
    
    /** 
     * Metodo para mostrar la lista de alumnos de una carrera y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de la carrera
     */
    public void mostrarListaAlumnos(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                System.out.println("Cantidad de alumnos:" + listaCarreras.get(i).getCantidadAlumnos() + "\n");
                listaCarreras.get(i).mostrarListaAlumnos();
                return;
            }
        }
    }
    
    /**
     * Metodo para agregar un ramo fuera de la mallla curricular de la carrera a un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno
     * @param nuevoRamo Objeto de la clase Ramo
     * @return boolean
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).agregarRamoOpcional(nombreAlumno, nuevoRamo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para actualizar el estado de un ramo de un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param codigoRamo String que contiene el codigo de un ramo de alguna carrera
     * @param estadoRamo Entero que contiene una de 3 opciones para cambiar el estado del ramo (0 = no cursado, 1 = cursando y 2 = aprobado)
     * @return boolean
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).actualizarRamo(nombreAlumno, codigoRamo, estadoRamo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que muestra los ramos de una carrera en especifico y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de una carrera en especifico
     */
    public void mostrarRamosCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                listaCarreras.get(i).mostrarRamosCarrera();
                return;
            }
        }
        System.out.println("La carrera no esta ingresada");
    }
    
    /**
     * Metodo que muestra la informacion respectiva de todas las carreras del instituto
     */
    public void mostrarCarreras(){
        for (int i = 0; i < listaCarreras.size(); i++) {
            System.out.println("Carrera: " + listaCarreras.get(i).getNombreCarrera() + " Alumnos: " + listaCarreras.get(i).getCantidadAlumnos());
        }
    }
    
    /**
     * Metodo para la busqueda de un ramo y entregar su informacion respectiva
     * @param codigoRamo String del codigo de un ramo
     * @return boolean
     */
    public boolean buscarRamo(String codigoRamo){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).buscarRamo(codigoRamo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para editar el nombre de una carrera
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param nuevoNombreCarrera String que contiene el nombre a cambiar de la carrera
     * @return boolean
     */
    public boolean editarCarrera(String nombreCarrera, String nuevoNombreCarrera){
        for(int i = 0; i < listaCarreras.size(); i++){
        
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.get(i).setNombreCarrera(nuevoNombreCarrera);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para editar el nombre de un alumno de alguna carrera
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param nuevoNombreAlumno String que contiene el nuevo nombre del alumno que se trata de encontrar
     * @return boolean
     */
    public boolean editarAlumno(String nombreAlumno, String nuevoNombreAlumno){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).editarAlumno(nombreAlumno, nuevoNombreAlumno)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que edita un ramo de la malla curricular de una carrera en especifico
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param codigoRamo String que contiene el codigo del ramo de una malla curricular de alguna carrera
     * @param nuevoNombreRamo String que contiene el nuevo nombre del ramo que se desea modificar
     * @return boolean
     */
    public boolean editarRamo(String nombreCarrera, String codigoRamo, String nuevoNombreRamo){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                return listaCarreras.get(i).editarRamo(codigoRamo, nuevoNombreRamo);
            }
        }
        return false;
    }
    /*
        Metodo que en caso de encontrar un ramo con el codigo señalado, lo elimina de la malla curricular de la carrera señalada
        @param codigoRamo String que contiene el codigo del ramo a eliminar
        @param nombreCarrera String que indica de que carrera se quiere eliminar el ramo
        @return boolean
    */

    public boolean eliminarRamo(String nombreCarrera, String codigoRamo){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                return listaCarreras.get(i).eliminarRamo(codigoRamo);
            }
        }
        return false;
    }

    /**
     * Metodo que crea un reporte en un archivo txt que muestra datos de las colecciones anidadas
     */
    public void crearReporte(){
        //Se crea el archivo reporte
        try{
            File archivo = new File("reporte.txt");
            archivo.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }

        //Se imprime en el archivo reporte
        try{
            FileWriter archivo = new FileWriter("reporte.txt");
            archivo.write("  Nombre de la carrera Cantidad Alumnos\n");
            for(int i = 0 ; i < listaCarreras.size() ; i++){
                Carrera cr = listaCarreras.get(i);
                archivo.write(String.format("%20s %1d",cr.getNombreCarrera(), cr.getCantidadAlumnos()) + "\n");
            }

            archivo.write("---------------------------------------------\n");
            archivo.write("         Rut alumnos Cantidad creditos\n");

            for(int i = 0 ; i < listaCarreras.size() ; i++){
                Carrera cr = listaCarreras.get(i);
                cr.reporteAlumno(archivo);
            }

            archivo.write("---------------------------------------------\n");
            archivo.write("      codigo del ramo Cantidad alumnos\n");

            for(int i = 0 ; i < listaCarreras.size() ; i++){
                Carrera cr = listaCarreras.get(i);
                cr.reporteRamo(archivo);
            }

            archivo.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
