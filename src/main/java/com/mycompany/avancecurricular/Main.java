package com.mycompany.avancecurricular;
import java.io.*;
        
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre de la carrera");
        Carrera carreraInformatica = new Carrera(lectorGeneral.readLine());
        
        while(true){
            System.out.println("1) Matricular Alumno");
            System.out.println("2) Eliminar Alumno");
            System.out.println("3) Mostrar lista de alumnos");
            System.out.println("4) Añadir nuevo ramo cursado a un alumno");
            System.out.println("5) Mostrar ramos de las carreras");
            System.out.println("0) Salir del programa");

            switch (Integer.parseInt(lectorGeneral.readLine())) {
                case 1:
                    System.out.println("Ingrese el nombre del alumno");
                    String nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el rut del alumno");
                    int rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                    
                    if(carreraInformatica.agregarAlumno(new Alumno(nombreAlumno, rutAlumno))) 
                        System.out.println("Alumno ingresado");
                    else 
                        System.out.println("Alumno ya estaba matriculado");
                    
                    break;
                case 2:
                    System.out.println("1) Eliminar alumno por rut");
                    System.out.println("2) Eliminar alumno por nombre");
                    switch (Integer.parseInt(lectorGeneral.readLine())) {
                        case 1:
                            if(carreraInformatica.eliminarAlumno(Integer.parseInt(lectorGeneral.readLine())))
                                System.out.println("Se elimino el alumno");
                            else
                                System.out.println("Alumno no matriculado");
                            break;
                        case 2:
                            if(carreraInformatica.eliminarAlumno(lectorGeneral.readLine()))
                                System.out.println("Se elimino el alumno");
                            else
                                System.out.println("Alumno no matriculado");
                            break;
                    }
                    
                    break;
                case 3:
                carreraInformatica.mostrarListaAlumnos();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo");
                    String codigoRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese el nombre del ramo");
                    String nombreRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese la cantidad de creditos que otorga el ramo");
                    int cantCreditos = Integer.parseInt(lectorGeneral.readLine());

                    if(carreraInformatica.agregarRamoActual(nombreAlumno, new Ramo(nombreRamo, codigoRamo, cantCreditos))){
                        System.out.println("Ramo agregado");
                    }
                    else{
                        System.out.println("El ramo ya estaba agregado");
                    }
                    break;
                case 5:
                    carreraInformatica.mostrarRamosCarrera();
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
