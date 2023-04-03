public class BiggestCardAI extends AI{

    /**
     *
     * @param hand the hand that the AI can play from.
     * @param cardPile the card pile that the AI can play to.
     * @return The largest valid card that can be played.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card topCard = cardPile.getTopCard();
        Card handCard;
        Card biggestCard = null;

        for (int i = 0; i < hand.getSize(); i++) {
            handCard = hand.get(i);

            if (isValid(handCard, topCard)) {
                if (biggestCard == null) {
                    biggestCard = handCard;
                } else if (handCard.getRankNum() > biggestCard.getRankNum()) {
                    biggestCard = handCard;
                }
            }
        }

        return biggestCard;
    }

    /**
     *
     * @return The name of the BiggestCardAI.
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
