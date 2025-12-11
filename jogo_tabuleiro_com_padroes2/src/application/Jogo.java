package application;

import java.util.Scanner;

import casas.Casa;
import casas.CasaReversa;
import jogadores.Jogador;
import tabuleiro.DesenharTabuleiro;
import tabuleiro.Tabuleiro;

public class Jogo {

    private Tabuleiro tabuleiro;
    private boolean debug;

    private final Scanner sc = new Scanner(System.in);

    public Jogo(boolean debug) {
        this.tabuleiro = Tabuleiro.getInstance();
        this.debug = debug;
    }

    public void configTabuleiro(int numCasas) {
        System.out.println("\n--- CONFIGURANDO O TABULEIRO ---");
        tabuleiro.configurarCasasViaUsuario(numCasas, sc);
    }

    public void config(int numJogadores) {
        System.out.println("\n--- CONFIGURANDO OS JOGADORES ---");
        tabuleiro.configurarJogadoresViaUsuario(numJogadores, sc);
    }

    public void printTabuleiro() {
        System.out.println(DesenharTabuleiro.desenhar(tabuleiro.getJogadores(),tabuleiro.getCasas().size()));
    }
    
    public void start() {

        boolean ativo = true;
        int turno = 0;

        System.out.println("\n========= INICIANDO O JOGO =========");
        if (debug) {
            System.out.println("MODO DEBUG ATIVADO — nesse modo os movimentos são manuais!");
        }

        while (ativo) {

            Jogador atual = tabuleiro.getJogadores().get(turno % tabuleiro.getJogadores().size());

            esperarJogador(atual);

            if (processarPrisao(atual)) {
                turno++;
                continue;
            }

            moverJogador(atual);

            aplicarTurbo(atual);

            aplicarRegraDaCasa(atual);

            mostrarPosicoes();

            printTabuleiro();

            abrirLojinha(atual);

            if (tabuleiro.chegouAoFim(atual)) {
                finalizarJogo(atual);
                ativo = false;
            }

            atual.setComprouNoTurno(false);

            turno++;
        }
    }

    private void esperarJogador(Jogador atual) {
        System.out.println("\nVez de " + atual.getNome() + " (" + atual.getCor() + ") — Tipo: " + atual.getTipo());
        System.out.print("Pressione ENTER para jogar...");
        sc.nextLine();
    }

    private boolean processarPrisao(Jogador atual) {

        if (!atual.isPulaRodada()) return false;

        if (atual.temSaidaPrisao()) {
            System.out.println(atual.getNome() + " usou o item SAIR DA PRISÃO!");
            atual.consumirSaidaPrisao();
            atual.setPulaRodada(false);
            return false;
        }

        System.out.println(atual.getNome() + " está preso e perde a vez!");
        atual.setPulaRodada(false);
        return true;
    }

    private void moverJogador(Jogador atual) {

        if (debug) {
            int novaPosicao = lerPosicaoDebug();
            atual.setPosicao(novaPosicao);
            System.out.println("(DEBUG) " + atual.getNome() + " foi movido para a casa " + novaPosicao);
            return;
        }

        int numeroDeCasas = atual.rolarDados();

        if (atual.temDadoSorte()) {
            numeroDeCasas += 1;
            System.out.println("Bônus do Dado da Sorte! +1 no movimento.");
            atual.consumirDadoSorte();
        }

        atual.mover(numeroDeCasas);
        System.out.println(atual.getNome() + " andou " + numeroDeCasas + " casas.");

        if (atual.getPosicao() >= tabuleiro.getCasas().size()) {
            atual.setPosicao(tabuleiro.getCasas().size() - 1);
        }
    }

    private int lerPosicaoDebug() {
        while (true) {
            try {
                int pos = Integer.parseInt(sc.nextLine());
                if (pos >= 0 && pos < tabuleiro.getCasas().size()) {
                    return pos;
                }
                System.out.print("Casa inválida! Digite novamente: ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida! Digite um número: ");
            }
        }
    }

    private void aplicarTurbo(Jogador atual) {
        if (atual.temTurbo()) {
            System.out.println("Turbo ativado! +3 casas!");
            atual.mover(3);
            atual.consumirTurbo();
        }
    }

    private void aplicarRegraDaCasa(Jogador atual) {
        Casa casa = tabuleiro.getCasas().get(atual.getPosicao());

        if (casa instanceof CasaReversa) {
            ((CasaReversa) casa).aplicarRegra(atual, sc);
        } else {
            casa.aplicarRegra(atual);
        }
    }

    private void mostrarPosicoes() {
        System.out.println("\nPosição dos jogadores:");
        for (Jogador j : tabuleiro.getJogadores()) {
            System.out.println(j.getNome() + " (" + j.getCor() + ") [" +
                    j.getTipo() + "] está na casa " + j.getPosicao());
        }
    }

    private void abrirLojinha(Jogador atual) {
        System.out.print("\n" + atual.getNome() +
                ", deseja abrir a lojinha? (s/n): ");
        String abrir = sc.nextLine().trim().toLowerCase();

        if (abrir.equals("s") || abrir.equals("sim")) {
            Loja.exibirLoja(atual, sc);
        }
    }

    private void finalizarJogo(Jogador atual) {

        System.out.println(atual.getNome() + " venceu o jogo!");

        System.out.println("\n======= FIM DE JOGO =======");

        for (Jogador j : tabuleiro.getJogadores()) {
            System.out.println("\nJogador: " + j.getNome());
            System.out.println("Cor: " + j.getCor());
            System.out.println("Tipo: " + j.getTipo());
            System.out.println("Posição final: " + j.getPosicao());
            System.out.println("Moedas: " + j.getMoedas());
            System.out.println("Total de jogadas: " + j.getJogadas());
        }

        System.out.println("\n===============================\n");
    }
}