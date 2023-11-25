package 算法提高课;

import java.util.Arrays;
import java.util.Scanner;

public class acw1020 {
    /**
     * 本题思路和之前的分析起来公式是差不多的 :
     *          只不过是状态表示有些不同, 导致初始化状态不同, 常见的三种表示 :
     *          f[i, j]表示从前i个物品中选, j代表当前体积, 具体含义看下面
     *          a. 体积最多是j -> f[0, 全部] = 0, 我们需要保证当前用的当前第二维的状态 v >= 0
     *          b. 体积恰好是j -> f[0, 0] = 0, f[0, 其他] = +INF (如果取最大值则是-INF, 不合法即可, 因为一个物品也不选, 还想让体积恰好是 `其他` 这不扯犊子吗), v >= 0
     *
     *          (本题)
     *          c. 体积至少是j -> f[0, 0] = 0, f[0, 其他] = +INF (如果取最大值则是-INF, 不合法即可, 因为一个物品也不选, 还想让体积至少是 `其他` 这不扯犊子吗)
     *              没有 v >= 0 的原因是体积至少是负数的情况是存在的, 且 v < 0 实际和 V == 0 是等价的, 因为我从前i个物品中选, 体积至少是负数的不就是我从前i个物品中选, 体积至少是0的情况吗 (前提是每一个物品的体积非负)
     *
     *
     *          本题分析 :
     *              状态表示f[i, j, k] -> 集合 : 所有从前i个物品中选, 且氧气含量至少是j, 氮气含量至少是k的所有选法
     *                               属性 : 重量最小值
     *
     *              状态计算 -> 不包含物品i的所有选法 : f[i - 1, j, k]
     *                         包含物品i的所有选法   : f[i - 1, Max(0, j - v1), Max(0, k - v2)]
     *                         从公式可以看出, 能用滚动数组优化
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(), n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[k + 10], b = new int[k + 10], c = new int[k + 10];
        for (int i = 1; i <= k; i ++ ) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }

        int[][] f = new int[m + 10][n + 10];
        for (int i = 0; i <= m; i ++ ) Arrays.fill(f[i], 0x3f3f3f3f);
        f[0][0] = 0;


        for (int i = 1; i <= k; i ++ )
            for (int j = m; j >= 0; j -- )
                for (int l = n; l >= 0; l -- )
                    f[j][l] = Math.min(f[j][l], f[Math.max(0, j - a[i])][Math.max(0, l - b[i])] + c[i]);

        System.out.println(f[m][n]);
    }
}
