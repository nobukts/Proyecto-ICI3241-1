package Clases;

import java.util.*;

import Interfaces.Verificador;

public class ColeccionAsignatura implements Verificador {
    private ArrayList<Asignatura> mallaCurricular;

    public ColeccionAsignatura(){
        mallaCurricular = new ArrayList<>();
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
     * Metodo que agrega un alumno a la lista de alumnos y al mapa de alumnos
     * @param al Objeto de la clase Alumno
     */
    public void agregarAlumno(Alumno al){
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
    }

    /**
     * Metodo para agregar una asignatura a la malla curricular
     * @param nuevaAsignatura La asignatura a agregar
     */
    public void agregarAsignaturaMalla(Asignatura nuevaAsignatura){
        mallaCurricular.add(nuevaAsignatura);
    }

    /**
     * Metodo para eliminar una asignatura
     * @param codigoAsignatura El codigo de la asignatura a eliminar
     * @return boolean true si se pudo eliminar, false si no se pudo eliminar
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
     * Metodo para disminuir los alumnos en una asignatura de la malla
     * @param codigoRamo el codigo de la asignatura a disminuir sus alumnos
     */
    public void disminuirAlumnos(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).disminuirAlumnos();
            }
            
        }
    }

    /**
     * Metodo para aumentar los alumnos en una asignatura de la malla
     * @param codigoRamo el codigo de la asignatura a aumentar sus alumnos
     */
    public void aumentarAlumnos(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).aumentarAlumnos();
            }
            
        }
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
