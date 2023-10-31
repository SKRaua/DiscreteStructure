package FindInverse;

import java.util.Scanner;

/**
 * Get the inverse of a modulo b.
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class FindInverse {

    /**
     * Extended Euclidean algorithm
     * 
     * @param a A positive integers a
     * @param b A positive integers b
     * @return An array containing gcd values, coefficients x and y
     *         (xa + by = 1)
     */
    public static int[] extendedGCD(int a, int b) {
        int[] result = new int[3];
        if (b == 0) {
            result[0] = a; // GCD(a, 0) = a
            result[1] = 1; // x
            result[2] = 0; // y
        } else {
            // Recursively find the GCD, x, and y
            int[] temp = extendedGCD(b, a % b);
            result[0] = temp[0]; // GCD(a, m)
            result[1] = temp[2]; // x
            result[2] = temp[1] - (a / b) * temp[2]; // y

            // Inverse element existence.
            // a = qb+r, q: quotient, r: remainder.
            // a0 = b1, b0 = r1
            // xa + yb = gcd(a,b) = a0 = 1
            //
            // x0*a0 + y0*b0 = 1, a0 = q0*b0 + r0, a1 = q1*b1 + r1
            // x0*b1 + y0*r1 = 1
            // x0*b1 + y0(a1 - q1*b1) = 1
            // y0*a1 + (x0 -y0*q1)b1 = 1, x1*a1 + y1*b1 = 1
            // x1 = y0, y1 = x0 - y0*(a1/b1)
            // x2 = y1, y2 = x1 - y1*(a2/b2)
            // ......
            // xn = inverse of a modulo b
        }
        // result[1] is the inverse of a modulo b
        return result;
    }

    /**
     * The main method to test the method.
     * 
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a and b");
        System.out.print("a: ");
        int a = input.nextInt();
        System.out.print("b: ");
        int b = input.nextInt();

        // Extended Euclidean algorithm
        int[] gcdExtended = extendedGCD(a, b);

        // Is gcd 1.
        if (gcdExtended[0] == 1) {
            // Inverse of a modulo b
            System.out.println("inverse: " + gcdExtended[1]);
        } else {
            System.out.println("No inverse.");
        }
        input.close();
    }
}