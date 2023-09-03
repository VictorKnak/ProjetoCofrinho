package Cofre;

public class Real extends Moeda {

    double cotacao = 1;

    public Real(double valor) {
        super(valor);
    }

    @Override
    void info() {

        System.out.println("\nReal - Valor depositado: R$ " + valor);
    }

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
        Real other = (Real) obj;
        if (Double.doubleToLongBits(cotacao) != Double.doubleToLongBits(other.cotacao))
            return false;
        return true;
    }

}
