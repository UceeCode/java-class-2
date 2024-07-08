import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextEditorApp extends JFrame {
    private JTextArea textArea;
    private JComboBox<String> fontComboBox;
    private JCheckBox boldCheckBox;
    private JButton increaseFontSizeButton;
    private JButton decreaseFontSizeButton;

    private int fontSize = 18;

    public TextEditorApp() {
        super("Text Editor");

        // Set up the text area
        textArea = new JTextArea(10, 30);
        textArea.setFont(new Font("Serif", Font.PLAIN, fontSize));
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set up the font combo box
        String[] fontStyles = {"Serif", "Sans-serif", "Monospaced"};
        fontComboBox = new JComboBox<>(fontStyles);
        fontComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedFont = (String) fontComboBox.getSelectedItem();
                textArea.setFont(new Font(selectedFont, getFontStyle(), fontSize));
            }
        });

        // Set up the bold check box
        boldCheckBox = new JCheckBox("Bold");
        boldCheckBox.setFont(new Font(boldCheckBox.getFont().getName(), Font.BOLD, 20));
        boldCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setFont(new Font(textArea.getFont().getName(), getFontStyle(), fontSize));
            }
        });

        // Set up the increase font size button
        increaseFontSizeButton = new JButton("+");
        increaseFontSizeButton.setFont(new Font(increaseFontSizeButton.getFont().getName(), Font.PLAIN, 20));
        increaseFontSizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fontSize++;
                textArea.setFont(new Font(textArea.getFont().getName(), getFontStyle(), fontSize));
            }
        });

        // Set up the decrease font size button
        decreaseFontSizeButton = new JButton("-");
        decreaseFontSizeButton.setFont(new Font(decreaseFontSizeButton.getFont().getName(), Font.PLAIN, 20));
        decreaseFontSizeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fontSize > 1) {
                    fontSize--;
                    textArea.setFont(new Font(textArea.getFont().getName(), getFontStyle(), fontSize));
                }
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(fontComboBox);
        controlPanel.add(boldCheckBox);
        controlPanel.add(increaseFontSizeButton);
        controlPanel.add(decreaseFontSizeButton);

        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int getFontStyle() {
        if (boldCheckBox.isSelected()) {
            return Font.BOLD;
        } else {
            return Font.PLAIN;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditorApp::new);
    }
}
