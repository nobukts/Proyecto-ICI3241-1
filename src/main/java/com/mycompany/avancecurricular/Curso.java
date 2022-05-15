package com.mycompany.avancecurricular;

abstract class Curso {
    private String nombreCurso;
    private String codigoCurso;
    private int cantidadCreditos;
    
    /**
     * Constructor vacio
     */
    public Curso(){
    }

    /**
     * Constructor de la clase Curso que instancia el nombre y codigo de la Curso, ademas de la cantidad de creditos 
     * @param nombreCurso String que contiene el nombre de la Curso
     * @param codigoCurso String que contiene el codigo de la Curso
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     */
    public Curso(String nombreCurso, String codigoCurso, int cantidadCreditos){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
    }
    
    /**
     * Constructor de la clase Curso que instancia el nombre y codigo de la Curso, ademas de la cantidad de creditos
     * y si la Curso es de primer año
     * @param nombreCurso String que contiene el nombre de la Curso
     * @param codigoCurso String que contiene el codigo de la Curso
     * @param cantidadCreditos Entero que contiene la cantidad de creditos
     * @param esDePrimero Booleano que indica si la carrera se imparte en el primer semestre de primer año
     */
    public Curso(String nombreCurso, String codigoCurso, int cantidadCreditos, boolean esDePrimero){
        this.cantidadCreditos = cantidadCreditos;
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
    }

    //------------GETTERS
    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public int getCantidadCreditos() {
        return cantidadCreditos;
    }

    //------------SETTERS
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        this.cantidadCreditos = cantidadCreditos;
    }
    
    /**
     * Metodo que permite mostrar la informacion de una Curso
     */
    abstract void mostrarInformacion();
}
