package clicker.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    private Calculator persCalc;
    private JLabel label;

    public ClickListener(Calculator persCalc, JLabel label){
        this.persCalc = persCalc;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        persCalc.increase();
        label.setText(String.valueOf(persCalc.giveValue()));
    }
}
