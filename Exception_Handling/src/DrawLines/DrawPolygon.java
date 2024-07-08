package DrawLines;

import javax.swing.*;
import java.awt.*;

public class DrawPolygon extends JPanel {
    static class Polygon {
        private int[] xPoints;
        private int[] yPoints;
        private int numPoints;

        public Polygon(int[] xPoints, int[] yPoints, int numPoints) {
            this.xPoints = xPoints;
            this.yPoints = yPoints;
            this.numPoints = numPoints;
        }

        public void draw(Graphics g) {
            g.drawPolygon(xPoints, yPoints, numPoints);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] xPoints = {50, 150, 250, 350};
        int[] yPoints = {50, 150, 50, 150};
        int numPoints = 4;

        Polygon polygon = new Polygon(xPoints, yPoints, numPoints);
        polygon.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Polygon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawPolygon());
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
