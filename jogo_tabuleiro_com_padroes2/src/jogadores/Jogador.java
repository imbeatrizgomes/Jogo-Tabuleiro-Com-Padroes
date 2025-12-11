package jogadores;

public abstract class Jogador {

    protected String nome;
    protected CorJogador cor;
    protected int posicao;
    protected int jogadas;
    protected boolean pulaRodada;
    protected int moedas = 0;

    protected Dados dados = new Dados();
    protected TipoJogador tipo = TipoJogador.NORMAL;

    //Itens da lojinha
    protected boolean itemSaidaPrisao = false;
    protected boolean itemTurbo = false;
    protected boolean itemImunidadeReversa = false;
    protected boolean itemDadoSorte = false;

    //Controle de compra por turno
    protected boolean comprouNoTurno = false;
    
    public Jogador(String nome, CorJogador cor) {
        this.nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        this.cor = cor;
        this.posicao = 0;
        this.jogadas = 0;
        this.pulaRodada = false;
    }

    public String getNome() { 
        return nome; 
    }

    public CorJogador getCor() { 
        return cor; 
    }

    public int getPosicao() { 
        return posicao; 
    }

    public int getJogadas() { 
        return jogadas; 
    }

    public int getMoedas() { 
        return moedas; 
    }

    public boolean isPulaRodada() {
        return pulaRodada;
    }

    public void setPulaRodada(boolean v) {
        this.pulaRodada = v;
    }

    public TipoJogador getTipo() {
        return tipo;
    }

    public void mudarTipo(TipoJogador novo) {
        this.tipo = novo;
    }

    public boolean isComprouNoTurno() { 
        return comprouNoTurno; 
    }

    public void setComprouNoTurno(boolean v) { 
        comprouNoTurno = v; 
    }

    //Itens da lojinha:

    //Sair da prisão
    public boolean temSaidaPrisao() { 
        return itemSaidaPrisao; 
    }
    public void ativarSaidaPrisao() { 
        itemSaidaPrisao = true; 
    }
    public void consumirSaidaPrisao() { 
        itemSaidaPrisao = false; 
    }

    //Modo Turbo
    public boolean temTurbo() { 
        return itemTurbo; 
    }
    public void ativarTurbo() { 
        itemTurbo = true; 
    }
    public void consumirTurbo() { 
        itemTurbo = false; 
    }

    //Imunidade a casa Reversa
    public boolean temImunidadeReversa() { 
        return itemImunidadeReversa; 
    }
    public void ativarImunidadeReversa() { 
        itemImunidadeReversa = true; 
    }
    public void consumirImunidadeReversa() { 
        itemImunidadeReversa = false; 
    }

    //Dados
    public boolean temDadoSorte() { 
        return itemDadoSorte; 
    }
    public void ativarDadoSorte() { 
        itemDadoSorte = true; 
    }
    public void consumirDadoSorte() { 
        itemDadoSorte = false; 
    }

    //Métodos do jogo
    public void mover(int casas) {
        this.posicao += casas;
        jogadas++;
    }

    public void setPosicao(int pos) {
        this.posicao = pos;
    }

    public void adicionarMoedas(int quantidade) {
        this.moedas += quantidade;
    }

    public abstract int rolarDados();
}