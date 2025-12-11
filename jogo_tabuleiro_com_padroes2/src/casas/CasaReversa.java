package casas;

import java.util.Scanner;
import jogadores.Jogador;
import tabuleiro.Tabuleiro;

public class CasaReversa extends Casa {

    public CasaReversa(int numero) {
        super(numero, new RegraCasa() {
            @Override
            public void aplicar(Jogador jogador) {
            }
        });
    }
    
    public void aplicarRegra(Jogador jogador, Scanner sc) {

        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        Jogador maisAtras = tabuleiro.getJogadores().stream()
                .filter(j -> j != jogador)
                .min((a, b) -> Integer.compare(a.getPosicao(), b.getPosicao()))
                .orElse(null);

        if (maisAtras == null || maisAtras.getPosicao() >= jogador.getPosicao()) {
            System.out.println(jogador.getNome() + " já era o último!");
            return;
        }

        if (jogador.temImunidadeReversa()) {
            System.out.println(jogador.getNome() + " usou sua IMUNIDADE REVERSA e evitou a troca!");
            jogador.consumirImunidadeReversa();
            jogador.setComprouNoTurno(true);
            return;
        }

        System.out.print(jogador.getNome() + ", deseja comprar IMUNIDADE por 5 moedas para evitar a troca? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();

        if (resp.equals("s") || resp.equals("sim")) {
            if (jogador.getMoedas() >= 5) {
                jogador.adicionarMoedas(-5);
                System.out.println("Imunidade a casa Reversa comprada e usada imediatamente!");
                jogador.setComprouNoTurno(true);
                return;
            } else {
                System.out.println("Moedas insuficientes!");
            }
        }

        int temp = jogador.getPosicao();
        jogador.setPosicao(maisAtras.getPosicao());
        maisAtras.setPosicao(temp);

        System.out.println(jogador.getNome() + " TROCOU DE POSIÇÃO com " + maisAtras.getNome() + " (CASA REVERSA)");
    }
}