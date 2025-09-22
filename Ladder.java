public final class Ladder extends BoardEntity {
    public Ladder(int bottom, int top) {
        super(bottom, top);
        if (bottom >= top) {
            throw new IllegalArgumentException("Ladder bottom must be less than top");
        }
    }
    
    @Override
    public String getType() {
        return "LADDER";
    }
    
    @Override
    public String toString() {
        return "Ladder{bottom=" + startPosition + ", top=" + endPosition + "}";
    }
}