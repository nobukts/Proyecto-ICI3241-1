package com.mycompany.avancecurricular;

public class Asignatura {
    private String nombreAsignatura;
    private String codigoAsignatura;
    private int cantidadCreditos;
    private boolean esDePrimero;
    private int cantidadAlumnos;
    
    /**
     * Constructor vacio
     */
    public Asignatura(){
    }

    /**
     * Constructor de la clase Asignatura que instancia el nombre y codigo de la asignatura, ademas de la cantidad de creditos 
     * @param nombreAsignatura String que contiene el nombre de la Asignatura
     * @param codigoAsignatura String que contiene el codigo de la Asignatura
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     */
    public Asignatura(String nombreAsignatura, String codigoAsignatura, int cantidadCreditos){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoAsignatura = codigoAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        esDePrimero = false;
        cantidadAlumnos = 0;
    }
    
    /**
     * Constructor de la clase Asignatura que instancia el nombre y codigo de la asignatura, ademas de la cantidad de creditos
     * y si la asignatura es de primer año
     * @param nombreAsignatura String que contiene el nombre de la Asignatura
     * @param codigoAsignatura String que contiene el codigo de la Asignatura
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     * @param esDePrimero Booleano que indica si la carrera se imparte en el primer semestre de primer año
     */
    public Asignatura(String nombreAsignatura, String codigoAsignatura, int cantidadCreditos, boolean esDePrimero){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoAsignatura = codigoAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.esDePrimero = esDePrimero;
        cantidadAlumnos = 0;
    }

    //------------GETTERS
    public boolean getEsDePrimero() {
        return esDePrimero;
    }
    
    public int getCantidadAlumnos(){
        return cantidadAlumnos;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    //------------SETTERS
    public void setEsDePrimero(boolean esDePrimero) {
        this.esDePrimero = esDePrimero;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }
    
    /**
     * Metodo que permite mostrar la informacion de una asignatura
     */
    public void mostrarInformacion(){
        System.out.println("Nombre de la asignatura: " + nombreAsignatura + " Codigo de la asignatura: " + codigoAsignatura + " Cantidad de creditos: " + cantidadCreditos + " Cantidad Alumnos: " + cantidadAlumnos);
    }

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