public final class Cell {
    private final int position;
    private IBoardEntity boardEntity;
    
    public Cell(int position) {
        this.position = position;
        this.boardEntity = null;
    }
    
    public int getPosition() { return position; }
    public IBoardEntity getBoardEntity() { return boardEntity; }
    public boolean hasSpecialEntity() { return boardEntity != null; }
    
    public void setBoardEntity(IBoardEntity entity) {
        this.boardEntity = entity;
    }
    
    @Override
    public String toString() {
        if (hasSpecialEntity()) {
            return "Cell{" + position + ", " + boardEntity.getType() + "}";
        }
        return "Cell{" + position + "}";
    }
}
