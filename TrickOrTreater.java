/**
 * @author jvogt33
 * @version 1.00
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    //Name defaults to Charlie Brown
    protected String name;

    //Age defaults to 8, acceptable range is [0, 12]
    protected int age;

    //Must be non-negative
    protected int numCandy;

    /**
     * Constructor for new TrickOrTreater. Never directly called outside of subclass.
     * @param name the name of this TrickOrTreater
     * @param age the age of this TrickOrTreater
     * @param numCandy the number of candy pieces this TrickOrTreater has.
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        char[] n;
        boolean nameIsEmpty = true;
        if (name != null) {
            n = name.toCharArray();
            for (int i = 0; i < name.length(); i++) {
                if (n[i] != ' ') {
                    nameIsEmpty = false;
                }
            }
        }
        if (name == null || nameIsEmpty) {
            this.name = "Charlie Brown";
        } else {
            this.name = name;
        }

        if (age < 0 || age > 12) {
            this.age = 8;
        } else {
            this.age = age;
        }

        if (numCandy <= 0) {
            this.numCandy = 0;
        } else {
            this.numCandy = numCandy;
        }
    }

    /**
     * Abstract method for TrickOrTreater subclasses.
     * Implementation should involve printing out a phrase and incrementing numCandycheckstyle-8.28
     */
    public abstract void trickOrTreat();

    protected void gainCandy(int c) {
        if (c > 0) {
            this.numCandy += c;
        }
    }

    protected int loseCandy(int c) {
        if (this.numCandy >= c) {
            this.numCandy -= c;
        } else {
            c = this.numCandy;
            this.numCandy = 0;
        }
        return c;
    }

    /**
     * String representation of this TrickOrTreater.
     * @return a string containing name, age, numCandy separated by slashes.
     */
    @Override
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }

    /**
     * Overrides compareTo from the Comparable interface.
     * Compares number of candy, with age as a backup.
     * If this numCandy is greater than other numCandy,
     * or if they are equal and this age is greater than other age,
     * returns positive integer.
     * @param other object to compare to
     * @return int representing results of the comparison
     */
    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.getNumCandy() != other.getNumCandy()) {
            return Integer.compare(this.getNumCandy(), other.getNumCandy());
        } else {
            return Integer.compare(this.age, other.age);
        }
    }

    /**
     * Getter for numCandy.
     * @return amount of candy this TrickOrTreater has
     */
    public int getNumCandy() {
        return numCandy;
    }
}