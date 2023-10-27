import java.util.ArrayList;

/**
 * The SetOperations class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class SetOperations {

    /**
     * The method to convert a set to a bit string
     * 
     * @param set The total set
     * @param A   A set
     * @return The bit string of set A
     */
    public static boolean[] toBitString(ArrayList<Object> set, ArrayList<Object> A) {
        boolean[] bitStringA = new boolean[set.size()];// set A represented as a bit string

        // Assuming that all elements A have no.
        for (int i = 0; i < set.size(); i++) {
            bitStringA[i] = false;
        }

        // Some elements in set A are also in the total set.
        for (int i = 0; i < set.size(); i++) {
            for (int j = 0; j < A.size(); j++) {
                if (set.get(i).equals(A.get(j))) {
                    bitStringA[i] = true;// This bit is true
                }
            }
        }

        return bitStringA;
    }

    /**
     * The method to convert a bit string to a set
     * 
     * @param set        The total set
     * @param bitStringA The bit string of set A
     * @return A set
     */
    public static ArrayList<Object> toSet(ArrayList<Object> set, boolean[] bitStringA) {
        ArrayList<Object> A = new ArrayList<Object>();// a set

        // If the Boolean value is true, the corresponding element is added to set A.
        for (int i = 0; i < set.size(); i++) {
            if (bitStringA[i] == true) {
                A.add(set.get(i));
            }
        }

        return A;
    }

    /**
     * The method to make complement
     * 
     * @param set The total set
     * @param A   A set
     * @return return the complement of the set
     */
    public static ArrayList<Object> complement(ArrayList<Object> set, ArrayList<Object> A) {
        boolean[] bitStringA = toBitString(set, A);// set A represented as a bit string
        boolean[] complementSet = new boolean[set.size()];// new set

        // Invert all elements
        for (int i = 0; i < set.size(); i++) {
            complementSet[i] = !bitStringA[i];
        }

        // Convert it to a set then return it.
        return toSet(set, complementSet);
    }

    /**
     * The method to make union
     * 
     * @param set The total set
     * @param A   A set
     * @param B   A set
     * @return return the union of the sets
     */
    public static ArrayList<Object> union(ArrayList<Object> set, ArrayList<Object> A, ArrayList<Object> B) {
        boolean[] bitStringA = toBitString(set, A);// set A represented as a bit string
        boolean[] bitStringB = toBitString(set, B);// set B represented as a bit string
        boolean[] unionSet = new boolean[set.size()];// new set

        // Take or operation one by one
        for (int i = 0; i < set.size(); i++) {
            unionSet[i] = bitStringA[i] || bitStringB[i];
        }

        // Convert it to a set then return it.
        return toSet(set, unionSet);
    }

    /**
     * The method to make intersection
     * 
     * @param set        The total set
     * @param bitStringA A set
     * @param bitStringB A set
     * @return return the intersection of the sets
     */
    public static ArrayList<Object> intersection(ArrayList<Object> set, ArrayList<Object> A, ArrayList<Object> B) {
        boolean[] bitStringA = toBitString(set, A);// set A represented as a bit string
        boolean[] bitStringB = toBitString(set, B);// set B represented as a bit string
        boolean[] intersectionSet = new boolean[set.size()];// new set

        // Take and operate one by one
        for (int i = 0; i < set.size(); i++) {
            intersectionSet[i] = bitStringA[i] && bitStringB[i];
        }

        // Convert it to a set then return it.
        return toSet(set, intersectionSet);
    }

    /**
     * The method to make difference
     * 
     * @param set        The total set
     * @param bitStringA A set
     * @param bitStringB A set
     * @return return the difference of the sets
     */
    public static ArrayList<Object> difference(ArrayList<Object> set, ArrayList<Object> A, ArrayList<Object> B) {
        boolean[] bitStringA = toBitString(set, A);// set A represented as a bit string
        boolean[] bitStringB = toBitString(set, B);// set B represented as a bit string
        boolean[] differenceSet = new boolean[set.size()];// new set

        // Take AND operate with Elements of A and The inverse of elements in B
        for (int i = 0; i < set.size(); i++) {
            differenceSet[i] = bitStringA[i] && !bitStringB[i];
        }

        // Convert it to a set then return it.
        return toSet(set, differenceSet);
    }

}
