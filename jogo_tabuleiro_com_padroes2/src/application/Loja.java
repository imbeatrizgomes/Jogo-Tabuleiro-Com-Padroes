package application;

import java.util.Scanner;
import jogadores.Jogador;

public class Loja {

    public static void exibirLoja(Jogador jogador, Scanner sc) {

        //Serve para caso o jogador compre na lojinha o item reverso
        if (jogador.isComprouNoTurno()) {
            System.out.println("\nVocê já comprou neste turno! Não pode abrir a lojinha agora.");
            return;
        }

        System.out.println("\n===== LOJINHA DO TABULEIRO =====");
        System.out.println(jogador.getNome() + " possui " + jogador.getMoedas() + " moedas.");

        System.out.println("Deseja comprar algum item?");
        System.out.println("1 - Sair da prisão - (4 moedas)");
        System.out.println("2 - Modo Turbo (+3 casas) - (6 moedas)");
        System.out.println("3 - Imunidade a casa Reversa - (5 moedas)");
        System.out.println("4 - Dado da Sorte (+1 no próximo dado) - (3 moedas)");
        System.out.println("0 - Não comprar");
        System.out.print("Escolha: ");

        String opcao = sc.nextLine().trim();

        switch (opcao) {

            case "1":
                if (jogador.getMoedas() >= 4) {
                    jogador.adicionarMoedas(-4);
                    jogador.ativarSaidaPrisao();
                    jogador.setComprouNoTurno(true);
                    System.out.println("Item 'Sair da Prisão' comprado!");
                } else {
                    System.out.println("Moedas insuficientes.");
                }
                break;

            case "2":
                if (jogador.getMoedas() >= 6) {
                    jogador.adicionarMoedas(-6);
                    jogador.ativarTurbo();
                    jogador.setComprouNoTurno(true);
                    System.out.println("Item 'Modo Turbo' comprado!");
                } else {
                    System.out.println("Moedas insuficientes.");
                }
                break;

            case "3":
                if (jogador.getMoedas() >= 5) {
                    jogador.adicionarMoedas(-5);
                    jogador.ativarImunidadeReversa();
                    jogador.setComprouNoTurno(true);
                    System.out.println("Imunidade a casa Reversa comprada!");
                } else {
                    System.out.println("Moedas insuficientes.");
                }
                break;

            case "4":
                if (jogador.getMoedas() >= 3) {
                    jogador.adicionarMoedas(-3);
                    jogador.ativarDadoSorte();
                    jogador.setComprouNoTurno(true);
                    System.out.println("Item 'Dado da Sorte' comprado!");
                } else {
                    System.out.println("Moedas insuficientes.");
                }
                break;

            case "0":
                System.out.println("Nenhum item comprado.");
                break;

            default:
                System.out.println("Opção inválida — nenhuma compra foi realizada.");
                break;
        }
    }
}
