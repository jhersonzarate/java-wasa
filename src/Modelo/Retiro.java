package Modelo;

public class Retiro {

    private int numRetiro, numMatricula;

    public Retiro() {
    }

    public Retiro(int numRetiro, int numMatricula) {
        this.numRetiro = numRetiro;
        this.numMatricula = numMatricula;
    }

    public int getNumRetiro() {
        return numRetiro;
    }

    public void setNumRetiro(int numRetiro) {
        this.numRetiro = numRetiro;
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

}
