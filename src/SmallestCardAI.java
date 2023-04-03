public class SmallestCardAI extends AI {

    /**
     *
     * @param hand the hand that the AI can play from.
     * @param cardPile the card pile that the AI can play to.
     * @return the smallest valid card that can be played.
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        Card topCard = cardPile.getTopCard();
        Card handCard;
        Card smallestCard = null;

        for (int i = 0; i < hand.getSize(); i++) {
            handCard = hand.get(i);

            if (isValid(handCard, topCard)) {
                if (smallestCard == null) {
                    smallestCard = handCard;
                } else if (handCard.getRankNum() < smallestCard.getRankNum()) {
                    smallestCard = handCard;
                }
            }
        }

        return smallestCard;
    }




    /**
     *
     * @return the name of the SmallestCardAI.
     */
    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
