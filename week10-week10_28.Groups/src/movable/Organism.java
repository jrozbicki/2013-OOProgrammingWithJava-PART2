package movable;

public class Organism implements Movable {
    private int xCoordinant;
    private int yCoorinant;

    public Organism(int x, int y) {
        this.xCoordinant = x;
        this.yCoorinant = y;
    }

    public String toString() {
        return "x: " + this.xCoordinant + "; y: " + this.yCoorinant;
    }

    @Override
    public void move(int dx, int dy) {
        this.xCoordinant += dx;
        this.yCoorinant += dy;
    }
}
