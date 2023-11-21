package App;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!!");
        System.out.println(C(22, 5));

        // System.out.println(combination(18, 1));
        System.out.println(C(26, 4) + C(25, 4) + C(24, 4) + C(23, 4) + C(22, 4) + C(21, 4) + C(20, 4) + C(19, 4));
        System.out.println(C(20, 4) + C(19, 4) + C(18, 4) + C(17, 4) + C(16, 4) + C(15, 4) + C(14, 4) + C(13, 4));

    }

    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     * 
     * @param n
     * @return
     */
    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     * 
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }

    /**
     * 计算组合数，即C(n, m) = n!/((n-m)! * m!)
     * 
     * @param n
     * @param m
     * @return
     */
    public static long C(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }
}
