public final class BotPlayer extends Player {
    public BotPlayer(String name, String id) {
        super(name, id);
    }
    
    @Override
    public String getPlayerType() {
        return "BOT";
    }
}