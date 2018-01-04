import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinusListener implements ActionListener{
    private JTextField input;
    private JTextField output;
    private JButton z;

    public MinusListener(JTextField input, JTextField output, JButton clear){
        this.input = input;
        this.output = output;
        this.z = clear;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            int In = Integer.parseInt(input.getText());
            int Out = Integer.parseInt(output.getText());

            Out -= In;

            this.input.setText("");
            this.output.setText("" + Out);

            if(Out==0){
                z.setEnabled(false);
            } else {
                z.setEnabled(true);
            }
        } catch (NumberFormatException nfe){
            this.input.setText("");
        }
    }
}
