package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;

    private Worm myWorm;
    private Random myRandom;
    private Apple myApple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.myRandom = new Random();

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        this.myWorm = new Worm(width / 2, height / 2, Direction.DOWN);

        this.myApple = new Apple(this.myRandom.nextInt(width), this.myRandom.nextInt(height));
        while (true) {
            this.myApple.setNewXY(this.myRandom.nextInt(this.width), this.myRandom.nextInt(this.height));
            if (!this.myWorm.runsInto(myApple)) {
                break;
            }
        }
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return this.myWorm;
    }

    public void setWorm(Worm worm) {
        this.myWorm = worm;
    }

    public Apple getApple() {
        return this.myApple;
    }

    public void setApple(Apple apple) {
        this.myApple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        this.myWorm.move();
        if (this.myWorm.runsInto(this.myApple)) {
            this.myWorm.grow();

            while (true) {
                this.myApple.setNewXY(this.myRandom.nextInt(this.width - 1) + 1, this.myRandom.nextInt(this.height - 1) + 1);
                if (!this.myWorm.runsInto(myApple)) {
                    break;
                }
            }

        }
        if (this.myWorm.runsIntoItself()) {
            this.continues = false;
        }
        for (Piece p : this.myWorm.getPieces()) {
            if (p.getX() >= this.width || p.getX() <= 0 || p.getY() >= this.height || p.getY() <= 0) {
                this.continues = false;
            }
        }
        this.updatable.update();
        super.setDelay(1000 / this.myWorm.getLength());
    }

}
