package jogadores;

public enum CorJogador {
    
	AZUL,
    LARANJA,
    MARROM,
    PRETO,
    ROSA,
    VERMELHO;

    public static CorJogador fromString(String texto) {
        if (texto == null) return null;

        for (CorJogador c : values()) {
            if (c.name().equalsIgnoreCase(texto.trim())) {
                return c;
            }
        }
        
        return null;
    }
}

