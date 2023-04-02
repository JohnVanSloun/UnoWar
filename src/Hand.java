public class Hand {
    private Card[] cards;
    private Deck deck;

    /**
     * Adds an amount of cards specified by the size to the hand to be held.
     * @param deck an object of type Deck
     * @param size The amount of cards the hand should be able to hold.
     */
    public Hand(Deck deck, int size) {
        this.cards = new Card[size];
        this.deck = deck;

        for (int i = 0; i < size; i++) {
            this.cards[i] = deck.draw();
        }
    }

    /**
     *
     * @return the amount of cards the hand contains.
     */
    public int getSize() {
        return this.cards.length;
    }

    /**
     *
     * @param i the index of the card being selected (0 indexed).
     * @return The card selected if the index is inbounds or the first card and an error message
     * if the index is out of bounds.
     */
    public Card get(int i) {
        if (i < 0 || i >= this.cards.length) {
            System.out.println("Invalid hand index!");
            return this.cards[0];
        } else {
            return this.cards[i];
        }
    }

    /**
     *
     * @param card the card being searched for to be removed from the hand.
     * @return true if the card is found and removed, and false if the card is not found in the hand.
     */
    public boolean remove(Card card) {
        for (int i = 0; i < this.cards.length; i++) {
            if (this.cards[i] == card) {
                this.cards[i] = this.deck.draw();
                return true;
            }
        }
        return false;
    }
}
