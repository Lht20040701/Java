package 算法提高课;

import java.util.Scanner;

public class acw242 {
    static int n, m;
    static long[] tr;
    public static int lowbit(int x) {return (x) & (-x);}
    public static void modify(int x, int y) {
        for (int i = x; i <= n; i += lowbit(i) ) tr[i] += y;
    }
    public static long querry(int x) {
        long ret = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ret += tr[i];
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        int[] a = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        tr = new long[n + 10];
        modify(1, a[1]);
        for (int i = 2; i <= n; i ++ ) {
            int d = a[i] - a[i - 1];
            modify(i, d);
        }
        while (m -- > 0) {
            String op = sc.next();
            if ("C".equals(op)) {
                int l = sc.nextInt(), r = sc.nextInt(), d = sc.nextInt();
                modify(l, d); modify(r + 1, -d);
            } else {
                int x = sc.nextInt();
                System.out.println(querry(x));
            }
        }
    }
}
