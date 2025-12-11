package casas;

import jogadores.Jogador;

public class CasaPrisao extends Casa {

    public CasaPrisao(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {
                jogador.setPulaRodada(true);
                System.out.println(jogador.getNome() + " caiu na PRISÃO e vai pular a próxima rodada!");
            }
        });
    }
}
