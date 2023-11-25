package 算法提高课;

import java.util.Scanner;

// 三维朴素版

/**
 * 思路 :
 *      花费1 : 精灵球数量
 *      花费2 : 皮卡丘的体力值
 *      价值 : 小精灵的数量
 *
 *      状态表示 : f[i, j, k]表示所有只从前i个物品中选, 且花费1不超过j, 花费2不超过k的选法的最大价值
 *      状态计算 : f[i, j, k] = max(f[i - 1, j, k], f[i - 1, j - w[i], k - v[i]] + 1); (可以看出可以使用滚动数组优化掉一维)
 * */
public class acw1022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] w = new int[k + 10], v = new int[k + 10];

        for (int i = 1; i <= k; i ++ ) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        int[][][] f = new int[k + 10][n + 10][m + 10];

        for (int i = 1; i <= k; i ++ )
            for (int j = 0; j <= n; j ++ )
                for (int l = 0; l <= m - 1; l ++ ) {
                    f[i][j][l] = f[i - 1][j][l];
                    if (j - w[i] >= 0 && l - v[i] >= 0)
                        f[i][j][l] = Math.max(f[i][j][l], f[i - 1][j - w[i]][l - v[i]] + 1);
                }

        for (int i = 0; i <= m - 1; i ++ )
            if (f[k][n][i] == f[k][n][m - 1]) {
                System.out.println(f[k][n][i] + " " + (m - i));
                break;
            }
    }
}

// 二维优化版
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[][] f = new int[n + 10][m + 10];
        int[] w = new int[k + 10], v = new int[k + 10];

        for (int i = 1; i <= k; i ++ ) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int i = 1; i <= k; i ++ )
            for (int j = n; j >= w[i]; j -- )
                for (int l = m - 1; l >= v[i]; l -- )
                    f[j][l] = Math.max(f[j][l], f[j - w[i]][l - v[i]] + 1);

        for (int i = 0; i <= m - 1; i ++ )
            if (f[n][i] == f[n][m - 1]) {
                System.out.println(f[n][i] + " " + (m - i));
                break;
            }
    }
}
