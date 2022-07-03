package Clases;

import java.io.*;
import java.util.ArrayList;

import Interfaces.FormatoSalida;

public class FormaEspecial implements FormatoSalida {
    public void crearReporte(String infoCarreras, String infoAlumnos, String infoCursos, ArrayList<String> infoObtenida){
        //Se crea el archivo reporte
        try{
            File archivo = new File("reporte.txt");
            archivo.createNewFile();
        }catch(IOException e){
        }

        //Se imprime en el archivo reporte
        try{
            try (FileWriter archivo = new FileWriter("reporte.txt")) {
                String[] infoSeparada;

                archivo.write("Nombres alumnos + RUT alumnos + Cantidad creditos\n");
                archivo.write(infoAlumnos);
                
                archivo.write("---------------------------------------------\n");
                archivo.write("Nombre de la carrera + Cantidad Alumnos\n");
                archivo.write(infoCarreras);
                
                archivo.write("---------------------------------------------\n");
                archivo.write("OBLIGATORIO\n");
                archivo.write("Nombre del curso               + Codigo del curso + Cantidad de creditos + Carrera o Escuela + cantidad de alumnos + Es de primero?\n");
                archivo.write(infoCursos);

                archivo.write("OPCIONAL\n");
                archivo.write("Nombre del curso               + Codigo del curso + Cantidad de creditos + Carrera o Escuela + cantidad de alumnos + Es de primero?\n");
                
                for(int i = 0 ; i < infoObtenida.size() ; i++){
                    infoSeparada = infoObtenida.get(i).split("-");
                    if(infoSeparada[6].equals("Opcional")){
                        archivo.write(String.format("[%-30s] + [%-16s] + [%-20s] + [%-17s] + [%-19s] + [%-14s]\n",infoSeparada[0],infoSeparada[1],infoSeparada[2],infoSeparada[3],infoSeparada[4],infoSeparada[5]));
                    }
                    
                }
            }
        }catch(IOException e){
        }
    }
}
