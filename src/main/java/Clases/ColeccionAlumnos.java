package Clases;

import java.util.*;

public class ColeccionAlumnos {
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;

    public ColeccionAlumnos(){
        mapaAlumnos = new HashMap<>();
        listaAlumnos = new ArrayList<>();
    }

    /**
     * Metodo que muestra la informacion de la lista de alumnos
     * @return 
     */
    public String[] mostrarListaAlumnos(){
        String[] alumnos = new String[listaAlumnos.size()];
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            alumnos[i] = listaAlumnos.get(i).mostrarAlumno();
        }

        return alumnos;
    }
    
    /**
     * Metodo para agregar alumno a la lista y al mapa alumnos
     * @param al el alumno que se agregara a las colecciones
     */
    public void agregarAlumno(Alumno al){
        listaAlumnos.add(al);
        mapaAlumnos.put(al.getNombreAlumno(), al);
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
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del nombre
     * @param nombreAlumno String que contiene el nombre del alumno a eliminar
     * @param coleccionAsignatura contiene la coleccion de asignatura para eliminar el alumno
     * @return boolean Verdadero si se pudo eliminar y falso si no se puedo eliminar
     */
    public String[] eliminarAlumno(String nombreAlumno){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                String[] listaRamos = mapaAlumnos.get(nombreAlumno).mostrarRamos();
                
                mapaAlumnos.remove(nombreAlumno);
                listaAlumnos.remove(i);
                return listaRamos;
            }
        }
        return null;
    }

    /**
     * Metodo que elimina un alumno de la lista y del mapa de alumnos a traves del rut
     * @param rutAlumno Entero que contiene el rut del alumno a eliminar
     * @param coleccionAsignatura contiene la coleccion de asignatura para eliminar el alumno
     * @return boolean Verdadero si se pudo eliminar y falso si no se puedo eliminar
     */
    public String[] eliminarAlumno(int rutAlumno){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == rutAlumno){
                String[] listaRamos = listaAlumnos.get(i).mostrarRamos();
                
                mapaAlumnos.remove(listaAlumnos.get(i).getNombreAlumno());
                listaAlumnos.remove(i);
                return listaRamos;
            }
        }
        return null;
    }

    /**
     * Metodo que actualiza el estado de un ramo que posee el alumno
     * @param nombreAlumno String que contiene el nombre del alumno a buscar
     * @param codigoRamo String que contiene el codigo del ramo a cambiar
     * @param estadoRamo Entero que contiene uno de los 3 estados que puede tener un ramo
     * @return boolean Verdadero si se pudo actualizar el estado del ramo y falso si no se pudo realizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno))
            return mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
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
    public ArrayList<String> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        ArrayList<String> alumnosRango = new ArrayList<>();
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno aux = listaAlumnos.get(i);
            if(aux.getCantidadCreditos() >= rangoMinimo && aux.getCantidadCreditos() <= rangoMaximo){
                alumnosRango.add(aux.mostrarAlumno());
            }
        }
        
        return alumnosRango;
    }

    /**
     * Metodo que busca un alumno y lo muestra
     * @param nombreAlumno nombre del alumno a buscar
     * @return
     */
    public String buscarAlumno(String nombreAlumno){
        if(mapaAlumnos.containsKey(nombreAlumno)) return mapaAlumnos.get(nombreAlumno).mostrarAlumno();
        return null;
    }

    /**
     * Metodo que busca un alumno y muestra sus ramos
     * @param nombreAlumno nombre del alumno a buscar
     * @return
     */
    public String[] buscarRamos(String nombreAlumno){
        if(mapaAlumnos.containsKey(nombreAlumno)) return mapaAlumnos.get(nombreAlumno).mostrarRamos();
        return null;
    }

    /**
     * Metodo que verifica si en el mapa alumnos se encuentra el alumno a buscar
     * @param nombreAlumno nombre del alumno a buscar
     * @return
     */
    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }

    /**
     * Metodo que verifica si en la lista alumnos se encuentra alguien con el rut ingresado
     * @param rut es el rut que se desea buscar en la lsita
     * @return
     */
    public boolean mismoRut(int rut){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == rut) return false;
        }
        return true;
    }

    /**
     * Metodo que verifica si la lista de alumnos esta vacia o no
     * @return boolean Verdadero si la lista esta vacia
     */
    public boolean noContieneAlumnos(){
        return listaAlumnos.isEmpty();
    }
}
