package Clases;

import java.util.*;

import Interfaces.FormatoSalida;

public class Instituto{
    private ColeccionCarreras listaCarreras;
    private ColeccionCursos mapaCursos;
    FormatoSalida fs;
    
    
    /**
     * Constructor de la clase Instituto, que inicializa la coleccion listaCarreras
     */
    public Instituto(){
        mapaCursos = new ColeccionCursos();
        listaCarreras = new ColeccionCarreras();
    }

    public void setFormatoSalida(FormatoSalida fs){
        this.fs = fs;
    }

    /**
     * Metodo para mostrar los cursos que existen
     * @return arraylist con la informacion de todos los cursos
     */
    public ArrayList<String> mostrarCursos(){
        return mapaCursos.mostrarCursos();
    }

    /**
     * Metodo que muestra los ramos de una carrera en especifico y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de una carrera en especifico
     * @return String[]
     */
    public String[] mostrarAsignaturasCarrera(String nombreCarrera){
        return listaCarreras.mostrarAsignaturasCarrera(nombreCarrera);
    }
    
    /**
     * Metodo que muestra la informacion respectiva de todas las carreras del instituto
     * @return String[]
     */
    public String[] mostrarCarreras(){
        return listaCarreras.mostrarCarreras();
    }

    /** 
     * Metodo para mostrar la lista de alumnos de una carrera y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de la carrera
     * @return String[]
     */
    public String[] mostrarListaAlumnos(String nombreCarrera){
        return listaCarreras.mostrarListaAlumnos(nombreCarrera);
    }
    
    /**
     * Metodo que agrega una carrera del instituto, e ingresa la malla curricular del mismo
     * @param nombreCarrera
     * @return boolean Verdadero si se logro agregar la carrera correctamente y falso si no se pudo agregar
     */
    public boolean agregarCarrera(String nombreCarrera){
        return listaCarreras.agregarCarrera(nombreCarrera);
    }
    
    /**
     * Metodo para agregar una malla curricular
     * @param nuevaAsignatura Asignatura a agregar
     * @param nombreCarrera String con el nombre dela carrera
     * @return boolean Verdadero si se logro agregar y falso si no se pudo agregar
     */
    public boolean agregarMalla(Asignatura nuevaAsignatura, String nombreCarrera){
        if(mapaCursos.verificar(nuevaAsignatura.getCodigoCurso())) return false;
        mapaCursos.agregarMalla(nuevaAsignatura);
        
        return listaCarreras.agregarAsignaturaMalla(nuevaAsignatura, nombreCarrera);
    }

    /**
     * Metodo para agregar un ramo fuera de la mallla curricular de la carrera a un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno
     * @param nuevoRamo Objeto de la clase Ramo
     * @param escuela
     * @return boolean Verdadero si se pudo agregar el ramo correctamente y falso si no se pudo agregar
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo, String escuela){
        return listaCarreras.agregarRamoOpcional(nombreAlumno, nuevoRamo, escuela, mapaCursos);
    }

    /**
     * Metodo que agrega un alumno a una carreara
     * @param al Objeto de la clase alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo agregar al alumno y  falso si no se pudo agregar
     */
    public boolean matricularAlumno(Alumno al, String nombreCarrera){
        return listaCarreras.matricularAlumno(al, nombreCarrera);
    }

    /**
     * Metodo que busca y elimina una carrera del instituto
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si es que se elimino la carrera y falso si no se pudo eliminar
     */
    public boolean eliminarCarrera(String nombreCarrera){
        return listaCarreras.eliminarCarrera(nombreCarrera);
    }

    /**
     * Metodo para eliminar a un alumno a traves de su rut y la carrera en la cual esta matriculado
     * @param rut Entero que contiene el rut del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
     */
    public boolean eliminarAlumno(int rut, String nombreCarrera){
        return listaCarreras.eliminarAlumno(rut, nombreCarrera, mapaCursos);
    }
    
    /**
     * Metodo para eliminar a un alumno a traves del nombre y la carrera en la cual esta matriculado
     * @param nombreAlumno String que contiene el nombre del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
     */
    public boolean eliminarAlumno(String nombreAlumno, String nombreCarrera){
        return listaCarreras.eliminarAlumno(nombreAlumno, nombreCarrera, mapaCursos);
    }

    /**
    * Metodo que en caso de encontrar una asignatura con el codigo se??alado, lo elimina de la malla curricular de la carrera se??alada
    * @param codigoAsignatura String que contiene el codigo de la asignatura a eliminar
    * @param nombreCarrera String que indica de que carrera se quiere eliminar la asignatura
    * @return boolean Verdadero si se pudo eliminar la asignatura y falso si no se pudo eliminar
    */
    public boolean eliminarAsignatura(String nombreCarrera, String codigoAsignatura){
        return listaCarreras.eliminarAsignatura(nombreCarrera, codigoAsignatura);
    }
    
