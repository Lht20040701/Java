package 算法提高课;

import java.util.Scanner;

public class acw1097 {
    static int n, m;
    static char[][] g;
    static final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static boolean[][] vis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        g = new char[n + 10][m + 10];
        vis = new boolean[n + 10][m + 10];

        for (int i = 0; i < n; i ++ ) {
            String s = sc.next();
            for (int j = 0; j < m; j ++ ) {
                g[i][j] = s.charAt(j);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j++) {
                if (g[i][j] == '.' || vis[i][j]) continue;
                dfs(i, j);
                ans++;
            }

        System.out.println(ans);
    }

    public static void dfs(int a, int b) {
        vis[a][b] = true;
        for (int i = 0; i < 8; i ++ ) {
            int x = a + dx[i], y = b + dy[i];
            if (x < 0 || x >= n || y < 0 || y >= m || g[x][y] == '.' || vis[x][y]) continue;
            dfs(x, y);
        }
    }
}
