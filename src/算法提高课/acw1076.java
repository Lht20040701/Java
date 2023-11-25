package 算法提高课;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw1076 {
    static int n;
    static int[][] maze;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static boolean[][] vis;
    static int[][][] pre;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        if (n == 0) return ;
        maze = new int[n][n];
        pre = new int[n][n][2];
        vis = new boolean[n][n];

        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < n; j ++ )
                maze[i][j] = sc.nextInt();

        bfs();
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n - 1, n - 1});
        vis[n - 1][n - 1] = true;

        out:while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            for (int i = 0; i < 4; i ++ ) {
                int a = x + dx[i], b = y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= n || vis[a][b] || maze[a][b] == 1) continue;
                q.add(new int[]{a, b});
                pre[a][b] = new int[]{x, y};
                vis[a][b] = true;
                if (a == 0 && b == 0) break out;
            }
        }

        int[] dep = {0, 0};
        do {
            System.out.println(dep[0] + " " + dep[1]);
            dep = pre[dep[0]][dep[1]];
        } while (dep[0] != n - 1 || dep[1] != n - 1);
        System.out.println(n - 1 + " " + (n - 1));
    }
}
