import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private boolean userAuthenticated;
    private int currentAccountNumber;
    private final Screen screen;
    private final Keypad keypad;
    private final BankDatabase bankDatabase;

    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    public ATM() {
        userAuthenticated = false;
        currentAccountNumber = 0;
        screen = new Screen();
        keypad = new Keypad();
        bankDatabase = new BankDatabase();
    }

    public void run() {
        while (true) {
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome to the ATM!");
                authenticateUser();
            }

            performTransactions();
            userAuthenticated = false;
            screen.displayMessageLine("\nThank you! Goodbye!");
        }
    }

    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput();
        screen.displayMessage("\nEnter your PIN: ");
        int pin = keypad.getInput();
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
        if (userAuthenticated) {
            currentAccountNumber = accountNumber;
        } else {
            screen.displayMessageLine("Invalid account number or PIN. Please try again.");
        }
    }

    private void performTransactions() {
        Transaction currentTransaction = null;
        boolean userExited = false;
        while (!userExited) {
            int mainMenuSelection = displayMainMenu();
            switch (mainMenuSelection) {
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute();
                    break;
                case EXIT:
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true;
                    break;
                default:
                    screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
                    break;
            }
        }
    }

    private int displayMainMenu() {
        int choice = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                screen.displayMessageLine("\nMain menu:");
                screen.displayMessageLine("1 - View my balance");
                screen.displayMessageLine("2 - Withdraw cash");
                screen.displayMessageLine("3 - Deposit funds");
                screen.displayMessageLine("4 - Exit\n");
                screen.displayMessage("Enter a choice: ");

                choice = keypad.getInput();
                if (choice < 1 || choice > 4) {
                    screen.displayMessageLine("Invalid selection. Please enter a number between 1 and 4.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                screen.displayMessageLine("Invalid input. Please enter a valid number.");
                keypad.clearInput();
            }
        }
        return choice;
    }

    private Transaction createTransaction(int type) {
        Transaction temp = null;
        switch (type) {
            case BALANCE_INQUIRY:
                temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL:
                temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, new CashDispenser());
                break;
            case DEPOSIT:
                temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, new DepositSlot());
                break;
            default:
                screen.displayMessageLine("\nInvalid selection. Try again.");
        }
        return temp;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }

    static class Screen {
        public void displayMessage(String message) {
            System.out.print(message);
        }

        public void displayMessageLine(String message) {
            System.out.println(message);
        }

        public void displayDollarAmount(BigDecimal amount) {
            System.out.printf("$%,.2f", amount);
        }
    }

    static class Keypad {
        private final Scanner scanner;

        public Keypad() {
            scanner = new Scanner(System.in);
        }

        public int getInput() {
            return scanner.nextInt();
        }

        public BigDecimal getInputBigDecimal() {
            return scanner.nextBigDecimal();
        }

        public void clearInput() {
            scanner.nextLine();
        }
    }

    static class BankDatabase {
        private Map<Integer, BigDecimal> balances;

        public BankDatabase() {
            balances = new HashMap<>();
            // Dummy initialization of balances, replace with actual data
            balances.put(12345, BigDecimal.valueOf(1000.0)); // Example account
        }

        public boolean authenticateUser(int accountNumber, int pin) {
            // Dummy implementation, replace with actual logic
            return true;
        }

        public BigDecimal getAvailableBalance(int accountNumber) {
            return balances.getOrDefault(accountNumber, BigDecimal.ZERO);
        }

        public BigDecimal getTotalBalance(int accountNumber) {
            return getAvailableBalance(accountNumber);
        }

        public void debit(int accountNumber, BigDecimal amount) {
            BigDecimal currentBalance = balances.getOrDefault(accountNumber, BigDecimal.ZERO);
            balances.put(accountNumber, currentBalance.subtract(amount));
        }

        public void credit(int accountNumber, BigDecimal amount) {
            BigDecimal currentBalance = balances.getOrDefault(accountNumber, BigDecimal.ZERO);
            balances.put(accountNumber, currentBalance.add(amount));
        }
    }

    abstract static class Transaction {
        public abstract void execute();
    }

    static class BalanceInquiry extends Transaction {
        private final int accountNumber;
        private final Screen screen;
        private final BankDatabase bankDatabase;

        public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase) {
            this.accountNumber = accountNumber;
            this.screen = screen;
            this.bankDatabase = bankDatabase;
        }

        @Override
        public void execute() {
            screen.displayMessageLine("\nBalance Information:");
            screen.displayMessage(" - Available balance: ");
            screen.displayDollarAmount(bankDatabase.getAvailableBalance(accountNumber));
            screen.displayMessage("\n - Total balance: ");
            screen.displayDollarAmount(bankDatabase.getTotalBalance(accountNumber));
            screen.displayMessageLine("");
        }
    }

    static class Withdrawal extends Transaction {
        private final int accountNumber;
        private final Screen screen;
        private final BankDatabase bankDatabase;
        private final Keypad keypad;
        private final CashDispenser cashDispenser;

        public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser) {
            this.accountNumber = accountNumber;
            this.screen = screen;
            this.bankDatabase = bankDatabase;
            this.keypad = keypad;
            this.cashDispenser = cashDispenser;
        }
        @Override
        public void execute() {
            screen.displayMessage("\nEnter the withdrawal amount (or 0 to cancel): ");
            try {
                BigDecimal amount = keypad.getInputBigDecimal();
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    if (bankDatabase.getAvailableBalance(accountNumber).compareTo(amount) >= 0) {
                        if (cashDispenser.isSufficientCashAvailable(amount.intValue())) {
                            bankDatabase.debit(accountNumber, amount);
                            cashDispenser.dispenseCash(amount.intValue());
                            screen.displayMessageLine("\nPlease take your cash.");
                        } else {
                            screen.displayMessageLine("\nInsufficient cash available in the ATM.");
                        }
                    } else {
                        screen.displayMessageLine("\nInsufficient funds in your account.");
                    }
                } else {
                    screen.displayMessageLine("\nInvalid withdrawal amount.");
                }
            } catch (InputMismatchException e) {
                screen.displayMessageLine("\nInvalid input. Please enter a valid amount.");
                keypad.clearInput();
            }
        }
    }

    static class Deposit extends Transaction {
        private final int accountNumber;
        private final Screen screen;
        private final BankDatabase bankDatabase;
        private final Keypad keypad;
        private final DepositSlot depositSlot;

        public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {
            this.accountNumber = accountNumber;
            this.screen = screen;
            this.bankDatabase = bankDatabase;
            this.keypad = keypad;
            this.depositSlot = depositSlot;
        }

        @Override
        public void execute() {
            screen.displayMessage("\nEnter the deposit amount: ");
            try {
                BigDecimal amount = keypad.getInputBigDecimal();
                if (amount.compareTo(BigDecimal.ZERO) > 0) {
                    screen.displayMessageLine("\nPlease insert your deposit into the deposit slot.");
                    screen.displayMessageLine("\nYour deposit of $" + amount + " has been received and will be processed shortly.");
                    bankDatabase.credit(accountNumber, amount); // Update the balance
                } else {
                    screen.displayMessageLine("\nInvalid deposit amount.");
                }
            } catch (InputMismatchException e) {
                screen.displayMessageLine("\nInvalid input. Please enter a valid amount.");
                keypad.clearInput();
            }
        }
    }

    static class CashDispenser {
        public boolean isSufficientCashAvailable(int amount) {
            // Dummy implementation, replace with actual logic
            return true;
        }

        public void dispenseCash(int amount) {
            // Dummy implementation, replace with actual logic
        }
    }

    static class DepositSlot {
        // Placeholder class, no specific functionality mentioned
    }
}