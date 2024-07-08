import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.*;

public class SimpleWebBrowser extends JFrame {
    private JTextField addressBar;
    private JEditorPane display;

    public SimpleWebBrowser() {
        super("Simple Web Browser");

        addressBar = new JTextField("https://www.google.com");
        addressBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                loadURL(addressBar.getText());
            }
        });

        display = new JEditorPane();
        display.setEditable(false);
        display.setContentType("text/html");

        JScrollPane scrollPane = new JScrollPane(display);

        add(addressBar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loadURL(addressBar.getText());
    }

    private void loadURL(String url) {
        try {
            display.setPage(url);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading page: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleWebBrowser();
            }
        });
    }
}
