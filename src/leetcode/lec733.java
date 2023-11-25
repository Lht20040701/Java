package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class lec733 {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] img = new boolean[100][100];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        img[sr][sc] = true;

        while (q.size() != 0) {
            int[] t = q.poll();

            for (int i = 0; i < 4; i ++ ) {
                int x = t[0] + dx[i];
                int y = t[1] + dy[i];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && !img[x][y] && image[x][y] == image[sr][sc]) {
                    img[x][y] = true;
                    image[x][y] = color;
                    q.add(new int[]{x, y});
                }
            }
        }
        image[sr][sc] =  color;
        System.out.println(Arrays.deepToString(image));
        return image;
    }
}
