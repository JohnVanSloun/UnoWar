import java.util.Random;

public class Deck {
    private Card[] cards;
    private int cardTracker;

    /**
     * Compiles a full deck of cards consisting of 52 unique cards and then shuffles them.
     */
    public Deck() {
        this.cards = new Card[52];
        this.cardTracker = -1;

        int suitTracker = 1;
        int rankTracker = 1;

        for (int i = 0; i < this.cards.length; i++) {
            if (suitTracker == 5) {
                suitTracker = 1;
            }

            if (rankTracker == 14) {
                rankTracker = 1;
            }

            cards[i] = new Card(rankTracker, suitTracker);
            suitTracker++;
            rankTracker++;
        }
        shuffle();
    }

    /**
     * Rearranges the order of the cards in the deck randomly.
     */
    public void shuffle() {
        Random rand = new Random();
        int j;
        Card temp;

        for (int i = this.cards.length - 1; i > 0; i--) {
            j = rand.nextInt(i);
            temp = this.cards[j];
            this.cards[j] = this.cards[i];
            this.cards[i] = temp;
        }
    }

    /**
     * Draws a new unused card from the deck.
     * @return The card that is selected to be drawn.
     */
    public Card draw() {
        if (this.isEmpty()) {
            this.shuffle();
            this.cardTracker = -1;
        }

        Card drawnCard = this.cards[this.cardTracker + 1];
        this.cardTracker++;
        return drawnCard;
    }

    /**
     *
     * @return The remaining amount of cards in the deck that can be drawn before it is shuffled.
     */
    public int cardsRemaining() {
        return (this.cards.length - (this.cardTracker + 1));
    }

    /**
     *
     * @return true if the deck is empty and false otherwise.
     */
    public boolean isEmpty() {
        if (this.cardTracker == 51) {
            return true;
        } else {
            return false;
        }
    }
}
