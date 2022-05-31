package Ventanas;

import Clases.*;

public class Main {
    public static void main(String[] args){
        Instituto inst = new Instituto();
        
        inst.agregarCarrera("Programacion");
        inst.agregarCarrera("Medicina");
        
        inst.agregarMalla(new Obligatorio("Programacion basica", "ICI111", 5, true, "Progamacion"), "Programacion");
        inst.agregarMalla(new Obligatorio("Programacion avanzada", "ICI222", 5, false, "Progamacion"), "Programacion");
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
            System.out.println("4) Editar Carrera/Alumno/Asignatura");
            System.out.println("9) Actualizar estado de un ramo de un alumno");
        }*/
    }
}
