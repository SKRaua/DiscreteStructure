
public class Test {
    public static int findInverse(int a, int b) {

        int x = 1, y = 0, temp;
        // xa + yb = a
        int gcd = gcd(a, b);
        if (gcd != 1) {
            throw new RuntimeException("No Inverse.");
        }

        while (b != 0) {
            int quotient = a / b;

            // Update a and b
            temp = b;
            b = a % b;
            a = temp;

            // Update x and lastX
            // temp = y;
            // y = x - quotient * y;
            // x = temp;

            temp = x;
            x = y + quotient * x + 1;
            y = temp - 1;

            // Extended Euclidean algorithm:
            // ax + by = a
            // a1 x1 + b1 y2 = a1 * 1 + b1 * 0 = a1
            // a2 x2 + b2 y2 = a2
            //
            // a1 = b1 * quotient1 + remainder1
            //
            // b2 = remainder1 = a1 - b1 * quotient1
            // a2 = b1
            //
            // a1(x1 - 1) + b1 y1 = b1(x2 - 1) + (a1 - b1 * quotient1)y2
            // a1(x1 - 1) + b1 y1 = a1 y2 + b1(x2 - quotient1 y2 - 1)
            //
            // y2 = x1 -1
            // x2 = y1 + quotient1 y2 + 1 = y1 + quotient1 x1 + 1
        }

        return x;

    }

    public static void main(String[] args) {
        int a = 7; // The integer for which you want to find the inverse
        int b = 11; // The modulo value

        int inverse = findInverse(a, b);
        System.out.println("The modular inverse of " + a + " modulo " + b + " is: " + inverse);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
