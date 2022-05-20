
package com.mycompany.avancecurricular;

/**
 *
 * @author alehe
 */
public interface Verificador {
    public boolean verificar(String carrera);
    public boolean verificarAlumno(String alumno, String carrera);
    public boolean verificarRamo(String alumno, String carrera, String ramo);
    public boolean verificarRamo(String alumno, String ramo);
    
}
