package com.mycompany.avancecurricular;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader lectorGeneral = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el nombre de la carrera");
        Instituto inst = new Instituto();
        
        while(true){
            System.out.println("1) Agregar Carrera");
            System.out.println("2) Eliminar Carrera");
            System.out.println("3) Matricular Alumno");
            System.out.println("4) Editar Carrera/Alumno/Ramo");
            System.out.println("5) Eliminar Alumno");
            System.out.println("6) Mostrar lista de alumnos de una carrera"); //<---------------------------
            System.out.println("7) Agregar nuevo ramo cursado a un alumno");
            System.out.println("8) Actualizar estado de un ramo de un alumno");
            System.out.println("9) Mostrar ramos de las carreras"); //<---------------------------
            System.out.println("10) Mostrar todas las carreras"); //<---------------------------
            System.out.println("11) Busqueda de ramo");
            System.out.println("12) Importar datos para probar el codigo");
            System.out.println("0) Salir del programa");

            //Creando los archivos
            try{
                File archivo = new File("listaAlumnosXCarrera.txt");
                archivo.createNewFile();
                File archivo2 = new File("ramosXCarrera.txt");
                archivo2.createNewFile();
                File archivo3 = new File("todasLasCarreras.txt");
                archivo3.createNewFile();

            }catch(IOException e){
                e.printStackTrace();
            }

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
                    String nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el rut del alumno");
                    int rutAlumno = Integer.parseInt(lectorGeneral.readLine());
                    System.out.println("Ingresar el nombre de la carrera");
                    String nombreCarrera = lectorGeneral.readLine();
                    
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
                            String nuevoNombreCarrera = lectorGeneral.readLine();
                            if(inst.editarCarrera(nombreCarrera, nuevoNombreCarrera))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro la carrera");
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del alumno");
                            nombreAlumno = lectorGeneral.readLine();
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese el nuevo nombre del alumno");
                            String nuevoNombreAlumno = lectorGeneral.readLine();
                            if(inst.editarAlumno(nombreCarrera, nombreAlumno, nuevoNombreAlumno))
                                System.out.println("Se edito correctamente");
                            else
                                System.out.println("No se encontro al alumno");
                            break;
                        case 3:
                            System.out.println("Ingrese el nombre del alumno");
                            nombreAlumno = lectorGeneral.readLine();
                            System.out.println("Ingrese el nombre de la carrera");
                            nombreCarrera = lectorGeneral.readLine();
                            System.out.println("Ingrese nombre del ramo");
                            String nombreRamo = lectorGeneral.readLine();
                            System.out.println("Ingrese nuevo nombre del ramo");
                            String nuevoNombreRamo = lectorGeneral.readLine();
                            if(inst.editarRamo(nombreCarrera, nombreAlumno, nombreRamo, nuevoNombreRamo))
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
                    inst.mostrarListaAlumnos(lectorGeneral.readLine()); //<-----------------------------------------------------------------------------------------------
                    break;
                case 7:
                    System.out.println("Ingrese el nombre del alumno");
                    nombreAlumno = lectorGeneral.readLine();
                    System.out.println("Ingrese el codigo del ramo");
                    String codigoRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese el nombre del ramo");
                    String nombreRamo = lectorGeneral.readLine();
                    System.out.println("Ingrese la cantidad de creditos que otorga el ramo");
                    int cantCreditos = Integer.parseInt(lectorGeneral.readLine());
                    System.out.println("Ingrese el nombre de la Carrera");
                    nombreCarrera = lectorGeneral.readLine();

                    if(inst.agregarRamoActual(nombreAlumno, new Ramo(nombreRamo, codigoRamo, cantCreditos), nombreCarrera))
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
                    int estadoRamo = Integer.parseInt(lectorGeneral.readLine());
                    System.out.println("Ingrese el nombre de la Carrera");
                    nombreCarrera = lectorGeneral.readLine();
                    
                    if(inst.actualizarRamo(nombreAlumno, codigoRamo, estadoRamo, nombreCarrera)) 
                        System.out.println("Se actualizo el estado");
                    else 
                        System.out.println("No se pudo actualizar la informacion");
                    
                    break;
                case 9:
                    inst.mostrarRamosCarrera(lectorGeneral.readLine()); //<---------------------------------------------------------------------------------
                    break;
                case 10:
                    inst.mostrarCarreras(); //<------------------------------------------------------------------------------------------------------------
                    break;
                case 11:
                    System.out.println("Ingrese el nombre del ramo");
                    nombreRamo = lectorGeneral.readLine();
                    
                    if(inst.buscarRamo(nombreRamo)){
                        System.out.println("Encontrado");
                    }else{
                        System.out.println("No se pudo buscar el ramo");
                    }
                    break;
                case 12:
                    CSV datosCSV = new CSV("importarDatos");
                    String linea = datosCSV.firstLine();
                    linea = datosCSV.nextLine();
                    
                    //Agregar carrera
                    if(inst.agregarCarrera(new Carrera(datosCSV.get_csvField(linea, 0)))){
                        System.out.println("La carrera se ingreso sin ningun problema");
                    }
                    else{
                        System.out.println("La carrera ya se encuentra ingresada");
                    }
                    
                    //Matricular alumno
                    while(true){
                        nombreAlumno = datosCSV.get_csvField(linea, 1);
                        rutAlumno = Integer.parseInt(datosCSV.get_csvField(linea, 2));
                        nombreCarrera = datosCSV.get_csvField(linea, 0);
                        if(inst.agregarAlumno(new Alumno(nombreAlumno, rutAlumno), nombreCarrera)) 
                            System.out.println("Alumno ingresado");
                        else 
                            System.out.println("Alumno ya estaba matriculado " + nombreAlumno);
                        linea = datosCSV.nextLine();
                        if(linea == null) break;
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
