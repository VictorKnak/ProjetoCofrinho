package Cofre;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    void info() {

        System.out.println("\nReal - Valor depositado: R$ " + valor);
    }

    @Override
    double converter() {
        return valor;
    }

}
