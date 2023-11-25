package 算法提高课;

import java.util.Scanner;

public class acw1264 {
    static int n, m;
    static int[] tr; // 树状数组
    public static int lowbit(int x) {return (x & (-x));}
    public static void modify(int x, int y) {
        for (int i = x; i <= n; i += lowbit(i) ) tr[i] += y;
    }

    public static int querry(int x) {
        int ret = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ret += tr[i];
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        tr = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt();
            modify(i, x);
        }

        while (m -- > 0) {
            int k = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
            if (k == 0) System.out.println(querry(b) - querry(a - 1));
            else modify(a, b);
        }
    }
}
