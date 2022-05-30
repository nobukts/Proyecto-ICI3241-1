package Clases;

public class Opcional extends Asignatura{
    String escuela;
    
    public Opcional(){
    }
    
    public Opcional(String nombre, String codigo, int totalCreditos, String escuela){
        super(nombre, codigo, totalCreditos);
        this.escuela = escuela;
    }    

    //Getter
    public String getEscuela() {
        return escuela;
    }

    //Setter
    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    
    /**
     * Metodo que muestra la informacion de la asignatura opcional
     */
    @Override
    public String mostrarInformacion(){
        return ("Nombre del Ramo: " + this.getNombreCurso() + " Lo imparte: " + escuela + " Cantidad de alumnos: " + this.getCantidadAlumnos() + " es OPCIONAL");
    }
    
    /**
     * Metodo que cambia la informacion de la asignatura opcional
     * @param nombreRamo String que contiene el nombre de la Asignatura
     * @param nombreImpartido String que contiene, en este caso, la escuela que imparte la asignatura
     */
    @Override
    public void cambiarInformacion(String nombreRamo, String nombreImpartido){
        this.setNombreCurso(nombreRamo);
        this.setEscuela(nombreImpartido);
    }
}
