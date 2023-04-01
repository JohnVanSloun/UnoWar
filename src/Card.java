public class Card {
    private int rank;
    private int suit;

    /**
     * Assigns the values to their respective fields if they are valid values or prints an error message if either of
     * the values are invalid.
     * @param rank an integer denoting the number or value of the card.
     * @param suit an integer denoting the suit of the card.
     */
    public Card(int rank, int suit) {
        if ((rank > 0 && rank < 14) && (suit > 0 && suit < 5)) {
            this.rank = rank;
            this.suit = suit;
        } else {
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        }
    }

    public int getRankNum() {
        return this.rank;
    }

    /**
     *
     * @return The name of the rank associated with the card's rank number.
     */
    public String getRankName() {
        String[] rankNames = {"Ace", "Two", "Three", "Four",
                              "Five", "Six", "Seven", "Eight",
                              "Nine", "Ten", "Jack", "Queen", "King"};
        return rankNames[this.rank - 1];
    }

    /**
     *
     * @return The name of the suit associated with the card's suit number.
     */
    public String getSuitName() {
        String[] suitNames = {"Spades", "Hearts", "Clubs", "Diamonds"};
        return suitNames[this.suit - 1];
    }

    /**
     *
     * @return A string formatting the information contained within the card class.
     */
    @Override
    public String toString() {
       return getRankName() + " of " + getSuitName();
    }

    /**
     *
     * @param obj an object being compared with this card object.
     * @return A boolean denoting whether the object is equal to the card object.
     */
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Card) &&
                (((Card) obj).getRankName() == getRankName()) &&
                (((Card) obj).getSuitName() == getSuitName()))
        {
            return true;
        } else {
            return false;
        }
    }
}
