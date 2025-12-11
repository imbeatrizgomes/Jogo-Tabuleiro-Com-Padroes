package tabuleiro;

import java.util.List;

import jogadores.CorJogador;
import jogadores.Jogador;

public class DesenharTabuleiro {

    private DesenharTabuleiro() {}

    public static String desenhar(List<Jogador> jogadores, int totalCasas) {

        StringBuilder sb = new StringBuilder();

        int casasPorLinha = 10;

        sb.append("\n============================================================\n");
        sb.append(String.format("%35s%n", " TABULEIRO"));
        sb.append("============================================================\n");

        //Casa inicial
        sb.append("Casa inicial (0): [");
        sb.append(jogadoresNaCasa(jogadores, 0));
        sb.append("]\n\n");

        //Linhas 
        for (int inicio = 1; inicio < totalCasas; inicio += casasPorLinha) {
            int fim = Math.min(inicio + casasPorLinha - 1, totalCasas - 1);

            sb.append(gerarLinhaDeCasas(jogadores, inicio, fim));
            sb.append(gerarLinhaDeNumeros(inicio, fim));
            sb.append("\n");
        }

        sb.append("============================================================\n");
        return sb.toString();
    }

    private static String jogadoresNaCasa(List<Jogador> jogadores, int casa) {
        StringBuilder sb = new StringBuilder();

        for (Jogador p : jogadores) {
            if (p.getPosicao() == casa) {

                CorJogador cor = p.getCor();
                String inicial;

                if (cor != null) {
                    inicial = cor.name().substring(0, 1);
                } else {
                    inicial = p.getNome().substring(0, 1).toUpperCase();
                }

                if (sb.length() > 0) sb.append(" ");

                sb.append(inicial);
            }
        }

        return sb.toString();
    }

    private static String gerarLinhaDeCasas(List<Jogador> jogadores, int inicio, int fim) {
        StringBuilder sb = new StringBuilder();

        for (int i = inicio; i <= fim; i++) {
            String dentro = jogadoresNaCasa(jogadores, i);

            sb.append("[");
            if (dentro.isEmpty()) {
                sb.append(" ");
            } else {
                sb.append(dentro);
            }
            sb.append("] ");
        }

        sb.append("\n");
        return sb.toString();
    }

    private static String gerarLinhaDeNumeros(int inicio, int fim) {
        StringBuilder sb = new StringBuilder();

        for (int i = inicio; i <= fim; i++) {
            sb.append(String.format("%3d ", i));
        }

        sb.append("\n");
        return sb.toString();
    }
}