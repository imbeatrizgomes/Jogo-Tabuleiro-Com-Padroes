package casas;

import jogadores.Jogador;

public abstract class Casa {
    
	protected int numero;
    protected RegraCasa regra;

    protected Casa(int numero, RegraCasa regra) {
        this.numero = numero;
        this.regra = regra;
    }

    public int getNumero() { 
    	return numero; 
    }

    public void aplicarRegra(Jogador jogador) {
        regra.aplicar(jogador);
    }
}
