package com.mycompany.avancecurricular;
import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Alumno> mapaAlumnos = new HashMap<>();
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            Alumno alumnoActual = new Alumno();
            System.out.println("Ingresar el nombre del alumno (o \"no\" para dejar de agregar alumnos)");
            String palabraIngresada = lector.readLine();
            alumnoActual.setNombreAlumno(palabraIngresada);

            if(palabraIngresada.equalsIgnoreCase("no")) break;
            
            System.out.println("Ingresar la cantidad de creditos");
            alumnoActual.setCantCreditos(Integer.parseInt(lector.readLine()));

            mapaAlumnos.put(alumnoActual.getNombreAlumno(), alumnoActual);   
        }
        
        for (String clave: mapaAlumnos.keySet()) {
            System.out.println(mapaAlumnos.get(clave).getNombreAlumno() + " " + mapaAlumnos.get(clave).getCantCreditos());
        }
    }    
}
