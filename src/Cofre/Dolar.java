package Cofre;

public class Dolar extends Moeda {

    // declarando a cotação atual do Dolar
    double cotacao = 4.88;

    // cria o contrutor
    public Dolar(double valor) {
        super(valor);
    }

    // método com as informações da moeda
    @Override
    void info() {

        System.out.println("\nDolar - Valor depositado: $ " + valor);
        System.out.println("        Cotação da moeda: R$ " + cotacao);

    }

    // método que converte o dolar para o real
    @Override
    double converter() {

        return valor *= cotacao;
    }

}
