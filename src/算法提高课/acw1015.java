package 算法提高课;

import java.util.Scanner;

public class acw1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            int r = sc.nextInt(), c = sc.nextInt();
            int[][] g = new int[r + 10][c + 10];

            for (int i = 1; i <= r; i ++ )
                for (int j = 1; j <= c; j++) {
                    g[i][j] = sc.nextInt();
                }

            int[][] f = new int[r + 10][c + 10];
            for (int i = 1; i <= r; i ++ )
                for (int j = 1; j <= c; j++) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + g[i][j];
                }

            System.out.println(f[r][c]);
        }
    }
}
