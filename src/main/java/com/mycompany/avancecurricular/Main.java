package com.mycompany.avancecurricular;
import java.io.*;
        
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));

        Carrera carreraInformatica = new Carrera("Ingenieria en informatica");
        
        while(true){
            System.out.println("1) Matricular Alumno");
            System.out.println("2) Mostrar lista de alumnos");
            System.out.println("3) Eliminar Alumno");
            System.out.println("0) Salir del programa");

            switch (Integer.parseInt(lectorGeneral.readLine())) {
                case 1:
                    System.out.println("Ingrese el nombre del alumno");
                    String nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el rut del alumno");
                    int rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                    
                    if(carreraInformatica.agregarAlumno(new Alumno(nombreAlumno, rutAlumno))){
                        System.out.println("Alumno ingresado");
                    }
                    else{
                        System.out.println("Alumno ya estaba matriculado");
                    }
                    break;
                
                case 2:
                    carreraInformatica.mostrarListaAlumnos();
                    break;
                
                case 3:
                    if(carreraInformatica.eliminarAlumno(lectorGeneral.readLine())){
                        System.out.println("Se elimino el alumno");
                    }
                    else{
                        System.out.println("Alumno no matriculado");
                    }
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
