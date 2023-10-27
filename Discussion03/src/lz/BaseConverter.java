package lz;

import java.util.Scanner;

public class BaseConverter {

    /**
     * Converts a positive integer to the specified base.
     *
     * @param n    The positive integer to be converted
     * @param base The target base
     * @return The equivalent base expansion of n as a string
     */
    public static String convertBase(int n, int base) {
        if (base == 10) {// Base =10
            return Integer.toString(n);
        } else if (base == 16) {// Base =16
            int newN = n / base;
            int oneDigit = n % base;
            if (oneDigit > 9) {
                char charDigit = (char) (64 + oneDigit - 9);
                if (newN != 0) {
                    return convertBase(newN, base) + charDigit;
                } else {
                    return "" + charDigit;
                }
            } else {// oneDigit <= 9
                if (newN != 0) {
                    return convertBase(newN, base) + oneDigit;
                } else {
                    return "" + oneDigit;
                }
            }
        } else {// Base = 2,3,8
            int newN = n / base;
            int oneDigit = n % base;
            if (newN != 0) {
                return convertBase(newN, base) + oneDigit;
            } else {
                return "" + oneDigit;
            }
        }
    }

    public static String toExpression(String convertBase, int base) {
        String expression = new String();
        for (int i = 0; i < convertBase.length(); i++) {
            char digit = convertBase.charAt(convertBase.length() - 1 - i);
            if (Character.isLetter(digit)) {
                int hexDigit = digit + 9 - 64;
                if (i == 0) {
                    expression = hexDigit + "*" + base + "^" + i;
                } else {
                    expression = hexDigit + "*" + base + "^" + i + "+" + expression;
                }
            } else {
                if (i == 0) {
                    expression = digit + "*" + base + "^" + i;
                } else {
                    expression = digit + "*" + base + "^" + i + "+" + expression;
                }
            }
        }
        return expression;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = input.nextInt();

        // Test conversion to different bases
        int[] bases = { 2, 3, 8, 10, 16 };

        for (int base : bases) {
            String convertBase = convertBase(n, base);
            System.out.println("Base " + base + " expression of " + n + ": " +
                    convertBase + "= "
                    + toExpression(convertBase, base));
        }
        input.close();
    }
}
