package com.mycompany.avancecurricular;
import java.io.*;
        
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));

        Carrera carreraInformatica = new Carrera("Ingenieria en informatica");
        
        while(true){
            System.out.println("1) Matricular Alumno");
            System.out.println("2) Mostrar lista de alumnos");
            System.out.println("0) Salir del programa");

            switch (Integer.parseInt(lectorGeneral.readLine())) {
                case 1:
                    String nombreAlumno = "a";
                    while(!nombreAlumno.equalsIgnoreCase("no")){
                        System.out.println("Ingrese el nombre del alumno, para parar ingrese \"no\"");
                        nombreAlumno = lectorGeneral.readLine();
                        if(nombreAlumno.equalsIgnoreCase("no")) break;
                        carreraInformatica.agregarAlumno(nombreAlumno);
                    }
                    break;
                
                case 2:
                    carreraInformatica.mostrarListaAlumnos();
                    break;
                
                case 0:
                    System.out.println("Salio del programa con exito");
                    return;
    
                default:
                    System.out.println("Ingreso una opcion invalida");
                    break;
            }
        }

    }
}
