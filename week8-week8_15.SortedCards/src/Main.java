import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write some test code here
/*
        Card first = new Card(2, Card.DIAMONDS);
        Card second = new Card(14, Card.CLUBS);
        Card third = new Card(12, Card.HEARTS);
        Card fourth = new Card(14, Card.HEARTS);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);

        System.out.println("");

        List<Card> cards = new ArrayList<Card>();

        cards.add(first);
        cards.add(second);
        cards.add(third);
        cards.add(fourth);
        //cards.add(second); //POR QUÉ???

        System.out.println(cards);
        Collections.sort(cards);
        System.out.println(cards);

        System.out.println("");



        Hand hand = new Hand();
        hand.add( new Card(12,Card.HEARTS) );
        hand.add( new Card(14,Card.DIAMONDS) );
        hand.add( new Card(2,Card.SPADES) );
        hand.add( new Card(2,Card.CLUBS) );
        hand.sort();
        hand.print();

        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(3, Card.CLUBS));
        cards.add(new Card(2, Card.DIAMONDS));
        cards.add(new Card(14, Card.CLUBS));
        cards.add(new Card(12, Card.HEARTS));
        cards.add(new Card(2, Card.CLUBS));

        SortAgainstSuitAndValue suitSorter = new SortAgainstSuitAndValue();
        Collections.sort(cards, suitSorter);

        for (Card c : cards) {
            System.out.println(c);

        }
        */
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sortAgainstSuit();

        hand.print();
    }
}
