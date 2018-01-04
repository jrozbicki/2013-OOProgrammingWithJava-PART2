import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener{
    private JTextField input;
    private JTextField output;
    private JButton z;

    public ClearListener(JTextField input, JTextField output, JButton clear){
        this.input = input;
        this.output = output;
        this.z = clear;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            this.input.setText("");
            this.output.setText("0");
            this.z.setEnabled(false);
        } catch (NumberFormatException nfe){
            this.input.setText("");
        }
    }
}
