

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;    

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(500,500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout outerLayout = new GridLayout(3,1);
        container.setLayout(outerLayout);

        JTextField output = new JTextField("0");
        output.setEnabled(false);

        JTextField input = new JTextField();
        
        ///// PANEL //////
        
        JPanel buttonPanel = new JPanel();
        GridLayout insideLayout = new GridLayout(1,3);
        buttonPanel.setLayout(insideLayout);

        JButton clear = new JButton("Z");
        ActionListener clearListener = new ClearListener(input,output,clear);
        clear.addActionListener(clearListener);
        clear.setEnabled(false);
                
        JButton plus = new JButton("+");
        ActionListener plusListener = new PlusListener(input,output,clear);
        plus.addActionListener(plusListener);
        
        JButton minus = new JButton("-");
        ActionListener minusListener = new MinusListener(input,output,clear);
        minus.addActionListener(minusListener);
        
        buttonPanel.add(plus);
        buttonPanel.add(minus);
        buttonPanel.add(clear);
        
        //////* PANEL *//////
        
        container.add(output);
        container.add(input);
        container.add(buttonPanel);
        
    }


    public JFrame getFrame() {
        return frame;
    }
}