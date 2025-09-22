public final class HumanPlayer extends Player {
    public HumanPlayer(String name, String id) {
        super(name, id);
    }
    
    @Override
    public String getPlayerType() {
        return "HUMAN";
    }
}