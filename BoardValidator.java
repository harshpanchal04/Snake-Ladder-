import java.util.*;

public final class BoardValidator {
    public static void validateBoard(int boardSize, List<Snake> snakes, List<Ladder> ladders) {
        validateBoardSize(boardSize);
        validateSnakes(snakes, boardSize);
        validateLadders(ladders, boardSize);
        validateNoConflicts(snakes, ladders);
    }
    
    private static void validateBoardSize(int boardSize) {
        if (boardSize < 10 || boardSize > 1000) {
            throw new IllegalArgumentException("Board size must be between 10 and 1000");
        }
    }
    
    private static void validateSnakes(List<Snake> snakes, int boardSize) {
        for (Snake snake : snakes) {
            if (snake.getStartPosition() <= 1 || snake.getStartPosition() >= boardSize) {
                throw new IllegalArgumentException("Snake head must be between 2 and " + (boardSize - 1));
            }
            if (snake.getEndPosition() < 1) {
                throw new IllegalArgumentException("Snake tail must be at least 1");
            }
        }
    }
    
    private static void validateLadders(List<Ladder> ladders, int boardSize) {
        for (Ladder ladder : ladders) {
            if (ladder.getStartPosition() < 1 || ladder.getStartPosition() >= boardSize) {
                throw new IllegalArgumentException("Ladder bottom must be between 1 and " + (boardSize - 1));
            }
            if (ladder.getEndPosition() >= boardSize) {
                throw new IllegalArgumentException("Ladder top must be less than " + boardSize);
            }
        }
    }
    
    private static void validateNoConflicts(List<Snake> snakes, List<Ladder> ladders) {
        Set<Integer> occupiedPositions = new HashSet<>();
        
        // Check snake conflicts
        for (Snake snake : snakes) {
            if (!occupiedPositions.add(snake.getStartPosition())) {
                throw new IllegalArgumentException("Position " + snake.getStartPosition() + " has multiple entities");
            }
        }
        
        // Check ladder conflicts
        for (Ladder ladder : ladders) {
            if (!occupiedPositions.add(ladder.getStartPosition())) {
                throw new IllegalArgumentException("Position " + ladder.getStartPosition() + " has multiple entities");
            }
        }
    }
}