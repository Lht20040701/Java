package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lec994 {
    class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int[][] minute;
    int[][] grid;
    int n , m;

    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public int orangesRotting(int[][] _grid) {
        grid = _grid;
        n = grid.length;
        m = grid[0].length;
        minute = new int[n][m];
        for (int i = 0; i < minute.length; i ++ ) Arrays.fill(minute[i], 0x3f3f3f3f);

        ArrayList<PII> co = new ArrayList<>();

        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < m; j ++ ) {
                if (grid[i][j] == 0) continue;
                if (grid[i][j] == 2) {
//                    System.out.println(i + " " + j);
                    co.add(new PII(i, j));
                }
            }
        }

        int ans = 0;
//        System.out.println(co.size());
        for (int i = 0; i < co.size(); i ++ ) bfs(co.get(i).x, co.get(i).y);
//        System.out.println(Arrays.deepToString(grid));
        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j++) {
                if (minute[i][j] != 0x3f3f3f3f) ans = Math.max(ans, minute[i][j]);
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        return ans;
    }

    public void bfs(int x, int y) {
        boolean[][] vis = new boolean[n][m];
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(x, y));
        minute[x][y] = Math.min(minute[x][y], 0);
        vis[x][y] = true;

        while (!q.isEmpty()) {
            PII t = q.poll();
            for (int i = 0; i < 4; i ++ ) {
                int a = t.x + dx[i], b = t.y + dy[i];
                if (a < 0 || a >= n || b < 0 || b >= m || grid[a][b] == 0 || vis[a][b]) continue;
                grid[a][b] = 2;
                minute[a][b] = Math.min(minute[a][b], minute[t.x][t.y] + 1);
                q.add(new PII(a, b));
                vis[a][b] = true;
            }
        }
    }
}
