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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(cotacao);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dolar other = (Dolar) obj;
        if (Double.doubleToLongBits(cotacao) != Double.doubleToLongBits(other.cotacao))
            return false;
        return true;
    }



    
}
