public class AI {

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
            if (handCard.getRankNum() >= topCard.getRankNum() || handCard.getSuitName().equals(topCard.getSuitName())) {
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
