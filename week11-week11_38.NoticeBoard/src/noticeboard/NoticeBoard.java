package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);


        JTextField north = new JTextField();
        JButton copy = new JButton("Copy!");
        JLabel south = new JLabel();


        ActionEventListener listener = new ActionEventListener(north, south);
        copy.addActionListener(listener);

        container.add(north);
        container.add(copy);
        container.add(south);
    }
}
