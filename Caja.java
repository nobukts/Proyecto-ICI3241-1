import java.io.*;

public class Caja {
    public static void main(String args[]) throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        //Lee el dato por el lector
        int tamañoArreglo;

        System.out.println("Ingrese la cantidad de alumnos:");
        tamañoArreglo = Integer.parseInt(lector.readLine());

        Alumno[] listaAlumnos = new Alumno[tamañoArreglo];

        //Rellenar los alumnos
        for(int i=0 ; i < listaAlumnos.length; i++){
            System.out.print("Ingrese el alumno " + (i+1) + "/" + listaAlumnos.length + ":");
            listaAlumnos[i] = new Alumno();
            listaAlumnos[i].setNombreAlumno(lector.readLine());
        }

        for(int i=0 ; i < listaAlumnos.length; i++){
            System.out.println(listaAlumnos[i].getNombreAlumno());
        }

        System.out.println("Ingrese la cantidad de ramos:");
        tamañoArreglo = Integer.parseInt(lector.readLine());

        Ramo[] listaRamos = new Ramo[tamañoArreglo];

        //Rellenar los ramos
        for(int i=0 ; i < listaRamos.length; i++){
            System.out.print("Ingrese el ramo " + (i+1) + "/" + listaRamos.length + ":");
            listaRamos[i] = new Ramo();
            listaRamos[i].setNombreRamo(lector.readLine());
        }

        for(int i=0 ; i < listaRamos.length; i++){
            System.out.println(listaRamos[i].getNombreRamo());
        }

    }  
}
