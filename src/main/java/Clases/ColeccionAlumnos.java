package Clases;

import java.util.*;

public class ColeccionAlumnos {
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;

    public ColeccionAlumnos(){
        mapaAlumnos = new HashMap<>();
        listaAlumnos = new ArrayList<>();
    }

    public boolean contieneAlumnos(){
        return listaAlumnos.isEmpty();
    }

    public int tamañoLista(){
        return listaAlumnos.size();
    }

    public boolean mismoRut(Alumno al){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == al.getRut()) return false;
        }
        return true;
    }

    public void agregarAlumno(Alumno al){
        listaAlumnos.add(al);
        mapaAlumnos.put(al.getNombreAlumno(), al);
    }

    public boolean eliminarAlumno(String nombreAlumno, ColeccionAsignatura coleccionAsignatura){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getNombreAlumno().equalsIgnoreCase(nombreAlumno)){
                
                //Resta 1 alumno de las asignaturas que tenia en curso el alumno
                coleccionAsignatura.eliminarAlumno(nombreAlumno, mapaAlumnos);
                
                mapaAlumnos.remove(nombreAlumno);
                listaAlumnos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarAlumno(int rutAlumno, ColeccionAsignatura coleccionAsignatura){
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getRut() == rutAlumno){
                
                //Resta 1 alumno de las asignaturas que tenia en curso el alumno
                coleccionAsignatura.eliminarAlumno(rutAlumno, mapaAlumnos, listaAlumnos.get(i).getNombreAlumno());
                
                mapaAlumnos.remove(listaAlumnos.get(i).getNombreAlumno());
                listaAlumnos.remove(i);
                return true;
            }
        }
        return false;
    }

    public String[] mostrarAlumno(){
        String[] alumnos = new String[listaAlumnos.size()];
        
        for (int i = 0; i < listaAlumnos.size(); i++) {
            alumnos[i] = listaAlumnos.get(i).mostrarAlumno();
        }

        return alumnos;
    }

    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno)){
            if(!mapaAlumnos.get(nombreAlumno).verificar(nuevoRamo.getCodigoCurso())){
                mapaAlumnos.get(nombreAlumno).agregarRamo(nuevoRamo);
                return true;
            }
        }

        return false;
    }

    public boolean actualizarRamo(String nombreAlumno, String codigoRamo, int estadoRamo){
        if(mapaAlumnos.containsKey(nombreAlumno))
            return mapaAlumnos.get(nombreAlumno).actualizarRamo(codigoRamo, estadoRamo);
        return false;
    }

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

    public Alumno alumnoMenorCreditos(){
        Alumno alumnoMenorCant = listaAlumnos.get(0);
        for (int i = 1; i < listaAlumnos.size(); i++) {
            if(alumnoMenorCant.getCantidadCreditos() > listaAlumnos.get(i).getCantidadCreditos()){
                alumnoMenorCant = listaAlumnos.get(i);
            }
        }
        
        return alumnoMenorCant;
    }

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

    public boolean verificarAlumnos(String nombreAlumno){
        return mapaAlumnos.containsKey(nombreAlumno);
    }

    public String buscarAlumno(String nombreAlumno){
        if(mapaAlumnos.containsKey(nombreAlumno)) return mapaAlumnos.get(nombreAlumno).mostrarAlumno();
        return null;
    }

    public String[] buscarRamos(String nombreAlumno){
        if(mapaAlumnos.containsKey(nombreAlumno)) return mapaAlumnos.get(nombreAlumno).mostrarRamos();
        return null;
    }
}
