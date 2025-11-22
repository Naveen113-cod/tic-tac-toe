import java.util.*;

class Board {
    private final int WIN_POSITION = 50;
    private Map<Integer, Integer> moves = new HashMap<>();

    public Board() {
        
        moves.put(10, 20);
        
        moves.put(30, 15);
    }

    public int getWinPosition() {
        return WIN_POSITION;
    }

    public int checkSnakesAndLadders(int pos) {
        if (moves.containsKey(pos)) {
            int newPos = moves.get(pos);
            if (newPos > pos) {
                System.out.println("Ladder! Climb to " + newPos);
            } else {
                System.out.println("Snake! Go down to " + newPos);
            }
            return newPos;
        }
        return pos;
    }
}

class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void updatePosition(int newPos) {
        this.position = newPos;
    }
}

class Game {
    private Player player;
    private Board board;
    private Random random = new Random();
    private Scanner sc = new Scanner(System.in);

    public Game() {
        board = new Board();
        player = new Player("Player 1");
    }

    private int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void start() {
        System.out.println("=== Snake and Ladder (OOP Version) ===");
        System.out.println("Reach " + board.getWinPosition() + " to win!");
        System.out.println("Press Enter to roll...");

        while (player.getPosition() < board.getWinPosition()) {
            sc.nextLine();
            int dice = rollDice();
            System.out.println("You rolled: " + dice);

            int newPos = player.getPosition() + dice;

            newPos = board.checkSnakesAndLadders(newPos);

            player.updatePosition(newPos);
            System.out.println("Current Position: " + player.getPosition());
        }

        System.out.println("\n " + player.getName() + " reached "
                + board.getWinPosition() + "! You win!");
    }
}

public class SnakeAndLadderGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}