
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Jump {

    private Random random;
    private int jump;
    private List<Integer> votes;

    public Jump() {
        votes = new ArrayList<Integer>();
    }

    public void goJump() {
        int i = 0;
        while (i < 5) {
            votes.add(randomInt(10, 20));
            i++;
        }
        this.jump = randomInt(60, 120);
    }

    public int randomInt(int min, int max) {
        random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public int getJump() {
        return jump;
    }

    public int getScore() {
        Collections.sort(votes);
        int sum = 0;
        //add the votes up after sorting
        for (Integer item : votes) {
            sum += item;
        }

        //remove the lowest and highest scores
        sum -= Collections.min(votes);
        sum -= Collections.max(votes);
        //add the jump length
        sum += jump;

        //for a score total
        return sum;
    }

    @Override
    public String toString() {
        return "" + votes;
    }
}
