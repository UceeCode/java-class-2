import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame {
    private JButton leftJButton;
    private JButton centerJButton;
    private JButton rightJButton;
    private FlowLayout layout;
    private Container container;

    public FlowLayoutFrame() {
        super("FlowLayout Demo");

        // Set up the layout
        layout = new FlowLayout();
        container = getContentPane();
        container.setLayout(layout);

        // Create buttons
        leftJButton = new JButton("Left");
        container.add(leftJButton);

        centerJButton = new JButton("Center");
        container.add(centerJButton);

        rightJButton = new JButton("Right");
        container.add(rightJButton);
    }

    public static void main(String[] args) {
        FlowLayoutFrame frame = new FlowLayoutFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
