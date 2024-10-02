import java.util.ArrayList;

public class Player {
    public ArrayList<Card> cards;
    private boolean hasAce = false;
    
    public Player() {
        this.cards = new ArrayList<Card>();
    }

    public void reset() {
        cards.clear();
        hasAce = false;
    }

    public void addCard(Card card) {
        cards.addLast(card);
        if (card.rank == Rank.Ace) {
            hasAce = true;
        }
    }

    public int getHandValue() {
        int total = 0;

        for (Card card : cards) {
            total += card.value();
        }

        // Subtract ten if we have an ace and our hand is over 21
        if (total > 21 && hasAce) {
            total -= 10;
        }

        return total;
    }

    public boolean isBust() {
        return getHandValue() > 21;
    }

    public boolean isBlackjack() {
        return getHandValue() == 21 && cards.size() == 2;
    }
}
