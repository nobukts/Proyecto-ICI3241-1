package com.mycompany.avancecurricular;

import java.io.*;
import java.util.ArrayList;

public class Instituto {
    private ArrayList<Carrera> listaCarreras;
    
    /**
     * Constructor de la clase Instituto, que inicializa la coleccion listaCarreras
     */
    public Instituto(){
        listaCarreras = new ArrayList<>();
    }
    
    /**
     * Metodo que agrega una carrera del instituto, e ingresa la malla curricular del mismo
     * @param nuevaCarrera Objeto de la clase carrera
     * @return boolean Verdadero si se logro agregar la carrera correctamente y falso si no se pudo agregar
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
            System.out.println("Ingrese el nombre de la asignatura, para terminar ingrese \"NO\"");
            String nombreAsignatura = lectorGeneral.readLine();
            if(nombreAsignatura.equalsIgnoreCase("no")) break;
            System.out.println("Ingrese el codigo de la asignatura (Formato XXX000)");
            String codigoAsignatura = lectorGeneral.readLine();
            System.out.println("Ingrese la cantidad de creditos");
            int cantCreditos = Integer.parseInt(lectorGeneral.readLine());
            System.out.println(("Es clase de primer semestre (si o no)")); 
            String res = lectorGeneral.readLine();

            boolean esDePrimero = false;
            if(res.equalsIgnoreCase("si")) esDePrimero = true;

            if(nuevaCarrera.verificarAsignatura(codigoAsignatura)) nuevaCarrera.agregarAsignaturaMalla(new Asignatura(nombreAsignatura, codigoAsignatura, cantCreditos, esDePrimero));
            else System.out.println("La asignatura ya se encuentra ingresado");
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
    public boolean matricularAlumno(Alumno al, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).verificarAlumnos(al.getNombreAlumno())){
                return false;
            }
        }

        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).matricularAlumno(al);
            }
        }
        
        return false;
    }

    /**
     * Metodo para eliminar a un alumno a traves de su rut y la carrera en la cual esta matriculado
     * @param rut Entero que contiene el rut del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
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
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
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
                System.out.println("\nCantidad de alumnos:" + listaCarreras.get(i).getCantidadAlumnos() + "\n");
                listaCarreras.get(i).mostrarListaAlumnos();
                return;
            }
        }
    }
    
    /**
     * Metodo para agregar un ramo fuera de la mallla curricular de la carrera a un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno
     * @param nuevoRamo Objeto de la clase Ramo
     * @return boolean Verdadero si se pudo agregar el ramo correctamente y falso si no se pudo agregar
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
     * @param codigoAsignatura String que contiene el codigo de un ramo de alguna carrera
     * @param estadoRamo Entero que contiene una de 3 opciones para cambiar el estado del ramo (0 = no cursado, 1 = cursando y 2 = aprobado)
     * @return boolean Verdadero si se pudo utilizar y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoAsignatura, int estadoRamo){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).actualizarRamo(nombreAlumno, codigoAsignatura, estadoRamo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que muestra los ramos de una carrera en especifico y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de una carrera en especifico
     */
    public void mostrarAsignaturasCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                listaCarreras.get(i).mostrarAsignaturas();
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
     * Metodo para la busqueda de una asignatura y entregar su informacion respectiva
     * @param codigoAsignatura String del codigo de una asignatura
     * @return boolean Verdadero si encontro el asignatura y falso si no existe la asignatura
     */
    public boolean buscarAsignatura(String codigoAsignatura){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).buscarAsignatura(codigoAsignatura)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para editar el nombre de una carrera
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param nuevoNombreCarrera String que contiene el nombre a cambiar de la carrera
     * @return boolean Verdadero si se pudo editar la carrera y falso si no se pudo editar
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
     * @return boolean Verdadero si se pudo editar el alumno y falso si no se pudo editar
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
     * Metodo que edita una asignatura de la malla curricular de una carrera en especifico
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param codigoAsignatura String que contiene el codigo de la asignatura de una malla curricular de alguna carrera
     * @param nuevoNombre String que contiene el nuevo nombre de la asignatura que se desea modificar
     * @return boolean Verdadero si se pudo editar la asignatura y falso si no se pudo editar
     */
    public boolean editarAsignatura(String nombreCarrera, String codigoAsignatura, String nuevoNombre){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                return listaCarreras.get(i).editarAsignatura(codigoAsignatura, nuevoNombre);
            }
        }
        return false;
    }
    /**
    * Metodo que en caso de encontrar una asignatura con el codigo señalado, lo elimina de la malla curricular de la carrera señalada
    * @param codigoAsignatura String que contiene el codigo de la asignatura a eliminar
    * @param nombreCarrera String que indica de que carrera se quiere eliminar la asignatura
    * @return boolean Verdadero si se pudo eliminar la asignatura y falso si no se pudo eliminar
    */

    public boolean eliminarAsignatura(String nombreCarrera, String codigoAsignatura){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                return listaCarreras.get(i).eliminarAsignatura(codigoAsignatura);
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
        }

        //Se imprime en el archivo reporte
        try{
            try (FileWriter archivo = new FileWriter("reporte.txt")) {
                archivo.write("Nombre de la carrera Cantidad Alumnos\n");
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    archivo.write(String.format("%20s %16d",cr.getNombreCarrera(), cr.getCantidadAlumnos()) + "\n");
                }
                
                archivo.write("---------------------------------------------\n");
                archivo.write("     Nombres alumnos + RUT alumnos + Cantidad creditos\n");
                
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    cr.reporteAlumno(archivo);
                }
                
                archivo.write("---------------------------------------------\n");
                archivo.write("Nombre de la carrera + Codigo Asignatura + Nombre Asignatura + Cantidad Alumnos\n");
                
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    archivo.write(String.format("%20s",cr.getNombreCarrera()));
                    cr.reporteAsignatura(archivo, true);
                    cr.reporteAsignatura(archivo, false);
                }
            }
        }catch(IOException e){
        }
    }
    
    public ArrayList<Alumno> alumnosMenorCantCreditos(){
        ArrayList<Alumno> alumnosMenosCreditos = new ArrayList<>();
        
        for(int i = 0; i < listaCarreras.size(); i++) {
           Alumno aux = listaCarreras.get(i).alumnoMenorCreditos();
           if(aux != null){
               alumnosMenosCreditos.add(aux);
           }
            
        }
        return alumnosMenosCreditos;
    } 

    public ArrayList<Alumno> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        ArrayList<Alumno> alumnosRangoCredito = new ArrayList<>();
        
        for (int i = 0; i < listaCarreras.size(); i++) {
            ArrayList<Alumno> listaAux = listaCarreras.get(i).alumnosRangoCredito(rangoMinimo, rangoMaximo);
            if(!listaAux.isEmpty()){
                alumnosRangoCredito.addAll(listaAux);
            }
        }

        return alumnosRangoCredito;
    }
}