public class Alumno {
    private String nombreAlumno;
    private String mallaCurricular[];
    private String ramosAprobados[];
    private String ramosActuales[];
    private String ramosFaltantes[];
    private int cantCreditos;

    public Alumno(){
        
    }

    public Alumno(String nombreAlumno, String mallaCurricular[], String ramosAprobados[], 
                    String ramosActuales[], String ramosFaltantes[], int cantCreditos){
        this.nombreAlumno = nombreAlumno;
        this.mallaCurricular = mallaCurricular;
        this.ramosAprobados = ramosAprobados;
        this.ramosActuales = ramosActuales;
        this.ramosFaltantes = ramosFaltantes;
        this.cantCreditos = cantCreditos;
    }

    public void setNombreAlumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
    }

    public void setMallaCurricular(String mallaCurricular[]){
        this.mallaCurricular= mallaCurricular;
    }

    public void setRamosAprobados(String ramosAprobados[]){
        this.ramosAprobados = ramosAprobados;
    }

    public void setRamosActuales(String ramosActuales[]){
        this.ramosActuales = ramosActuales;
    }

    public void setRamosFaltantes(String ramosFaltantes[]){
        this.ramosFaltantes = ramosFaltantes;
    }

    public void setCantCreditos(int cantCreditos){
        this.cantCreditos = cantCreditos;
    }

    public String getNombreAlumno(){
        return this.nombreAlumno;
    }

    public String[] getMallaCurricular(){
        return this.mallaCurricular;
    }

    public String[] getRamosAprobados(){
        return this.ramosAprobados;
    }

    public String[] getRamosActuales(){
        return this.ramosActuales;
    }

    public String[] getRamosFaltantes(){
        return this.ramosFaltantes;
    }

    public int getCantCreditos(){
        return this.cantCreditos;
    }
}
