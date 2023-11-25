package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] g = new int[n + 10][n + 10];
        int[][] f = new int[n + 10][n + 10];

        for (int i = 0; i <= n; i ++ ) {
            Arrays.fill(g[i], 0x3f3f3f3f);
            Arrays.fill(f[i], 0x3f3f3f3f);
        }

        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ )
                g[i][j] = sc.nextInt();

        f[1][1] = g[1][1];
        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ ) {
                if (i == 1 && j == 1) continue;
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + g[i][j];
            }

        System.out.println(f[n][n]);
    }
}
