import java.util.Scanner;

public final class Game {
    private final GameConfig config;
    private final Board board;
    private final IDice dice;
    private final TurnManager turnManager;
    private final GameStateManager stateManager;
    private final Scanner scanner;
    
    public Game(GameConfig config) {
        this.config = config;
        this.board = new Board(config.getBoardSize(), config.getSnakes(), config.getLadders());
        this.dice = new DiceImpl();
        
        GameState gameState = new GameState(config.getPlayers());
        this.turnManager = new TurnManager(gameState);
        this.stateManager = new GameStateManager(gameState, board, config.getWinningStrategy());
        this.scanner = new Scanner(System.in);
    }
    
    public void startGame() {
        System.out.println("=== Snake and Ladder Game Started ===");
        System.out.println("Board Size: " + config.getBoardSize());
        System.out.println("Winning Rule: " + config.getWinningStrategy().getDescription());
        System.out.println("Starting Rule: " + config.getStartingStrategy().getDescription());
        System.out.println("Players: " + config.getPlayers().size());
        
        for (Player player : config.getPlayers()) {
            System.out.println("  - " + player.getName() + " (" + player.getPlayerType() + ")");
        }
        System.out.println();
        
        gameLoop();
        
        if (turnManager.getWinner() != null) {
            System.out.println("🎉 Game Over! Winner: " + turnManager.getWinner().getName());
        }
    }
    
    private void gameLoop() {
        while (!turnManager.isGameEnded()) {
            Player currentPlayer = turnManager.getCurrentPlayer();
            playTurn(currentPlayer);
            
            if (!turnManager.isGameEnded()) {
                turnManager.nextTurn();
            }
        }
    }
    
    private void playTurn(Player currentPlayer) {
        System.out.println("\n--- " + currentPlayer.getName() + "'s Turn ---");
        System.out.println("Current Position: " + currentPlayer.getCurrentPosition());
        
        if (currentPlayer instanceof HumanPlayer) {
            System.out.print("Press Enter to roll dice...");
            scanner.nextLine();
        } else {
            System.out.println("Bot is rolling dice...");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }
        
        int diceValue = dice.roll();
        System.out.println("Dice rolled: " + diceValue);
        
        // Check starting strategy
        if (!config.getStartingStrategy().canStart(diceValue, currentPlayer.hasStarted())) {
            System.out.println(currentPlayer.getName() + " cannot start yet. Need to roll 6!");
            return;
        }
        
        int oldPosition = currentPlayer.getCurrentPosition();
        boolean hasWon = stateManager.makeMove(currentPlayer, diceValue);
        int newPosition = currentPlayer.getCurrentPosition();
        
        System.out.println("Moved from " + oldPosition + " to " + newPosition);
        
        // Check for special entities
        if (board.hasSpecialEntity(newPosition)) {
            IBoardEntity entity = board.getSpecialEntity(newPosition);
            if (entity instanceof Snake) {
                System.out.println("🐍 Oops! Bitten by snake! Sliding down to " + entity.getEndPosition());
            } else if (entity instanceof Ladder) {
                System.out.println("🪜 Great! Climbed the ladder to " + entity.getEndPosition());
            }
        }
        
        if (hasWon) {
            turnManager.declareWinner(currentPlayer);
        }
    }
    
    public void close() {
        scanner.close();
    }
}