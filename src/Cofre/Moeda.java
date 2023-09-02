package Cofre;

public abstract class Moeda {

    double valor;

    // cria o construtor
    public Moeda(double valor) {
        this.valor = valor;
    }

    // métodos abstrados para as classes filhas
    abstract void info();

    abstract double converter();

}
