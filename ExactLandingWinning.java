public final class ExactLandingWinning implements IWinningStrategy {
    @Override
    public boolean hasWon(int currentPosition, int boardSize) {
        return currentPosition == boardSize;
    }
    
    @Override
    public String getDescription() {
        return "Win by landing exactly on the last cell";
    }
}