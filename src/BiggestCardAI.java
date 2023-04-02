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
        Card biggestCard = hand.get(0);

        for (int i = 0; i < hand.getSize(); i++) {
            handCard = hand.get(i);
            if ((handCard.getRankNum() >= topCard.getRankNum()) && (handCard.getRankNum() > biggestCard.getRankNum())) {
                biggestCard = handCard;
            }
        }

        if (biggestCard.getRankNum() < topCard.getRankNum()) {
            return null;
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
