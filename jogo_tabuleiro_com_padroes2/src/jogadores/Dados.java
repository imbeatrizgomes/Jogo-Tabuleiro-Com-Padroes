package jogadores;

import java.util.Random;

public class Dados {
    private final Random random = new Random();

    public int rolar() {
        return random.nextInt(6) + 1;
    }

    public int[] rolar2() {
        int d1 = rolar();
        int d2 = rolar();
        return new int[]{d1, d2};
    }

}

