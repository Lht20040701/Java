package 算法提高课;

import java.util.Scanner;

public class acw1023 {

    /**
     * 本题是dp求方案数的完全背包版本
     * 复习了完全背包问题 :
     *      状态表示 : f[i][j] -> 从前i个中选, 恰好等于j的选法
     *      状态初始 : f[i][0] = 1无论怎么选, 使加起来面值为0只有什么也不选这一种
     *      公式推导 : f[i][j]     = f[i - 1][j] + f[i][j - 1 * w] + f[i][j - 2 * w] + ... + f[i][j - k * w];
     *                f[i][j - w] =               f[i][j - 1 * w] + f[i][j - 2 * w] + ... + f[i][j - k * w];
     *                ==> f[i][j] = f[i - 1][j] + f[i][j - w] 可以看到可以优化为一维
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] w = {10, 20, 50, 100};
        int[] f = new int[n + 10];

        f[0] = 1;
        for (int i = 0; i < 4; i ++ )
            for (int j = w[i]; j <= n; j ++ )
                f[j] += f[j - w[i]];

        System.out.println(f[n]);
    }
}
