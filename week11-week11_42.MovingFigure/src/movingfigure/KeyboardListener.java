package movingfigure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Component component;
    private Figure figure;

    public KeyboardListener(Component component, Figure figure){
        this.component = component;
        this.figure = figure;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");
            figure.move(-1,0);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");
            figure.move(1,0);
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");
            figure.move(0,-1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("Keystroke " + e.getKeyCode() +  " pressed.");
            figure.move(0,1);
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}