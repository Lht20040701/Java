package 算法提高课;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw1106 {

    /**
     * 理解起来非常简单, 但是有问题需要注意 :
     *          1. 本题不是四个方向, 斜着也是可以的, 具体看案例2, 所以我们可以直接把该位置周围的8个格子全都枚举一遍进行判断
     *          2. 然后就是边界判断 -> 我们可以逆向思考, 只有当 "周围的格子" 的高度不等于该位置的高度的时候, 那不等于该位置高度的这个所谓的 "周围的格子" 就是边界的一部分
     *          3. 注意, 是存在既不是山峰也不是山谷的, 也就是山中, 所以我们算出has_lower和has_higher以后, 要看是否只符合其中一个, 或者谁都不符合 (第三种情况, 整个地图既是山峰也是山谷)
     *
     *          具体写法看下面代码部分
     * */
    static int n;
    static int[][] g;
    static boolean[][] vis;
    static int valley = 0, peak = 0;
    static boolean has_higher = false, has_lower = false; // Java没有引用, 包装类好像也不行, 所以就用全局变量
    static class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        g = new int[n + 10][n + 10];
        vis = new boolean[n + 10][n + 10];

        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ )
                g[i][j] = sc.nextInt();

        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= n; j ++ ) {
                if (vis[i][j]) continue;
                has_higher = false; has_lower = false; //每次都重置一下
                bfs(i, j);
                if (!has_higher) peak ++ ; // 没高的, 是山峰
                if (!has_lower) valley ++ ; // 没低的, 是山谷
            }

        System.out.println(peak + " " + valley);
    }

    public static void bfs(int xx, int yy) {
        Queue<PII> q = new LinkedList<>();
        q.add(new PII(xx, yy));

        while (!q.isEmpty()) {
            PII t = q.poll();

            for (int i = t.x - 1; i <= t.x + 1; i ++ )
                for (int j = t.y - 1; j <= t.y + 1; j ++ ) {
                    if (i == t.x && j == t.y) continue; // 遍历周围8个格子
                    if (i <= 0 || i > n || j <= 0 || j > n) continue;
                    if (g[i][j] != g[xx][yy]) { // 边界判断 -> 高度和g[xx][yy]不相同的就是边界
                        if (g[i][j] < g[xx][yy]) has_lower = true;
                        if (g[i][j] > g[xx][yy]) has_higher = true;
                    } else if (!vis[i][j]) { // 没有遍历过且高度等于我
                        vis[i][j] = true;
                        q.add(new PII(i, j));
                    }
                }
        }
    }
}
