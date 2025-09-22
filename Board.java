import java.util.*;

public final class Board {
    private final int size;
    private final Cell[] cells;
    private final Map<Integer, IBoardEntity> specialEntities;
    
    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.cells = new Cell[size + 1]; // 1-indexed
        this.specialEntities = new HashMap<>();
        
        initializeCells();
        setupSpecialEntities(snakes, ladders);
    }
    
    private void initializeCells() {
        for (int i = 1; i <= size; i++) {
            cells[i] = new Cell(i);
        }
    }
    
    private void setupSpecialEntities(List<Snake> snakes, List<Ladder> ladders) {
        for (Snake snake : snakes) {
            specialEntities.put(snake.getStartPosition(), snake);
            cells[snake.getStartPosition()].setBoardEntity(snake);
        }
        
        for (Ladder ladder : ladders) {
            specialEntities.put(ladder.getStartPosition(), ladder);
            cells[ladder.getStartPosition()].setBoardEntity(ladder);
        }
    }
    
    public int getSize() { return size; }
    
    public Cell getCell(int position) {
        if (position < 1 || position > size) {
            throw new IllegalArgumentException("Position must be between 1 and " + size);
        }
        return cells[position];
    }
    
    public int getNewPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        
        // Check if move is within board bounds
        if (newPosition > size) {
            return currentPosition; // Stay at current position if exceeding board
        }
        
        // Check for special entities (snakes/ladders)
        IBoardEntity entity = specialEntities.get(newPosition);
        if (entity != null) {
            return entity.getEndPosition();
        }
        
        return newPosition;
    }
    
    public boolean hasSpecialEntity(int position) {
        return specialEntities.containsKey(position);
    }
    
    public IBoardEntity getSpecialEntity(int position) {
        return specialEntities.get(position);
    }
}