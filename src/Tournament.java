public class Tournament {

    public static void main(String[] args) {
        AI randomAI = new AI();
        AI randomAI2 = new AI();
        AI smallAI = new SmallestCardAI();
        AI bigAI = new BiggestCardAI();

        UnoWarMatch randVSRand = new UnoWarMatch(randomAI, randomAI2);
        System.out.println(randomAI.toString() + " vs. " + randomAI.toString() + " winrate " + randVSRand.winRate(1000));

        UnoWarMatch randVSSmall = new UnoWarMatch(randomAI, smallAI);
        System.out.println(randomAI.toString() + " vs. " + smallAI.toString() + " winrate " + randVSSmall.winRate(1000));

        UnoWarMatch randVSBig = new UnoWarMatch(randomAI, bigAI);
        System.out.println(randomAI.toString() + " vs. " + bigAI.toString() + " winrate " + randVSBig.winRate(1000));

        UnoWarMatch smallVSRand = new UnoWarMatch(smallAI, randomAI);
        System.out.println(smallAI.toString() + " vs. " + randomAI.toString() + " winrate " + smallVSRand.winRate(1000));

        UnoWarMatch smallVSSmall = new UnoWarMatch(smallAI, smallAI);
        System.out.println(smallAI.toString() + " vs. " + smallAI.toString() + " winrate " + smallVSSmall.winRate(1000));

        UnoWarMatch smallVSBig = new UnoWarMatch(smallAI, bigAI);
        System.out.println(smallAI.toString() + " vs. " + bigAI.toString() + " winrate " + smallVSBig.winRate(1000));

        UnoWarMatch bigVSRand = new UnoWarMatch(bigAI, randomAI);
        System.out.println(bigAI.toString() + " vs. " + randomAI.toString() + " winrate " + bigVSRand.winRate(1000));

        UnoWarMatch bigVSSmall = new UnoWarMatch(bigAI, smallAI);
        System.out.println(bigAI.toString() + " vs. " + smallAI.toString() + " winrate " + bigVSSmall.winRate(1000));

        UnoWarMatch bigVSBig = new UnoWarMatch(bigAI, bigAI);
        System.out.println(bigAI.toString() + " vs. " + bigAI.toString() + " winrate " + bigVSBig.winRate(1000));
    }
}
