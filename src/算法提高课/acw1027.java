package 算法提高课;

import java.util.Scanner;

public class acw1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] w = new int[n + 10][n + 10];
        int[][][] f = new int[2 * n + 10][n + 10][n + 10];

        while (true) {
            int x = sc.nextInt(), y = sc.nextInt(), c = sc.nextInt();
            if (x == 0 && y == 0 && c == 0) break;
            w[x][y] = c;
        }

        for (int k = 2; k <= n + n; k++)
            for (int i1 = 1; i1 <= n; i1 ++ )
                for (int i2 = 1; i2 <= n; i2 ++) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 >= 1 && j1 <= n && j2 >= 1 && j2 <= n) {
                        int t = w[i1][j1];
                        if (i1 != i2) t += w[i2][j2];

                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);
                    }
                }

        System.out.println(f[n + n][n][n]);
    }
}
