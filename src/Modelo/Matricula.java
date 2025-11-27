package Modelo;

public class Matricula {

    private int numMatricula, codAlumno, codCurso;

    public Matricula() {
    }

    public Matricula(int numMatricula, int codAlumno, int codCurso) {
        this.numMatricula = numMatricula;
        this.codAlumno = codAlumno;
        this.codCurso = codCurso;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public int getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(int codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    @Override
    public String toString() {
        return String.valueOf(numMatricula);
    }
}
