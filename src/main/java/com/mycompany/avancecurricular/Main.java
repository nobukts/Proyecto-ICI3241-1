package com.mycompany.avancecurricular;
import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Alumno> mapaAlumnos = new HashMap<>();
        Alumno alumnoActual = new Alumno();
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            System.out.println("Ingresar el nombre del alumno");
            String palabraIngresada = lector.readLine();
            alumnoActual.setNombreAlumno(palabraIngresada);

            if(palabraIngresada.equals("No")) break;
            
            System.out.println("Ingresar la cantidad de creditos");
            alumnoActual.setCantCreditos(Integer.parseInt(lector.readLine()));

            mapaAlumnos.put(alumnoActual.getNombreAlumno(), alumnoActual);   
        }
        
    }    
}
