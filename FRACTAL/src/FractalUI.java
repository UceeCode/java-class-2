import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalUI extends JFrame {

    private final int width = 800;
    private final int height = 600;

    private JComboBox<String> fractalComboBox;
    private JButton drawButton;
    private JPanel fractalPanel;

    public FractalUI() {
        setTitle("Fractal Viewer");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Initialize components
        fractalComboBox = new JComboBox<>(new String[]{"Mandelbrot Set", "Julia Set"});
        drawButton = new JButton("Draw");
        fractalPanel = new JPanel();

        // Add action listener to the draw button
        drawButton.addActionListener(e -> drawFractal());

        // Set layout
        JPanel controlPanel = new JPanel();
        controlPanel.add(fractalComboBox);
        controlPanel.add(drawButton);
        add(controlPanel, BorderLayout.NORTH);
        add(fractalPanel, BorderLayout.CENTER);
    }

    private void drawFractal() {
        // Remove the previous fractal component if exists
        fractalPanel.removeAll();

        // Get the selected fractal from the combo box
        String selectedFractal = (String) fractalComboBox.getSelectedItem();

        // Draw the selected fractal
        if (selectedFractal == null) {
            JOptionPane.showMessageDialog(this, "Please select a fractal to draw.", "No Fractal Selected", JOptionPane.ERROR_MESSAGE);
            return; // Exit method if no fractal is selected
        }

        // Create and add the selected fractal component
        switch (selectedFractal) {
            case "Mandelbrot Set":
                MandelbrotComponent mandelbrotComponent = new MandelbrotComponent(width, height);
                fractalPanel.add(mandelbrotComponent);
                break;
            case "Julia Set":
                JuliaComponent juliaComponent = new JuliaComponent(width, height);
                fractalPanel.add(juliaComponent);
                break;
        }

        // Refresh panel
        fractalPanel.revalidate();
        fractalPanel.repaint();
    }

    public class MandelbrotComponent extends JComponent {

        private final int width;
        private final int height;

        public MandelbrotComponent(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            double zx, zy, cX, cY, tmp;
            int maxIterations = 1000;
            double zoom = 150;
            double moveX = -0.5;
            double moveY = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    zx = zy = 0;
                    cX = (x - width / 2) / zoom + moveX;
                    cY = (y - height / 2) / zoom + moveY;
                    int iter = maxIterations;
                    while (zx * zx + zy * zy < 4 && iter > 0) {
                        tmp = zx * zx - zy * zy + cX;
                        zy = 2.0 * zx * zy + cY;
                        zx = tmp;
                        iter--;
                    }
                    g.setColor(iter == 0 ? Color.BLACK : Color.getHSBColor((maxIterations / (float) iter) % 1, 1, 1));
                    g.drawLine(x, y, x, y);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
    }

    public class JuliaComponent extends JComponent {

        private final int width;
        private final int height;

        public JuliaComponent(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            double zx, zy, cX = -0.7, cY = 0.27015, tmp;
            int maxIterations = 1000;
            double zoom = 150;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    zx = 1.5 * (x - width / 2) / (0.5 * zoom * width);
                    zy = (y - height / 2) / (0.5 * zoom * height);
                    int iter = maxIterations;
                    while (zx * zx + zy * zy < 4 && iter > 0) {
                        tmp = zx * zx - zy * zy + cX;
                        zy = 2.0 * zx * zy + cY;
                        zx = tmp;
                        iter--;
                    }
                    g.setColor(iter == 0 ? Color.BLACK : Color.getHSBColor((maxIterations / (float) iter) % 1, 1, 1));
                    g.drawLine(x, y, x, y);
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(width, height);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FractalUI().setVisible(true));
 
    }

}
