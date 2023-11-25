package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw903 {
    static int m, n;
    static int[] dis, level;
    static boolean[] st;
    static int[][] g;

    /*
     * 思路 : 首先用到了虚拟源点, 加入了等级限制
     *       先不说等级限制的前提下讨论题目 => 单纯的虚拟源点问题了就是, 因为不知道从哪一个物品开始买是最好的, 所以我们让下标为0的点作为源点, 让其连上别的所有的节点, 边权就是直接购买该点的花费p
     *                                   接着问题就变成了简单的单源最短路问题
     *       在刚刚的基础上讨论等级限制 => 其实非常简单粗暴, 我们注意数据范围, N只有100, M >= 1, 所以我们最坏也只有100个区间, 朴素dij的时间复杂度是 O(n^2) 所以整体算下来时间复杂度是100 * 100 * 100 = 1e6
     *                                所以我们只需要把所有包含第1个物品 (酋长的承诺是物品1, 我们的目的就是买这个物品, 且酋长的等级不一定最高) 的等级区间 (如何求只符合等级区间的点集的最小花费, 见下面代码) 的最小花费都求出来, 然后取一个min就好了
     *
     *       (ps : dij不需要考虑自环的问题, 因为 d[t] <= d[t] + g[t][t] 是严格成立的)
     * */

    private static void init() {
        g = new int[n + 10][n + 10];
        level = new int[n + 10];
        dis = new int[n + 10];
        st = new boolean[n + 10];

        for (int i = 1; i <= n; i ++ ) Arrays.fill(g[i], 0x3f3f3f3f);
    }

    // down表示可交易区间的
    private static int dij(int down, int up) {
        Arrays.fill(dis, 0x3f3f3f3f);
        Arrays.fill(st, false);
        // 每次求解之前记得初始化
        dis[0] = 0; // 从源点开始搜

        // dij板子
        for (int i = 1; i <= n + 1; i ++ ) {
            int t = -1;
            for (int j = 0; j <= n; j ++ )
                if (!st[j] && (t == -1 || dis[t] > dis[j])) t = j;

            st[t] = true;
            for (int j = 0; j <= n; j ++ )
                if (level[j] >= down && level[j] <= up)
                    dis[j] = Math.min(dis[j], dis[t] + g[t][j]);
            // 注意上面, 只更新符合等级区间要求的点
        }

        return dis[1]; // 返回结果
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); n = sc.nextInt();
        init(); // 初始化
        // 我们把0认为是虚拟源点, g[0][i]代表直接购买i这个物品的边
        for (int i = 1; i <= n; i ++ ) {
            int p = sc.nextInt(), l = sc.nextInt(), x = sc.nextInt();
            g[0][i] = p; // 如上
            level[i] = l;
            // g[t][j]代表t这个物品作为替代优惠购买j这个物品的花费
            while (x -- > 0) {
                int t = sc.nextInt(), v = sc.nextInt();
                g[t][i] = Math.min(g[t][i], v); // 重边只存一个最小的
            }
        }

        int ans = 0x3f3f3f3f;
        for (int i = level[1] - m; i <= level[1]; i ++ ) ans = Math.min(ans, dij(i, i + m)); // 把所有包含level[1]的区间全搜一遍, 这样时间复杂度最多是100 * (100 * 100) = 1e6
        // 注意酋长的等级不一定是最高的
        System.out.println(ans);
    }
}
