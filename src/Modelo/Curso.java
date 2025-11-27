package Modelo;

public class Curso {

    private int codCurso, Ciclo, Creditos, Horas;
    private String Asignatura;

    public Curso() {
    }

    public Curso(int codCurso, int Ciclo, int Creditos, int Horas, String Asignatura) {
        this.codCurso = codCurso;
        this.Ciclo = Ciclo;
        this.Creditos = Creditos;
        this.Horas = Horas;
        this.Asignatura = Asignatura;
    }

    public Curso(int codCurso, String Asignatura) {
        this.codCurso = codCurso;
        this.Asignatura = Asignatura;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getCiclo() {
        return Ciclo;
    }

    public void setCiclo(int Ciclo) {
        this.Ciclo = Ciclo;
    }

    public int getCreditos() {
        return Creditos;
    }

    public void setCreditos(int Creditos) {
        this.Creditos = Creditos;
    }

    public int getHoras() {
        return Horas;
    }

    public void setHoras(int Horas) {
        this.Horas = Horas;
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    @Override
    public String toString() {
        return codCurso + " - " + Asignatura;
    }

}
