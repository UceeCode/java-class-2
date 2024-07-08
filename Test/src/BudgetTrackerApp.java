import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BudgetTrackerApp extends JFrame {
    private List<Expense> expenses;
    private JTextField nameField, amountField;
    private DefaultTableModel tableModel;
    private JTable expenseTable;
    private JLabel totalLabel;

    public BudgetTrackerApp() {
        expenses = new ArrayList<>();

        // Set up the UI
        setTitle("Budget Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240));

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Amount:"));
        amountField = new JTextField();
        inputPanel.add(amountField);
        JButton addButton = new JButton("Add Expense");
        addButton.setBackground(new Color(51, 153, 255));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Expense Table
        String[] columns = {"Name", "Amount", "Action"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        expenseTable = new JTable(tableModel);
        expenseTable.setBackground(Color.WHITE);
        expenseTable.getTableHeader().setReorderingAllowed(false);
        expenseTable.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        expenseTable.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(expenseTable);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Total Panel
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalPanel.setBackground(Color.WHITE);
        totalPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        totalPanel.add(new JLabel("Total:"));
        totalLabel = new JLabel("0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
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
                updateTable();
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

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Expense expense : expenses) {
            Object[] rowData = {expense.getName(), expense.getAmount(), "Delete"};
            tableModel.addRow(rowData);
        }
    }

    private void updateTotal() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        DecimalFormat df = new DecimalFormat("#.00");
        totalLabel.setText("$" + df.format(total));
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

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        setBackground(new Color(255, 0, 0));
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            // Perform deletion here
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete this expense?", "Confirmation", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {
                // Delete the expense from the table and update the UI
                DefaultTableModel model = (DefaultTableModel) ((JTable) this.getComponent()).getModel();
                model.removeRow(((JTable) this.getComponent()).getSelectedRow());
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
