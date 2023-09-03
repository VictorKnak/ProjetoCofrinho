package Cofre;

import java.util.ArrayList;

public class Cofrinho {

    double totalValor;

    ArrayList<Moeda> listaMoeda = new ArrayList<Moeda>();

    // Adicionar a moeda
    public void adicionar(Moeda valor) {
        listaMoeda.add(valor);
    }

    // Remover as moedas
    public void remover(Moeda m) {
        listaMoeda.remove(m);
    }

    // Lista as moedas
    public void listar() {

        for (Moeda m : listaMoeda) {
            m.info();
        }

    }

    // total Convertido
    public double totalConvertido() {

        for (Moeda m : listaMoeda) {
            totalValor += m.converter();
        }

        return totalValor;

    }

}
