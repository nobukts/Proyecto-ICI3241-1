package Ventanas;

import Clases.*;

public class Main {
    public static void main(String[] args){
        Instituto inst = new Instituto();
        
        inst.agregarCarrera("Programacion");
        inst.agregarCarrera("Medicina");
        
        inst.agregarMalla(new Obligatorio("Programacion basica", "ICI111", 5, true, "Progamacion"), "Programacion");
        inst.agregarMalla(new Obligatorio("Biologia basica", "BIO111", 5, true, "Medicina"), "Medicina");
        
        inst.matricularAlumno(new Alumno("Jose", 20972384), "Programacion");
        inst.matricularAlumno(new Alumno("Perez", 20932384), "Programacion");
        inst.matricularAlumno(new Alumno("Alva", 20973234), "Programacion");
        inst.matricularAlumno(new Alumno("Rick", 20932324), "Medicina");
        
        inst.agregarRamoOpcional("Jose", new Ramo("Principio de poesia estricta", "LEN201", 3) , "Lengua");
        inst.agregarRamoOpcional("Alva", new Ramo("Principios de la biblia", "TEO321", 2) , "Teologia");
        inst.agregarRamoOpcional("Rick", new Ramo("Programacion en Java", "ICI232", 4) , "Informatica");
        
        MenuPrincipal menuP = new MenuPrincipal(inst);
        menuP.setVisible(true);
        
        /*
        while(true){
            System.out.println("2) Eliminar Carrera");
            System.out.println("4) Editar Carrera/Alumno/Asignatura");
            System.out.println("5) Eliminar Asignatura");
            System.out.println("6) Eliminar Alumno");
            System.out.println("9) Actualizar estado de un ramo de un alumno");
            System.out.println("10) Mostrar asignaturas de las carreras"); 
            System.out.println("12) Busqueda de una asignatura");
            System.out.println("13) Crear reporte");
            System.out.println("14) Buscar al alumno con menos creditos de cada carrera");
            System.out.println("15) Buscar alumnos segun rango de cantidad de creditos");
        }*/
    }
}
