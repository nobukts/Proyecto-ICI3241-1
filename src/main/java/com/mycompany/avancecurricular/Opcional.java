package com.mycompany.avancecurricular;

public class Opcional extends Asignatura{
    String escuela;
    
    public Opcional(){
    }
    
    public Opcional(String nombre, String codigo, int totalCreditos, String escuela){
        super(nombre, codigo, totalCreditos);
        this.escuela = escuela;
    }    

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    
    public void mostrarInformacion(){
        System.out.print("Nombre del Ramo: " + this.getNombreCurso() + "Lo imparte: " + escuela + " Cantidad de alumnos: " + this.getCantidadAlumnos());
        System.out.println(" Es OPCIONAL");
    }
    
    @Override
    public void cambiarInformacion(String nombreRamo, String nombreImpartido){
        this.setNombreCurso(nombreRamo);
        this.setEscuela(nombreImpartido);
    }
}
