package tabuleiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import casas.Casa;
import casas.CasaFactory;
import jogadores.CorJogador;
import jogadores.Jogador;
import jogadores.JogadorFactory;

public class Tabuleiro {

    private static Tabuleiro instancia;

    private List<Casa> casas = new ArrayList<>();
    private List<Jogador> jogadores = new ArrayList<>();

    private Tabuleiro() {
    	
    }

    public static Tabuleiro getInstance() {
        if (instancia == null) {
            instancia = new Tabuleiro();
        }
        return instancia;
    }

    public void configurarCasasViaUsuario(int numCasas, Scanner sc) {
        casas = new ArrayList<>();

        System.out.println("\nTipos de casa possíveis:");
        System.out.println("simples, sorte, azar, prisao, reversa, surpresa, jogadenovo");

        for (int i = 0; i <= numCasas; i++) {
            System.out.print("Tipo da casa " + i + ": ");
            String tipo = sc.nextLine().trim().toLowerCase();

            while (!tipoValido(tipo)) {
                System.out.println("Tipo inválido! Digite novamente:");
                tipo = sc.nextLine().trim().toLowerCase();
            }

            casas.add(CasaFactory.criarCasa(i, tipo));
        }

        System.out.println("\nTabuleiro configurado com " + casas.size() + " casas!");
    }

    //Validar tipos
    private boolean tipoValido(String tipo) {
        switch (tipo) {
            case "simples":
            case "sorte":
            case "azar":
            case "prisao":
            case "reversa":
            case "surpresa":
            case "jogadenovo":
                return true;
            default:
                return false;
        }
    }

    public void configurarJogadoresViaUsuario(int numJogadores, Scanner sc) {
        jogadores = new ArrayList<>();

        for (int i = 1; i <= numJogadores; i++) {
            System.out.println("\nJogador " + i);

            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();

            CorJogador cor = null;
            while (cor == null) {
            	System.out.print("Cores válidas: AZUL, LARANJA, MARROM, PRETO, ROSA, VERMELHO.");
            	System.out.println();
            	System.out.println("Cor: ");
                String corTxt = sc.nextLine().trim();
                cor = CorJogador.fromString(corTxt);
                if (cor == null) {
                    System.out.println("Cor inválida! Cores válidas: AZUL, LARANJA, MARROM, PRETO, ROSA, VERMELHO.");
                }
            }

            System.out.print("Tipo (1-Normal, 2-Sortudo, 3-Azarado): ");
            int tipo = lerTipoJogador(sc);

            jogadores.add(JogadorFactory.criarJogador(nome, cor, tipo));
        }

        System.out.println("\nJogadores configurados!");
    }
    
    private int lerTipoJogador(Scanner sc) {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 1 && n <= 3) return n;
            } catch (Exception ignored) {}
            System.out.print("Tipo inválido! Digite 1, 2 ou 3: ");
        }
    }

    public List<Casa> getCasas() {
        return casas;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public boolean chegouAoFim(Jogador j) {
        return j.getPosicao() >= casas.size() - 1;
    }
}