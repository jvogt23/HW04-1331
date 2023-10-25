/**
 * @author jvogt33
 * @version 1.00
 */
public interface Robbable {
    /**
     * Defines a robbery conducted on the object implementing this interface.
     * A robbery removes an amount of candy from the object, and this method
     * should implement that functionality and return the amount lost.
     * @return int representing amount of candy lost
     */
    int beRobbed();
}
