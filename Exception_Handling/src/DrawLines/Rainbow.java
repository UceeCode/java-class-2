package DrawLines;

import javax.swing.*;
import java.awt.*;

public class Rainbow extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 10;
        int startAngle = 0;
        int arcAngle = 360 / 7;

        // Define the rainbow colors
        Color[] rainbowColors = {
                Color.RED, Color.ORANGE, Color.YELLOW,
                Color.GREEN, Color.BLUE, new Color(75, 0, 130), new Color(238, 130, 238)
        };

        // Draw the rainbow arcs
        for (int i = 0; i < rainbowColors.length; i++) {
            g.setColor(rainbowColors[i]);
            g.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, startAngle, arcAngle);
            startAngle += arcAngle;
        }
    }

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Rainbow Colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of RainbowColors
        Rainbow panel = new Rainbow();

        // Add the panel to the frame
        frame.add(panel);

        // Set the size of the frame
        frame.setSize(400, 400);

        // Make the frame visible
        frame.setVisible(true);
    }
}

