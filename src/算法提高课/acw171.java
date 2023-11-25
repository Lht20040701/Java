package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw171 {
    /**
     * 双向搜索 : 当我们单向搜索发现搜索树过大的时候, 我们可以从起点搜索只搜树高度的一半, 然后从答案的一边出发再搜索树的一半, 可以有效的剪掉许多枝
     * 为什么本题是双向搜索 : 首先我们用不了01背包的dp, 因为w太大了, 所以只能爆搜, 其次就是单向爆搜的话是2^46, 远远超时
     * 本题如何双向搜索 :
     *                  1. 其实本质是拿空间换时间, 我们将数据范围分为两半搜索, 第一半搜完我们把所有结果放入一个集合weights中
     *                  2. 第二半每搜索出一个结果s, 以后我们在第一次搜索的集合weights中通过二分找出一个最大的x使得, s + x <= w 成立 (可以看到是左边界
     *                  3. 然后我们在搜索的过程中再加入一些剪枝优化
     *
     *                  然后整体算下来时间复杂度大概是23 * 2^23 + 23 * 2^23 + 2^23 == 47 * 2^23 --> 3.76 * 10^8 这个 ... emmm, 能过
     * */
    static int[] weights;
    static int[] g;
    static int cnt = 0, n, w, k;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        w = sc.nextInt(); n = sc.nextInt();
        weights = new int[1 << ((n + 1) / 2)]; // 第一次搜索的结果大概是2^{(n + 1) / 2}个
        g = new int[n + 10];
        k = n / 2; // 将数据范围分开

        for (int i = 1; i <= n; i ++ ) g[i] = sc.nextInt();

        dfs1(1, 0); // 第一次搜索

        Arrays.sort(weights, 0, cnt);
        int t = 1; // 利用双指针给weights去重, 确实挺不错的
        for (int i = 1; i < cnt; i ++ )
            if (weights[i] != weights[i - 1])
                weights[t++] = weights[i];
        cnt = t;

        dfs2(k + 1, 0); // 第二次搜索

        System.out.println(ans);
    }

    public static void dfs1(int u, int sum) {
        if (u == k + 1) {
            weights[cnt ++ ] = sum; // 将第一搜索出的结果放入集合中
            return ;
        }

        dfs1(u + 1, sum);
        if ((long) sum + g[u] <= w) dfs1(u + 1, sum + g[u]); // 注意爆int
    }

    public static void dfs2(int u, int sum) {
        if (u == n + 1) { // 通过二分寻找让sum + x <= w 成立的最大x
            int l = 0, r = cnt - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (weights[mid] <= w - sum) l = mid;
                else r = mid - 1;
            }

            if (weights[l] <= w - sum)  ans = Math.max(ans, weights[l] + sum); // 尝试更新答案
            return ;
        }

        dfs2(u + 1, sum);
        if ((long) sum + g[u] <= w) dfs2(u + 1, sum + g[u]); // 注意爆int
    }
}
