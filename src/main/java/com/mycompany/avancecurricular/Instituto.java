package com.mycompany.avancecurricular;

import java.util.ArrayList;
import java.util.HashMap;

public class Instituto {
    private String nombreSede;
    private HashMap<String, Alumno> mapaAlumnos;
    private ArrayList<Alumno> listaAlumnos;
    
    public Instituto(String nombreSede){
        mapaAlumnos = new HashMap<>();
        listaAlumnos = new ArrayList<>();
        this.nombreSede = nombreSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public void agregarAlumnos(Alumno nuevoAlumno){
        mapaAlumnos.put(nuevoAlumno.getNombreAlumno(), nuevoAlumno);
        listaAlumnos.add(nuevoAlumno);
    }

    public void agregarDatosAlumno(String nombreAlumno,Ramo mallaCurricular){
        mapaAlumnos.get(nombreAlumno).getMallaCurricular().add(mallaCurricular);
        int ultimoDato = listaAlumnos.size() - 1;
        listaAlumnos.get(ultimoDato).getMallaCurricular().add(mallaCurricular);
    }

    public void agregarDatosAlumno(Ramo mallaCurricular, Ramo ramosActuales){

    }
    
    public void mostrarAlumnos(){
        System.out.println("\nAlumnos de la sede " + this.nombreSede + "\n");
        if(listaAlumnos.size() == 0){
            System.out.println("No ha ingresado ningun alumno por el momento");
            return;
        }
        else{
            for (int i = 0; i < listaAlumnos.size(); i++) {
                System.out.println("Nombre: " + listaAlumnos.get(i).getNombreAlumno());
                System.out.println("Malla: ");
                for (int j = 0; j < listaAlumnos.get(i).getMallaCurricular().size(); j++) {
                    System.out.println(listaAlumnos.get(i).getMallaCurricular().get(j));
                }
            }
        }
    }
}
