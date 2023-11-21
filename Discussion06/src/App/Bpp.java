package App;

public class Bpp {
    public int CI(int n, int m) {
        return i(n) / (i(m) * i(n - m));
    }

    public int i(int num) {// 简单的循环计算的阶乘
        int sum = 1;
        for (int i = 1; i <= num; i++) {// 循环num

            sum *= i;// 每循环一次进行乘法运算

        }

        return sum;// 返回阶乘的值
    }

}
