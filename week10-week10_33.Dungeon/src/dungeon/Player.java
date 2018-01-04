package dungeon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private int x;
    private int y;
    private int xMax;
    private int yMax;

    public Player(int lenght, int height) {
        this.x = 0;
        this.y = 0;
        this.xMax = lenght - 1;
        this.yMax = height - 1;

    }



    public String printPosition(){
        String position = "@ "+x+" "+y;
        return position;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(char character) {
        switch (character) {
            case 'w':
                if(getY()-1<0){
                } else {
                    this.y--;
                }
                break;
            case 's':
                if(getY()+1>yMax){
                } else {
                    this.y++;
                }
                break;
            case 'a':
                if(getX()-1<0){
                } else {
                    this.x--;
                }
                break;
            case 'd':
                if(getX()+1>xMax){
                } else {
                    this.x++;
                }
                break;
        }
    }
}


