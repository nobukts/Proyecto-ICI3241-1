package Clases;

import java.util.*;

import Interfaces.Verificador;

public class ColeccionCursos implements Verificador {
    private HashMap<String, Asignatura> mapaCursos;

    public ColeccionCursos(){
        mapaCursos = new HashMap<>();
    }

    /**
     * Metodo para mostrar los cursos que existen
     * @return arraylist con la informacion de todos los cursos
     */
    public ArrayList<String> mostrarCursos(){
        ArrayList<String> listaCursos = new ArrayList<>();
        mapaCursos.forEach((key, value)->{
            listaCursos.add(value.mostrarInformacion());
        });

        return listaCursos;
    }

    /**
     * Metodo para agregar una asignatura a la malla curricular
     * @param nuevaAsignatura Asignatura a agregar
     */
    public void agregarMalla(Asignatura nuevaAsignatura){
        mapaCursos.put(nuevaAsignatura.getCodigoCurso(), nuevaAsignatura);
    }

    /**
     * Metodo para agregar un ramo opcional
     * @param nuevoRamo Ramo a agregar
     * @param escuela String con el nombre de la escuela
     */
    public void agregarRamoOpcional(Ramo nuevoRamo, String escuela){
        Opcional asigAux = new Opcional(nuevoRamo.getNombreCurso(), nuevoRamo.getCodigoCurso(), nuevoRamo.getCantidadCreditos(), escuela);
        if(verificar(asigAux.getCodigoCurso())){
            mapaCursos.get(asigAux.getCodigoCurso()).aumentarAlumnos();
        }
        else{
            mapaCursos.put(asigAux.getCodigoCurso(), asigAux);
            asigAux.aumentarAlumnos();
        }
    }

    /**
     * Metodo que edita una asignatura de la malla curricular de una carrera en especifico
     * @param codigoAsignatura String que contiene el codigo de la asignatura de una malla curricular de alguna carrera
     * @param nuevoNombre String que contiene el nuevo nombre de la asignatura que se desea modificar
     * @param nuevaInformacion Strinf que cambia la informacion, si es Obligatorio cambia la carrera y si es Opcional cambia la escuela que los imparte respectivamente
     * @return boolean Verdadero si se pudo editar la asignatura y falso si no se pudo editar
     */
    public boolean editarAsignatura(String codigoAsignatura, String nuevoNombre, String nuevaInformacion){
        if(!mapaCursos.containsKey(codigoAsignatura)) return false;
        
        mapaCursos.get(codigoAsignatura).cambiarInformacion(nuevoNombre, nuevaInformacion);
        
        return true;
    }

    /**
     * Metodo para la busqueda de una asignatura y entregar su informacion respectiva
     * @param codigoAsignatura String del codigo de una asignatura
     * @return boolean Verdadero si encontro el asignatura y falso si no existe la asignatura
     */
    public String buscarAsignatura(String codigoAsignatura){
        if(!mapaCursos.containsKey(codigoAsignatura)) return null;
        return mapaCursos.get(codigoAsignatura).mostrarInformacion();
    }

    /**
     * Metodo para disminuir alumnos
     * @param codigo String con el codigo del curso a disminuir
     */
    public void disminuirAlumnos(String codigo){
        mapaCursos.get(codigo).disminuirAlumnos();
    }

    /**
     * Metodo para aumentar alumnos
     * @param codigo String con el codigo del curso a aumentar
     */
    public void aumentarAlumnos(String codigo){
        mapaCursos.get(codigo).aumentarAlumnos();
    }

    /**
     * Metodo de la interface que verifica si una asignatura se encuentra o no en la lista
     * @param codigoCurso String que contiene el codigo del curso
     * @return Boolean true si el codigo se encuentra en el mapa cursos y falso si no se encuentra
     */
    @Override
    public boolean verificar(String codigoCurso){
        return mapaCursos.containsKey(codigoCurso);
    }
}
