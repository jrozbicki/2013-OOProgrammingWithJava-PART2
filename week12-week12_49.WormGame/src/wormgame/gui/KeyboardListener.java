/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

/**
 *
 * @author chanhnguyen
 */
public class KeyboardListener implements KeyListener {

    private Worm keyWorm;

    public KeyboardListener(Worm worm) {
        this.keyWorm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent pe) {
        if (pe.getKeyCode() == KeyEvent.VK_UP) {
            this.keyWorm.setDirection(Direction.UP);
        } else if (pe.getKeyCode() == KeyEvent.VK_LEFT) {
            this.keyWorm.setDirection(Direction.LEFT);
        } else if (pe.getKeyCode() == KeyEvent.VK_DOWN) {
            this.keyWorm.setDirection(Direction.DOWN);
        } else if (pe.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.keyWorm.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
