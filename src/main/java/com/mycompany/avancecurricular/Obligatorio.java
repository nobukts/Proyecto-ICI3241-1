package com.mycompany.avancecurricular;

public class Obligatorio extends Asignatura{
    String carrera;
    public Obligatorio(){
        
    }
    
    public Obligatorio(String nombre, String codigo, int totalCreditos, boolean esDePrimero ,String carrera){
        super(nombre, codigo, totalCreditos, esDePrimero);
        this.carrera = carrera;
    }    

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public void mostrarInformacion(){
        System.out.print("Nombre del Ramo: " + this.getNombreCurso() + " Carrera: " + carrera); 
        System.out.println(" Es OBLIGATORIO");
    }
    
    /**
     *
     * @param nombreRamo
     * @param nombreImpartido
     */
    public void cambiarInformacion(String nombreRamo, String nombreImpartido){
        this.setNombreCurso(nombreRamo);
        this.setCarrera(nombreImpartido);
    }
}
