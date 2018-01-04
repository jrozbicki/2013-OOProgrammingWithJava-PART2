package greeter.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Swing on");
        frame.setSize(new Dimension(400,200));
        this.createComponents(frame);
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel text = new JLabel("Hi!");
        container.add(text);
    }

    public JFrame getFrame() {
        return frame;
    }
}