    /**
     * Metodo para actualizar el estado de un ramo de un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param codigoAsignatura String que contiene el codigo de un ramo de alguna carrera
     * @param estadoRamo Entero que contiene una de 3 opciones para cambiar el estado del ramo (0 = no cursado, 1 = cursando y 2 = aprobado)
     * @return boolean Verdadero si se pudo utilizar y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoAsignatura, int estadoRamo){
        return listaCarreras.actualizarRamo(nombreAlumno, codigoAsignatura, estadoRamo, mapaCursos);
    }
    
    /**
     * Metodo para editar el nombre de una carrera
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param nuevoNombreCarrera String que contiene el nombre a cambiar de la carrera
     * @return boolean Verdadero si se pudo editar la carrera y falso si no se pudo editar
     */
    public boolean editarCarrera(String nombreCarrera, String nuevoNombreCarrera){
        return listaCarreras.editarCarrera(nombreCarrera, nuevoNombreCarrera);
    }

    /**
     * Metodo para editar el nombre de un alumno de alguna carrera
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param nuevoNombreAlumno String que contiene el nuevo nombre del alumno que se trata de encontrar
     * @return boolean Verdadero si se pudo editar el alumno y falso si no se pudo editar
     */
    public boolean editarAlumno(String nombreAlumno, String nuevoNombreAlumno){
        return listaCarreras.editarAlumno(nombreAlumno, nuevoNombreAlumno);
    }

    /**
     * Metodo que edita una asignatura de la malla curricular de una carrera en especifico
     * @param codigoAsignatura String que contiene el codigo de la asignatura de una malla curricular de alguna carrera
     * @param nuevoNombre String que contiene el nuevo nombre de la asignatura que se desea modificar
     * @param nuevaInformacion Strinf que cambia la informacion, si es Obligatorio cambia la carrera y si es Opcional cambia la escuela que los imparte respectivamente
     * @return boolean Verdadero si se pudo editar la asignatura y falso si no se pudo editar
     */
    public boolean editarAsignatura(String codigoAsignatura, String nuevoNombre, String nuevaInformacion){
        return mapaCursos.editarAsignatura(codigoAsignatura, nuevoNombre, nuevaInformacion);
    }
    
    /**
     * Metodo que retorna una lista con los alumnos con menor cantidad de creditos de cada carrera
     * @return ArrayList de alumnos con menor cantidad de creditos
     */
    public String[] alumnosMenorCantCreditos(){
        return listaCarreras.alumnosMenorCantCreditos();
    }

    /**
     * Metodo que retorna una lista con los alumnos que se encuentran en el rango de creditos que se piden
     * @param rangoMinimo Cantidad de creditos minima
     * @param rangoMaximo Cantidad de creditos maxima
     * @return ArrayList de alumnos
     */
    public ArrayList<String> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        return listaCarreras.alumnosRangoCredito(rangoMinimo, rangoMaximo);
    }
    
    /**
     * Metodo que busca un alumno y lo muestra
     * @param nombreCarrera String con el nombre de la carrera
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return String con la informacion del alumno
     */
    public String buscarAlumno(String nombreCarrera, String nombreAlumno){
        return listaCarreras.buscarAlumno(nombreCarrera, nombreAlumno);
    }
    
    /**
     * Metodo para buscar los ramos de un alumno y mostrarlos
     * @param nombreCarrera String con el nombre de la carrera
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return cadena de string con la informacion de los ramos de un alumno
     */
    public String[] buscarRamosAlumno(String nombreCarrera, String nombreAlumno){
        return listaCarreras.buscarRamosAlumno(nombreCarrera, nombreAlumno);
    }
    
    /**
     * Metodo para buscar los ramos de un alumno y mostrarlos
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return cadena de string con la informacion de los ramos de un alumno
     */
    public String[] buscarRamosAlumno(String nombreAlumno){
        return listaCarreras.buscarRamosAlumno(nombreAlumno);
    }

    /**
     * Metodo para la busqueda de una asignatura y entregar su informacion respectiva
     * @param codigoAsignatura String del codigo de una asignatura
     * @return boolean Verdadero si encontro el asignatura y falso si no existe la asignatura
     */
    public String buscarAsignatura(String codigoAsignatura){
        return mapaCursos.buscarAsignatura(codigoAsignatura);
    }

    /**
     * Metodo que verifica si la lista carreras esta vacia
     * @return boolean true si la lista carreras esta vacia, false si no esta vacia
     */
    public boolean noContieneCarrera(){
        return listaCarreras.noContieneCarrera();
    }
    
    /**
     * Metodo que verifica si la lista carreras no contiene alumnos
     * @return boolean true si la lista carreras no contiene alumnos, false si contiene
     */
    public boolean noContieneAlumnos(){
        return listaCarreras.noContieneAlumnos();
    }

    /**
     * Metodo que crea un reporte en un archivo txt que muestra datos de las colecciones anidadas
     */
    public void crearReporte(){
        String infoCarreras = listaCarreras.reporteCarrera();
        String infoAlumnos = listaCarreras.reporteAlumnos();
        String infoCursos = listaCarreras.reporteCursos();
        ArrayList<String> infoObtenida = mostrarCursos();
        fs.crearReporte(infoCarreras, infoAlumnos, infoCursos, infoObtenida);
    }
}