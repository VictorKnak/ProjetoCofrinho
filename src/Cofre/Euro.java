package Cofre;

public class Euro extends Moeda {

    // declarando a cotação atual do Euro
    double cotacao = 5.28;

    public Euro(double valor, double cotacao) {
        super(valor);
        this.cotacao = cotacao;
    }

    @Override
    double info() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'info'");
    }

    // Converter o Euro para real
    @Override
    double converter() {

        return valor *= cotacao;

        // throw new UnsupportedOperationException("Unimplemented method 'converter'");
    }

}
