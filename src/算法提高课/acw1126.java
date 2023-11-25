package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw1126 {

    static int n, m;
    static int[][] g;
    static double[] d;
    static boolean[] st;

    private static void init() {
        g = new int[n + 10][n + 10];
        st = new boolean[n + 10];
        d = new double[n + 10];
        for (int i = 1; i <= n; i ++ ) Arrays.fill(g[i], 0x3f3f3f3f);
    }

    private static double dij(int a, int b) {
        Arrays.fill(d, 0x3f3f3f3f);

        d[b] = 100;
        for (int i = 1; i <= n; i ++ ) {
            int t = -1;
            for (int j = 1; j <= n; j ++ )
                if (!st[j] && (t == -1 || d[t] > d[j])) t = j;

            st[t] = true;
            for (int j = 1; j <= n; j ++ ) {
                if (g[t][j] == 0x3f3f3f3f || t == j) continue;
                d[j] = Math.min(d[j], d[t] / (1.0 - g[t][j] / 100.0));
            }

//            System.out.println("debug -> d[2] : " + d[1] + " i : " + i);
        }

        return d[a];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        init();

        for (int i = 1; i <= m; i ++ ) {
            int x = sc.nextInt(), y = sc.nextInt(), w = sc.nextInt();
            g[x][y] = g[y][x] = Math.min(g[x][y], w);
        }

        int a = sc.nextInt(), b = sc.nextInt();
        System.out.printf("%.8f\n", dij(a, b));

//        for (int i = 1; i <= n; i ++ ) {
//            System.out.println("debug -> i : " + i + " d : " + d[i]);
//        }
    }
}
