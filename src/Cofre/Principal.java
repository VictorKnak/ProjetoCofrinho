package Cofre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {

        // Declaração e inicialização das variáveis
        int opcao;
        String nomeDaOpcao = "";
        String opcaoErrada = "\n** Opção incorreta tente novamente! **";
        double valor = 0;
        String identificacaoMoeda = "";
        String menu = "";
        String opcaoMoeda = "";
        int tipoMoeda = 0;

        // Monta o menu
        menu += "\n|------------------|";
        menu += "\n|------ Menu ------|";
        menu += "\n|------------------|";
        menu += "\n1 - Adicionar";
        menu += "\n2 - Remover";
        menu += "\n3 - Listar";
        menu += "\n4 - Calcular total convertido para Real";
        menu += "\n5 - Encerrar";

        // Monta as opções de moeda
        opcaoMoeda += "1 - Dolar";
        opcaoMoeda += "\n2 - Euro";
        opcaoMoeda += "\n3 - Real";
        opcaoMoeda += "\n4 - Voltar";

        // Estancia a classe cofrinho
        Cofrinho cofrinho = new Cofrinho();

        while (true) {

            // Estancia a classe para pegar dado do teclado
            Scanner teclado = new Scanner(System.in);

            System.out.println(menu);

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

            // Caso escolha Dola
            if (opcao == 1) {

                // Loop infinito
                while (true) {

                    // Imprime as opções de moedas para adicionar
                    System.out.println("\n|======================================================|");
                    System.out.println("| Escolha qual tipo de moeda que você deseja adicionar |");
                    System.out.println("|======================================================|");
                    System.out.println(opcaoMoeda);

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

                        // Se for escolhido Dolar
                        if (tipoMoeda == 1) {
                            cofrinho.adicionar(new Dolar(valor));

                            identificacaoMoeda = "$";

                            // Se for escolhido Euro
                        } else if (tipoMoeda == 2) {
                            cofrinho.adicionar(new Euro(valor));
                            identificacaoMoeda = "\u20AC";

                            // Se for escolhido Real
                        } else if (tipoMoeda == 3) {
                            cofrinho.adicionar(new Real(valor));
                            identificacaoMoeda = "R$";
                        }

                        // Imprime na tela o valor depositado
                        System.out.println("\nValor de " + identificacaoMoeda + valor + " depositado com sucesso!");
                        break;

                    }

                }

                // Remover
            } else if (opcao == 2) {

                // Loop infinito
                while (true) {

                    // Imprime as opções de moedas para adicionar
                    System.out.println("\n|======================================================|");
                    System.out.println("|  Escolha qual tipo de moeda que você deseja remover  |");
                    System.out.println("|======================================================|");
                    System.out.println(opcaoMoeda);

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

                        System.out.println("\n$$ Digite o valor que deseja remover $$");

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

                        // Se for escolhido Dolar
                        if (tipoMoeda == 1) {
                            cofrinho.remover(new Dolar(valor));

                            identificacaoMoeda = "$";

                            // Se for escolhido Euro
                        } else if (tipoMoeda == 2) {
                            cofrinho.remover(new Euro(valor));
                            identificacaoMoeda = "\u20AC";

                            // Se for escolhido Real
                        } else if (tipoMoeda == 3) {
                            cofrinho.remover(new Real(valor));
                            identificacaoMoeda = "R$";
                        }

                        // Imprime na tela o valor depositado
                        System.out.println("\nValor de " + identificacaoMoeda + valor + " removido com sucesso!");
                        break;

                    }

                }

            }
            // Listar
            else if (opcao == 3) {
                // Chama o método para listar as moedas depositadas
                cofrinho.listar();

                // Calcular total convertido
            } else if (opcao == 4) {
                System.out.println("\nVocê possui R$ " + cofrinho.totalConvertido() + " depositados!");

                // Encerrar
            } else if (opcao == 5) {
                System.out.println("Programa encerrado com sucesso!");
                break;
            }

        }

    }

}
