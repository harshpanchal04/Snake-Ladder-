public final class TurnManager {
    private final GameState gameState;
    
    public TurnManager(GameState gameState) {
        this.gameState = gameState;
    }
    
    public Player getCurrentPlayer() {
        return gameState.getCurrentPlayer();
    }
    
    public void nextTurn() {
        gameState.moveToNextPlayer();
    }
    
    public boolean isGameEnded() {
        return gameState.isGameEnded();
    }
    
    public Player getWinner() {
        return gameState.getWinner();
    }
    
    public void declareWinner(Player winner) {
        gameState.endGame(winner);
    }
}