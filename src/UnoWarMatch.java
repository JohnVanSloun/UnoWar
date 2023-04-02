import java.sql.SQLFeatureNotSupportedException;

public class UnoWarMatch {
    private AI ai1;
    private AI ai2;

    /**
     *
     * @param ai1 The ai that will take the role of player 1.
     * @param ai2 The ai that will take the role of player 2.
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * Plays a round of UnoWar.
     * @param deck The deck being used in the game
     * @param hand1 The hand that takes the first turn.
     * @param hand2 The hand that takes the successive turn.
     * @param startHand a boolean denoting which hand plays first (true for hand1 and false for hand2).
     * @return true if player1 wins and false if player2 wins.
     */
    public boolean playRound(Deck deck, Hand hand1, Hand hand2, boolean startHand) {
        CardPile cardPile = new CardPile(deck.draw());
        boolean turn = startHand;
        Card ai1Play;
        Card ai2Play;

        while (true) {
            if (turn) {
                ai1Play = ai1.getPlay(hand1, cardPile);
                if (ai1Play == null) {
                    return false;
                }
                cardPile.play(ai1Play);
                hand1.remove(ai1Play);
                turn = false;
            } else {
                ai2Play = ai2.getPlay(hand2, cardPile);
                if (ai2Play == null) {
                    return true;
                }
                cardPile.play(ai2Play);
                hand2.remove(ai2Play);
                turn = true;
            }
        }
    }

    /**
     * Plays a game of UnoWar until one of the players has one 10 rounds.
     * @return true if ai1 has won and false if ai2 has won.
     */
    public boolean playGame() {
        Deck deck = new Deck();

        Hand ai1Hand = new Hand(deck, 5);
        Hand ai2Hand = new Hand(deck, 5);

        int ai1Score = 0;
        int ai2Score = 0;

        boolean turn = true;

        while ((ai1Score != 10) && (ai2Score != 10)) {
            if (playRound(deck, ai1Hand, ai2Hand, turn)) {
                ai1Score++;
                turn = true;
            } else {
                ai2Score++;
                turn = false;
            }
        }

        return (ai1Score == 10);
    }

    /**
     * Plays nTrials number of games of UnoWar and finds the win rate of ai1.
     * @param nTrials the number of times a game should be played.
     * @return The win rate of ai1 as a double.
     */
    public double winRate(int nTrials) {
        int ai1Wins = 0;

        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                ai1Wins++;
            }
        }

        return ((double)(ai1Wins)) / ((double)(nTrials));
    }


}
