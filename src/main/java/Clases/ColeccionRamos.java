package Clases;

import java.util.ArrayList;

public class ColeccionRamos {
    private ArrayList<Ramo> ramosAlumno;

    public ColeccionRamos(){
        ramosAlumno = new ArrayList<>();
    }

    /**
     * Metodo para obtener la cantidad de creditos de un ramo
     * @param codigoRamo String con el codigo del ramo a buscar
     * @return int con la informacion de la cantidad de creditos del ramo ingresado
     */
    public int getCantidadCreditos(String codigoRamo){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(ramosAlumno.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                return ramosAlumno.get(i).getCantidadCreditos();
            }
        }
        return -1;
    }

    /**
     * Metodo que permite mostrar la informacion de los ramos de los alumnos
     * @return arreglo de String con la informacion de los ramos del alumno
     */
    public String[] mostrarRamos(){
        String[] listaRamos = new String[ramosAlumno.size()];
        
        for (int i = 0; i < ramosAlumno.size(); i++) {
            listaRamos[i] = ramosAlumno.get(i).mostrarInformacion();
            
        }
        
        return listaRamos;
    }

    /**
     * Metodo para agregar un ramo opcional a un solo alumno
     * @param nuevoRamo Objeto de la clase Ramo que se desea agregar a los ramos del alumno
     */
    public void agregarRamo(Ramo nuevoRamo){
        ramosAlumno.add(nuevoRamo);
    }

    /**
     * Metodo para corroborar que asignaturas esta cursando el alumno
     * @param codigoAsignatura String que contiene el codigo del ramo que se quiere verificar
     * @return boolean true si es que el alumno esta cursando el ramo, false si lo tiene aprobado o aun no lo esta cursando
     */
    public boolean eliminarAlumno(String codigoAsignatura){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(ramosAlumno.get(i).getCodigoCurso().equalsIgnoreCase(codigoAsignatura)){
                return ramosAlumno.get(i).getEstadoRamo() == 1;
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar el estado de un ramo del alumno
     * @param codigoRamo String que contiene el codigo del ramo que se esta buscando en el alumno
     * @param estadoRamo Entero que contiene el estado del ramo
     * @return boolean Verdadero si se puede actualizar el estado del ramo y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String codigoRamo, int estadoRamo){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(ramosAlumno.get(i).getCodigoCurso().equalsIgnoreCase(codigoRamo)){
                boolean res = ramosAlumno.get(i).actualizarRamo(estadoRamo);
                
                return res;
            }
            
        }
        return false;
    }

    /**
     * Metodo para verificar si el codigo del curso se encuentra en el arraylist de ramosAlumno
     * @param codigoCurso String que contiene el codigo del ramo que estamos verificando
     * @return boolean Falso si no se encuentra el ramo en la malla curricular y Verdadero si ya se encuentra
     */
    public boolean verificarCodigoCurso(String codigoCurso){
        for (int i = 0; i < ramosAlumno.size(); i++) {
            if(codigoCurso.equals(ramosAlumno.get(i).getCodigoCurso())) return true;
        }
        return false;
    }
}
