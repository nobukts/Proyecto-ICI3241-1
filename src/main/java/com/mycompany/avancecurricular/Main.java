package com.mycompany.avancecurricular;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Instituto sedeActual = new Instituto("FIN");
        int contAlumnos = 1;

        while(true){
            System.out.print("Ingrese el nombre del alumno " + contAlumnos + " a agregar, para cancelar coloque \"no\": ");
            String nombreAlumno = lector.readLine();
            if(nombreAlumno.equalsIgnoreCase("no")) break;

            Alumno alumnoIngresado = new Alumno(nombreAlumno);
            sedeActual.agregarAlumnos(alumnoIngresado);
            contAlumnos++;

            System.out.println("1) Solo malla curricular");
            System.out.println("2) Malla curricular y cursos actuales");

            switch(Integer.parseInt(lector.readLine())){
                case 1:
                    while(true){
                        System.out.println("Ingresar ramo de la malla curricular");
                        String ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        sedeActual.agregarDatosAlumno(nombreAlumno, new Ramo(ramoIngresado));
                    }
                    break;
            }
        }

        sedeActual.mostrarAlumnos();
    }
}
