package 算法提高课;

import java.util.Scanner;

public class acw1116 {
    static boolean[][] st;
    static int ans;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            n = sc.nextInt(); m = sc.nextInt();
            int x = sc.nextInt(), y = sc.nextInt();

            ans = 0;
            st = new boolean[n + 10][m + 10];
            dfs(x, y, 1);
            System.out.println(ans);
        }
    }

    static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static void dfs(int x, int y, int cnt) { // 当前位置[x, y], 已经走过cnt个格子了
        st[x][y] = true;
        if (cnt == n * m) {
            ans ++ ;
            return ;
        }

        for (int i = 0; i < 8; i ++ ) {
            int a = x + dx[i], b = y + dy[i];
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]) continue;
            dfs(a, b, cnt + 1);
            st[a][b] = false;
        }
    }
}
