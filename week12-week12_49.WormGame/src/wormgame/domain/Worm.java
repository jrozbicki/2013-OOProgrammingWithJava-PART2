/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author chanhnguyen
 */
public class Worm {

    private Direction wormDirection;
    private final List<Piece> wormPiece;
    private boolean GrowOrNot = false;
//    private boolean eatApple = false;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.wormDirection = originalDirection;
        this.wormPiece = new ArrayList<Piece>();
        this.wormPiece.add(new Piece(originalX, originalY));
    }

    public Direction getDirection() {
        return this.wormDirection;
    }

    public void setDirection(Direction dir) {
        this.wormDirection = dir;
    }

    public int getLength() {
        return this.wormPiece.size();
    }

    public List<Piece> getPieces() {
        return this.wormPiece;
    }

    public void move() {
        if (this.wormPiece.size() < 3) {
            this.grow();
        }
        Piece newPiece = new Piece(this.wormPiece.get(this.wormPiece.size() - 1).getX(), this.wormPiece.get(this.wormPiece.size() - 1).getY());

        if (this.wormDirection == Direction.UP) {
            newPiece.move(0, -1);
        } else if (this.wormDirection == Direction.LEFT) {
            newPiece.move(-1, 0);
        } else if (this.wormDirection == Direction.DOWN) {
            newPiece.move(0, 1);
        } else {
            newPiece.move(1, 0);
        }
        this.wormPiece.add(newPiece);
        if (!this.GrowOrNot) {
            this.wormPiece.remove(0);
        } else {
            this.GrowOrNot = false;
        }

    }

    public void grow() {

        this.GrowOrNot = true;

    }

    public boolean runsInto(Piece piece) {
        for (Piece p : this.wormPiece) {
            if (p.getX() == piece.getX() && p.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
//        return this.wormPiece.get(this.wormPiece.size() - 1).getX() == piece.getX() && this.wormPiece.get(this.wormPiece.size() - 1).getY() == piece.getY();
    }

    public boolean runsIntoItself() {
        for (Piece p : this.wormPiece) {
            for (Piece c : this.wormPiece) {
                if (p == c) {
                    continue;
                }
                if (p.getX() == c.getX() && p.getY() == c.getY()) {

                    return true;
                }
            }
        }
        return false;
    }
}
