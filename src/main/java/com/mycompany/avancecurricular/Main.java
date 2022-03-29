package com.mycompany.avancecurricular;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Instituto sedeActual = new Instituto("FIN");
        int contAlumnos = 1;
        while(true){
            System.out.print("Ingrese el nombre del alumno " + contAlumnos + " a agregar, para cancelar coloque \"no\": ");
            String palabraIngresada = lector.readLine();
            if(palabraIngresada.equalsIgnoreCase("no")) break;
            Alumno alumnoIngresado = new Alumno(palabraIngresada);
            sedeActual.agregarAlumnos(alumnoIngresado);
            contAlumnos++;
        }

        sedeActual.mostrarAlumnos();
    }
}
