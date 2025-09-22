import java.util.Random;

public final class DiceImpl implements IDice {
    private final Random random;
    
    public DiceImpl() {
        this.random = new Random();
    }
    
    // For testing with specific seed
    public DiceImpl(long seed) {
        this.random = new Random(seed);
    }
    
    @Override
    public int roll() {
        return random.nextInt(6) + 1; // 1 to 6
    }
}