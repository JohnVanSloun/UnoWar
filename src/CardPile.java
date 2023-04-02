public class CardPile {
    private Card topCard;
    private int size;

    /**
     * Initializes the card pile.
     * @param topCard the card that will be the first topCard of the CardPile
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.size = 1;
    }

    /**
     *
     * @param card The card assessed to see whether it can be legally played or not.
     * @return true if the card can legally be played onto the card pile and false if not.
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }

        if (card.getRankNum() >= topCard.getRankNum() || card.getSuitName().equals(topCard.getSuitName())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * If the card can legally be played then it is added to the pile and becomes the new top card if it is illegal
     * then an error message is printed.
     * @param card The card being attempted to play onto the pile.
     */
    public void play(Card card) {
        if (canPlay(card)) {
            this.topCard = card;
            this.size++;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    /**
     *
     * @return The number of cards in a card pile as an int.
     */
    public int getNumCards() {
        return this.size;
    }

    /**
     *
     * @return The current top card.
     */
    public Card getTopCard() {
        return this.topCard;
    }
}
