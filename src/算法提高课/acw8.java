package 算法提高课;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

// 三维朴素版
public class acw8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), v = sc.nextInt(), m = sc.nextInt();
        int[] av = new int[n + 10], am = new int[n + 10], aw = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            av[i] = sc.nextInt();
            am[i] = sc.nextInt();
            aw[i] = sc.nextInt();
        }

        int[][][] f = new int[n + 10][v + 10][m + 10];

        for (int i = 1; i <= n; i ++ )
            for (int j = 0; j <= v; j ++ )
                for (int k = 0; k <= m; k ++ ) {
                    f[i][j][k] = f[i - 1][j][k];
                    if (j - av[i] >= 0 && k - am[i] >= 0) {
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - av[i]][k - am[i]] + aw[i]);
                    }
                }

        System.out.println(f[n][v][m]);
    }
}

// 二维优化版
class acw8Solution2 {
    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt(), v = sc.nextInt(), m = sc.nextInt();
        int[] av = new int[n + 10], am = new int[n + 10], aw = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            av[i] = sc.nextInt();
            am[i] = sc.nextInt();
            aw[i] = sc.nextInt();
        }

        int[][] f = new int[v + 10][m + 10];

        for (int i = 1; i <= n; i ++ )
            for (int j = v; j >= av[i]; j -- )
                for (int k = m; k >= am[i]; k -- )
                    f[j][k] = Math.max(f[j][k], f[j - av[i]][k - am[i]] + aw[i]);

        out.write(f[v][m] + "");
        out.close();
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
