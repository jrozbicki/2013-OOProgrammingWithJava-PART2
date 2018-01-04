package movingfigure;

import java.awt.*;
import java.util.ArrayList;

public class CompoundFigure extends Figure {
    private ArrayList<Figure> list = new ArrayList<Figure>();

    public CompoundFigure(){}


    public void add(Figure f) {
        list.add(f);
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure each : list) {
            each.draw(graphics);
        }
    }

    @Override
    public void move(int x, int y){
        for(Figure each : list){
            each.move(x,y);
        }
    }
}