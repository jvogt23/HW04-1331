/**
 * @author jvogt33
 * @version 1.00
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    /**
     * Initializes a new Ghost. Ghost is a subclass of TrickOrTreater.
     * @param name Name of this Ghost
     * @param age age of this Ghost
     * @param numCandy number of candy this Ghost starts with
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    /**
     * No-Arg constructor.
     * Name initializes to "Casper the Unfriendly Ghost", age to 12, numCandy to 0.
     */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    /**
     * Overrides abstract method from TrickOrTreater.
     */
    @Override
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        this.gainCandy(2);
    }

    /**
     * Steals candy from TrickOrTreater described in the parameters.
     * Only steals candy from a TrickOrTreater that implements Robbable.
     * Increments robberiesConducted if robbery is successful.
     * @param o the TrickOrTreater to be robbed.
     */
    public void rob(TrickOrTreater o) {
        if (o instanceof Robbable) {
            int a = this.getNumCandy();
            this.gainCandy(((Robbable) o).beRobbed());
            if (a < this.getNumCandy()) {
                robberiesConducted++;
            }
        }
    }

    /**
     * Overrides TrickOrTreater.toString().
     * Returns all info from TrickOrTreater plus robberiesConducted, in same format.
     * @return string representation of this Ghost
     */
    @Override
    public String toString() {
        return super.toString() + String.format("/%d", robberiesConducted);
    }

    /**
     * Overrides TrickOrTreater.compareTo().
     * Compares this to another TrickOrTreater using parameters in TrickOrTreater
     * compareTo method, plus robberiesConducted.
     * @param other the other TrickOrTreater to compare to
     * @return int representing the natural order of Ghosts
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        int a = super.compareTo(other);
        if (other instanceof Ghost
            && a == 0) {
            a = Integer.compare(this.robberiesConducted,
                ((Ghost) other).robberiesConducted);
        }
        return a;
    }
}
