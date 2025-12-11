package jogadores;

public class JogadorSemSorte extends Jogador {

    public JogadorSemSorte(String nome, CorJogador cor) {
        super(nome, cor);
        this.tipo = TipoJogador.AZARADO;
    }

    @Override
    public int rolarDados() {
        int[] dadosJogados = dados.rolar2();
        int soma = dadosJogados[0] + dadosJogados[1];
        if (soma > 6) soma = 6;

        System.out.println(getNome() + " (Azarado) jogou os dados: [" + dadosJogados[0] + " e " + dadosJogados[1] + "] = " + soma);

        return soma;
    }

}


