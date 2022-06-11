package Clases;

import java.util.ArrayList;

public class ColeccionCarreras {
    private ArrayList<Carrera> listaCarreras;

    public ColeccionCarreras(){
        listaCarreras = new ArrayList<>();
    }

    /**
     * Metodo que muestra los ramos de una carrera en especifico y su respectiva informacion
     * @param nombreCarrera String que contiene el nombre de una carrera en especifico
     * @return String[]
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
     * @return String[]
     */
    public String[] mostrarCarreras(){
        String[] carreras = new String[listaCarreras.size()];
        for (int i = 0; i < listaCarreras.size(); i++) {
            carreras[i] = listaCarreras.get(i).mostrarCarrera();
        }

        return carreras;
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

    /**
     * Metodo para agregar la asignatura ala malla curricular
     * @param nuevaAsignatura Asignatura a agregar
     * @param nombreCarrera String con el nombre dela carrera
     * @return boolean Verdadero si se logro agregar y falso si no se pudo agregar
     */
    public boolean agregarAsignaturaMalla(Asignatura nuevaAsignatura, String nombreCarrera){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).getNombreCarrera().equals(nombreCarrera)) return listaCarreras.get(i).agregarAsignaturaMalla(nuevaAsignatura);
            
        }
        return false;
    }

    /**
     * Metodo para agregar un ramo fuera de la mallla curricular de la carrera a un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno
     * @param nuevoRamo Objeto de la clase Ramo
     * @param escuela
     * @return boolean Verdadero si se pudo agregar el ramo correctamente y falso si no se pudo agregar
     */
    public boolean agregarRamoOpcional(String nombreAlumno, Ramo nuevoRamo, String escuela, ColeccionCursos mapa_Cursos){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(listaCarreras.get(i).agregarRamoOpcional(nombreAlumno, nuevoRamo)){
                mapa_Cursos.agregarRamoOpcional(nuevoRamo, escuela);
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
     * Metodo para eliminar a un alumno a traves de su rut y la carrera en la cual esta matriculado
     * @param rut Entero que contiene el rut del alumno
     * @param nombreCarrera String que contiene el nombre de una carrera
     * @return boolean Verdadero si se pudo eliminar el alumno y falso si no se logro eliminar
     */
    public boolean eliminarAlumno(int rut, String nombreCarrera, ColeccionCursos mapa_Cursos){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                String[] listaRamos = listaCarreras.get(i).eliminarAlumno(rut);
                if(listaRamos != null){
                    for (int j = 0; j < listaRamos.length; j++) {
                        String[] infoSeparada = listaRamos[j].split("-");
                        if(infoSeparada[2].equals("Cursando")) mapa_Cursos.disminuirAlumnos(infoSeparada[1]);

                    }
                    return true;    
                }
                
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
    public boolean eliminarAlumno(String nombreAlumno, String nombreCarrera, ColeccionCursos mapa_Cursos){
        for (int i = 0; i < listaCarreras.size(); i++) {
            if(nombreCarrera.equalsIgnoreCase(listaCarreras.get(i).getNombreCarrera())){
                String[] listaRamos = listaCarreras.get(i).eliminarAlumno(nombreAlumno);
                if(listaRamos != null){
                    for (int j = 0; j < listaRamos.length; j++) {
                        String[] infoSeparada = listaRamos[j].split("-");
                        if(infoSeparada[2].equals("Cursando")) mapa_Cursos.disminuirAlumnos(infoSeparada[1]);

                    }
                    return true;    
                }
            }
        }
        return false;
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
     * Metodo para actualizar el estado de un ramo de un alumno
     * @param nombreAlumno String que contiene el nombre de un alumno de alguna carrera
     * @param codigoAsignatura String que contiene el codigo de un ramo de alguna carrera
     * @param estadoRamo Entero que contiene una de 3 opciones para cambiar el estado del ramo (0 = no cursado, 1 = cursando y 2 = aprobado)
     * @return boolean Verdadero si se pudo utilizar y falso si no se pudo actualizar
     */
    public boolean actualizarRamo(String nombreAlumno, String codigoAsignatura, int estadoRamo, ColeccionCursos mapa_Cursos){
        
        for (int i = 0 ; i < listaCarreras.size() ; i++) {
            if(listaCarreras.get(i).actualizarRamo(nombreAlumno, codigoAsignatura, estadoRamo)){
                if(estadoRamo == 0 || estadoRamo == 2){
                    mapa_Cursos.disminuirAlumnos(codigoAsignatura);
                }else if(estadoRamo == 1){
                    mapa_Cursos.aumentarAlumnos(codigoAsignatura);
                }
                return true;
            }
        }
        return false;
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
     * Metodo para reunir informacion para el reporte
     * @return String con la informacion concatenada
     */
    public String reporteCarrera(){
        String[] infoSeparada;
        String infoConcatenada = new String();
        for(int i = 0 ; i < listaCarreras.size() ; i++){
            infoSeparada = listaCarreras.get(i).mostrarCarrera().split("-");
            infoConcatenada += String.format("[%-20s] + [%-16S]\n",infoSeparada[0],infoSeparada[1]);
        }
        return infoConcatenada;
    }

    /**
     * Metodo para reunir informacion para el reporte
     * @return String con la informacion concatenada
     */
    public String reporteAlumnos(){
        String[] infoObtenida;
        String[] infoSeparada;
        String infoConcatenada = new String();
        for(int i = 0 ; i < listaCarreras.size() ; i++){
            infoObtenida = listaCarreras.get(i).mostrarListaAlumnos();

            for(int k = 0 ; k < infoObtenida.length ; k++){
                infoSeparada = infoObtenida[k].split("-"); //Se separa la informacion por un guion
                infoConcatenada += String.format("[%-15s] + [%-11s] + [%-17s]\n",infoSeparada[0],infoSeparada[1],infoSeparada[2]);
            }
        }
        return infoConcatenada;
    }

    /**
     * Metodo para reunir informacion para el reporte
     * @return String con la informacion concatenada
     */
    public String reporteCursos(){
        String[] infoObtenida;
        String[] infoSeparada;
        String infoConcatenada = new String();
        for(int i = 0 ; i < listaCarreras.size() ; i++){
            infoObtenida = listaCarreras.get(i).mostrarAsignaturas();

            for(int k = 0 ; k < infoObtenida.length ; k++){
                infoSeparada = infoObtenida[k].split("-"); //Se separa la informacion por un guion
                infoConcatenada += String.format("[%-30s] + [%-16s] + [%-20s] + [%-17s] + [%-19s] + [%-14s]\n",infoSeparada[0],infoSeparada[1],infoSeparada[2],infoSeparada[3],infoSeparada[4],infoSeparada[5]);
            }
        }
        return infoConcatenada;
    }
}
