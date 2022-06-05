package Clases;


import java.io.*;
import java.util.*;

public class Carrera{
    private String nombreCarrera;
    private int cantidadAlumnos;
    private ColeccionAlumnos coleccionAlumnos;
    private ColeccionAsignatura coleccionAsignatura;
    //private ArrayList<Asignatura> mallaCurricular;
    
    
    /**
     * Constructor vacio que inicializa las colecciones de la clase
     */
    public Carrera(){
        coleccionAlumnos = new ColeccionAlumnos();
        coleccionAsignatura = new ColeccionAsignatura();
    }

    /**
     * Constructor de la clase Carrera que inicializa el nombre y sus colecciones
     * @param nombreCarrera String que contiene el nombre de la carrera
     */
    public Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
        coleccionAlumnos = new ColeccionAlumnos();
        coleccionAsignatura = new ColeccionAsignatura();
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

    public boolean contieneAlumnos(){
        return coleccionAlumnos.contieneAlumnos();
    }
    
    /**
     * Metodo que agrega un alumno a la lista de alumnos y al mapa de alumnos
     * @param al Objeto de la clase Alumno
     * @return boolean Verdadero si el alumno se pudo matricular y falso si ya se encontraba matriculado
     */
    public boolean matricularAlumno(Alumno al){
        if(coleccionAlumnos.mismoRut(al) == false){return false;}
        
        coleccionAlumnos.agregarAlumno(al);
        cantidadAlumnos++;
        
        coleccionAsignatura.agregarAlumno(al);
        
        return true;
    }

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del nombre
     * @param nombreAlumno String que contiene el nombre del alumno a eliminar
     * @return boolean Verdadero si se pudo eliminar con exito al alumno y falso si no se pudo eliminarlo
     */
    public boolean eliminarAlumno(String nombreAlumno){
        if(coleccionAlumnos.contieneAlumnos()) return false;
        if(coleccionAlumnos.eliminarAlumno(nombreAlumno, coleccionAsignatura)){
            cantidadAlumnos--;
            return true;
        }

        return false;
    }

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del rut
     * @param rutAlumno Entero que contiene el rut del alumno a eliminar
     * @return boolean Verdadero si se pudo eliminar con exito al alumno y falso si no se pudo eliminarlo
     */
    public boolean eliminarAlumno(int rutAlumno){
        if(coleccionAlumnos.contieneAlumnos()) return false;
        if(coleccionAlumnos.eliminarAlumno(rutAlumno, coleccionAsignatura)){
            cantidadAlumnos--;
            return true;
        }
        
        return false;
    }

    /**
     * Metodo que en caso de encontrar una asignatura con el codigo señalado, lo elimina de la malla curricular
     * @param codigoAsignatura String que contiene el codigo de la asignatura a eliminar
     * @return boolean Verdadero si se puedo eliminar la asignatura, falso si no se pudo eliminar
     */
    public boolean eliminarAsignatura(String codigoAsignatura){
        return coleccionAsignatura.eliminarAsignatura(codigoAsignatura);
    }

    /**
     * Metodo que muestra la informacion de la lista de alumnos almacenados de la carrera
     * @return 
     */
    public String[] mostrarListaAlumnos(){       
        return coleccionAlumnos.mostrarAlumno();
    }
    
    public String mostrarCarrera(){
        return (this.getNombreCarrera() + " " + this.getCantidadAlumnos());
    }

    /**
     * Metodo que muestra las asignaturas impartidos por la carrera, con su respectiva informacion
     * @return 
     */
    public String[] mostrarAsignaturas(){
        return coleccionAsignatura.mostrarAsignaturas();
    }

    /**
     * Metodo que agrega un asignatura a la malla curricular de la carrera
     * @param nuevaAsignatura Objeto de la clase Asignatura que se va a agregar a la malla curricular
     * @return boolean Verdadero si se pudo agregar la asignatura a la malla y falso si no se pudo agregar
     */
    public boolean agregarAsignaturaMalla(Asignatura nuevaAsignatura){
        if(coleccionAsignatura.verificar(nuevaAsignatura.getCodigoCurso())) return false;

        coleccionAsignatura.agregarAsignaturaMalla(nuevaAsignatura);
        return true;
    }

