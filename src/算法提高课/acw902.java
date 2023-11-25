package 算法提高课;

import java.util.Scanner;

public class acw902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String a = " " + sc.next();
        int m = sc.nextInt();
        String b = " " + sc.next();

        int[][] f = new int[n + 10][m + 10];

        for (int i = 0; i <= m; i ++ ) f[0][i] = i;
        for (int i = 0; i <= n; i ++ ) f[i][0] = i;

        for (int i = 1; i <= n; i ++ ) {
            for (int j = 1; j <= m; j ++ ) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (a.charAt(i) == b.charAt(j)) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                else f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
            }
        }

        System.out.println(f[n][m]);
    }
}
