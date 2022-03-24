package com.mycompany.avancecurricular;

public class Alumno {
    private String nombreAlumno;
    private String[] mallaCurricular;
    private String[] ramosAprobados;
    private String[] ramosActuales;
    private String[] ramosFaltantes;
    int cantCreditos;

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String[] getMallaCurricular() {
        return mallaCurricular;
    }

    public String[] getRamosAprobados() {
        return ramosAprobados;
    }

    public String[] getRamosActuales() {
        return ramosActuales;
    }

    public String[] getRamosFaltantes() {
        return ramosFaltantes;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public void setMallaCurricular(String[] mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

    public void setRamosAprobados(String[] ramosAprobados) {
        this.ramosAprobados = ramosAprobados;
    }

    public void setRamosActuales(String[] ramosActuales) {
        this.ramosActuales = ramosActuales;
    }

    public void setRamosFaltantes(String[] ramosFaltantes) {
        this.ramosFaltantes = ramosFaltantes;
    }

    public void setCantCreditos(int cantCreditos) {
        this.cantCreditos = cantCreditos;
    }

}
