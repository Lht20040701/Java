package 算法提高课;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class acw1098 {
    /**
     * 思路 :
     *       其实本质和普通的搜索是没什么区别的, 主要是看懂题是如何进行抽象的, 别看到题就被吓住了 (看懂题非常重要
     *       一个房间如坐标为[1, 1]的房间周围的墙表示为1, 2, 4, 8的和x, 其实对这四个数应该敏感一点, 二进制嘛
     *       所以我们可以让四个方向, 左上右下 -> x二进制的第一位是否是1, 第二位是否为1, 往后类推
     *       然后就变成了普通的搜索, 有墙不走, 没墙走
     * */
    static int m, n;
    static int[][] g;
    static int marea;
    static boolean[][] st;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); n = sc.nextInt();
        g = new int[m + 10][n + 10];
        st = new boolean[m + 10][n + 10];

        for (int i = 1; i <= m; i ++ ) for (int j = 1; j <= n; j++) g[i][j] = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i <= m; i ++ ) {
            for (int j = 1; j <= n; j ++ ) {
                if (st[i][j]) continue;
                cnt ++ ;
                marea = Math.max(marea, bfs(i, j));
            }
        }

        System.out.println(cnt);
        System.out.println(marea);
    }

    static class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int xx, int yy) {
        int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(xx, yy));
        st[xx][yy] = true;

        int area = 0;
        while (!q.isEmpty()) {
            PII t = q.poll();
            area ++ ;
            for (int i = 0; i < 4; i ++ ) {
                int x = t.x + dx[i], y = t.y + dy[i];
                if (x <= 0 || y <= 0 || x > m || y > n) continue;
                if (st[x][y]) continue;
                if ((g[t.x][t.y] >> i & 1) == 1) continue; // 进制枚举这个方向有没有墙, 是否可以走
                q.add(new PII(x, y));
                st[x][y] = true;
            }
        }

        return area;
    }
}
