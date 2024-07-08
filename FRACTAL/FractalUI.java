import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalUI extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private JComboBox<String> fractalComboBox;
    private JButton drawButton;
    private JPanel fractalPanel;

    public FractalUI() {
        setTitle("Fractal Viewer");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize components
        fractalComboBox = new JComboBox<>(new String[]{"Mandelbrot Set", "Julia Set"});
        drawButton = new JButton("Draw");
        fractalPanel = new JPanel();

        // Add action listener to the draw button
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawFractal();
            }
        });

        // Set layout
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        controlPanel.add(fractalComboBox);
        controlPanel.add(drawButton);

        add(controlPanel, BorderLayout.NORTH);
        add(fractalPanel, BorderLayout.CENTER);
    }

    private void drawFractal() {
        // Get the selected fractal from the combo box
        String selectedFractal = (String) fractalComboBox.getSelectedItem();

        // Clear previous fractal
        fractalPanel.removeAll();
        fractalPanel.repaint();

        // Draw the selected fractal
        if (selectedFractal.equals("Mandelbrot Set")) {
            // Draw Mandelbrot Set
            FractalComponent mandelbrotComponent = new MandelbrotComponent(WIDTH, HEIGHT);
            fractalPanel.add(mandelbrotComponent);
        } else if (selectedFractal.equals("Julia Set")) {
            // Draw Julia Set
            FractalComponent juliaComponent = new JuliaComponent(WIDTH, HEIGHT);
            fractalPanel.add(juliaComponent);
        }

        // Refresh panel
        fractalPanel.revalidate();
        fractalPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FractalUI().setVisible(true);
            }
        });
    }
}
