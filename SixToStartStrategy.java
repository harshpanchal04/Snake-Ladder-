public final class SixToStartStrategy implements IStartingStrategy {
    @Override
    public boolean canStart(int diceValue, boolean hasStarted) {
        if (hasStarted) {
            return true; // Can always continue if already started
        }
        return diceValue == 6; // Need 6 to start
    }
    
    @Override
    public String getDescription() {
        return "Must roll 6 to start the game";
    }
}