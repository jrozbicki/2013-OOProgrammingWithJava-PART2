package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double v) {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                if (new Random().nextDouble() <= v) {
                    turnToLiving(x,y);
                } else {
                    turnToDead(x,y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int il) {
        if (0 <= i && i < getWidth() && 0 <= il && il < getHeight() && getBoard()[i][il]) {
            //System.out.println("yes");
            return true;
        } else {
            //System.out.println("no");
            return false;
        }
    }

    @Override
    public void turnToLiving(int i, int il) {
        if (0 <= i && i < getWidth() && 0 <= il && il < getHeight()) {
            getBoard()[i][il] = true;
        }
    }

    @Override
    public void turnToDead(int i, int il) {
        if (0 <= i && i < getWidth() && 0 <= il && il < getHeight()) {
            getBoard()[i][il] = false;

        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int il) {
        int neighboursAlive = 0;
        if (0 <= i && i < getWidth() && 0 <= il && il < getHeight()){
            if(0 <= i-1 && i-1 < getWidth() && 0 <= il-1 && il-1 < getHeight() && isAlive(i-1,il-1)){
                //System.out.println("7");
                neighboursAlive++;
            }
            if(0 <= i && i < getWidth() && 0 <= il-1 && il-1 < getHeight() && isAlive(i,il-1)){
                //System.out.println("8");
                neighboursAlive++;
            }
            if(0 <= i+1 && i+1 < getWidth() && 0 <= il-1 && il-1 < getHeight() && isAlive(i+1,il-1)){
                //System.out.println("9");
                neighboursAlive++;
            }
            if(0 <= i+1 && i+1 < getWidth() && 0 <= il && il < getHeight() && isAlive(i+1,il)){
                //System.out.println("6");
                neighboursAlive++;
            }
            if(0 <= i+1 && i+1 < getWidth() && 0 <= il+1 && il+1 < getHeight() && isAlive(i+1,il+1)){
                //System.out.println("3");
                neighboursAlive++;
            }
            if(0 <= i && i < getWidth() && 0 <= il+1 && il+1 < getHeight() && isAlive(i,il+1)){
                //System.out.println("2");
                neighboursAlive++;
            }
            if(0 <= i-1 && i-1 < getWidth() && 0 <= il+1 && il+1 < getHeight() && isAlive(i-1,il+1)){
                //System.out.println("1");
                neighboursAlive++;
            }
            if(0 <= i-1 && i-1 < getWidth() && 0 <= il && il < getHeight() && isAlive(i-1,il)){
                //System.out.println("4");
                neighboursAlive++;
            }
        }
        return neighboursAlive;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        if(isAlive(i,i1)) {
            if (i2 < 2) {
                turnToDead(i, i1);
            }
            if (i2 > 3) {
                turnToDead(i, i1);
            }
        }
        if(!isAlive(i,i1)){
            if(i2==3){
                turnToLiving(i,i1);
            }
        }
    }
}
