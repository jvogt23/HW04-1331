/**
 * @author jvogt33
 * @version 1.00
 */
public class Witch extends TrickOrTreater implements Robbable {
    private String signatureCackle;

    /**
     * Constructor for new Witch.
     * @param name the name of this Witch
     * @param age the age of this Witch
     * @param numCandy the amount of candy the Witch will start out with
     * @param signatureCackle String representing the cackle the Witch will produce in trickOrTreat()
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle == null || signatureCackle.trim().equals("")) {
            this.signatureCackle = "Bwahaha";
        } else {
            this.signatureCackle = signatureCackle;
        }
    }

    /**
     * No-Arg constructor for new Witch.
     * Produces default values "Maleficent", 7, 0, "Bwahaha"
     */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    /**
     * Overrides TrickOrTreater.trickOrTreat().
     * This implementation prints string containing "{signatureCackle}! I'll get you my pretty!",
     * then runs gainCandy() with candy amount 3
     */
    @Override
    public void trickOrTreat() {
        System.out.println(String.format("%s! I'll get you my pretty!", signatureCackle));
        this.gainCandy(3);
    }

    /**
     * Overrides Robbable.beRobbed().
     * A witch can lose up to 6 candy in a robbery, depending on the amount they
     * have before it occurs.
     * @return the amount of candy lost as an int
     */
    @Override
    public int beRobbed() {
        int c = this.loseCandy(6);
        return c;
    }

    /**
     * Overrides TrickOrTreater.compareTo().
     * @param o the other TrickOrTreater to compare to
     * @return int representing natural order of Witches.
     */
    @Override
    public int compareTo(TrickOrTreater o) {
        int x = super.compareTo(o);
        if (x == 0 && o instanceof Witch) {
            x = Integer.compare(this.signatureCackle.length(),
                ((Witch) o).signatureCackle.length());
        }
        return x;
    }
}
