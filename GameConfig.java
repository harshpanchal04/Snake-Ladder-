import java.util.*;

public final class GameConfig {
    private final int boardSize;
    private final List<Snake> snakes;
    private final List<Ladder> ladders;
    private final IWinningStrategy winningStrategy;
    private final IStartingStrategy startingStrategy;
    private final List<Player> players;
    
    private GameConfig(Builder builder) {
        this.boardSize = builder.boardSize;
        this.snakes = List.copyOf(builder.snakes);
        this.ladders = List.copyOf(builder.ladders);
        this.winningStrategy = builder.winningStrategy;
        this.startingStrategy = builder.startingStrategy;
        this.players = List.copyOf(builder.players);
        
        // Validate the configuration
        BoardValidator.validateBoard(boardSize, snakes, ladders);
        validatePlayers();
    }
    
    private void validatePlayers() {
        if (players.size() < 1 || players.size() > 6) {
            throw new IllegalArgumentException("Number of players must be between 1 and 6");
        }
    }
    
    // Getters
    public int getBoardSize() { return boardSize; }
    public List<Snake> getSnakes() { return snakes; }
    public List<Ladder> getLadders() { return ladders; }
    public IWinningStrategy getWinningStrategy() { return winningStrategy; }
    public IStartingStrategy getStartingStrategy() { return startingStrategy; }
    public List<Player> getPlayers() { return players; }
    
    // Builder Pattern
    public static class Builder {
        private int boardSize = 100;
        private List<Snake> snakes = new ArrayList<>();
        private List<Ladder> ladders = new ArrayList<>();
        private IWinningStrategy winningStrategy = new ReachLastCellWinning();
        private IStartingStrategy startingStrategy = new ImmediateStartStrategy();
        private List<Player> players = new ArrayList<>();
        
        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }
        
        public Builder addSnake(Snake snake) {
            this.snakes.add(snake);
            return this;
        }
        
        public Builder addLadder(Ladder ladder) {
            this.ladders.add(ladder);
            return this;
        }
        
        public Builder setWinningStrategy(IWinningStrategy strategy) {
            this.winningStrategy = strategy;
            return this;
        }
        
        public Builder setStartingStrategy(IStartingStrategy strategy) {
            this.startingStrategy = strategy;
            return this;
        }
        
        public Builder addPlayer(Player player) {
            this.players.add(player);
            return this;
        }
        
        public GameConfig build() {
            return new GameConfig(this);
        }
    }
}