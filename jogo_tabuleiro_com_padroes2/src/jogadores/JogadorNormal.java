package jogadores;

public class JogadorNormal extends Jogador {

    public JogadorNormal(String nome, CorJogador cor) {
        super(nome, cor);
        this.tipo = TipoJogador.NORMAL;
    }

    @Override
    public int rolarDados() {
        int[] dadosJogados = dados.rolar2();
        int soma = dadosJogados[0] + dadosJogados[1];

        System.out.println(getNome() + " jogou os dados: [" + dadosJogados[0] + " e " + dadosJogados[1] + "] = " + soma);

        return soma;
    }

}


