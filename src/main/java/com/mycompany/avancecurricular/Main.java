package com.mycompany.avancecurricular;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));
        Instituto inst = new Instituto();
      
        //Variables primitivas a usar
        String codigoAsignatura, nombreAsignatura, nombreAlumno, nombreCarrera, nuevoNombre;
        int rutAlumno, estadoRamo, cantCreditos;

        while(true){
            System.out.println("1) Agregar Carrera");
            System.out.println("2) Eliminar Carrera");
            System.out.println("3) Matricular Alumno");
            System.out.println("4) Editar Carrera/Alumno/Asignatura");
            System.out.println("5) Eliminar Asignatura");
            System.out.println("6) Eliminar Alumno");
            System.out.println("7) Mostrar lista de alumnos de una carrera"); 
            System.out.println("8) Agregar ramo que no pertenece a la malla curricular");
            System.out.println("9) Actualizar estado de un ramo de un alumno");
            System.out.println("10) Mostrar asignaturas de las carreras"); 
            System.out.println("11) Mostrar todas las carreras"); 
            System.out.println("12) Busqueda de una asignatura");
            System.out.println("13) Crear reporte");
            System.out.println("0) Salir del programa");
            System.out.println("Consejo: Consideres las mayusculas y minusculas");

            switch (Integer.parseInt(lectorGeneral.readLine())) {
                case 1:
                    System.out.println("Ingrese el nombre de la carrera");
                    if(inst.agregarCarrera(new Carrera(lectorGeneral.readLine()))){
                        System.out.println("La carrera se ingreso sin ningun problema");
                    }
                    else{
                        System.out.println("La carrera no se pudo agregar correctamente");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la carrera");
                    if(inst.eliminarCarrera(lectorGeneral.readLine())){
                        System.out.println("La carrera se elimino con exito");
                    }
                    else{
                        System.out.println("La carrera no se pudo eliminar correctamente");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el rut del alumno (Sin digito verificador)");
                    rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                    System.out.println("Ingresar el nombre de la carrera");
                    nombreCarrera = lectorGeneral.readLine();
                    
                    if(inst.matricularAlumno(new Alumno(nombreAlumno, rutAlumno), nombreCarrera)) 
                        System.out.println("Alumno ingresado");
                    else 
                        System.out.println("Alumno no se pudo matricular correctamente");
                    
                    break;
                case 4:
                    System.out.println("1) Editar nombre Carrera");
                    System.out.println("2) Editar nombre Alumno");
                    System.out.println("3) Editar nombre Asignatura");
                    switch (Integer.parseInt(lectorGeneral.readLine())){
                        case 1:
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese el nuevo nombre de la carrera");
                            nuevoNombre = lectorGeneral.readLine();
                            if(inst.editarCarrera(nombreCarrera, nuevoNombre))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro la carrera");
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del alumno");
                            nombreAlumno = lectorGeneral.readLine();
                            System.out.println("Ingrese el nuevo nombre del alumno");
                            nuevoNombre = lectorGeneral.readLine();
                            if(inst.editarAlumno(nombreAlumno, nuevoNombre))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro al alumno");
                            break;
                        case 3:
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese codigo de la asignatura (Formato XXX000)");
                            codigoAsignatura = lectorGeneral.readLine();
                            System.out.println("Ingrese nuevo nombre de la asignatura");
                            nuevoNombre = lectorGeneral.readLine();
                            if(inst.editarAsignatura(nombreCarrera, codigoAsignatura, nuevoNombre))
                                System.out.println("Editado correctamente");
                            else
                                System.out.println("No se encontro la asignatura");
                            break;    
                    }
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la carrera");
                    nombreCarrera = lectorGeneral.readLine();
                    System.out.println("Ingrese codigo de la asignatura");
                    codigoAsignatura = lectorGeneral.readLine();
                    if(inst.eliminarAsignatura(nombreCarrera, codigoAsignatura))
                        System.out.println("Asignatura eliminado correctamente");
                    else
                        System.out.println("No se encontro la asignatura");
                    break;
                case 6:
                    System.out.println("1) Eliminar alumno por rut");
                    System.out.println("2) Eliminar alumno por nombre");
                    switch (Integer.parseInt(lectorGeneral.readLine())) {
                        case 1:
                            System.out.println("Ingrese el rut del alumno (Sin digito verificador)");
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
                case 7:
                    System.out.println("Ingresar nombre de la carrera");
                    inst.mostrarListaAlumnos(lectorGeneral.readLine());
                    break;
                case 8:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo (Formato XXX000)");
                    codigoAsignatura = lectorGeneral.readLine();
                    System.out.println("Ingrese el nombre del ramo");
                    nombreAsignatura = lectorGeneral.readLine();
                    System.out.println("Ingrese la cantidad de creditos que otorga el ramo");
                    cantCreditos = Integer.parseInt(lectorGeneral.readLine());

                    if(inst.agregarRamoOpcional(nombreAlumno, new Ramo(nombreAsignatura, codigoAsignatura, cantCreditos)))
                        System.out.println("Ramo agregado");
                    else
                        System.out.println("El ramo no se pudo agregar correctamente");
                    
                    break;
                case 9:
                    System.out.println("Ingrese nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo (Formato XXX000)");
                    codigoAsignatura = lectorGeneral.readLine();
                    System.out.println("Ingrese el estado del ram (0 = por cursar, 1 = cursando, 2 = aprobado)");
                    estadoRamo = Integer.parseInt(lectorGeneral.readLine());
                    
                    if(inst.actualizarRamo(nombreAlumno, codigoAsignatura, estadoRamo)) 
                        System.out.println("Se actualizo el estado");
                    else 
                        System.out.println("No se pudo actualizar la informacion");
                    
                    break;
                case 10:
                    System.out.println("Ingresar el nombre de la carrera");
                    inst.mostrarAsignaturasCarrera(lectorGeneral.readLine());
                    break;
                case 11:
                    inst.mostrarCarreras();
                    break;
                case 12:
                    System.out.println("Ingrese el codigo de la asignatura (Formato XXX000)");
                    codigoAsignatura = lectorGeneral.readLine();
                    
                    if(!inst.buscarAsignatura(codigoAsignatura)){
                        System.out.println("Hubo un problema en la busqueda");
                    }
                    break;
                case 13:
                    inst.crearReporte();
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
