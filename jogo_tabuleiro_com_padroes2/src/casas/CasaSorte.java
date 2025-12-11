package casas;

import jogadores.Jogador;
import jogadores.TipoJogador;

public class CasaSorte extends Casa {

    public CasaSorte(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {
                if (jogador.getTipo() == TipoJogador.AZARADO) {
                    System.out.println(jogador.getNome() + " é azarado e NÃO pode avançar 3 casas.");
                } else {
                    jogador.mover(3);
                    System.out.println(jogador.getNome() + " avançou 3 casas! (CASA DA SORTE)");
                }
            }
        });
    }
}