package Clases;

import Interfaces.Verificador;

public class Alumno implements Verificador{
    private String nombreAlumno;
    private int cantidadCreditos;
    private int rut;
    private ColeccionRamos coleccionRamos;

    /**
     * Constructor vacio que inicializa el ArrayList ramosAlumno
     */
    public Alumno(){
        coleccionRamos = new ColeccionRamos();
    }

    /**
     * Constructor de la Clase Alumno que instancia el nombre del alumno y el rut
     * @param nombreAlumno String que contiene el nombre del alumno
     * @param rut int que contiene el RUT del alumno
     */
    public Alumno(String nombreAlumno, int rut){
        this.nombreAlumno = nombreAlumno;
        this.rut = rut;
        coleccionRamos = new ColeccionRamos();
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
     * @return 
     */
    public String mostrarAlumno(){
        return (getNombreAlumno() + '-' + getRut() + '-' + getCantidadCreditos());
    }

    /**
     * Metodo que permite mostrar la informacion de los ramos de los alumnos
     * @return arreglo de String con la informacion de los ramos del alumno
     */
    public String[] mostrarRamos(){
        return coleccionRamos.mostrarRamos();
    }

    /**
     * Metodo para agregar un ramo opcional a un solo alumno
     * @param nuevoRamo Objeto de la clase Ramo que se desea agregar a los ramos del alumno
     */
    public void agregarRamo(Ramo nuevoRamo){
        coleccionRamos.agregarRamo(nuevoRamo);
    }
        
    /**
     * Metodo para corroborar que asignaturas esta cursando el alumno
     * @param codigoAsignatura String que contiene el codigo del ramo que se quiere verificar
     * @return boolean true si es que el alumno esta cursando el ramo, false si lo tiene aprobado o aun no lo esta cursando
     */
    public boolean eliminarAlumno(String codigoAsignatura){
        return coleccionRamos.eliminarAlumno(codigoAsignatura);
    }

    /**
     * Metodo para actualizar el estado de un ramo del alumno
     * @param codigoRamo String que contiene el codigo del ramo que se esta buscando en el alumno
     * @param estadoRamo Entero que contiene el estado del ramo
     * @return boolean Verdadero si se puede actualizar el estado del ramo y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String codigoRamo, int estadoRamo){
        if(coleccionRamos.actualizarRamo(codigoRamo, estadoRamo)){
            if(estadoRamo == 2) cantidadCreditos += coleccionRamos.getCantidadCreditos(codigoRamo);
            return true;
        }
        return false;
    }
    
    /**
     * Metodo de la interface que verifica si un ramo se encuentra entre los ramos del alumno
     * @param codigoCurso String que contiene el codigo del ramo que estamos verificando
     * @return boolean Falso si no se encuentra el ramo en la malla curricular y Verdadero si ya se encuentra
     */
    @Override
    public boolean verificar(String codigoCurso){
        return coleccionRamos.verificarCodigoCurso(codigoCurso);
    }
}
