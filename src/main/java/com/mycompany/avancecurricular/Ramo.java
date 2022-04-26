package com.mycompany.avancecurricular;

public class Ramo {
    private String nombreRamo;
    private String codigoRamo;
    private int estadoRamo;
    private int cantidadCreditos;
    private int cantidadAlumnos;

    public Ramo(String nombreRamo, String codigoRamo, int cantidadCreditos){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoRamo = codigoRamo;
        this.nombreRamo = nombreRamo;
        estadoRamo = 1;
        cantidadAlumnos = 0;
    }
    
    public Ramo(String nombreRamo, String codigoRamo, int cantidadCreditos, int estadoRamo){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoRamo = codigoRamo;
        this.nombreRamo = nombreRamo;
        this.estadoRamo = estadoRamo;
        cantidadAlumnos = 0;
    }

    public int getEstadoRamo() {
        return estadoRamo;
    }

    public void setEstadoRamo(int estadoRamo) {
        this.estadoRamo = estadoRamo;
    }
    
    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getNombreRamo() {
        return nombreRamo;
    }
    public void setNombreRamo(String nombreRamo) {
        this.nombreRamo = nombreRamo;
    }
    public String getCodigoRamo() {
        return codigoRamo;
    }
    public void setCodigoRamo(String codigoRamo) {
        this.codigoRamo = codigoRamo;
    }
    public int getCantidadCreditos() {
        return cantidadCreditos;
    }
    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    /**
     * Metodo que aumenta la cantidad de alumnos, usado al copiar la malla
     */
    public void aumentarCantidadAlumnos(){
        cantidadAlumnos++;
    }

    /**
     * Metodo que permite mostrar la informacion de un ramo
     */
    public void mostrarInformacion(){
        System.out.println("Nombre del ramo: " + nombreRamo + " Codigo del ramo: " + codigoRamo + " Cantidad de Alumnos: " + cantidadAlumnos + " Cantidad de creditos: " + cantidadCreditos);
    }

    /**
     * Metodo que permite la actualizacion de informacion al cambiar el estado de un ramo
     * @param estadoRamo Entero que contiene el estado del ramo (0 = No cursado, 1 = Cursando y 2 = Aprobado)
     * @return boolean
     */
    public boolean actualizarRamo(int estadoRamo){
        if(this.estadoRamo == estadoRamo) return false;
        
        this.estadoRamo = estadoRamo;
        if(estadoRamo == 0 || estadoRamo == 2) cantidadAlumnos--;
        else cantidadAlumnos++;
        
        return true;
    }
    
}