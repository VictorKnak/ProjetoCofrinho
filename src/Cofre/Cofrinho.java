package Cofre;

import java.util.ArrayList;

public class Cofrinho {

    ArrayList<Moeda> Moeda = new ArrayList<Moeda>();

    // Adicionar a moeda
    public void adicionar(Moeda m) {
        Moeda.add(m);
    }

    // Remover as moedas
    public void remover(Moeda m) {
        Moeda.remove(m);
    }

    // Lista as moedas
    public void listar() {

        for (Moeda M : Moeda) {
            System.out.println(M);
        }

    }

    // total Convertido
    public void totalConvertido() {

    }

}
