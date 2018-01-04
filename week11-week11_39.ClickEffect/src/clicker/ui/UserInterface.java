package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator personalCalculator = new PersonalCalculator();

    public UserInterface(Calculator persCalc){
        this.personalCalculator = persCalc;
    }


    @Override
    public void run() {

        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        JLabel textName = new JLabel(String.valueOf(this.personalCalculator.giveValue()));
        JButton clickButton = new JButton("Click!");
        ClickListener click = new ClickListener(personalCalculator, textName);
        clickButton.addActionListener(click);

        container.add(textName,BorderLayout.NORTH);
        container.add(clickButton,BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
