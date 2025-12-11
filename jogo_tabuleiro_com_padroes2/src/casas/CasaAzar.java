package casas;

import jogadores.TipoJogador;
import jogadores.Jogador;

public class CasaAzar extends Casa {

    public CasaAzar(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {
                if (jogador.getTipo() == TipoJogador.SORTUDO) {
                    System.out.println(jogador.getNome() + " é sortudo e NÃO volta 3 casas.");
                } else {
                    jogador.mover(-3);
                    System.out.println(jogador.getNome() + " voltou 3 casas! (CASA DO AZAR)");
                }
            }
        });
    }
}

