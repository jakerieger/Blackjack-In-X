import java.util.Scanner;

public class Blackjack {
    public Deck deck;
    public Player player;
    public Player dealer;
    private Scanner scanner;

    public Blackjack() {
        this.deck = new Deck();
        this.player = new Player();
        this.dealer = new Player();
        this.scanner = new Scanner(System.in);
    }

    private void playerTurn() {
        if (player.isBlackjack() && !dealer.isBlackjack()) {
            return;
        }

        String input = "";
        do {
            //System.out.flush();
            System.out.printf("Your hand: %d\n", player.getHandValue());
            System.out.print("Hit (h) or Stand (s): ");

            if (scanner.hasNext()) {
                input = scanner.next().trim();
                if (input.equals("h")) {
                    player.addCard(deck.deal());
                }
            }

        } while (input.equals("h") && !player.isBust());
    }

    private void dealerTurn() {
        while (dealer.getHandValue() < 17) {
            dealer.addCard(deck.deal());
        }
    }

    private void gameOver() {
        if (player.isBust()) {
            System.out.println("You busted! Dealer wins.");
        } else if (dealer.isBust()) {
            System.out.println("Dealer busted! You win.");
        } else if (player.getHandValue() > dealer.getHandValue()) {
            System.out.printf("You won with: %d\n", player.getHandValue());
        } else if (player.getHandValue() == dealer.getHandValue()) {
            System.out.println("It's a tie!");
        } else {
            System.out.printf("Dealer wins with: %d\n", dealer.getHandValue());
        }

        String input;
        System.out.print("Would you like to (q)uit or (r)eplay?: ");
        input = scanner.next().trim();
        if (input.equals("r")) {
            reset();
            play();
        } else {
            System.out.println("Goodbye!");
        }
    }

    public void play() {
        deck.shuffle(10);

        player.addCard(deck.deal());
        player.addCard(deck.deal());
        dealer.addCard(deck.deal());
        dealer.addCard(deck.deal());

        playerTurn();
        if (!player.isBust()) {
            dealerTurn();
        }
        gameOver();
    }

    private void reset() {
        deck.reset();
        player.reset();
        dealer.reset();
    }

    public static void main(String[] args) {
        Blackjack game = new Blackjack();
        game.play();
    }
}