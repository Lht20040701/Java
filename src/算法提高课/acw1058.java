 package 算法提高课;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class acw1058 {
    public static void main(String[] args) throws IOException {
        Read sc = new Read();

        int n = sc.nextInt();
        int[] w = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) w[i] = sc.nextInt();
        int[][] f = new int[n + 10][3];

        /**
         * 本题自动机 :
         *      状态表示 : f[i][x]走了i步到了x状态的最大利润
         *      (2) : f[i][2]是第i天处于有货状态 (1) : f[i][1]是第i天处于冷冻状态  (0) : f[i][0]是第i天处于没货状态
         *                                                  没货第一天                       没货第二天
         *
         *        @1                            @4
         *      |----|                        |----|
         *      |    |                        |    |
         *      \   \/    @2           @3     \/  /
         *       (2) ----------> (1) --------> (0)
         *         /\                           |
         *         |                            |
         *         |----------------------------|
         *                       @5
         *
         *    状态转移 :
         *      @1 : f[i][2] = f[i - 1][2]          -> 第i天的有货状态从第i - 1天的有货状态 不交易 转移而来
         *      @2 : f[i][1] = f[i - 1][2] + w[i]   -> 第i天的冷冻状态从第i - 1天的冷冻状态 交易 (卖出) 转移而来
         *      @3 : f[i][0] = f[i - 1][1]          -> 第i天的没货状态从第i - 1天的冷冻状态 无法交易 转移而来
         *      @4 : f[i][0] = f[i - 1][0]          -> 第i天的没货状态从第i - 1天的没货状态 不交易 转移而来
         *      @5 : f[i][2] = f[i - 1][0] - w[i]   -> 第i天的有货状态从第i - 1天的没货状态 交易 (买入) 转换而来
         * */

        // 状态机入口初始化
        f[0][0] = 0; f[0][1] = f[0][2] = -0x3f3f3f3f;
        //

        for (int i = 1; i <= n; i ++ ) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][2] + w[i];
            f[i][2] = Math.max(f[i - 1][0] - w[i], f[i - 1][2]);
        }

        System.out.println(Math.max(f[n][1], f[n][0]));

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
