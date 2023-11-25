package 算法提高课;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class acw1252 {
    static int n, m, w;
    static int[] p;
    static int[] c, d;
    static List<Integer> lis = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); w = sc.nextInt();
        p = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) {p[i] = i; lis.add(i);} // init

        c = new int[n + 10]; d = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }

        for (int i = 1; i <= m; i ++ ) {
            int u = sc.nextInt(), v = sc.nextInt();
            int pu = find(u), pv = find(v);
            if (pu != pv) {
                p[pu] = pv;
                c[pv] += c[pu];
                d[pv] += d[pu];
                lis.remove((Integer) pu);
            }
        }

        int[] f = new int[w + 10];

        f[0] = 0;
        int t = lis.size();

        for (int i = 0; i < t; i ++ ) {
            int vv = c[lis.get(i)];
            int ww = d[lis.get(i)];
            for (int j = w; j >= vv; j -- ) {
                f[j] = Math.max(f[j], f[j - vv] + ww);
            }
        }

        System.out.println(f[w]);
    }

    private static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
}
