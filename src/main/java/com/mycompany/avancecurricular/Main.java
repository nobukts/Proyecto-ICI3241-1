package com.mycompany.avancecurricular;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingresar el nombre del instituto");
        Instituto sedeActual = new Instituto(lector.readLine());
        int contAlumnos = 1;

        while(true){
            System.out.print("Ingrese el nombre del alumno " + contAlumnos + " a agregar, para cancelar coloque \"no\": ");
            String nombreAlumno = lector.readLine();
            if(nombreAlumno.equalsIgnoreCase("no")) break;

            System.out.print("Ingrese el rut del alumno " + contAlumnos + " a agregar (Sin puntos ni guión Ej: 12345678k): ");
            String rutAlumno = lector.readLine();

            Alumno alumnoIngresado = new Alumno(nombreAlumno,rutAlumno);
            sedeActual.agregarAlumnos(alumnoIngresado);
            contAlumnos++;

            System.out.println("1) Solo malla curricular");
            System.out.println("2) Malla curricular y cursos actuales");

            String ramoIngresado;
            ArrayList<Ramo> ramosIngresados = new ArrayList<>();

            switch(Integer.parseInt(lector.readLine())){
                case 1:
                    while(true){
                        System.out.println("Ingresar ramo de la malla curricular");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        sedeActual.agregarDatosAlumno(nombreAlumno, new Ramo(ramoIngresado));
                    }
                    break;
                case 2:
                    while(true){
                        System.out.println("Ingresar ramo de la malla curricular");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;
                        ramosIngresados.add(new Ramo(ramoIngresado));
                    }
                    
                    while(true){
                        System.out.println("Ingresar ramo que esta cursando");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        sedeActual.agregarDatosAlumno(nombreAlumno, ramosIngresados,new Ramo(ramoIngresado));
                    }
                    break;
                default:
                    System.out.println("Ingreso una opcion invalida");
                    break;
            }
        }

        sedeActual.mostrarAlumnos();
    }
}
