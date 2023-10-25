/**
 * @author jvogt33
 * @version 1.00
 */
public class HalloweenNight {
    private TrickOrTreater[] cryptKickerFive;
    private TrickOrTreater[] ghoulGang;

    /**
     * constructor for new HalloweenNight.
     * @param ccf TrickOrTreater array for one of the two teams. Should be of length 5 with no null elements
     * @param gg TrickOrTreater array for the other team, with the same rules applied.
     */
    public HalloweenNight(TrickOrTreater[] ccf, TrickOrTreater[] gg) {
        this.cryptKickerFive = ccf;
        this.ghoulGang = gg;
    }

    /**
     * Overrides Object.toString.
     * @return string representation of the HalloweenNight teams
     */
    @Override
    public String toString() {
        String a = "";
        a += "cryptKickerFive: ";
        a += String.format("%s, %s, %s, %s, %s", cryptKickerFive[0],
            cryptKickerFive[1],
            cryptKickerFive[2],
            cryptKickerFive[3],
            cryptKickerFive[4]);
        a += " versus ghoulGang: ";
        a += String.format("%s, %s, %s, %s, %s", ghoulGang[0],
            ghoulGang[1],
            ghoulGang[2],
            ghoulGang[3],
            ghoulGang[4]);

        return a;
    }

    /**
     * Compares the members of the teams to determine which is at an advantage.
     * Uses compareTo() for each TrickOrTreater
     */
    public void compareTeams() {
        int a = 0;
        for (int i = 0; i < cryptKickerFive.length; i++) {
            a += cryptKickerFive[i].compareTo(ghoulGang[i]);
        }

        if (a > 0) {
            System.out.println("cryptKickerFive is favored.");
        } else if (a < 0) {
            System.out.println("ghoulGang is favored.");
        } else {
            System.out.println("Neither team is favored.");
        }
    }

    /**
     * Initializes a battle.
     * Each team runs trickOrTreat() and then robs members of other team, in turn.
     * @param goal The amount of candy each team should reach in order to win
     */
    public void battle(int goal) {
        if (goal <= 0) {
            goal = 60;
        }

        do {
            for (TrickOrTreater i : cryptKickerFive) {
                i.trickOrTreat();
            }
            for (int i = 0; i < cryptKickerFive.length; i++) {
                if (cryptKickerFive[i] instanceof Ghost) {
                    ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
                }
            }

            for (TrickOrTreater i : ghoulGang) {
                i.trickOrTreat();
            }
            for (int i = 0; i < ghoulGang.length; i++) {
                if (ghoulGang[i] instanceof Ghost) {
                    ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
                }
            }
        } while (countCandy(cryptKickerFive) < goal && countCandy(ghoulGang) < goal);

        if (countCandy(cryptKickerFive) >= goal && countCandy(ghoulGang) >= goal) {
            System.out.println("It is a tie!");
        } else if (countCandy(cryptKickerFive) >= goal) {
            System.out.println("cryptKickerFive won!");
        } else {
            System.out.println("ghoulGang won!");
        }

    }

    private int countCandy(TrickOrTreater[] team) {
        int a = 0;
        for (TrickOrTreater i : team) {
            a += i.getNumCandy();
        }
        return a;
    }
}
