public class AI {

    /**
     *
     * @param card The card being analyzed for validity to be played.
     * @param topCard the card on the top of the deck.
     * @return true if the card is valid false if not.
     */
    public boolean isValid(Card card, Card topCard) {
        if (card.getSuitName().equals(topCard.getSuitName()) || card.getRankNum() >= topCard.getRankNum()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param hand the hand that the AI can play from.
     * @param cardPile the card pile that the AI can play to.
     * @return A valid card from the hand that can be played to the card pile or null if there are no valid cards.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card topCard = cardPile.getTopCard();
        Card handCard;
        for (int i = 0; i < hand.getSize(); i++) {
            handCard = hand.get(i);

            if (isValid(handCard, topCard)) {
                return handCard;
            }
        }

        return null;
    }

    /**
     *
     * @return The name of the AI as a String.
     */
    @Override
    public String toString() {
        return "Random Card AI";
    }
}
