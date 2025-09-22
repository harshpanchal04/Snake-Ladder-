import java.util.*;

public final class GameState {
    private final List<Player> players;
    private int currentPlayerIndex;
    private boolean gameEnded;
    private Player winner;
    
    public GameState(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.currentPlayerIndex = 0;
        this.gameEnded = false;
        this.winner = null;
    }
    
    public List<Player> getPlayers() { return Collections.unmodifiableList(players); }
    public int getCurrentPlayerIndex() { return currentPlayerIndex; }
    public Player getCurrentPlayer() { return players.get(currentPlayerIndex); }
    public boolean isGameEnded() { return gameEnded; }
    public Player getWinner() { return winner; }
    
    public void moveToNextPlayer() {
        if (!gameEnded) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
    
    public void endGame(Player winner) {
        this.gameEnded = true;
        this.winner = winner;
    }
}
