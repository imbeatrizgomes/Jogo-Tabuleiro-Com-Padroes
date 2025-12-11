package casas;

import java.util.Random;
import jogadores.Jogador;
import jogadores.TipoJogador;

public class CasaSurpresa extends Casa {

    private static final Random random = new Random();

    public CasaSurpresa(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {

                int tipo = random.nextInt(3);
                TipoJogador novo;

                switch (tipo) {
                    case 0: novo = TipoJogador.NORMAL; break;
                    case 1: novo = TipoJogador.AZARADO; break;
                    default: novo = TipoJogador.SORTUDO; break;
                }

                jogador.mudarTipo(novo);
                System.out.println(jogador.getNome() + " caiu na Casa Surpresa! Agora é " + jogador.getTipo() + ".");
            }
        });
    }
}