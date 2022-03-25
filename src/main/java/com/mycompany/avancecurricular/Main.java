/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.avancecurricular;
import java.io.* ;
/**
 *
 * @author Nobu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        //Vamos a inicializar las variables
        String datoIngresado;
        int tamañoArreglo;

        System.out.println("Ingrese la cantidad de alumnos:");
        tamañoArreglo = Integer.parseInt(lector.readLine());
        Alumno[] listaAlumnos = new Alumno[tamañoArreglo];

        //De momento los ramos seran siempre los mismos
        String[] malla = {"ICI3241" , "ICI3243" , "EST3107"};

        for(int i=0 ; i < listaAlumnos.length; i++){
            System.out.println("Ingrese el alumno " + (i+1) + "/" + listaAlumnos.length + ":");
            listaAlumnos[i] = new Alumno();
            listaAlumnos[i].setNombreAlumno(lector.readLine());

            listaAlumnos[i].setMallaCurricular(malla);
        }

        for(int i=0 ; i < listaAlumnos.length; i++){
            System.out.print("El alumno " + (i+1) + "/" + listaAlumnos.length + ": ");
            System.out.println(listaAlumnos[i].getNombreAlumno());
            System.out.print("Su malla es: ");
            for(int k=0 ; k < 3; k++){
                String[] mallaAux = new String[3];
                mallaAux = listaAlumnos[i].getMallaCurricular();
                System.out.println(mallaAux[k]);
            }

        }

    }
    
}
