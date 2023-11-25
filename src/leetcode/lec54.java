package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec54 {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    List<Integer> lis = new ArrayList<>();

    boolean[][] st = new boolean[110][110];
    public List<Integer> spiralOrder(int[][] matrix) {
        int fr = 0;
        int ed = matrix.length * matrix[0].length;

        int x = 0, y = 0;
        for (int i = 0; i < ed; i ++ ) {
            if (!st[x][y]) {
                lis.add(matrix[x][y]);
                st[x][y] = true;
            }

            int a = x + dx[fr], b = y + dy[fr];
            if (a < 0 || a >= matrix.length || b < 0 || b >= matrix[0].length || st[a][b]) {
                fr = (fr + 1) % 4;
                a = x + dx[fr];
                b = y + dy[fr];
            }

            x = a;
            y = b;
        }

        return lis;
    }
}
