package Cofre;

public class Euro extends Moeda {

    // declarando a cotação atual do Euro
    double cotacao = 5.28;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    void info() {

        System.out.println("Euro - Valor depositado: R$ " + valor);
        System.out.println("Cotação da moeda: RS " + cotacao);
    }

    // @Override
    // public String toString() {
    // return "\nDolar - Valor depositado: R$" + valor + "\n Cotação da moeda: R$" +
    // cotacao;
    // }

    // Converter o Euro para real
    @Override
    double converter() {

        return valor *= cotacao;

        // throw new UnsupportedOperationException("Unimplemented method 'converter'");
    }

}
