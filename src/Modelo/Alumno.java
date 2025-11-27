package Modelo;

public class Alumno {

    private int codAlumno, Edad, Estado;
    private String Nombres, Apellidos, DNI, Celular;

    public Alumno() {
    }

    public Alumno(int codAlumno, int Edad, int Estado, String Nombres, String Apellidos, String DNI, String Celular) {
        this.codAlumno = codAlumno;
        this.Edad = Edad;
        this.Estado = Estado;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.DNI = DNI;
        this.Celular = Celular;
    }

    public Alumno(int codAlumno, String Nombres) {
        this.codAlumno = codAlumno;
        this.Nombres = Nombres;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    @Override
    public String toString() {
        return codAlumno + " - " + Nombres;
    }

}
