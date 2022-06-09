package Clases;

import Interfaces.Verificador;
import java.io.*;
import java.util.*;

public class Instituto implements Verificador{
    private ArrayList<Carrera> listaCarreras;
    private HashMap<String, Asignatura> mapaCursos;
    
    /**
     * Constructor de la clase Instituto, que inicializa la coleccion listaCarreras
     */
    public Instituto(){
        mapaCursos = new HashMap<>();
        listaCarreras = new ArrayList<>();
    }
    
    /**
     * Metodo que agrega una carrera del instituto, e ingresa la malla curricular del mismo
     * @param nombreCarrera
     * @return boolean Verdadero si se logro agregar la carrera correctamente y falso si no se pudo agregar
     */
    public boolean agregarCarrera(String nombreCarrera){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera))
                return false;
        }

        listaCarreras.add(new Carrera(nombreCarrera));
        
        return true;
    }
    
    
    public boolean agregarMalla(Asignatura nuevaAsignatura, String nombreCarrera){
        if(mapaCursos.containsKey(nuevaAsignatura.getCodigoCurso())) return false;
        mapaCursos.put(nuevaAsignatura.getCodigoCurso(), nuevaAsignatura);
        
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equals(nombreCarrera)) return listaCarreras.get(i).agregarAsignaturaMalla(nuevaAsignatura);
            
        }
        return false;
    }

    /**
     * Metodo que verifica si la lista carreras esta vacia
     * @return boolean true si la lista carreras esta vacia, false si no esta vacia
     */
    public boolean noContieneCarrera(){
        return listaCarreras.isEmpty();
    }
    
    /**
     * Metodo que verifica si la lista carreras no contiene alumnos
     * @return boolean true si la lista carreras no contiene alumnos, false si contiene
     */
    public boolean noContieneAlumnos(){
        if(!noContieneCarrera()) return listaCarreras.get(0).noContieneAlumnos();
        return false;
    }
    
    /**
     * Metodo que busca y elimina una carrera del instituto
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si es que se elimino la carrera y falso si no se pudo eliminar
     */
    public boolean eliminarCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Metodo que agrega un alumno a una carreara
     * @param al Objeto de la clase alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo agregar al alumno y  falso si no se pudo agregar
     */
    public boolean matricularAlumno(Alumno al, String nombreCarrera){
        //Verifica que no exista nadie con el mismo nombre en otra carrera
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).verificarAlumnos(al.getNombreAlumno())){
                return false;
            }
        }

        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).matricularAlumno(al);
            }
        }
        
        return false;
    }

    /**
     * Metodo para eliminar a un alumno a traves de su rut y la carrera en la cual esta matriculado
     * @param rut Entero que contiene el rut del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
     */
    public boolean eliminarAlumno(int rut, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(rut);
            } 
        }
        return false;
    }
    
    /**
     * Metodo para eliminar a un alumno a traves del nombre y la carrera en la cual esta matriculado
     * @param nombreAlumno String que contiene el nombre del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
     */
    public boolean eliminarAlumno(String nombreAlumno, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).eliminarAlumno(nombreAlumno);
            }
        }
        return false;
    }
    
    /** 
     * Metodo para mostrar la lista de alumnos de una carrera y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de la carrera
     * @return 
     */
    public String[] mostrarListaAlumnos(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).mostrarListaAlumnos();
            }
        }
        
        return null;
    }
    
    /**
     * Metodo para agregar un ramo fuera de la mallla curricular de la carrera a un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno
     * @param nuevoRamo Objeto de la clase Ramo
     * @param escuela
     * @return boolean Verdadero si se pudo agregar el ramo correctamente y falso si no se pudo agregar
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo, String escuela){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).agregarRamoOpcional(nombreAlumno, nuevoRamo)){

                Opcional asigAux = new Opcional(nuevoRamo.getNombreCurso(), nuevoRamo.getCodigoCurso(), nuevoRamo.getCantidadCreditos(), escuela);
                if(verificar(asigAux.getCodigoCurso())){
                    mapaCursos.get(asigAux.getCodigoCurso()).aumentarAlumnos();
                }
                else{
                    mapaCursos.put(asigAux.getCodigoCurso(), asigAux);
                    asigAux.aumentarAlumnos();
                }
                
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo para actualizar el estado de un ramo de un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param codigoAsignatura String que contiene el codigo de un ramo de alguna carrera
     * @param estadoRamo Entero que contiene una de 3 opciones para cambiar el estado del ramo (0 = no cursado, 1 = cursando y 2 = aprobado)
     * @return boolean Verdadero si se pudo utilizar y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoAsignatura, int estadoRamo){
        
        for (int i = 0 ; i < listaCarreras.size() ; i++) {
            if(listaCarreras.get(i).actualizarRamo(nombreAlumno, codigoAsignatura, estadoRamo)){
                if(estadoRamo == 0 || estadoRamo == 2){
                    mapaCursos.get(codigoAsignatura).disminuirAlumnos();
                }else if(estadoRamo == 1){
                    mapaCursos.get(codigoAsignatura).aumentarAlumnos();
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metodo que muestra los ramos de una carrera en especifico y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de una carrera en especifico
     * @return 
     */
    public String[] mostrarAsignaturasCarrera(String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                return listaCarreras.get(i).mostrarAsignaturas();
            }
        }
        
        return null;
    }
    
    /**
     * Metodo que muestra la informacion respectiva de todas las carreras del instituto
     * @return 
     */
    public String[] mostrarCarreras(){
        String[] carreras = new String[listaCarreras.size()];
        for (int i = 0; i < listaCarreras.size(); i++) {
            carreras[i] = listaCarreras.get(i).mostrarCarrera();
        }
        
        return carreras;
    }
    
    
    /**
     * Metodo para editar el nombre de una carrera
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @param nuevoNombreCarrera String que contiene el nombre a cambiar de la carrera
     * @return boolean Verdadero si se pudo editar la carrera y falso si no se pudo editar
     */
    public boolean editarCarrera(String nombreCarrera, String nuevoNombreCarrera){
        for(int i = 0; i < listaCarreras.size(); i++){
        
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                listaCarreras.get(i).setNombreCarrera(nuevoNombreCarrera);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para editar el nombre de un alumno de alguna carrera
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param nuevoNombreAlumno String que contiene el nuevo nombre del alumno que se trata de encontrar
     * @return boolean Verdadero si se pudo editar el alumno y falso si no se pudo editar
     */
    public boolean editarAlumno(String nombreAlumno, String nuevoNombreAlumno){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).editarAlumno(nombreAlumno, nuevoNombreAlumno)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que edita una asignatura de la malla curricular de una carrera en especifico
     * @param codigoAsignatura String que contiene el codigo de la asignatura de una malla curricular de alguna carrera
     * @param nuevoNombre String que contiene el nuevo nombre de la asignatura que se desea modificar
     * @param nuevaInformacion Strinf que cambia la informacion, si es Obligatorio cambia la carrera y si es Opcional cambia la escuela que los imparte respectivamente
     * @return boolean Verdadero si se pudo editar la asignatura y falso si no se pudo editar
     */
    public boolean editarAsignatura(String codigoAsignatura, String nuevoNombre, String nuevaInformacion){
        if(!mapaCursos.containsKey(codigoAsignatura)) return false;
        
        mapaCursos.get(codigoAsignatura).cambiarInformacion(nuevoNombre, nuevaInformacion);
        
        return true;
    }
    
    /**
    * Metodo que en caso de encontrar una asignatura con el codigo señalado, lo elimina de la malla curricular de la carrera señalada
    * @param codigoAsignatura String que contiene el codigo de la asignatura a eliminar
    * @param nombreCarrera String que indica de que carrera se quiere eliminar la asignatura
    * @return boolean Verdadero si se pudo eliminar la asignatura y falso si no se pudo eliminar
    */
    public boolean eliminarAsignatura(String nombreCarrera, String codigoAsignatura){
        for(int i = 0; i < listaCarreras.size(); i++){
            if(listaCarreras.get(i).getNombreCarrera().equalsIgnoreCase(nombreCarrera)){
                return listaCarreras.get(i).eliminarAsignatura(codigoAsignatura);
            }
        }
        return false;
    }

    /**
     * Metodo que crea un reporte en un archivo txt que muestra datos de las colecciones anidadas
     */
    public void crearReporte(){
        //Se crea el archivo reporte
        try{
            File archivo = new File("reporte.txt");
            archivo.createNewFile();
        }catch(IOException e){
        }

        //Se imprime en el archivo reporte
        try{
            try (FileWriter archivo = new FileWriter("reporte.txt")) {
                archivo.write("Nombre de la carrera Cantidad Alumnos\n");
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    archivo.write(String.format("%20s %16d",cr.getNombreCarrera(), cr.getCantidadAlumnos()) + "\n");
                }
                
                archivo.write("---------------------------------------------\n");
                archivo.write("     Nombres alumnos + RUT alumnos + Cantidad creditos\n");
                
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    cr.reporteAlumno(archivo,cr);
                }
                
                archivo.write("---------------------------------------------\n");
                archivo.write("Nombre de la carrera + Codigo Asignatura + Nombre Asignatura + Cantidad Alumnos\n");
                
                for(int i = 0 ; i < listaCarreras.size() ; i++){
                    Carrera cr = listaCarreras.get(i);
                    archivo.write(String.format("%20s",cr.getNombreCarrera()));
                    cr.reporteAsignatura(archivo, true, cr);
                    cr.reporteAsignatura(archivo, false, cr);
                }
            }
        }catch(IOException e){
        }
    }
    
    /**
     * Metodo que retorna una lista con los alumnos con menor cantidad de creditos de cada carrera
     * @return ArrayList de alumnos con menor cantidad de creditos
     */
    public String[] alumnosMenorCantCreditos(){
        String[] alumnosMenosCreditos = new String[listaCarreras.size()];
        
        for(int i = 0; i < listaCarreras.size(); i++) {
           Alumno aux = listaCarreras.get(i).alumnoMenorCreditos();
           if(aux != null){
               alumnosMenosCreditos[i] = aux.mostrarAlumno();
               alumnosMenosCreditos[i] += ("-" + listaCarreras.get(i).getNombreCarrera());
           }
            
        }
        return alumnosMenosCreditos;
    } 

    /**
     * Metodo que retorna una lista con los alumnos que se encuentran en el rango de creditos que se piden
     * @param rangoMinimo Cantidad de creditos minima
     * @param rangoMaximo Cantidad de creditos maxima
     * @return ArrayList de alumnos
     */
    public ArrayList<String> alumnosRangoCredito(int rangoMinimo, int rangoMaximo){
        ArrayList<String> alumnosRangoCredito = new ArrayList<>();
        
        for (int i = 0; i < listaCarreras.size(); i++) {
            ArrayList<String> listaAux = listaCarreras.get(i).alumnosRangoCredito(rangoMinimo, rangoMaximo);
            if(!listaAux.isEmpty()){
                alumnosRangoCredito.addAll(listaAux);
            }
        }

        return alumnosRangoCredito;
    }

    /**
     * Metodo de la interface que verifica si una asignatura se encuentra o no en la lista
     * @param codigoCurso String que contiene el codigo del curso
     * @return Boolean true si el codigo se encuentra en el mapa cursos y falso si no se encuentra
     */
    @Override
    public boolean verificar(String codigoCurso){
        return mapaCursos.containsKey(codigoCurso);
    }
    
    /**
     * Metodo que busca un alumno y lo muestra
     * @param nombreCarrera String con el nombre de la carrera
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return String con la informacion del alumno
     */
    public String buscarAlumno(String nombreCarrera, String nombreAlumno){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equals(nombreCarrera)) return listaCarreras.get(i).buscarAlumno(nombreAlumno);
        }
        
        return null;
    }
    
    /**
     * Metodo para buscar los ramos de un alumno y mostrarlos
     * @param nombreCarrera String con el nombre de la carrera
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return cadena de string con la informacion de los ramos de un alumno
     */
    public String[] buscarRamosAlumno(String nombreCarrera, String nombreAlumno){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equals(nombreCarrera)) return listaCarreras.get(i).buscarRamos(nombreAlumno);
        }
        
        return null;
    }
    
    /**
     * Metodo para buscar los ramos de un alumno y mostrarlos
     * @param nombreAlumno String con el nombre del alumno a buscar
     * @return cadena de string con la informacion de los ramos de un alumno
     */
    public String[] buscarRamosAlumno(String nombreAlumno){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).buscarAlumno(nombreAlumno) != null) return listaCarreras.get(i).buscarRamos(nombreAlumno);
        }
        
        return null;
    }

    /**
     * Metodo para la busqueda de una asignatura y entregar su informacion respectiva
     * @param codigoAsignatura String del codigo de una asignatura
     * @return boolean Verdadero si encontro el asignatura y falso si no existe la asignatura
     */
    public String buscarAsignatura(String codigoAsignatura){
        if(!mapaCursos.containsKey(codigoAsignatura)) return null;
        return mapaCursos.get(codigoAsignatura).mostrarInformacion();
    }
    
    /**
     * Metodo para mostrar los cursos que existen
     * @return arraylist con la informacion de todos los cursos
     */
    public ArrayList<String> mostrarCursos(){
        ArrayList<String> listaCursos = new ArrayList<>();
        mapaCursos.forEach((key, value)->{
            listaCursos.add(value.mostrarInformacion());
        });
        
        return listaCursos;
    }
}