enum Rank {
    Two(2, "Two"),
    Three(3, "Three"),
    Four(4, "Four"),
    Five(5, "Five"),
    Six(6, "Six"),
    Seven(7, "Seven"),
    Eight(8, "Eight"),
    Nine(9, "Nine"),
    Ten(10, "Ten"),
    Jack(10, "Jack"),
    Queen(10, "Queen"),
    King(10, "King"),
    Ace(11, "Ace");

    public final int value;
    public final String name;

    private Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }
}

enum Suit {
    Clubs("Clubs"),
    Diamonds("Diamonds"),
    Hearts("Hearts"),
    Spades("Spades");

    public String name;

    private Suit(String name) {
        this.name = name;
    }
}

public class Card {
    public Rank rank;
    public Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override public String toString() {
        return this.rank.name + " of " + this.suit.name;
    }

    public int value() {
        return this.rank.value;
    }
}
