package casas;

public class CasaFactory {

    public static Casa criarCasa(int numero, String tipo) {

        switch (tipo.toLowerCase()) {
            case "simples":
                return new CasaSimples(numero);
            case "sorte":
                return new CasaSorte(numero);
            case "azar":
                return new CasaAzar(numero);
            case "prisao":
                return new CasaPrisao(numero);
            case "reversa":
                return new CasaReversa(numero);
            case "surpresa":
                return new CasaSurpresa(numero);
            case "jogadenovo":
                return new CasaJogaDeNovo(numero);
            default:
                return null;
        }
    }
}