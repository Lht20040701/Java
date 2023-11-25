package leetcode;

public class lec64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < m; j ++ ) {
                if (i - 1 < 0 && j - 1 < 0) f[0][0] = grid[i][j];
                else if (i - 1 < 0) f[i][j] = f[i][j - 1] + grid[i][j];
                else if (j - 1 < 0) f[i][j] = f[i - 1][j] + grid[i][j];
                else f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[n - 1][m - 1];
    }
}
