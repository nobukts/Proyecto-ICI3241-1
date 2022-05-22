package com.mycompany.avancecurricular;

public class Obligatorio extends Asignatura{
    String carrera;
    
    public Obligatorio(){
        
    }
    
    public Obligatorio(String nombre, String codigo, int totalCreditos, boolean esDePrimero ,String carrera){
        super(nombre, codigo, totalCreditos, esDePrimero);
        this.carrera = carrera;
    }    

    //Getter
    public String getCarrera() {
        return carrera;
    }

    //Setter
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * Metodo que muestra la informacion de la asignatura obligatoria
     */
    @Override
    public void mostrarInformacion(){
        System.out.print("Nombre del Ramo: " + this.getNombreCurso() + " Carrera: " + carrera + " Cantidad de alumnos: " + this.getCantidadAlumnos()); 
        System.out.println(" Es OBLIGATORIO");
    }
    
    /**
     * Metodo que cambia la informacion de la asignatura obligatoria
     * @param nombreRamo String que contiene el nombre de la asignatura
     * @param nombreImpartido String que contiene en este caso, la carrera a la que pertenece este ramo
     */
    @Override
    public void cambiarInformacion(String nombreRamo, String nombreImpartido){
        this.setNombreCurso(nombreRamo);
        this.setCarrera(nombreImpartido);
    }
}
