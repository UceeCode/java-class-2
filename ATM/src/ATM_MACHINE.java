import java.util.Scanner;
import java.util.InputMismatchException;



// Class to display messages on the ATM screen
class Screen {
    public void displayMessageLine(String message) {
        System.out.println(message);
    }

    // Other methods for displaying messages on the screen
}

// Class to handle user input from the keypad
class Keypad {
    private Scanner scanner;

    public Keypad() {
        scanner = new Scanner(System.in);
    }

    public int getInput() {
        return scanner.nextInt();
    }

    // Other methods for handling keypad input
}

// Class to manage the ATM's cash dispenser
class CashDispenser {
    // Methods for dispensing cash
}

// Class to manage the ATM's deposit slot
class DepositSlot {
    // Methods for handling deposits
}

// Class to manage the bank's database of accounts
class BankDatabase {
    // Methods for authenticating users, retrieving account information, etc.
    public boolean authenticateUser(int accountNumber, int pin) {
        // Dummy implementation, replace with actual logic
        return true;
    }
}

// Abstract class for ATM transactions
abstract class Transaction {
    protected int accountNumber;
    protected Screen screen;
    protected BankDatabase bankDatabase;

    public abstract void execute();
}

// Concrete class for balance inquiry transaction
class BalanceInquiry extends Transaction {
    public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
    }

    public void execute() {
        // Implement execute() method for balance inquiry
        screen.displayMessageLine("Balance Inquiry");
    }
}

// Concrete class for withdrawal transaction
class Withdrawal extends Transaction {
    private Keypad keypad;
    private CashDispenser cashDispenser;

    public Withdrawal(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, CashDispenser cashDispenser) {
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
        this.keypad = keypad;
        this.cashDispenser = cashDispenser;
    }

    public void execute() {
        // Implement execute() method for withdrawal
        screen.displayMessageLine("Withdrawal");
    }
}

// Concrete class for deposit transaction
class Deposit extends Transaction {
    private Keypad keypad;
    private DepositSlot depositSlot;

    public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, Keypad keypad, DepositSlot depositSlot) {
        this.accountNumber = accountNumber;
        this.screen = screen;
        this.bankDatabase = bankDatabase;
        this.keypad = keypad;
        this.depositSlot = depositSlot;
    }

    public void execute() {
        // Implement execute() method for deposit
        screen.displayMessageLine("Deposit");
    }
}

// Represents an automated teller machine
public class ATM_MACHINE {
    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot; // ATM's deposit slot
    private BankDatabase bankDatabase; // account information database

    // constants corresponding to main menu options
    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    // no-argument ATM constructor initializes instance variables
    public ATM_MACHINE() {
        userAuthenticated = false; // user is not authenticated to start
        currentAccountNumber = 0; // no current account number to start
        screen = new Screen(); // create screen
        keypad = new Keypad(); // create keypad
        cashDispenser = new CashDispenser(); // create cash dispenser
        depositSlot = new DepositSlot(); // create deposit slot
        bankDatabase = new BankDatabase(); // create acct info database
    } // end no-argument ATM constructor

    // start ATM
    public void run() {
        // welcome and authenticate user; perform transactions
        while (true) {
            // loop while user is not yet authenticated
            while (!userAuthenticated) {
                screen.displayMessageLine("\nWelcome!");
                authenticateUser(); // authenticate user
            } // end while

            performTransactions(); // user is now authenticated
            userAuthenticated = false; // reset before next ATM session
            currentAccountNumber = 0; // reset before next ATM session
            screen.displayMessageLine("\nThank you! Goodbye!");
        } // end while
    }

    // attempts to authenticate user against database
    private void authenticateUser() {
        screen.displayMessage("\nPlease enter your account number: ");
        int accountNumber = keypad.getInput(); // input account number
        screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
        int pin = keypad.getInput(); // input PIN
        // set userAuthenticated to boolean value returned by database
        userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);
        // check whether authentication succeeded
        if (userAuthenticated) {
            currentAccountNumber = accountNumber; // save user's account #
        } else {
            screen.displayMessageLine("Invalid account number or PIN. Please try again.");
        }
    } // end method authenticate user

    // display the main menu and perform transactions
    private void performTransactions() {
        // local variable to store transaction currently being processed
        Transaction currentTransaction = null;
        boolean userExited = false; // user has not chosen to exit
        // loop while user has not chosen option to exit system
        while (!userExited) {
            // show main menu and get user selection
            int mainMenuSelection = displayMainMenu();
            // decide how to proceed based on user's menu selection
            switch (mainMenuSelection) {
                // user chose to perform one of three transaction types
                case BALANCE_INQUIRY:
                case WITHDRAWAL:
                case DEPOSIT:
                    // initialize as new object of chosen type
                    currentTransaction = createTransaction(mainMenuSelection);
                    currentTransaction.execute(); // execute transaction
                    break;
                case EXIT: // user chose to terminate session
                    screen.displayMessageLine("\nExiting the system...");
                    userExited = true; // this ATM session should end
                    break;
                default: // user did not enter an integer from 1-4
                    screen.displayMessageLine("\nYou did not enter a valid selection. Try again.");
                    break;
            } // end switch
        } // end while
    } // end method performTransactions

    // display the main menu and return an input selection
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

                choice = keypad.getInput(); // get user's selection

                if (choice < 1 || choice > 4) {
                    screen.displayMessageLine("Invalid selection. Please enter a number between 1 and 4.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                // Handle the case when the user enters a non-integer value
                screen.displayMessageLine("Invalid input. Please enter a valid number.");
                keypad.clearInput(); // Clear the invalid input
            }
        }

        return choice;
    } // end method displayMainMenu

    // return object of specified Transaction subclass
    // return object of specified Transaction subclass
    private Transaction createTransaction(int type) {
        Transaction temp = null; // missing semicolon here
        // temporary Transaction variable
        switch (type) {
            case BALANCE_INQUIRY: // create new BalanceInquiry transaction
                temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase);
                break;
            case WITHDRAWAL: // create new Withdrawal transaction
                temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
                break;
            case DEPOSIT: // create new Deposit transaction
                temp = new Deposit(currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
                break;
            default:
                screen.displayMessageLine("\nInvalid selection. Try again.");
        } // end switch

        return temp; // return the newly created object
    } // end method createTransaction
    // Main method to start the ATM
    public static void main(String[] args) {
        ATM_MACHINE atm = new ATM_MACHINE();
        atm.run();
    }
}
