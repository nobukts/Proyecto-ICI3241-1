package Clases;

import Interfaces.Verificador;
import java.io.*;
import java.util.*;

public class Carrera implements Verificador{
    private String nombreCarrera;
    private int cantidadAlumnos;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Asignatura> mallaCurricular;
    
    
    /**
     * Constructor vacio que inicializa las colecciones de la clase
     */
    public Carrera(){
        listaAlumnos = new ArrayList<>();
        mapaAlumnos = new HashMap<>();
        mallaCurricular = new ArrayList<>();
    }

    /**
     * Constructor de la clase Carrera que inicializa el nombre y sus colecciones
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

    public boolean contieneAlumnos(){
        return listaAlumnos.isEmpty();
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
        cantidadAlumnos++;
        
        for(int i = 0; i < mallaCurricular.size(); i++){
            Asignatura aux = mallaCurricular.get(i);
            Ramo nuevoRamo = new Ramo(aux.getNombreCurso(), aux.getCodigoCurso(), aux.getCantidadCreditos());
            if(aux.getEsDePrimero()){
                aux.aumentarAlumnos();
                nuevoRamo.setEstadoRamo(1);
            }
            else nuevoRamo.setEstadoRamo(0);
            al.agregarRamo(nuevoRamo);
        }
        
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
                
                //Resta 1 alumno de las asignaturas que tenia en curso el alumno
                for (int j = 0; j < mallaCurricular.size(); j++) {
                    if(mapaAlumnos.containsKey(nombreAlumno)){
                        if(mapaAlumnos.get(nombreAlumno).eliminarAlumno(mallaCurricular.get(j).getCodigoCurso())) 
                            mallaCurricular.get(j).disminuirAlumnos();
                    }
                }
                
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
     * @return boolean Verdadero si se pudo eliminar con exito al alumno y falso si no se pudo eliminarlo
     */
    public boolean eliminarAlumno(int rutAlumno){
        if(listaAlumnos.isEmpty()) return false;

        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == rutAlumno){
                
                //Resta 1 alumno de las asignaturas que tenia en curso el alumno
                for (int j = 0; j < mallaCurricular.size(); j++) {
                    if(mapaAlumnos.containsKey(listaAlumnos.get(i).getNombreAlumno())){
                        if(mapaAlumnos.get(listaAlumnos.get(i).getNombreAlumno()).eliminarAlumno(mallaCurricular.get(j).getCodigoCurso())) 
                            mallaCurricular.get(j).disminuirAlumnos();
                    }
                }
                
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
     * @return 
     */
    public String[] mostrarListaAlumnos(){
        String[] alumnos = new String[listaAlumnos.size()];
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            alumnos[i] = listaAlumnos.get(i).mostrarAlumno();
        }
        
        return alumnos;
    }
    
    public String mostrarCarrera(){
        return (this.getNombreCarrera() + " " + this.getCantidadAlumnos());
    }

    /**
     * Metodo que agrega un asignatura a la malla curricular de la carrera
     * @param nuevaAsignatura Objeto de la clase Asignatura que se va a agregar a la malla curricular
     * @return boolean Verdadero si se pudo agregar la asignatura a la malla y falso si no se pudo agregar
     */
    public boolean agregarAsignaturaMalla(Asignatura nuevaAsignatura){
        if(verificar(nuevaAsignatura.getCodigoCurso())) return false;

        mallaCurricular.add(nuevaAsignatura);
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
            if(!mapaAlumnos.get(nombreAlumno).verificar(nuevoRamo.getCodigoCurso())){
                mapaAlumnos.get(nombreAlumno).agregarRamo(nuevoRamo);
                return true;
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
        boolean res = false;
        if(mapaAlumnos.containsKey(nombreAlumno))
            res = mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
        
        if(res == true && (estadoRamo == 0 || estadoRamo == 2)){
            for (int i = 0; i < mallaCurricular.size(); i++) {
                if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                    mallaCurricular.get(i).disminuirAlumnos();
                }
                
            }
        }
        else if(res == true && estadoRamo == 1){
            for (int i = 0; i < mallaCurricular.size(); i++) {
                if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                    mallaCurricular.get(i).aumentarAlumnos();
                }
                
            }
        }
        
        return res;
    }

    /**
     * Metodo que muestra las asignaturas impartidos por la carrera, con su respectiva informacion
     * @return 
     */
    public String[] mostrarAsignaturas(){
        String[] malla = new String[mallaCurricular.size()];
        
        for (int i = 0; i < mallaCurricular.size(); i++) {
            malla[i] = mallaCurricular.get(i).mostrarInformacion();
        }
        
        return malla;
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
     * Metodo que en caso de encontrar una asignatura con el codigo señalado, lo elimina de la malla curricular
     * @param codigoAsignatura String que contiene el codigo de la asignatura a eliminar
     * @return boolean Verdadero si se puedo eliminar la asignatura, falso si no se pudo eliminar
     */
    public boolean eliminarAsignatura(String codigoAsignatura){
        for (int i = 0; i < mallaCurricular.size(); i++){
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoAsignatura)){
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
                archivo.write(String.format("%20s %13d %19d",al.getNombreAlumno(),al.getRut(), al.getCantidadCreditos()) + "\n");
            }
        }catch(IOException e){
        }
    }

    /**
     * Metodo para escribir en el archivo reporte.txt los datos de las asignaturas
     * @param archivo FileWriter que contiene el nombre del archivo en donde se escribirá la información
     * @param aux boolean sirve para saber si se imprime la primera asignatura o no
     */
    public void reporteAsignatura(FileWriter archivo, boolean aux){
        try{
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
        }
    }
    
    /**
     * Metodo que busca el alumno con la menor cantidad de creditos en la carrera
     * @return Alumno con menor cantidad de creditos
     */
    public Alumno alumnoMenorCreditos(){
        Alumno alumnoMenorCant = listaAlumnos.get(0);
        for (int i = 1; i < listaAlumnos.size(); i++) {
            if(alumnoMenorCant.getCantidadCreditos() > listaAlumnos.get(i).getCantidadCreditos()){
                alumnoMenorCant = listaAlumnos.get(i);
            }
        }
        
        return alumnoMenorCant;
    }

    /**
     * Metodo que busca a los alumnos del rango de creditos ingresados por el usuario
     * @param rangoMinimo Cantidad minima de creditos 
     * @param rangoMaximo Cantidad maxima de creditos
     * @return ArrayList con los alumnos dentro del rango de creditos
     */
    public ArrayList<Alumno> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        ArrayList<Alumno> alumnosRango = new ArrayList<>();
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno aux = listaAlumnos.get(i);
            if(aux.getCantidadCreditos() >= rangoMinimo && aux.getCantidadCreditos() <= rangoMaximo){
                alumnosRango.add(aux);
            }
        }
        
        return alumnosRango;
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
     * Metodo de la interface que verifica si una asignatura se encuentra entre la malla curricular de la carera
     * @param codigoAsignatura String que contiene el codigo del asignatura que estamos verificando
     * @return boolean Verdadero si se encuentra el asignatura en la malla y falso, si no se encuentra
     */
    @Override
    public boolean verificar(String codigoAsignatura){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoAsignatura)){
                return true;
            }
            
        }
        return false;
    }
}

