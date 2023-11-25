package 算法提高课;

import java.io.*;
import java.util.*;

public class acw173 {
    /**
     * 多源bfs : 和之前见过的超级源点类似, 只不过那个是把所有的起始点连到一个距离为0的虚拟源点上, 而这个是把所有的起始点全都放到刚开始的队列中, 并且置vis[i][j] = 0;
     * 然后就是吐槽一下 : Acwing什么时候可以优化Java同学的体验 ... , Java同学不加快读快写疯狂TLE
     * */
    static int n;
    static int m;
    static char[][] g = new char[1010][1010];
    static int[][] vis = new int[1010][1010];
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static public class PII {
        int x, y;
        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        Read sc = new Read(); // 快读
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); // 快写
        n = sc.nextInt(); m = sc.nextInt();

        for (int i = 0; i < n; i ++ ) {
            char[] s = sc.next().toCharArray();
            for (int j = 0; j < m; j ++ )
                g[i][j] = s[j];
        }

        bfs();
        for (int i = 0; i < n; i ++ ) {
            for (int j = 0; j < m; j ++ )
                out.write(vis[i][j] + " ");
            out.write("\n");
        }
        out.close(); // 一定要关闭以后才会把答案刷出来
    }

    public static void bfs() {
        Queue<PII> q = new LinkedList<>();
        for (int i = 0; i < n; i ++ ) Arrays.fill(vis[i], -1);

        for (int i = 0; i < n; i ++ )
            for (int j = 0; j < m; j ++ )
                if (g[i][j] == '1') {
                    q.add(new PII(i, j));
                    vis[i][j] = 0;
                }

        while (!q.isEmpty()) {
            PII t = q.poll();
            int x = t.x, y = t.y;
            for (int i = 0; i < 4; i ++ ) {
                int a = x + dx[i], b = y + dy[i];
                if (a < 0 || b < 0 || a >= n || b >= m) continue;
                if (vis[a][b] != -1) continue;
                vis[a][b] = vis[x][y] + 1;
                q.add(new PII(a, b));
            }
        }
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
