package com.mycompany.avancecurricular;

public class Ramo extends Curso{
    private int estadoRamo;
    
    /**
     * Constructor vacio que inicializa el estado del ramo como "cursando" (1)
     */
    public Ramo(){
    }
    
    /**
     * Constructor de la SubClase Ramo, que inicializa el nombre y codigo del ramo, ademas de la cantidad de creditos.
     * Inicializa el estado del ramo como "Cursando" (1)
     * @param nombre String que contiene el nombre del ramo
     * @param codigo String que contiene el codigo del ramo
     * @param totalCreditos Entero que contiene el codigo del ramo
     */
    public Ramo(String nombre, String codigo, int totalCreditos){
        super(nombre, codigo, totalCreditos);
        estadoRamo = 1;
    }

    /**
     * Constructor de la SubClase Ramo, que inicializa el nombre y codigo del ramo, ademas de la cantidad de creditos.
     * Inicializa el estado del ramo como "Cursando" (1)
     * @param nombre String que contiene el nombre del ramo
     * @param codigo String que contiene el codigo del ramo
     * @param totalCreditos Entero que contiene el codigo del ramo
     * @param estadoRamo Entero que indica el estado del ramo (0 = Por cursar, 1 = En curso, 2 = Aprobado)
     */    
    public Ramo(String nombre, String codigo, int totalCreditos, int estadoRamo){
        super(nombre, codigo, totalCreditos);
        this.estadoRamo = estadoRamo;
    }

    //------------GETTERS
    public int getEstadoRamo() {
        return estadoRamo;
    }
    
    //------------SETTERS
    public void setEstadoRamo(int estadoRamo) {
        this.estadoRamo = estadoRamo;
    }
    
     /**
     * Metodo que permite la actualizacion de informacion al cambiar el estado de un ramo
     * @param estadoRamo Entero que contiene el estado del ramo (0 = No cursado, 1 = Cursando y 2 = Aprobado)
     * @return boolean Verdadero si se puede actualizar el ramo y falso si no se puede actualizar
     */
    public boolean actualizarRamo(int estadoRamo){
        if(this.estadoRamo == estadoRamo) return false;
        this.estadoRamo = estadoRamo;
        return true;
    }
    
    /**
     *
     */
    public void mostrarInformacion(){
        System.out.println("Nombre del Ramo: " + this.getNombreCurso() + " Estado del ramo: ");
        switch(this.getEstadoRamo()){
            case 0:
                System.out.print("No cursado");
                break;
            case 1:
                System.out.print("Cursando");
                break;
            case 2:
                System.out.print("Aprobado");
                break;
        }
    }
}
