package App;

import java.math.BigInteger;

public class New {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!!");
        System.out.println(C(22, 1));

        System.out.println(C(22, 5));
        System.out.println(C(13, 5));

        System.out.println(C(33, 4) + C(32, 4) + C(31, 4) + C(30, 4) + C(29, 4) + C(28, 4));
        System.out.println(C(24, 4) + C(23, 4) + C(22, 4) + C(21, 4) + C(20, 4) + C(19, 4) + C(18, 4) + C(17, 4));

    }

    /**
     * Calculate the factorial of a number, n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    private static BigInteger factorial(int n) {
        if (n <= 1) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Calculate the combination (C) of two numbers, C(n, m) = n! / (m! * (n - m)!)
     *
     * @param n
     * @param m
     * @return
     */
    public static int C(int n, int m) {
        if (n < m) {
            return 0;
        }
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(m).multiply(factorial(n - m));
        return numerator.divide(denominator).intValue();
    }
}
