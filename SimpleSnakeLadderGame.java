import java.util.Scanner;
import java.util.Random;

public class SimpleSnakeLadderGame {
    public static void main(String[] args) {

        int pos = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Simple Snake and Ladder Game!");
        System.out.println("Reach 50 to win. Press Enter to roll.");

        while (pos < 50) {
            try {
                String input = sc.nextLine();
                if (!input.equals("")) {
                    throw new Exception("Invalid input! Just press ENTER.");
                }

                int dice = 0;
                try {
                    dice = rand.nextInt(6) + 1;
                } catch (Exception e) {
                    System.out.println("Dice error! Rolling again...");
                    dice = 1; 
                }

                System.out.println("You rolled: " + dice);

                int newPos = pos + dice;

                if (newPos < 0) {
                    throw new ArithmeticException("Position became negative!");
                }

                pos = newPos;

                if (pos == 10) {
                    System.out.println("Ladder! Go to 20");
                    pos = 20;
                }

                if (pos == 30) {
                    System.out.println("Snake! Back to 15");
                    pos = 15;
                }

                System.out.println("Current position: " + pos);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again by pressing ENTER only.");
            }
        }

        System.out.println(" You reached 50! You win!");
        sc.close();
    }
}