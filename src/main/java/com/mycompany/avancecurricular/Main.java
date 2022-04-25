package com.mycompany.avancecurricular;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));

        Instituto inst = new Instituto();
        
        //Variables primitivas a usar
        String codigoRamo, nombreRamo, nombreAlumno, nombreCarrera, nuevoNombreAlumno, nuevoNombreCarrera, nuevoNombreRamo;
        int rutAlumno, estadoRamo;

        while(true){
            System.out.println("1) Agregar Carrera");
            System.out.println("2) Eliminar Carrera");
            System.out.println("3) Matricular Alumno");
            System.out.println("4) Editar Carrera/Alumno/Ramo");
            System.out.println("5) Eliminar Alumno");
            System.out.println("6) Mostrar lista de alumnos de una carrera"); 
            System.out.println("7) Agregar nuevo ramo cursado a un alumno");
            System.out.println("8) Actualizar estado de un ramo de un alumno");
            System.out.println("9) Mostrar ramos de las carreras"); 
            System.out.println("10) Mostrar todas las carreras"); 
            System.out.println("11) Busqueda de ramo");
            System.out.println("0) Salir del programa");

            switch (Integer.parseInt(lectorGeneral.readLine())) {
                case 1:
                    System.out.println("Ingrese el nombre de la carrera");
                    if(inst.agregarCarrera(new Carrera(lectorGeneral.readLine()))){
                        System.out.println("La carrera se ingreso sin ningun problema");
                    }
                    else{
                        System.out.println("La carrera ya se encuentra ingresada");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carrera");
                    if(inst.eliminarCarrera(lectorGeneral.readLine())){
                        System.out.println("La carrera se elimino con exito");
                    }
                    else{
                        System.out.println("La carrera no se pudo eliminar");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el rut del alumno");
                    rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                    System.out.println("Ingresar el nombre de la carrera");
                    nombreCarrera = lectorGeneral.readLine();
                    
                    if(inst.agregarAlumno(new Alumno(nombreAlumno, rutAlumno), nombreCarrera)) 
                        System.out.println("Alumno ingresado");
                    else 
                        System.out.println("Alumno ya estaba matriculado");
                    
                    break;
                case 4:
                    System.out.println("1) Editar nombre Carrera");
                    System.out.println("2) Editar nombre Alumno");
                    System.out.println("3) Editar nombre Ramo");
                    switch (Integer.parseInt(lectorGeneral.readLine())){
                        case 1:
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese el nuevo nombre de la carrera");
                            nuevoNombreCarrera = lectorGeneral.readLine();
                            if(inst.editarCarrera(nombreCarrera, nuevoNombreCarrera))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro la carrera");
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del alumno");
                            nombreAlumno = lectorGeneral.readLine();
                            System.out.println("Ingrese el nuevo nombre del alumno");
                            nuevoNombreAlumno = lectorGeneral.readLine();
                            if(inst.editarAlumno(nombreAlumno, nuevoNombreAlumno))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro al alumno");
                            break;
                        case 3:
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese codigo del ramo");
                            codigoRamo = lectorGeneral.readLine();
                            System.out.println("Ingrese nuevo nombre del ramo");
                            nuevoNombreRamo = lectorGeneral.readLine();
                            if(inst.editarRamo(nombreCarrera, codigoRamo, nuevoNombreRamo))
                                System.out.println("Editado correctamente");
                            else
                                System.out.println("No se encontro el ramo");
                            break;    
                    }
                    break;
                case 5:
                    System.out.println("1) Eliminar alumno por rut");
                    System.out.println("2) Eliminar alumno por nombre");
                    switch (Integer.parseInt(lectorGeneral.readLine())) {
                        case 1:
                            System.out.println("Ingrese el rut del alumno");
                            rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            if(inst.eliminarAlumno(rutAlumno, nombreCarrera))
                                System.out.println("Se elimino el alumno");
                            else
                                System.out.println("Alumno no matriculado");
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del alumno");
                            nombreAlumno = lectorGeneral.readLine();
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            if(inst.eliminarAlumno(nombreAlumno, nombreCarrera))
                                System.out.println("Se elimino el alumno");
                            else
                                System.out.println("Alumno no matriculado");
                            break;
                    }
                    
                    break;
                case 6:
                    System.out.println("Ingresar nombre de la carrera");
                    inst.mostrarListaAlumnos(lectorGeneral.readLine());
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo");
                    codigoRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese el nombre del ramo");
                    nombreRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese la cantidad de creditos que otorga el ramo");
                    int cantCreditos = Integer.parseInt(lectorGeneral.readLine());

                    if(inst.agregarRamoActual(nombreAlumno, new Ramo(nombreRamo, codigoRamo, cantCreditos)))
                        System.out.println("Ramo agregado");
                    else
                        System.out.println("El ramo ya estaba agregado");
                    
                    break;
                case 8:
                    System.out.println("Ingrese nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo");
                    codigoRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese el estado del ram (0 = por cursar, 1 = cursando, 2 = aprobado)");
                    estadoRamo = Integer.parseInt(lectorGeneral.readLine());
                    
                    if(inst.actualizarRamo(nombreAlumno, codigoRamo, estadoRamo)) 
                        System.out.println("Se actualizo el estado");
                    else 
                        System.out.println("No se pudo actualizar la informacion");
                    
                    break;
                case 9:
                    System.out.println("Ingresar el nombre de la carrera");
                    inst.mostrarRamosCarrera(lectorGeneral.readLine());
                    break;
                case 10:
                    inst.mostrarCarreras();
                    break;
                case 11:
                    System.out.println("Ingrese el codigo del ramo");
                    codigoRamo = lectorGeneral.readLine();
                    
                    if(inst.buscarRamo(codigoRamo)){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No se pudo buscar el ramo");
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
