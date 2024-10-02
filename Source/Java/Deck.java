import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        reset();
    }

    public void reset() {
        cards.clear();
        cards.ensureCapacity(52);
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public void shuffle(int iterations) {
        for (int i = 0; i < iterations; ++i) {
            try {
                Collections.shuffle(cards);
            } catch (UnsupportedOperationException ex) {
                System.err.println(ex.toString());
            }
        }
    }

    public Card deal() {
        if (cards.isEmpty()) {
            throw new RuntimeException("No more cards left in deck.");
        }

        var c = cards.getLast();
        cards.removeLast();
        return c;
    }

    public void print() {
        System.out.println("DECK");
        System.out.format("Cards in deck: %d\n\n", cards.size());

        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
}
