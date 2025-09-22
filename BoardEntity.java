public abstract class BoardEntity implements IBoardEntity {
    protected final int startPosition;
    protected final int endPosition;
    
    public BoardEntity(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
    
    @Override
    public int getStartPosition() {
        return startPosition;
    }
    
    @Override
    public int getEndPosition() {
        return endPosition;
    }
}