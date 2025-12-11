package jogadores;

public class JogadorFactory {

    public static Jogador criarJogador(String nome, CorJogador cor, int tipo) {
        switch (tipo) {
            case 1: return new JogadorNormal(nome, cor);
            case 2: return new JogadorComSorte(nome, cor);
            case 3: return new JogadorSemSorte(nome, cor);
            default: throw new IllegalArgumentException("Tipo de jogador inválido!");
        }
    }
}

