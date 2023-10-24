public class Witch extends TrickOrTreater implements Robbable{
    private String signatureCackle;

    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        if (signatureCackle == null || signatureCackle.trim() == "") {
            this.signatureCackle = "Bwahaha";
        } else {
            this.signatureCackle = signatureCackle;
        }
    }

    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    @Override
    public void trickOrTreat() {
        System.out.println(String.format("%s! I'll get you my pretty!", signatureCackle));
        this.gainCandy(3);
    }

    @Override
    public int beRobbed() {
        int c = this.loseCandy(6);
        return c;
    }

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
