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
            System.out.println("1) Ingresar Alumno");
            System.out.println("2) Buscar Alumno");
            System.out.println("3) Mostrar Alumno");
            System.out.println("0) Salir del programa");
            switch(Integer.parseInt(lector.readLine())){
               case 1:
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

                                System.out.println("Ingresar codigo del ramo ingresado de la forma 3 letras y 4 digitos: ");
                                ramoCodigoIngresado = lector.readLine();

                                sedeActual.agregarDatosAlumno(nombreAlumno, new Ramo(ramoIngresado,ramoCodigoIngresado), rutAlumno);
                            }
                        break;
                        
                        case 2:
                            while(true){
                                System.out.println("Ingresar ramo de la malla curricular (Para cancelar escriba \"no\"): ");
                                ramoIngresado = lector.readLine();
                                if(ramoIngresado.equalsIgnoreCase("no")) break;

                                System.out.println("Ingresar codigo del ramo ingresado de la forma 3 letras y 4 digitos: ");
                                ramoCodigoIngresado = lector.readLine();

                                ramosIngresados.add(new Ramo(ramoIngresado,ramoCodigoIngresado));
                            }

                            while(true){
                                System.out.println("Ingresar ramo que esta cursando (Para cancelar escriba \"no\"): ");
                                ramoIngresado = lector.readLine();
                                if(ramoIngresado.equalsIgnoreCase("no")) break;

                                System.out.println("Ingresar codigo del ramo ingresado de la forma 3 letras y 4 digitos: ");
                                ramoCodigoIngresado = lector.readLine();

                                sedeActual.agregarDatosAlumno(nombreAlumno, ramosIngresados,new Ramo(ramoIngresado,ramoCodigoIngresado), rutAlumno);
                            }
                        break;
                    default:
                       System.out.println("Ingreso una opcion invalida");
                        break;
                }
                break;
            case 2:
                System.out.println("Como desea buscar el alumno?");
                System.out.println("1) Nombre");
                System.out.println("2) Rut");
                int opcionBuscar;

                opcionBuscar = Integer.parseInt(lector.readLine());
                if(opcionBuscar == 1){
                    System.out.println("Ingrese el nombre: ");
                    nombreAlumno = lector.readLine();

                    sedeActual.buscarAlumno(nombreAlumno);
                }else{
                    System.out.println("Ingrese los primeros 8 digitos del rut: ");
                    int digitos = Integer.parseInt(lector.readLine());
                    System.out.println("Ingrese el digito verificador: ");
                    String digitoVerificador = lector.readLine();

                    sedeActual.buscarAlumno(digitos, digitoVerificador);
                }
            case 3:
                sedeActual.mostrarAlumnos();
                break;
            case 0:
                return;
            }
        }
    }
}