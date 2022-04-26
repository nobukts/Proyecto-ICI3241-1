package com.mycompany.avancecurricular;

import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private int cantidadCreditos;
    private int rut;
    private ArrayList<Ramo> ramosAlumno;

    public Alumno(String nombreAlumno, int rut){
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        ramosAlumno = new ArrayList<>();
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }

    /**
     * Metodo que permite mostrar la informacion del alumno
     */
    public void mostrarAlumno(){
        System.out.println("Nombre: " + nombreAlumno + " Rut: " + rut + " Cantidad de creditos: " + cantidadCreditos);
    }
    
    /**
     * Metodo que permite copiar la informacion de la malla curricular de la carrera al alumno, para poder realizar 
        de forma personalizada cambios en los ramos
     * @param mallaCurricular ArrayList que contiene la malla curricular de la carrera
     */
    public void copiarMalla(ArrayList<Ramo> mallaCurricular){
        ramosAlumno.addAll(mallaCurricular);
        for (int i = 0; i < mallaCurricular.size(); i++) {
            mallaCurricular.get(i).aumentarCantidadAlumnos();
        }
    }

    /**
     * Metodo para agregar un ramo opcional a un solo alumno
     * @param nuevoRamo Objeto de la clase Ramo que se desea agregar a los ramos del alumno
     * @return boolean
     */
    public boolean agregarRamoOpcional(Ramo nuevoRamo){
        Ramo ramoAuxiliar;
        for (int i = 0; i < ramosAlumno.size(); i++) {
            ramoAuxiliar = ramosAlumno.get(i);
            if(ramoAuxiliar.getEstadoRamo() == 1 || ramoAuxiliar.getEstadoRamo() == 2){
                return false;
            }
        }
        
        nuevoRamo.setEstadoRamo(1);
        ramosAlumno.add(nuevoRamo);
        return true;
    }
    
    /**
     * Metodo para actualizar el estado de un ramo del alumno
     * @param codigoRamo String que contiene el codigo del ramo que se esta buscando en el alumno
     * @param estadoRamo Entero que contiene el estado del ramo
     * @return boolean
     */
    public boolean actualizarRamo(String codigoRamo, int estadoRamo){
        Ramo ramoAuxiliar;
        
        for (int i = 0; i < ramosAlumno.size(); i++) {
            ramoAuxiliar = ramosAlumno.get(i);
            if(ramoAuxiliar.getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                boolean resultado = ramoAuxiliar.actualizarRamo(estadoRamo);
                if(resultado == true && estadoRamo == 2){
                    cantidadCreditos += ramoAuxiliar.getCantidadCreditos();
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodo que verifica si un ramo se encuentra entre los ramos del alumno
     * @param codigoRamo String que contiene el codigo del ramo que estamos verificando
     * @return boolean
     */
    public boolean verificarRamo(String codigoRamo){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(ramosAlumno.get(i).getCodigoRamo().equalsIgnoreCase(codigoRamo)){
                return false;
            }
            
        }
        return true;
    }
}
