import java.util.Scanner;

public class ATM {
    private static double balance = 0; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the ATM");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter deposit amount in dollars: $");
        double depositAmount = scanner.nextDouble();
        double nairaEquivalent = depositAmount * 1200;
        balance += nairaEquivalent;
        System.out.printf("$%.2f has been converted to %.2f Naira and deposited into your account.%n", depositAmount, nairaEquivalent);
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter withdrawal amount in Naira: ₦");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.printf("%.2f Naira has been withdrawn from your account.%n", withdrawAmount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is %.2f Naira.%n", balance);
    }
}
