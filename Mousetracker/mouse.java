import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse extends JFrame {
    private JPanel mousePanel;
    private JLabel statusBar;

    public Mouse() {
        super("Mouse Events");

        mousePanel = new JPanel();
        mousePanel.setBackground(Color.WHITE);
        add(mousePanel, BorderLayout.CENTER);

        statusBar = new JLabel("Default");
        add(statusBar, BorderLayout.SOUTH);

        MouseHandler handler = new MouseHandler();
        mousePanel.addMouseListener(handler);
        mousePanel.addMouseMotionListener(handler);
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            statusBar.setText(String.format("Clicked at [%d, %d]", event.getX(), event.getY()));
        }

        @Override
        public void mousePressed(MouseEvent event) {
            statusBar.setText("Mouse pressed");
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            statusBar.setText("Mouse released");
        }

        @Override
        public void mouseEntered(MouseEvent event) {
            statusBar.setText("Mouse entered");
            mousePanel.setBackground(Color.ORANGE);
        }

        @Override
        public void mouseExited(MouseEvent event) {
            statusBar.setText("Mouse exited");
            mousePanel.setBackground(Color.PINK);
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            statusBar.setText(String.format("Dragged at [%d, %d]", event.getX(), event.getY()));
        }

        @Override
        public void mouseMoved(MouseEvent event) {
            statusBar.setText(String.format("Moved at [%d, %d]", event.getX(), event.getY()));
        }
    }

    public static void main(String[] args) {
        Mouse frame = new Mouse();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
