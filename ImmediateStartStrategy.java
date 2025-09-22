public final class ImmediateStartStrategy implements IStartingStrategy {
    @Override
    public boolean canStart(int diceValue, boolean hasStarted) {
        return true; // Can start with any dice value
    }
    
    @Override
    public String getDescription() {
        return "Can start with any dice value";
    }
}