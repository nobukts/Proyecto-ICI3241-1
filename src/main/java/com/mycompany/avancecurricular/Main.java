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
            System.out.println("Ingrese el nombre del alumno " + contAlumnos + " a agregar, para cancelar coloque \"no\": ");
            String nombreAlumno = lector.readLine();
            if(nombreAlumno.equalsIgnoreCase("no")) break;

            System.out.println("Ingrese el rut del alumno " + contAlumnos + " a agregar (Sin puntos ni guión Ej: 12345678k): ");
            String rutAlumno = lector.readLine();

            Alumno alumnoIngresado = new Alumno(nombreAlumno,rutAlumno);
            sedeActual.agregarAlumnos(alumnoIngresado);
            contAlumnos++;

            System.out.println("Eliga la opcion para agregar los datos correspondientes al alumno");
            System.out.println("1) Solo malla curricular");
            System.out.println("2) Malla curricular y cursos actuales");

            String ramoIngresado;
            String ramoCodigoIngresado;
            ArrayList<Ramo> ramosIngresados = new ArrayList<>();

            switch(Integer.parseInt(lector.readLine())){
                case 1:
                    while(true){
                        System.out.println("Ingresar ramo de la malla curricular (Para cancelar escriba \"no\"): ");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        System.out.println("Ingresar codigo del ramo ingresado: ");
                        ramoCodigoIngresado = lector.readLine();

                        sedeActual.agregarDatosAlumno(nombreAlumno, new Ramo(ramoIngresado,ramoCodigoIngresado), rutAlumno);
                    }
                    break;
                case 2:
                    while(true){
                        System.out.println("Ingresar ramo de la malla curricular (Para cancelar escriba \"no\"): ");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        System.out.println("Ingresar codigo del ramo ingresado: ");
                        ramoCodigoIngresado = lector.readLine();

                        ramosIngresados.add(new Ramo(ramoIngresado,ramoCodigoIngresado));
                    }
                    
                    while(true){
                        System.out.println("Ingresar ramo que esta cursando (Para cancelar escriba \"no\"): ");
                        ramoIngresado = lector.readLine();
                        if(ramoIngresado.equalsIgnoreCase("no")) break;

                        System.out.println("Ingresar codigo del ramo ingresado: ");
                        ramoCodigoIngresado = lector.readLine();

                        sedeActual.agregarDatosAlumno(nombreAlumno, ramosIngresados,new Ramo(ramoIngresado,ramoCodigoIngresado), rutAlumno);
                    }
                    break;
                default:
                    System.out.println("Ingreso una opcion invalida");
                    break;
            }
        }

        while(true){
            System.out.println("Funcionalidad (Ingrese el número de la opción):");
            System.out.println("1) Buscar alumnos");
            System.out.println("2) Salir");

            int opcion;
            int opcionBuscar;
            opcion = Integer.parseInt(lector.readLine());
            if(opcion == 1){
                System.out.println("Como desea buscar el alumno?");
                System.out.println("1) Nombre");
                System.out.println("2) Rut");

                opcionBuscar = Integer.parseInt(lector.readLine());
                if(opcionBuscar == 1){
                    System.out.println("Ingrese el nombre: ");
                    String nombreAlumno = lector.readLine();

                    sedeActual.buscarAlumno(nombreAlumno);
                }else{
                    System.out.println("Ingrese los primeros 8 digitos del rut: ");
                    int digitos = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese el digito verificador: ");
                    String digitoVerificador = lector.readLine();

                    sedeActual.buscarAlumno(digitos, digitoVerificador);
                }
            }else{
                break;
                
            }
        }

        
        

        sedeActual.mostrarAlumnos();
    }
}