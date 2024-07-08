package Workshop;

import java.util.Random;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the dice game");
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;

            int sum = dice1 + dice2;

            if (sum == 7 || sum == 11) {
                System.out.println("You rolled " + dice1 + " and " + dice2);
                System.out.println("You win");
                playAgain = askToPlayAgain(scanner);
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You rolled " + dice1 + " and " + dice2);
                System.out.println("You lose");
                playAgain = askToPlayAgain(scanner);
            } else {
                int point = sum;
                System.out.println("Your point is " + point);
                boolean pointReached = false;
                while (!pointReached) {
                    System.out.println("Rolling again...");
                    int newDice1 = random.nextInt(6) + 1;
                    int newDice2 = random.nextInt(6) + 1;
                    int newSum = newDice1 + newDice2;
                    System.out.println("You rolled " + newDice1 + " and " + newDice2);
                    if (newSum == point) {
                        System.out.println("You win");
                        pointReached = true;
                        playAgain = askToPlayAgain(scanner);
                    } else if (newSum == 7) {
                        System.out.println("You lose");
                        pointReached = true;
                        playAgain = askToPlayAgain(scanner);
                    }
                }
            }
        }

        scanner.close();
        System.out.println("Thanks for playing");
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Do you want to play again? (yes/no)");
        String playAgainInput = scanner.nextLine().toLowerCase();
        return playAgainInput.equals("yes");
    }
}
