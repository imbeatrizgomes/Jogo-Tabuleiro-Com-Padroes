package jogadores;

public class JogadorComSorte extends Jogador {

    public JogadorComSorte(String nome, CorJogador cor) {
        super(nome, cor);
        this.tipo = TipoJogador.SORTUDO;
    }

    @Override
    public int rolarDados() {
        int[] dadosJogados = dados.rolar2();
        int soma = dadosJogados[0] + dadosJogados[1];
        if (soma < 7) soma = 7;

        System.out.println(getNome() + " (Sortudo) jogou os dados: [" + dadosJogados[0] + " e " + dadosJogados[1] + "] = " + soma);

        return soma;
    }

}