    /**
     * Metodo para agregar un ramo que no pertenece a la malla curricular a un alumno
     * @param nombreAlumno String que contiene el nombre del alumno que se le quiere añadir el ramo
     * @param nuevoRamo Objeto de la clase Ramo que se va agregar al alumno
     * @return boolean Verdadero si se pudo agregar el ramo a los ramos del alumno y falso si no se pudo agregar
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo){
        return coleccionAlumnos.agregarRamoOpcional(nombreAlumno, nuevoRamo);
    }
    
    /**
     * Metodo que actualiza el estado de un ramo que posee el alumno
     * @param nombreAlumno String que contiene el nombre del alumno a buscar
     * @param codigoRamo String que contiene el codigo del ramo a cambiar
     * @param estadoRamo Entero que contiene uno de los 3 estados que puede tener un ramo
     * @return boolean Verdadero si se pudo actualizar el estado del ramo y falso si no se pudo realizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        boolean res = false;
        res = coleccionAlumnos.actualizarRamo(nombreAlumno, codigoRamo, estadoRamo);
        
        if(res == true && (estadoRamo == 0 || estadoRamo == 2)){
            coleccionAsignatura.disminuirAlumnos(codigoRamo);
        }
        else if(res == true && estadoRamo == 1){
            coleccionAsignatura.aumentarAlumnos(codigoRamo);
        }
        
        return res;
    }

    
    /**
     * Metodo que permite editar el nombre de un alumno
     * @param nombreAlumno String que contiene el nombre del alumno para realizar la busqueda
     * @param nuevoNombreAlumno String que contiene el nuevo nombre del alumno
     * @return boolean Verdadero si se pudo editar el alumno y falso si no se logro editar
     */
    public boolean editarAlumno(String nombreAlumno, String nuevoNombreAlumno){
        return coleccionAlumnos.editarAlumno(nombreAlumno, nuevoNombreAlumno);
    }

    

    /**
     * Metodo para escribir en el archivo reporte.txt los datos de los alumnos
     * @param archivo FileWriter que contiene el nombre del archivo en donde se escribirá la información
     */
    public void reporteAlumno(FileWriter archivo){
        //try{
        //    for(int i = 0 ; i < listaAlumnos.size() ; i++){
        //        Alumno al = listaAlumnos.get(i);
        //        archivo.write(String.format("%20s %13d %19d",al.getNombreAlumno(),al.getRut(), al.getCantidadCreditos()) + "\n");                  ---------------------<
        //    }
        //}catch(IOException e){
        //}
    }

    /**
     * Metodo para escribir en el archivo reporte.txt los datos de las asignaturas
     * @param archivo FileWriter que contiene el nombre del archivo en donde se escribirá la información
     * @param aux boolean sirve para saber si se imprime la primera asignatura o no
     */
    public void reporteAsignatura(FileWriter archivo, boolean aux){
        /* try{
            //True si se imprime la primera asignatura, False si no es la primera asignatura
            if(aux){
                //Esto evita que si la malla no tenga carrera se caiga el programa
                if(mallaCurricular.isEmpty()){
                    archivo.write("\n");
                    return;
                }
                Asignatura rm = mallaCurricular.get(0);
                archivo.write(String.format("%20s %19s %14d",rm.getCodigoCurso(), rm.getNombreCurso(), rm.getCantidadAlumnos()) + "\n");
            }else{
                for(int i = 1 ; i < mallaCurricular.size() ; i++){
                    Asignatura rm = mallaCurricular.get(i);
                    archivo.write(String.format("%40s %19s %14d",rm.getCodigoCurso(),rm.getNombreCurso(), rm.getCantidadAlumnos()) + "\n");
                }
            }
            
        }catch(IOException e){
        } */
    }
    
    /**
     * Metodo que busca el alumno con la menor cantidad de creditos en la carrera
     * @return Alumno con menor cantidad de creditos
     */
    public Alumno alumnoMenorCreditos(){
        return coleccionAlumnos.alumnoMenorCreditos();
    }

    /**
     * Metodo que busca a los alumnos del rango de creditos ingresados por el usuario
     * @param rangoMinimo Cantidad minima de creditos 
     * @param rangoMaximo Cantidad maxima de creditos
     * @return ArrayList con los alumnos dentro del rango de creditos
     */
    public ArrayList<String> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        return coleccionAlumnos.alumnosRangoCredito(rangoMinimo, rangoMaximo);
    }

    /**
     * Metodo que verifica si el alumno se encuentra dentro de la carrera
     * @param nombreAlumno String que contiene el nombre del alumno que se desea verificar
     * @return boolean Verdadero si contiene al alumno y falso si no lo contiene
     */
    public boolean verificarAlumnos(String nombreAlumno){
        return coleccionAlumnos.verificarAlumnos(nombreAlumno);
    }
    
    public String buscarAlumno(String nombreAlumno){
        return coleccionAlumnos.buscarAlumno(nombreAlumno);
    }
    
    public String[] buscarRamos(String nombreAlumno){
        return coleccionAlumnos.buscarRamos(nombreAlumno);
    }
}

