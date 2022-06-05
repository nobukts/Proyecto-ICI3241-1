package Clases;

import java.util.*;

import Interfaces.Verificador;

public class ColeccionAsignatura implements Verificador {
    private ArrayList<Asignatura> mallaCurricular;

    public ColeccionAsignatura(){
        mallaCurricular = new ArrayList<>();
    }

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

    public void agregarAsignaturaMalla(Asignatura nuevaAsignatura){
        mallaCurricular.add(nuevaAsignatura);
    }

    public void disminuirAlumnos(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).disminuirAlumnos();
            }
            
        }
    }

    public void aumentarAlumnos(String codigoRamo){
        for (int i = 0; i < mallaCurricular.size(); i++) {
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                mallaCurricular.get(i).aumentarAlumnos();
            }
            
        }
    }

    public String[] mostrarAsignaturas(){
        String[] malla = new String[mallaCurricular.size()];
        
        for (int i = 0; i < mallaCurricular.size(); i++) {
            malla[i] = mallaCurricular.get(i).mostrarInformacion();
        }
        
        return malla;
    }

    public boolean eliminarAsignatura(String codigoAsignatura){
        for (int i = 0; i < mallaCurricular.size(); i++){
            if(mallaCurricular.get(i).getCodigoCurso().equalsIgnoreCase(codigoAsignatura)){
                mallaCurricular.remove(i);
                return true;
            }
        }
        return false;
    }

    public void eliminarAlumno(String nombreAlumno, HashMap<String, Alumno> mapaAlumnos){
        for (int j = 0; j < mallaCurricular.size(); j++) {
            if(mapaAlumnos.containsKey(nombreAlumno)){
                if(mapaAlumnos.get(nombreAlumno).eliminarAlumno(mallaCurricular.get(j).getCodigoCurso())) 
                    mallaCurricular.get(j).disminuirAlumnos();
            }
        }
    }

    public void eliminarAlumno(int rutAlumno, HashMap<String, Alumno> mapaAlumnos, String nombreAlumno){
        for (int j = 0; j < mallaCurricular.size(); j++) {
            if(mapaAlumnos.containsKey(nombreAlumno)){
                if(mapaAlumnos.get(nombreAlumno).eliminarAlumno(mallaCurricular.get(j).getCodigoCurso())) 
                    mallaCurricular.get(j).disminuirAlumnos();
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
