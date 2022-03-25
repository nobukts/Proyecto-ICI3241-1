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
            String palabraIngresada = lector.readLine();
            System.out.println("Ingresar el nombre del alumno");
            alumnoActual.setNombreAlumno(palabraIngresada);

            if(palabraIngresada.equals("No")) break;
            
            System.out.println("Ingresar la cantidad de creditos");
            alumnoActual.setCantCreditos(Integer.parseInt(lector.readLine()));

            mapaAlumnos.put(alumnoActual.getNombreAlumno(), alumnoActual);   
        }
        
    }    
}
