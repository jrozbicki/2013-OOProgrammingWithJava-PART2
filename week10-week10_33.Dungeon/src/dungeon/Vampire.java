package dungeon;

import java.util.List;
import java.util.Random;

public class Vampire {
    private int x;
    private int y;
    private Random random;
    private int xMax;
    private int yMax;
    private boolean vampireMove;
    private List<Vampire> squad;
    private String[][] field;

    public Vampire(int lenght, int height, boolean vampireMove, List<Vampire> squad, String[][] field) {
        this.random = new Random();
        this.xMax = lenght-1;
        this.yMax = height-1;
        this.x = this.random.nextInt(xMax);
        this.y = this.random.nextInt(xMax);
        this.vampireMove = vampireMove;
        this.squad = squad;
        this.field = field;
    }

    public String printPosition() {
        String position = "v " + x + " " + y;
        return position;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int vampireStepCounter(char[] inputArray) {
        int moveCounter = inputArray.length;
        return moveCounter;
    }

    public boolean ifEmpty(String[][] field, int x, int y) {
        //System.out.println(x+" , "+y);
        if (field[x][y].equals(".") || field[x][y].equals("@")) {
            return true;
        } else {
            return false;
        }
    }


    public char randomMove() {
        char RandomChar = 'a';
        int randomInt = this.random.nextInt(4);
        switch (randomInt) {
            case 0:
                RandomChar = 'w';
                break;
            case 1:
                RandomChar = 's';
                break;
            case 2:
                RandomChar = 'a';
                break;
            case 3:
                RandomChar = 'd';
                break;
        }
        return RandomChar;
    }

    public void move(char character) {
        if (vampireMove) {
            switch (character) {
                case 'w':
                    if (getY() - 1 < 0) {
                    } else if (!ifEmpty(this.field,this.getX(),this.getY()-1)) {
                    } else {
                        this.y--;
                    }

                    break;
                case 's':
                    if (getY() + 1 > yMax) {
                    } else if (!ifEmpty(this.field,this.getX(),this.getY()+1)) {
                    } else {
                        this.y++;
                    }
                    break;
                case 'a':
                    if (getX() - 1 < 0) {
                        break;
                    } else if (!ifEmpty(this.field,this.getX()-1,this.getY())) {
                    } else {
                        this.x--;
                    }
                    break;
                case 'd':
                    if (getX() + 1 > xMax) {
                        break;
                    } else if (!ifEmpty(this.field, this.getX()+1,this.getY())) {
                    } else {
                        this.x++;
                    }
                    break;
            }
        }
    }
}
