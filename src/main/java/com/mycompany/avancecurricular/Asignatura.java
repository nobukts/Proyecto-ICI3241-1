package com.mycompany.avancecurricular;

abstract class Asignatura extends Curso{
    private int cantidadAlumnos;
    private boolean esDePrimero;
    
    /**
     * Constructor vacio
     */
    public Asignatura(){
        
    }

    /**
     * Constructor de la clase Asignatura que instancia el nombre y codigo de la Asignatura, ademas de la cantidad de creditos 
     * @param nombreAsignatura String que contiene el nombre de la Asignatura
     * @param codigoAsignatura String que contiene el codigo de la Asignatura
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     */
    public Asignatura(String nombreAsignatura, String codigoAsignatura, int cantidadCreditos){
        super(nombreAsignatura,codigoAsignatura,cantidadCreditos);
        esDePrimero = false;
        cantidadAlumnos = 0;
    }
    
    /**
     * Constructor de la clase Asignatura que instancia el nombre y codigo de la Asignatura, ademas de la cantidad de creditos
     * y si la Asignatura es de primer año
     * @param nombreAsignatura String que contiene el nombre de la Asignatura
     * @param codigoAsignatura String que contiene el codigo de la Asignatura
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     * @param esDePrimero Booleano que indica si la carrera se imparte en el primer semestre de primer año
     */
    public Asignatura(String nombreAsignatura, String codigoAsignatura, int cantidadCreditos, boolean esDePrimero){
        super(nombreAsignatura,codigoAsignatura,cantidadCreditos,esDePrimero);
        this.esDePrimero = esDePrimero;
        cantidadAlumnos = 0;
    }

    //Getters
    public boolean getEsDePrimero() {
        return esDePrimero;
    }
    
    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }
    
    //Setters
    public void setEsDePrimero(boolean esDePrimero) {
        this.esDePrimero = esDePrimero;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    
    /**
     * Metodo abstracto que muestra la informacion de la asignatura
     */
    @Override
    abstract void mostrarInformacion();
    
    /**
     * Metodo abstracto que cambia la informacion de la asignatura
     * @param nombreRamo String que contiene el nombre de la asignatura
     * @param nombreImpartido String que contiene, la escuela o carrera que imparte la asignatura
     */
    abstract void cambiarInformacion(String nombreRamo, String nombreImpartido);
    
    /**
     * Metodo que aumenta la cantidad de alumnos de la asignatura
     */
    public void aumentarAlumnos(){
        cantidadAlumnos++;
    }
    /**
     * Metodo que disminuye la cantidad de alumnos de la asignatura
     */
    public void disminuirAlumnos(){
        cantidadAlumnos--;
    }
}
