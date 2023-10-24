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

    public TrickOrTreater(String name, int age, int numCandy) {
        if (name == null) {
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

    public abstract void trickOrTreat();

    protected void gainCandy(int c) {
        if (c > 0) {
            this.numCandy += c;
        }
    }

    protected int loseCandy(int c) {
        if (c > 0) {
            this.numCandy -= c;
        }

        if (this.numCandy < 0) {
            c += this.numCandy;
            this.numCandy = 0;
        }
        return c;
    } 

    @Override
    public String toString() {
        return String.format("%s/%d/%d", this.name, this.age, this.numCandy);
    }

    @Override
    public int compareTo(TrickOrTreater other) {
        if (this.numCandy != other.numCandy) {
            return Integer.compare(this.numCandy, other.numCandy);
        } else {
            return Integer.compare(this.age, other.age);
        }
    }

    public int getNumCandy() {
        return numCandy;
    }
}