package NumberTheory;

public class ModuloInverse {
    public static int[] extendedGCD(int a, int m) {
        int[] result = new int[3];
        if (m == 0) {
            result[0] = a; // GCD(a, 0) = a
            result[1] = 1; // x
            result[2] = 0; // y
        } else {
            // Recursively find the GCD, x, and y
            int[] temp = extendedGCD(m, a % m);
            result[0] = temp[0]; // GCD(a, m)
            result[1] = temp[2]; // x
            result[2] = temp[1] - (a / m) * temp[2]; // y
        }
        return result;
    }

    public static int modInverse(int a, int m) {
        int[] gcdExtended = extendedGCD(a, m);
        int gcd = gcdExtended[0];
        int x = gcdExtended[1];

        if (gcd == 1) {
            // Ensure x is positive
            x = (x % m + m) % m;
            return x;
        }

        return -1; // The modular inverse does not exist
    }

    public static void main(String[] args) {
        int a = 7; // 要求逆元的整数
        int m = 26; // 模数

        int inverse = modInverse(a, m);
        if (inverse != -1) {
            System.out.println("逆元: " + inverse);
        } else {
            System.out.println("模逆元不存在");
        }
    }
}
