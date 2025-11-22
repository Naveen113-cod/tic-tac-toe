import java.util.Scanner;
import java.util.Random;

public class SimpleSnakeLadder {
    public static void main(String[] args) {

        int pos = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Simple Snake and Ladder Game!");
        System.out.println("Reach 50 to win. Press Enter to roll.");

        while (pos < 50) {
            sc.nextLine();
            int dice = rand.nextInt(6) + 1;
            System.out.println("You rolled: " + dice);

            pos = pos + dice;

            if (pos == 10) {
                System.out.println("Ladder! Go to 20");
                pos = 20;
            }

            if (pos == 30) {
                System.out.println("Snake! Back to 15");
                pos = 15;
            }

            System.out.println("Current position: " + pos);
        }

        System.out.println(" You reached 50! You win!");
        sc.close();
    }
}