import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> listOfCardsInHand = new ArrayList<Card>();

    public void add(Card card) {
        listOfCardsInHand.add(card);
    }

    public void print() {
        for (Card each : listOfCardsInHand) {
            System.out.println(each);
        }
    }

    public void sort() {
        Collections.sort(listOfCardsInHand);
    }

    @Override
    public int compareTo(Hand hand) {
        int sumOfThis = 0;
        int sumOfHand = 0;
        for (Card each : this.listOfCardsInHand) {
            sumOfThis += each.getValue();
        }
        for (Card each2 : hand.listOfCardsInHand) {
            sumOfHand += each2.getValue();
        }
        if (sumOfThis < sumOfHand) {
            return -1;
        } else if (sumOfThis == sumOfHand) {
            return 0;
        } else {
            return 1;
        }
    }

    public void sortAgainstSuit() {
        Collections.sort(listOfCardsInHand, new SortAgainstSuitAndValue());

    }
}

