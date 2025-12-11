package application;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Deseja jogar no modo DEBUG? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();

        boolean debug = resp.equals("s") || resp.equals("sim");

        Jogo jogo = new Jogo(debug);

        System.out.print("Número de casas: ");
        int numCasas = sc.nextInt();  

        int numJogadores = 0;
        while (numJogadores < 2 || numJogadores > 6) {
            System.out.print("Número de jogadores (2 a 6): ");

            if (sc.hasNextInt()) {
                numJogadores = sc.nextInt();

                if (numJogadores < 2 || numJogadores > 6) {
                    System.out.println("Valor inválido! Digite entre 2 e 6.");
                }

            } else {
                System.out.println("Entrada inválida! Digite um inteiro.");
                sc.next();
            }
        }
        sc.nextLine();

        jogo.configTabuleiro(numCasas);
        jogo.config(numJogadores);
        jogo.printTabuleiro();
        jogo.start();

        sc.close();
    }
}
