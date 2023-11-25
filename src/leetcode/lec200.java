package leetcode;

public class lec200 {
    boolean[][] island;
    char[][] grid;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    int n, m;
    int ans = 0;

    public void dfs(int x, int y) {
        island[x][y] = true;
        for (int i = 0; i < 4; i ++ ) {
            int depx = x + dx[i], depy = y + dy[i];
            if (depx < 0 || depx >= n || depy < 0 || depy >= m || island[depx][depy] || grid[depx][depy] == '0') continue;
            island[depx][depy] = true;
            dfs(depx, depy);
        }
    }

    public int numIslands(char[][] _grid) {
        grid = _grid;
        n = grid.length;
        m = grid[0].length;
        island = new boolean[n][m];
        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < m; j ++ ) {
                if (island[i][j] || grid[i][j] == '0') continue;
                ans ++ ;
                dfs(i, j);
            }
        }
        return ans;
    }
}
