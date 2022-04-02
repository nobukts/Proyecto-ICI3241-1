package com.mycompany.avancecurricular;

import java.io.*;
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
    }

    public void agregarDatosAlumno(String nombreAlumno, ArrayList<Ramo> mallaCurricular, Ramo ramosActuales, String rutAlumno){
        mapaAlumnosNombre.get(nombreAlumno).setMallaCurricular(mallaCurricular);
        mapaAlumnosNombre.get(nombreAlumno).getRamosActuales().add(ramosActuales);
    }
    
    public void mostrarAlumnos(){
        System.out.println("\n[Alumnos de la sede " + this.nombreSede + "]\n");
        if(listaAlumnos.size() == 0){
            System.out.println("No ha ingresado ningun alumno por el momento");
            return;
        }
        else{
            for (int i = 0; i < listaAlumnos.size(); i++) {
                System.out.println("- Nombre: " + listaAlumnos.get(i).getNombreAlumno());
                System.out.print("- Malla: ");
                byte auxComa = 0;

                for (int j = 0; j < listaAlumnos.get(i).getMallaCurricular().size(); j++) {
                    if(auxComa == 1){ System.out.print(" , ");}
                    else{
                        auxComa = 1;
                    }
                    System.out.print(listaAlumnos.get(i).getMallaCurricular().get(j).getNombreRamo());
                }
                System.out.println();
                auxComa = 0;

                if(listaAlumnos.get(i).getRamosActuales().isEmpty() == false){
                    System.out.print("- Ramos actuales: ");
                    
                    for (int j = 0; j < listaAlumnos.get(i).getRamosActuales().size(); j++) {
                        if(auxComa == 1){ System.out.print(" , ");}
                        else{
                            auxComa = 1;
                        }
                        System.out.print(listaAlumnos.get(i).getRamosActuales().get(j).getNombreRamo());
                    }
                }
            }
        }
    }

    public void buscarAlumno(String nombreAlumno) throws IOException{
        System.out.println("Nombre: " + mapaAlumnosNombre.get(nombreAlumno).getNombreAlumno());
        System.out.println("Rut: " + mapaAlumnosNombre.get(nombreAlumno).getRutAlumno());

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Desea buscar mas informacion sobre un ramo de la malla del alumno?");
        System.out.println("1) Buscar informacion un ramo ramo");
        System.out.println("2) salir");

        int opcion = Integer.parseInt(lector.readLine());
        int opcionBuscar;

        if(opcion == 1){
            System.out.println("Como desea buscar el ramo?");
            System.out.println("1) Nombre");
            System.out.println("2) Codigo");

            opcionBuscar = Integer.parseInt(lector.readLine());
            if(opcionBuscar == 1){
                System.out.println("Ingrese el nombre: ");
                String nombreRamo = lector.readLine();

                mapaAlumnosNombre.get(nombreAlumno).buscarRamo(nombreRamo);
            }else{
                System.out.println("Ingrese las 3 letras en MAYUSCULAS del codigo del ramo: ");
                String letrasCodigo = lector.readLine();
                System.out.println("Ingrese los 4 digitos del codigo del ramo: ");
                int digitosCodigo = Integer.parseInt(lector.readLine());

                mapaAlumnosNombre.get(nombreAlumno).buscarRamo(letrasCodigo, digitosCodigo);
            }
        }
    }

    public void buscarAlumno(int digitosRut, String digitoVerificador){
        String rut = String.valueOf(digitosRut) + digitoVerificador;

        System.out.println("Nombre: " + mapaAlumnosRut.get(rut).getNombreAlumno());
        System.out.println("Rut: " + mapaAlumnosRut.get(rut).getRutAlumno());
        
        
    }
}
