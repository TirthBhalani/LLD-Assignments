import java.util.Random;

public class StandardDice implements IDice {
    private int sides;
    private Random random;

    public StandardDice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
