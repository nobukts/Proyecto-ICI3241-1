package com.mycompany.avancecurricular;

import java.util.ArrayList;
import java.util.HashMap;

public class Instituto {
    private String nombreSede;
    private HashMap<String, Alumno> mapaAlumnosNombre;
    private HashMap<String, Alumno> mapaAlumnosRut;
    private ArrayList<Alumno> listaAlumnos;
    
    public Instituto(){

    }

    public Instituto(String nombreSede){
        mapaAlumnosNombre = new HashMap<>();
        mapaAlumnosRut = new HashMap<>();
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
        mapaAlumnosNombre.put(nuevoAlumno.getNombreAlumno(), nuevoAlumno);
        mapaAlumnosRut.put(nuevoAlumno.getRutAlumno(), nuevoAlumno);
        listaAlumnos.add(nuevoAlumno);
    }

    public void agregarDatosAlumno(String nombreAlumno, Ramo mallaCurricular, String rutAlumno){
        mapaAlumnosNombre.get(nombreAlumno).getMallaCurricular().add(mallaCurricular);
        mapaAlumnosRut.get(rutAlumno).getMallaCurricular().add(mallaCurricular);
    }

    public void agregarDatosAlumno(String nombreAlumno, ArrayList<Ramo> mallaCurricular, Ramo ramosActuales, String rutAlumno){
        mapaAlumnosNombre.get(nombreAlumno).setMallaCurricular(mallaCurricular);
        mapaAlumnosNombre.get(nombreAlumno).getRamosActuales().add(ramosActuales);

        mapaAlumnosRut.get(rutAlumno).setMallaCurricular(mallaCurricular);
        mapaAlumnosRut.get(rutAlumno).getRamosActuales().add(ramosActuales);
    }
    
    public void mostrarAlumnos(){
        System.out.println("\nAlumnos de la sede " + this.nombreSede + "\n");
        if(listaAlumnos.size() == 0){
            System.out.println("No ha ingresado ningun alumno por el momento");
            return;
        }
        else{
            for (int i = 0; i < listaAlumnos.size(); i++) {
                System.out.println("- Nombre: " + listaAlumnos.get(i).getNombreAlumno());
                System.out.println("- Malla: ");

                for (int j = 0; j < listaAlumnos.get(i).getMallaCurricular().size(); j++) {
                    System.out.println(listaAlumnos.get(i).getMallaCurricular().get(j).getNombreRamo());
                }

                System.out.println("- Ramos actuales: ");
                for (int j = 0; j < listaAlumnos.get(i).getRamosActuales().size(); j++) {
                    System.out.println(listaAlumnos.get(i).getRamosActuales().get(j).getNombreRamo());
                }
            }
        }
    }

    public void buscarAlumno(String nombreAlumno){
        System.out.println("Nombre: " + mapaAlumnosNombre.get(nombreAlumno).getNombreAlumno());
        System.out.println("Rut: " + mapaAlumnosNombre.get(nombreAlumno).getRutAlumno());
    }

    public void buscarAlumno(int digitosRut, String digitoVerificador){
        String rut = String.valueOf(digitosRut) + digitoVerificador;

        System.out.println("Nombre: " + mapaAlumnosRut.get(rut).getNombreAlumno());
        System.out.println("Rut: " + mapaAlumnosRut.get(rut).getRutAlumno());
        
    }
}
