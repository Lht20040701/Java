package leetcode;

public class lec79 {
    String word;
    boolean[][] vis;
    char[][] board;
    int n, m;
    static int[] dx = new int[] {1, 0, -1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public boolean exist(char[][] _board, String _word) {
        word = _word; board = _board; n = board.length; m = board[0].length;
        vis = new boolean[n][m];

        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j ++ ) {
                // if (dfs(new StringBuilder(), i, j)) return true;
                if (board[i][j] == word.charAt(0) && dfs(new StringBuilder(), i, j)) return true;
            }
        return false;
    }

    public boolean dfs(StringBuilder s, int x, int y) {
        vis[x][y] = true;
        StringBuilder ss = new StringBuilder(s.toString());
        ss.append(board[x][y]);
        if (ss.toString().equals(word)) return true;

        boolean f = false;
        for (int i = 0; i < 4; i ++ ) {
            int depx = x + dx[i], depy = y + dy[i];
            if (depx < 0 || depx >= n || depy < 0 || depy >= m || vis[depx][depy] || board[depx][depy] != word.charAt(ss.toString().length())) continue;
            f = f || dfs(ss, depx, depy);
        }
        vis[x][y] = false;
        return f;
    }
}
