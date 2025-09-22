public final class Snake extends BoardEntity {
    public Snake(int head, int tail) {
        super(head, tail);
        if (head <= tail) {
            throw new IllegalArgumentException("Snake head must be greater than tail");
        }
    }
    
    @Override
    public String getType() {
        return "SNAKE";
    }
    
    @Override
    public String toString() {
        return "Snake{head=" + startPosition + ", tail=" + endPosition + "}";
    }
}