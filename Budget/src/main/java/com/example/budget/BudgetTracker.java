import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BudgetTracker extends JFrame {
    private List<Expense> expenses;
    private JTextField nameField, amountField;
    private JTextArea expenseArea;
    private JLabel totalLabel;

    public BudgetTrackerApp() {
        expenses = new ArrayList<>();

        // Set up the UI
        setTitle("Budget Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);
        JButton addButton = new JButton("Add Expense");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        expenseArea = new JTextArea();
        add(new JScrollPane(expenseArea), BorderLayout.CENTER);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.add(new JLabel("Total:"));
        totalLabel = new JLabel("0.00");
        totalPanel.add(totalLabel);
        add(totalPanel, BorderLayout.SOUTH);
    }

    private void addExpense() {
        String name = nameField.getText();
        String amountStr = amountField.getText();
        if (!name.isEmpty() && !amountStr.isEmpty()) {
            try {
                double amount = Double.parseDouble(amountStr);
                Expense expense = new Expense(name, amount);
                expenses.add(expense);
                updateExpenseArea();
                updateTotal();
                nameField.setText("");
                amountField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount format. Please enter a number.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Name and amount cannot be empty.");
        }
    }

    private void updateExpenseArea() {
        expenseArea.setText("");
        for (Expense expense : expenses) {
            expenseArea.append(expense.getName() + ": $" + expense.getAmount() + "\n");
        }
    }

    private void updateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        totalLabel.setText(String.format("%.2f", total));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BudgetTrackerApp().setVisible(true);
            }
        });
    }
}

class Expense {
    private String name;
    private double amount;

    public Expense(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
