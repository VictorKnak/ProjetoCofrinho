package Cofre;

public abstract class Moeda {

    double valor;

    // cria o contrutor
    public Moeda(double valor) {
        super();
        this.valor = valor;
    }

    // métodos abstrados para as classes filhas
    abstract double info();

    abstract double converter();

}
