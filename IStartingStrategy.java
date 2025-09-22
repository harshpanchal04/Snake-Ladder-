public interface IStartingStrategy {
    boolean canStart(int diceValue, boolean hasStarted);
    String getDescription();
}