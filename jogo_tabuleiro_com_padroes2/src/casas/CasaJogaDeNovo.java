package casas;

import jogadores.Jogador;

public class CasaJogaDeNovo extends Casa {

    public CasaJogaDeNovo(int numero) {
        super(numero, new RegraCasa() {

            @Override
            public void aplicar(Jogador jogador) {

                int numeroDeCasas = jogador.rolarDados();
                jogador.mover(numeroDeCasas);
                
                System.out.println(
                    jogador.getNome() + " jogou de novo e andou " + numeroDeCasas + " casas!"
                );
            }
        });
    }
}