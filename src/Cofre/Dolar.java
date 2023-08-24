package Cofre;

public class Dolar extends Moeda {

    // declarando a cotação atual do Dolar
    double cotacao = 4.88;

    // cria o contrutor
    public Dolar(double valor, double cotacao) {
        super(valor);
        this.cotacao = cotacao;
    }

    // método com as informações da moeda
    @Override
    double info() {

        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'info'");
    }

    // método que converte o dolar para o real
    @Override
    double converter() {

        return valor *= cotacao;
    }

}
