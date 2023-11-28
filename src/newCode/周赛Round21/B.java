package newCode.周赛Round21;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static int n, m, k;
    static char[][] g;
    private static void draw(int x, int y, char c) {
        for (int i = x - 2; i <= x + 2; i ++ ) {
            if (i < 0 || i >= n) continue;
            g[i][y] = c;
        }

        for (int i = y - 2; i <= y + 2; i ++ ) {
            if (i < 0 || i >= m) continue;
            g[x][i] = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        g = new char[n + 10][m + 10];

        for (int i = 0; i < n; i ++ ) Arrays.fill(g[i], '.');

        while (k -- > 0) {
            int x = sc.nextInt(), y = sc.nextInt();
            String c = sc.next();
            x -- ; y -- ;

            draw(x, y, c.charAt(0));
        }

        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < m; j ++ )
                System.out.print(g[i][j]);
            System.out.println();
        }
    }
}
