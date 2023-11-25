package 算法提高课;

import java.util.Scanner;

public class acw11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), v = sc.nextInt();
        final int Mod = 1_000_000_007;

        int[] aw = new int[n + 10];
        int[] av = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) {
            av[i] = sc.nextInt();
            aw[i] = sc.nextInt();
        }

        int[][] f = new int[n + 10][v + 10]; // f[i, j] : 从前i个物品中选提及不超过j的选法中价值最大的
        int[][] g = new int[n + 10][v + 10]; // g[i, j] : 从前i个物品中选体积不超过j的选法中, 价值恰好为f[i, j]的选法方案数

        // 状态初始值
        // for (int i = 0; i <= n; i ++ ) f[i][0] = 0; 这里因为数组自动初始化为0不用管
        // for (int i = 1; i <= v; i ++ ) f[0][i] = 0; 这里因为数组自动初始化为0不用管
        for (int i = 0; i <= v; i ++ ) g[0][i] = 1; // 一个物品也不选, 体积不超过i的选法中, 价值恰好为f[0, i] == 0的方案是什么也不选这一种
        //

        /**
         * 思路 :
         *      和之前一道题不同的是, 这一题是求f[i][j]最优方案的方案数, 之前acw278是求体积装满 (恰好) 背包的方案数, 可以仔细看看区别
         *
         *      我们只需要开一个g[i, j]数组 : 从前i个物品中选体积不超过j的选法中, 价值恰好为f[i, j]的选法方案数
         *      然后算f[i][j]状态的时候顺便把g[i][j]也给求出来
         *
         *
         * 具体求法 :
         *      f[i][j]和01背包一样, 我们不再说了
         *
         *      看g[i][j] :
         *      1. 如果f[i - 1][j]大, g[i][j] = g[i - 1][j] -> 对应不选物品i的情况, 只有 f[i - 1][j] 才能走到 f[i][j]
         *      2. 如果f[i - 1][j - av[i]] + aw[i] 大, g[i][j] = g[i - 1][j - av[i]] -> 对应选物品i的情况, 只有 f[i - 1][j - av[i]] + aw[i] 才能走到 f[i][j]
         *      3. 如果f[i - 1][j - av[i]] + aw[i] == f[i - 1][j], g[i][j] = g[i - 1][j] + g[i - 1][j - av[i]] -> 两条路同时都是我们的方案数, 选不选i都可以走到f[i][j], 所以全加上
         * */

        for (int i = 1; i <= n; i ++ ) {
            g[i][0] = 1; // 从前i个物品中选, 且体积不超过0的选法中, 价值恰好为f[i, 0] == 0的方案是什么也不选这一种
            for (int j = 1; j <= v; j ++ ) { // 因为下面是累加, 所以防止污染g[i][0] (更保险), 所以这里从1开始循环
                int x = f[i - 1][j];
                int y = j - av[i] >= 0 ? f[i - 1][j - av[i]] + aw[i] : -0x3f3f3f3f; // 三目运算符, 看y是否合法

                if (x > y) {
                    g[i][j] = g[i - 1][j] % Mod;
                    f[i][j] = x;
                }
                else if (x < y) {
                    g[i][j] = g[i - 1][j - av[i]] % Mod;
                    f[i][j] = y;
                }
                else {
                    g[i][j] = (g[i - 1][j] % Mod + g[i - 1][j - av[i]] % Mod) % Mod;
                    f[i][j] = x;
                }
                g[i][j] %= Mod;
            }
        }

        System.out.println(g[n][v] % Mod);
    }
}

class acw11Solution2 {
    public static void main(String[] args) {

    }
}
