package casas;

import jogadores.Jogador;

public class CasaSimples extends Casa {

    public CasaSimples(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {
                jogador.adicionarMoedas(1);
                System.out.println(jogador.getNome() + " caiu em uma CASA NORMAL e ganhou +1 moeda. Total: " + jogador.getMoedas());
            }
        });
    }
}
