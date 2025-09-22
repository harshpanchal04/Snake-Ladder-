public final class GameStateManager {
    private final GameState gameState;
    private final Board board;
    private final IWinningStrategy winningStrategy;
    
    public GameStateManager(GameState gameState, Board board, IWinningStrategy winningStrategy) {
        this.gameState = gameState;
        this.board = board;
        this.winningStrategy = winningStrategy;
    }
    
    public boolean makeMove(Player player, int diceValue) {
        int newPosition = board.getNewPosition(player.getCurrentPosition(), diceValue);
        player.setPosition(newPosition);
        
        return winningStrategy.hasWon(newPosition, board.getSize());
    }
    
    public GameState getGameState() {
        return gameState;
    }
}