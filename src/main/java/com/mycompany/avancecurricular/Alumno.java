package com.mycompany.avancecurricular;
import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private String rutAlumno;
    private ArrayList<Ramo> mallaCurricular;
    private ArrayList<Ramo> ramosAprobados;
    private ArrayList<Ramo> ramosActuales;
    private ArrayList<Ramo> ramosFaltantes;
    private int cantCreditos;

    public Alumno(){
        
    }

    public Alumno(String nombreAlumno, String rutAlumno){
        this.nombreAlumno = nombreAlumno;
        this.rutAlumno = rutAlumno;
        this.mallaCurricular = new ArrayList<>();
        this.ramosAprobados = new ArrayList<>();
        this.ramosActuales = new ArrayList<>();
        this.ramosFaltantes = new ArrayList<>();
        this.cantCreditos = 0;
    }

    public Alumno(String nombreAlumno, String rutAlumno, ArrayList<Ramo> mallaCurricular, ArrayList<Ramo> ramosAprobados, ArrayList<Ramo> ramosActuales, ArrayList<Ramo> ramosFaltantes, int cantCreditos){
        this.nombreAlumno = nombreAlumno;
        this.rutAlumno = rutAlumno;
        this.mallaCurricular = mallaCurricular;
        this.ramosAprobados = ramosAprobados;
        this.ramosActuales = ramosActuales;
        this.ramosFaltantes = ramosFaltantes;
        this.cantCreditos = cantCreditos;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    public ArrayList<Ramo> getMallaCurricular() {
        return mallaCurricular;
    }

    public void setMallaCurricular(ArrayList<Ramo> mallaCurricular) {
        this.mallaCurricular = mallaCurricular;
    }

    public ArrayList<Ramo> getRamosAprobados() {
        return ramosAprobados;
    }

    public void setRamosAprobados(ArrayList<Ramo> ramosAprobados) {
        this.ramosAprobados = ramosAprobados;
    }

    public ArrayList<Ramo> getRamosActuales() {
        return ramosActuales;
    }

    public void setRamosActuales(ArrayList<Ramo> ramosActuales) {
        this.ramosActuales = ramosActuales;
    }

    public ArrayList<Ramo> getRamosFaltantes() {
        return ramosFaltantes;
    }

    public void setRamosFaltantes(ArrayList<Ramo> ramosFaltantes) {
        this.ramosFaltantes = ramosFaltantes;
    }

    public int getCantCreditos() {
        return cantCreditos;
    }

    public void setCantCreditos(int cantCreditos) {
        if(cantCreditos < 0) cantCreditos *= -1;
        this.cantCreditos = cantCreditos;
    }

    public void buscarRamo(String nombreRamo){
        for(int i = 0 ; i < mallaCurricular.size() ; i++){
            if(mallaCurricular.get(i).getNombreRamo().equalsIgnoreCase(nombreRamo)){
                System.out.print("- Informacion del ramo " + nombreRamo + ": ");
                System.out.println("Codigo ramo: " + mallaCurricular.get(i).getCodigoRamo());
                break;
            }
        }
    }

    public void buscarRamo(String codigoLetras, int codigoNumeros){
        String codigoRamo = codigoLetras + String.valueOf(codigoNumeros);
        System.out.println(codigoRamo);
        for(int i = 0 ; i < mallaCurricular.size() ; i++){
            if(mallaCurricular.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                System.out.print("- Informacion del ramo " + codigoRamo + ": ");
                System.out.println("Nombre ramo: " + mallaCurricular.get(i).getNombreRamo());
                break;
            }
        }
    }

    public void mostrarTodosRamos(){
        for(int i = 0 ; i < mallaCurricular.size() ; i++){
            System.out.println("Ramo " + (i+1) + ": " + mallaCurricular.get(i).getNombreRamo());
        }
    }

}
