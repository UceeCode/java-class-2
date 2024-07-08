import javax.swing.*;

public class Dialouge {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Programming in Java is interesting");

        // Create an instance of the nameDialog class and call its method
        nameDialog dialog = new nameDialog();
        dialog.showNameInputDialog();
    }

    // Define the nameDialog class
    public static class nameDialog {
        public void showNameInputDialog() {
            // Show an input dialog to get the user's name
            String name = JOptionPane.showInputDialog("What is your name?");

            // Display a welcome message with the user's name
            String message = String.format("Welcome to Java Programming, %s!", name);
            JOptionPane.showMessageDialog(null, message);
        }
    }
}

