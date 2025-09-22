public class GameDemo {
    public static void main(String[] args) {
        // Create a sample game configuration
        GameConfig config = new GameConfig.Builder()
            .setBoardSize(100)
            .addSnake(new Snake(99, 54))
            .addSnake(new Snake(95, 75))
            .addSnake(new Snake(93, 73))
            .addSnake(new Snake(87, 24))
            .addSnake(new Snake(64, 60))
            .addSnake(new Snake(62, 19))
            .addSnake(new Snake(49, 11))
            .addSnake(new Snake(46, 25))
            .addSnake(new Snake(16, 6))
            .addLadder(new Ladder(2, 38))
            .addLadder(new Ladder(7, 14))
            .addLadder(new Ladder(8, 31))
            .addLadder(new Ladder(15, 26))
            .addLadder(new Ladder(21, 42))
            .addLadder(new Ladder(28, 84))
            .addLadder(new Ladder(36, 44))
            .addLadder(new Ladder(51, 67))
            .addLadder(new Ladder(71, 91))
            .addLadder(new Ladder(78, 98))
            .setWinningStrategy(new ExactLandingWinning())
            .setStartingStrategy(new SixToStartStrategy())
            .addPlayer(PlayerFactory.createHumanPlayer("Alice"))
            .addPlayer(PlayerFactory.createBotPlayer("Bot1"))
            .build();
        
        Game game = new Game(config);
        game.startGame();
        game.close();
    }
}