package BaseConverter;

import java.util.Scanner;

/**
 * The BaseConverter class
 * 
 * @author Xinyang Zhou
 * @version 2.0
 */
public class BaseConverter {

    /**
     * Converts the decimal number n to another base number and returns its string.
     * 
     * @param n    The decimal number
     * @param base The other base
     * @return The string that specifies the number of base
     */
    public static String convertBase(int n, int base) {
        if (base == 10) {
            // Directly return a string.
            return Integer.toString(n);
        } else {
            String result = new String();
            while (n > 0) {
                // The remainders determines each digit of the new number.
                int remainder = n % base;
                // If the remainder is greater than 9, use A to F to represent 10 to 15
                // (using ASCII)
                char digit = (remainder > 9) ? (char) ('A' + remainder - 10) : (char) ('0' + remainder);
                // Add one digit to the result.
                result = digit + result;
                n /= base;
            }
            return result;
        }
    }

    /**
     * Expands the numbers in each bases into a expression.
     * 
     * @param nBase The number n in various bases
     * @param base  The other base
     * @return The expression of the number
     */
    public static String toExpression(String nBase, int base) {
        String expression = new String();
        for (int i = 0; i < nBase.length(); i++) {
            char digit = nBase.charAt(nBase.length() - 1 - i);
            // If the digit is a letter, use 10 to 15 to represent A to F.
            int value = Character.isDigit(digit) ? (digit - '0') : (digit - 'A' + 10);
            // Construct this expression.
            if (i == 0) {
                expression = value + "*" + base + "^" + i;
            } else {
                expression = value + "*" + base + "^" + i + "+" + expression;
            }
        }
        return expression;
    }

    /**
     * The main to test the methods
     * 
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        // Input the number.
        int n = input.nextInt();
        // Tests each bases.
        int[] bases = { 2, 3, 8, 10, 16 };
        // Calls methods and outputs results
        for (int base : bases) {
            String convertBase = convertBase(n, base);
            String expression = toExpression(convertBase, base);
            System.out.println("Base " + base + " expression of " + n + ": " + convertBase + " = " + expression);
        }
        input.close();
    }
}