import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class paintPanel extends JPanel {
    private int pointCount = 0;
    private final int MAX_POINTS = 10000;
    private Point[] points = new Point[MAX_POINTS];
    private Point prevPoint;

    public paintPanel() {
        setBackground(Color.WHITE);

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
                if (pointCount < MAX_POINTS) {
                    points[pointCount] = event.getPoint();
                    pointCount++;
                    repaint();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 1; i < pointCount; i++) { 
            g.drawLine(points[i - 1].x, points[i - 1].y, points[i].x, points[i].y);
        }
    }

    public void clearPoints() {
        pointCount = 0;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint Panel Test");
        paintPanel paintPanel = new paintPanel();

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> paintPanel.clearPoints());

        frame.add(paintPanel, BorderLayout.CENTER);
        frame.add(clearButton, BorderLayout.SOUTH);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
