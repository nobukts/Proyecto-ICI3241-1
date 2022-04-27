package com.mycompany.avancecurricular;

import java.util.ArrayList;

public class Alumno {
    private String nombreAlumno;
    private int cantidadCreditos;
    private int rut;
    private ArrayList<Ramo> ramosAlumno;

    /**
     * Constructor vacio que inicializa el ArrayList ramosAlumno
     */
    public Alumno(){
        ramosAlumno = new ArrayList<>();
    }

    /**
     * Constructor de la Clase Alumno
     * @param nombreAlumno String que contiene el nombre del alumno
     * @param rut int que contiene el RUT del alumno
     */
    public Alumno(String nombreAlumno, int rut){
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        ramosAlumno = new ArrayList<>();
    }

    //------------GETTERS

    public int getRut() {
        return rut;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    //------------SETTERS

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
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
            if(mallaCurricular.get(i).getEstadoRamo() == 1) mallaCurricular.get(i).aumentarCantidadAlumnos();
        }
    }

    /**
     * Metodo para agregar un ramo opcional a un solo alumno
     * @param nuevoRamo Objeto de la clase Ramo que se desea agregar a los ramos del alumno
     */
    public boolean agregarRamoOpcional(Ramo nuevoRamo){
        nuevoRamo.setEstadoRamo(1);
        ramosAlumno.add(nuevoRamo);
        return true;
    }
    
    /**
     * Metodo que se utiliza para decrementar en 1 a los ramos del alumno eliminado
     */
    public void decrementarAlumnos(){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(ramosAlumno.get(i).getEstadoRamo() == 1){
                int cantAlumnos = ramosAlumno.get(i).getCantidadAlumnos();
                cantAlumnos--;
                ramosAlumno.get(i).setCantidadAlumnos(cantAlumnos);
            }
        }
    }

    /**
     * Metodo para actualizar el estado de un ramo del alumno
     * @param codigoRamo String que contiene el codigo del ramo que se esta buscando en el alumno
     * @param estadoRamo Entero que contiene el estado del ramo
     * @return boolean Verdadero si se puede actualizar el estado del ramo y falso si no se pudo actualizar
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
     * @return boolean Verdadero si no se encuentra el ramo en la malla curricular y falso si ya se encuentra
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
