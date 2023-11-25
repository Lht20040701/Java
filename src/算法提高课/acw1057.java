package 算法提高课;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class acw1057 {
    public static void main(String[] args) throws IOException {
        Read sc = new Read(); // 输入超过十万, 不开快读会被卡

        int n = sc.nextInt(), k = sc.nextInt();
        int[] w = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) w[i] = sc.nextInt();
        int[][][] f = new int[n + 10][k + 10][2];

        /**
         * 本题状态机 :
         *         状态表示 : f[i][j][x]表示经过了i步, 进行了j次交易, 状态为x
         *         (1)表示持有股票为 : f[i][j][1] (0)表示没有股票为 : f[i][j][0]
         *                                   @4
         *                     |------------------------------|
         *                     |                              |
         *          |-------\| |                              \/ /------|
         *       @3 |         (1)                            (0)        | @1
         *          |------/  /\                              | |\------|
         *                    |                               |
         *                    |                               |
         *                    |-------------------------------|
         *                                  @2
         *
         *      注意 : 一次买入卖出为一笔交易
         *
         *
         *      状态转移 :
         *      @1 : f[i][j][0] = f[i - 1][j][0]             -> 我上一天没有股票, 还选择不交易 (不买入), 所以是由上一天交易了 j 次且 0 状态转移过来的
         *      @2 : f[i][j][1] = f[i - 1][j - 1][0] - w[i]  -> 我上一天没有股票, 我选择交易一次 (也就是买入股票开始这次交易), 所以是由上一天交易了 j - 1 次且 0 状态转移过来的
         *      @3 : f[i][j][1] = f[i - 1][j][1]             -> 我上一天有股票, 还选择了不交易 (不卖出), 所以是由上一天交易了 j 次且 1 状态转移过来的
         *      @4 : f[i][j][0] = f[i - 1][j][1] + w[i]      -> 我上一天有股票, 选择了交易 (也就是选择卖出股票结束这次交易), 所以是由上一天交易了 j 次且 1 状态转移过来的 (从第 j 次交易的买入转移过来)
         * */


        // 将所有非入口全都初始化为负无穷, 入口初始化为0
        for (int i = 0; i <= n; i ++ ) for (int j = 0; j <= k; j ++ ) Arrays.fill(f[i][j], -0x3f3f3f3f);
        for (int i = 0; i <= n; i ++ ) f[i][0][0] = 0;
        //

        for (int i = 1; i <= n; i ++ )
            for (int j = 1; j <= k; j++) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j][1] + w[i]);
                f[i][j][1] = Math.max(f[i - 1][j][1], f[i - 1][j - 1][0] - w[i]);
            }

        int ans = 0;
        for (int i = 0; i <= k; i ++ ) ans = Math.max(ans, f[n][i][0]);
        System.out.println(ans);
    }

    // 使用的时候注意抛出异常throws IOException
    static class Read {
        StringTokenizer st = new StringTokenizer("");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String next() throws IOException {
            while(!st.hasMoreTokens()){
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
// 重写别的快读的时候格式都差不多
    }

}
