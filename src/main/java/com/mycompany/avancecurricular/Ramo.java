package com.mycompany.avancecurricular;

public class Ramo {
    private String nombreRamo;
    private String codigoRamo;
    private String nombreProfesor;
    private int creditosOtorga;
    private int cantidadAlumnos;
    
    public Ramo(){
        
    }

    public Ramo(String nombreRamo){
        this.nombreRamo = nombreRamo;
    }

    public Ramo(String nombreRamo, String codigoRamo){
        this.nombreRamo = nombreRamo;
        this.codigoRamo = codigoRamo;
    }

    public Ramo(String nombreRamo, String codigoRamo, String nombreProfesor, int creditosOtorga, int cantidadAlumnos){
        this.nombreRamo = nombreRamo;
        this.codigoRamo = codigoRamo;
        this.nombreProfesor = nombreProfesor;
        this.creditosOtorga = creditosOtorga;
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

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public int getCreditosOtorga() {
        return creditosOtorga;
    }

    public void setCreditosOtorga(int creditosOtorga) {
        this.creditosOtorga = creditosOtorga;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    } 
}
