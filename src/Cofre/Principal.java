package Cofre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {

        // Declaração e inicialização das variáveis
        int opcao;
        String nomeDaOpcao = "";
        String opcaoErrada = "\n** Opção incorreta tente novamente! **";
        Moeda depositar;
        double valor = 0;

        // Estancia a classe cofrinho
        Cofrinho cofrinho = new Cofrinho();

        while (true) {

            // Estancia a classe para pegar dado do teclado
            Scanner teclado = new Scanner(System.in);

            System.out.println("\n|------------------|");
            System.out.println("|------ Menu ------|");
            System.out.println("|------------------|");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Remover");
            System.out.println("3 - Listar");
            System.out.println("4 - Calcular total convertido para Real");
            System.out.println("5 - Encerrar");

            // Carrega a opção digitada no teclado
            opcao = teclado.nextInt();

            if (opcao > 5) {
                System.out.println(opcaoErrada);
                continue;
            }

            // Case para verificar as opções escolhidas e adicionar na String para exibir a
            // mensagem na tela
            switch (opcao) {
                case 1:
                    nomeDaOpcao = "adicionar";
                    break;
                case 2:
                    nomeDaOpcao = "remover";
                    break;
                case 3:
                    nomeDaOpcao = "listar";
                    break;
                case 4:
                    nomeDaOpcao = "calcular total convertido para real";
                    break;
                case 5:
                    nomeDaOpcao = "";
                    break;
            }

            // Valida se a variável está vazia e encerra o programa
            if (nomeDaOpcao.isEmpty()) {
                System.out.println("\n|*************************************|");
                System.out.println("|** Programa encerrado com sucesso! **|");
                System.out.println("|*************************************|");
                return;

            } else { // Caso não esteja vazia imprime a opção escolhida na tela do susuário

                System.out.println("\n** Opção " + nomeDaOpcao.toUpperCase() + " escolhida com sucesso! **");

            }

            // switchCase para caso a opção desejada seja escolhida realiza o método
            switch (opcao) {

                case 1: // Adicionar

                    // inicializa a variavel para carrgar o tipo da moeda
                    int tipoMoeda = 0;

                    // Loop infinito
                    while (true) {

                        // Imprime as opções de moedas para adicionar
                        System.out.println("\n|======================================================|");
                        System.out.println("| Escolha qual tipo de moeda que você deseja adicionar |");
                        System.out.println("|======================================================|");
                        System.out.println("1 - Dolar");
                        System.out.println("2 - Euro");
                        System.out.println("3 - Real");
                        System.out.println("4 - Voltar");
                        tipoMoeda = teclado.nextInt();

                        // Verifica se a opcao escolhida foi para voltar ao menu anterior e da um break
                        // para sair do loop
                        if (tipoMoeda == 4) {
                            break;
                        }

                        // verifica se o tipo da moeda está entre a opções disponiveis
                        if (tipoMoeda <= 0 || tipoMoeda > 3) {

                            // Loop inifinito
                            while (true) {

                                // Qustiona o usuário se deseja continuar
                                System.out.println("\n|----------------------------------------------------|");
                                System.out.println("|** Opção incorreta, deseja tentar novamente S/N ? **|");
                                System.out.println("|----------------------------------------------------|");

                                // Pega do teclado a opção digitada
                                String simNao = teclado.next().toUpperCase();

                                // verifica se é realmente somente um caractere
                                if (simNao.length() == 1) {

                                    // Se for "não" para o programa
                                    if (simNao.equals("N")) {
                                        System.out.println("\n|*************************************|");
                                        System.out.println("|** Programa encerrado com sucesso! **|");
                                        System.out.println("|*************************************|");
                                        return;

                                        // Se for "sim", Saí do Loop
                                    } else if (simNao.equals("S")) {
                                        break;

                                    } else {
                                        System.out.println(opcaoErrada);
                                    }

                                } else { // caso seja mais de 1 caractere pergunta novamente

                                    System.out.println(opcaoErrada);
                                }
                            }

                        } else { // Se estiver nas opções disponiveis adiciona na moeda correspondente

                            System.out.println("\n$$ Digite o valor que deseja depositar $$");

                            // Faz tratamento caso seja digitado algum caractere
                            try {

                                // carrega o valor desejado digitado no teclado
                                valor = teclado.nextDouble();

                                // Se for menor que zero da erro
                                if (valor <= 0) {
                                    throw new RuntimeException("\n!!!! Valor Inválido! Tente novamente !!!!");
                                }

                            } catch (InputMismatchException e) {

                                System.out.println("\n!!!! Formato de número errado! Tente Novamente !!!!");
                                break;

                            }

                            catch (Exception e) {

                                System.out.println(e.getMessage());
                                break;

                            }

                            depositar = null;

                            // switchCase para verificar o tipo da moeda escolhida
                            switch (tipoMoeda) {
                                case 1: // Dolar
                                    depositar = new Dolar(valor);

                                case 2: // Euro
                                    depositar = new Euro(valor);

                                case 3: // Real
                                    depositar = new Real(valor);

                            }

                            cofrinho.adicionar(depositar);
                            System.out.println("Valor de R$" + valor + " depositado com sucesso!");
                            break;

                        }

                    }

                case 2: // Remover
                    break;

                case 3: // Listar

                    cofrinho.listar();
                    break;

                case 4: // Calcular total convertido
                    break;

                case 5: // Encerrar
                    System.out.println("Programa encerrado com sucesso!");
                    break;

            }

        }

    }
}
