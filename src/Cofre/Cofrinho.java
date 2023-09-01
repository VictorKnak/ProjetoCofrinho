package Cofre;

import java.util.ArrayList;

public class Cofrinho {

    ArrayList<Moeda> ListaMoeda = new ArrayList<Moeda>();

    // Adicionar a moeda
    public void adicionar(Moeda valor) {
        ListaMoeda.add(valor);
    }

    // Remover as moedas
    public void remover(Moeda m) {
        ListaMoeda.remove(m);
    }

    // Lista as moedas
    public void listar() {

        for (Moeda M : ListaMoeda) {
            M.info();
        }

    }

    // total Convertido
    public void totalConvertido() {

    }

}
