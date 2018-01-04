package movingfigure;

import java.awt.*;

public class Square extends Figure {
    private int sideLenght;

    public Square(int x, int y, int sideLenght){
        super(x, y);
        this.sideLenght = sideLenght;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(),super.getY(),this.sideLenght,this.sideLenght);
    }
}

