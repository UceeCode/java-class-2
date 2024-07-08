package Workshop;

import java.util.Random;

public class DiceGame {

    public static void main(String[] args) {
        Random random = new Random();
        boolean playing = true;

        while (playing) {
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            int sum = dice1 + dice2;

            System.out.println("You rolled " + dice1 + " and " + dice2);
            System.out.println("Sum = " + sum);

            if (sum == 7 || sum == 11) {
                System.out.println("You win");
                playing = false;
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You lose");
                playing = false;
            } else {
                int point = sum;
                boolean pointReached = false;

                while (!pointReached) {
                    System.out.println("Point = " + point);
                    int newDice1 = random.nextInt(6) + 1;
                    int newDice2 = random.nextInt(6) + 1;
                    int newSum = newDice1 + newDice2;
                    System.out.println("You rolled " + newDice1 + " and " + newDice2);
                    System.out.println("Sum = " + newSum);

                    if (newSum == point) {
                        System.out.println("You win");
                        pointReached = true;
                        playing = false;
                    } else if (newSum == 7) {
                        System.out.println("You lose");
                        pointReached = true;
                        playing = false;
                    }
                }
            }
        }
    }
}
