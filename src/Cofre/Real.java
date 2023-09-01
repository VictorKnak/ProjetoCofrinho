package Cofre;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    void info() {

        System.out.println("Real - Valor depositado: R$ " + valor);
    }

    // @Override
    // public String toString() {
    //     return "\nReal - Valor depositado: R$" + valor;
    // }

    @Override
    double converter() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'converter'");
    }

}
