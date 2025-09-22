public interface IWinningStrategy {
    boolean hasWon(int currentPosition, int boardSize);
    String getDescription();
}