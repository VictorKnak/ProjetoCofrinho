package Cofre;

public class Euro extends Moeda {

    // declarando a cotação atual do Euro
    double cotacao = 5.28;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    void info() {

        System.out.println("\nEuro - Valor depositado: \u20AC " + valor);
        System.out.println("       Cotação da moeda: R$ " + cotacao);
    }

    // Converter o Euro para real
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
        Euro other = (Euro) obj;
        if (Double.doubleToLongBits(cotacao) != Double.doubleToLongBits(other.cotacao))
            return false;
        return true;
    }

    

}
