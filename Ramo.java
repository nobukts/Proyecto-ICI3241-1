public class Ramo{
    private String nombreRamo;
    private String codigoRamo;
    private String nombreProfesor;
    private int creditosOtorga;
    private int cantidadAlumnos;

    public Ramo() {

    }

    public Ramo(String nombreRamo, String codigoRamo, String nombreProfesor, int creditosOtorga, int cantidadAlumnos) {
        this.nombreRamo = nombreRamo;
        this.codigoRamo = codigoRamo;
        this.nombreProfesor = nombreProfesor;
        this.creditosOtorga = creditosOtorga;
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public void setNombreRamo(String nombreRamo){
        this.nombreRamo = nombreRamo;
    }
    public void setCodigoRamo(String codigoRamo){
        this.codigoRamo = codigoRamo;
    }
    public void setNombreProfesor(String nombreProfesor){
        this.nombreProfesor = nombreProfesor;
    }
    public void setCreditosOtorga(int creditosOtorga){
        this.creditosOtorga = creditosOtorga;
    }
    public void setCantidadAlumnos(int cantidadAlumnos){
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public String getNombreRamo(){
        return this.nombreRamo;
    }
    public String getcodigoRamo(){
        return this.codigoRamo;
    }
    public String getNombreProfesor(){
        return this.nombreProfesor;
    }
    public int getCreditosOtorga(){
        return this.creditosOtorga;
    }
    public int getCantidadAlumnos(){
        return this.cantidadAlumnos;
    }


}