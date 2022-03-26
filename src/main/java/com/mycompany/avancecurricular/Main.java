package com.mycompany.avancecurricular;
import java.io.* ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Alumno> mapaAlumnos = new HashMap<>();
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int cont = 0;

        //Se usaran los mismos ramos para todos de momento
        Ramo ramo1 = new Ramo("BASE DE DATOS","ICI2340","RICARDO GONZALES",3,10);
        Ramo ramo2 = new Ramo("PROGRAMACION AVANZADA","ICI4150","PABLO ESCAMILLA",4,5);
        Ramo ramo3 = new Ramo("MATEMATICAS","MAT1150","SARA TORRES",3,20);
        ArrayList<Ramo> mallaCurricularAux = new ArrayList<Ramo>();
        mallaCurricularAux.add(ramo1);
        mallaCurricularAux.add(ramo2);
        mallaCurricularAux.add(ramo3);
        ArrayList<Ramo> ramosVaciosAux = new ArrayList<Ramo>();
        String palabraIngresada = new String();

        while(true){
            cont++;
            Alumno alumnoActual = new Alumno();
            System.out.println("Ingresar el nombre del alumno " + cont + "/? (o \"no\" para dejar de agregar alumnos)");
            palabraIngresada = lector.readLine();
            alumnoActual.setNombreAlumno(palabraIngresada);

            if(palabraIngresada.equalsIgnoreCase("no")) break;
            
            System.out.println("Ingresar la cantidad de creditos del alumno " + cont);
            alumnoActual.setCantCreditos(Integer.parseInt(lector.readLine()));

            alumnoActual.setMallaCurricular(mallaCurricularAux);
            alumnoActual.setRamosActuales(mallaCurricularAux);
            alumnoActual.setRamosAprobados(ramosVaciosAux);
            alumnoActual.setRamosFaltantes(ramosVaciosAux);

            mapaAlumnos.put(alumnoActual.getNombreAlumno(), alumnoActual);
        }
        
        cont = 0;

        for (String clave: mapaAlumnos.keySet()) {
            cont++;
            System.out.println("Alumno " + cont + ": " + mapaAlumnos.get(clave).getNombreAlumno() + " (" + mapaAlumnos.get(clave).getCantCreditos() + " creditos) Malla: ");
            
            Iterator itr=mapaAlumnos.get(clave).getMallaCurricular().iterator();
            while(itr.hasNext()){
                Ramo ramoMostrar=(Ramo)itr.next();
                System.out.println(ramoMostrar.getNombreRamo() + " / "+ramoMostrar.getCodigoRamo() + " / " + ramoMostrar.getNombreProfesor());
            }
            

        }
    }    
}
