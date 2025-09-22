public final class PlayerFactory {
    private static int botCounter = 1;
    
    public static Player createHumanPlayer(String name) {
        return new HumanPlayer(name, "HUMAN_" + name);
    }
    
    public static Player createBotPlayer(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = "Bot" + botCounter++;
        }
        return new BotPlayer(name, "BOT_" + name);
    }
    
    public static Player createBotPlayer() {
        return createBotPlayer("Bot" + botCounter);
    }
}