import java.util.ArrayList;
import java.util.Arrays;

/**
 * The driver class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Driver {

    /**
     * The main method to test the SetOperations class.
     * 
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args) {
        ArrayList<Object> set = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        ArrayList<Object> A = new ArrayList<>(Arrays.asList("3", "2", "5", "7"));
        ArrayList<Object> B = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "6"));

        System.out.println("The total set: " + set);
        System.out.println("Set A: " + A);
        System.out.println("Set B: " + B);

        System.out.println("The complement set of A: " + SetOperations.complement(set, A));
        System.out.println("The union set of A and B: " + SetOperations.union(set, A, B));
        System.out.println("The intersection set of A and B: " + SetOperations.intersection(set, A, B));
        System.out.println("The difference set of A and B: " + SetOperations.difference(set, A, B));

    }
}