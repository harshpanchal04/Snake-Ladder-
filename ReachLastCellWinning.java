public final class ReachLastCellWinning implements IWinningStrategy {
    @Override
    public boolean hasWon(int currentPosition, int boardSize) {
        return currentPosition >= boardSize;
    }
    
    @Override
    public String getDescription() {
        return "Win by reaching or crossing the last cell";
    }
}