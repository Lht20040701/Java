package 算法提高课;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw188 {
    static char[][] g;
    static int[][] d;
    static int c, r;
    static int sx, sy, ex, ey;
    static final int[] dx = {-2, -2, -1, -1, 1 ,1, 2, 2};
    static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        c = sc.nextInt(); r = sc.nextInt();
        g = new char[r + 10][c + 10];
        d = new int[r + 10][c + 10];

        for (int i = 1; i <= r; i ++ ) Arrays.fill(d[i], -1);

        for (int i = 1; i <= r; i ++ ) {
            String s = " " + sc.next();
            for (int j = 1; j <= c; j ++ ) {
                char x = s.charAt(j);
                g[i][j] = x;
                if (x == 'K') {
                    sx = i;
                    sy = j;
                } else if (x == 'H') {
                    ex = i;
                    ey = j;
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});
        d[sx][sy] = 0;

        out:while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];

            for (int i = 0; i < 8; i ++ ) {
                int a = x + dx[i], b = y + dy[i];
                if (a <= 0 || a > r || b <= 0 || b > c || g[a][b] == '*' || d[a][b] != -1) continue;
                q.add(new int[]{a, b});
                d[a][b] = d[x][y] + 1;
                if (a == ex && b == ey) break out;
            }
        }

        return d[ex][ey];
    }
}
