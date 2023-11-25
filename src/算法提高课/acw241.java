package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw241 {
    static Scanner sc = new Scanner(System.in);
    static final int N = 2000010;
    static int n; // 查询操作求的是1 -> n这个范围内的
    static int[] a = new int[N];
    static int[] t = new int[N];

    static int[] Lower = new int[N];
    static int[] Greater = new int[N];

    public static int lowbit(int x) {return x & (-x);}

    public static void add(int x, int k) {
        for (int i = x; i <= n;  i += lowbit(i)) t[i] += k;
    }

    public static int ask(int x) {
        int ret = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ret += t[i]; // 注意这里是i > 0, 0因为二进制没有1, 所以我们不用, 把他当作结束的标志
        return ret;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();

        for (int i = 1; i <= n; i ++ ) { // 从左往右记录一遍
            int y = a[i];
            Lower[i] = ask(y - 1);  // 记录左边比y小的有几个
            Greater[i] = ask(n) - ask(y); // 记录左比y大的有几个
            add(y, 1); // y出现过了
        }

        Arrays.fill(t, 0);

        long resA = 0, resV = 0;
        for (int i = n; i >= 1; i -- ) {
            int y = a[i];
            resA += (long) Lower[i] * ask(y - 1); // 记录右边比y小的有几个, 顺便计算答案
            resV += (long) Greater[i] * (ask(n) - ask(y)); // 记录右边比y大的有几个, 顺便计算答案
            add(y, 1); // y出现过了
        }
        System.out.println(resV + " " + resA);
    }
}
