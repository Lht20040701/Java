package 算法提高课;

import java.util.Scanner;

public class acw275 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int[][] g = new int[m + 10][n + 10];

        for (int i = 1; i <= n; i ++ ) for (int j = 1; j <= m; j++) g[i][j] = sc.nextInt();

        int[][][] f = new int[n + m + 10][n + 10][n + 10];
        int ans = 0;

        for (int k = 2; k <= n + m; k ++ ) {
            for (int i1 = 1; i1 <= m; i1 ++ ) {
                for (int i2 = 1; i2 <= m; i2 ++ ) {
                    int j1 = k - i1, j2 = k - i2;
                    if (j1 > 0 && j1 <= n && j2 > 0 && j2 <= n) {
                        int t = g[i1][j1];
                        if (i1 != i2) t += g[i2][j2];

                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1 - 1][i2] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2 - 1] + t);
                        f[k][i1][i2] = Math.max(f[k][i1][i2], f[k - 1][i1][i2] + t);
                    }
                }
            }
        }

        System.out.println(f[n + m][m][m]);
    }
}
