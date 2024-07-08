package Exception_Handling;

import java.util.Scanner;

public class ExceptionHandling {
    public static int Quotient(int numerator, int denominator) {
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a numerator:");
            int numerator = scanner.nextInt();

            System.out.println("Enter a denominator:");
            int denominator = scanner.nextInt();

            System.out.println("Result = " + Quotient(numerator, denominator));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero!");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
