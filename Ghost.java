/**
 * @author jvogt33
 * @version 1.00
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted;

    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
        this.robberiesConducted = 0;
    }

    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        this.gainCandy(2);
    }

    public void rob(TrickOrTreater o) {
        if (o instanceof Robbable) {
            this.gainCandy(((Robbable) o).beRobbed());
            robberiesConducted++;
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format("/%d", robberiesConducted);
    }

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
