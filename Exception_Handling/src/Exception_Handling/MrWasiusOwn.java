package Exception_Handling;

import java.util.Scanner;

public class MrWasiusOwn {
    public static int quotient(int numerator, int denominator) throws ArithmeticException {
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        do {
            try {
                System.out.println("Enter a numerator:");
                int numerator = scanner.nextInt();

                System.out.println("Enter a denominator:");
                int denominator = scanner.nextInt();

                System.out.println("Result = " + quotient(numerator, denominator));
                continueLoop = false;
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero! Please enter a non-zero denominator.");
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (continueLoop);

        scanner.close();
    }
}
