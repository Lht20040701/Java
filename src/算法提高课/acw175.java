package 算法提高课;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class acw175 {
    /**
     * 双端队列bfs -> 01bfs : 如果把问题所构成的图抽象完以后只有边权为0和1的边, 并且属于最短路问题, 那么就可以通过双端队列来实现一个简化版dijsktra来求解
     * 本题抽象 : 不看边, 只看网格上的点, 两个点之间如果恰好有电缆相连, 则到达的权重是0, 否则就需要手动反转一下线缆, 所以到达的权重是1
     * 本题的注意点以及双端队列实现的过程 :
     *              1. 首先本题有一半的点是无法到达的, 因为假如我们从左上角是(0, 0)开始, 我们移动以后x, y必须同时变化, 所以我们能到达的点需要和起始点的奇偶性相同 (曼哈顿距离的奇偶性) , 所以导致本题可能有无解的情况, 也就是(r, c)和(0, 0)奇偶性不同
     *              2. 我们知道证明bfs正确需要有二段性和单调性来证明, 所以这里为了bfs的正确性, 我们把边权为0的点放到队头, 边权为1的点放到队尾
     *              3. 和普通的bfs不同, 先被拓展到的点不一定是最优的, 和堆优化的dijsiktra思想类似, 出队的点就是确定答案的点, 然后用这个确定答案的点更新别的点可能会让之前一些被拓展过的点得到更优的解
     *                  (所以导致, 有一些地方长得和dijsktra非常类似, 比如d < dist[a][b], 和st[x][y] continue;, 一个是尝试得到更优解, 一个是处理冗余)
     *                  (这里如果想不明白的话可以动手画个图, 一下子就懂了)
     *              4. 然后就是这道题本身非常抽象的地方了, 我们走的点, 需要通过两点之间的格子来判断边权是0还是1, 通过寻找一个点周围四个格子和该点的坐标关系来找出四个格子(ix, iy偏移数组, 思想和走点用的dx, dy类似)
     *                   最后看两点之间的这个格子的字符和对应方向cs数组是否相同, 相同就代表有电缆直接相连, 边权为0, 否则需要反转一下电缆, 边权为1
     *                   (注意, cs和dx, dy和ix, iy的方向都是对应的, 觉得我写的抽象的话可以看看代码, 应该就懂了)
     *              5. 注意最后正确处理返回值
     * */
    static int r, c;
    static char[][] g;
    static int[][] dist;
    static boolean[][] st;

    static class PII {
        int x, y;

        public PII(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            r = sc.nextInt(); c = sc.nextInt();
            g = new char[r + 10][c + 10];
            dist = new int[r + 10][c + 10];
            st = new boolean[r + 10][c + 10];
            for (int i = 0; i < r + 1; i ++ ) Arrays.fill(dist[i], 0x3f3f3f3f);

            for (int i = 0; i < r; i++) {
                String x = sc.next();
                for (int j = 0; j < c; j++)
                    g[i][j] = x.charAt(j);
            }

            if ((r + c & 1) == 1) {
                System.out.println("NO SOLUTION");
                continue;
            }
//            System.out.println("dist[r][c] -> " + dist[r][c]);
//            System.out.println("bfs -> " + bfs());
//            System.out.println("dist[r][c] -> " + dist[r][c]);
            System.out.println(bfs());
        }
    }

    static final int[] dx = {-1, -1, 1, 1};
    static final int[] dy = {-1, 1, 1, -1};
    //                        左上 右上 右下 左下
//                         \   /    \   /
    static final char[] cs = {'\\', '/', '\\', '/'};
    static final int[] ix = {-1, -1, 0, 0};
    static final int[] iy = {-1, 0, 0, -1};

    public static int bfs() {
        Deque<PII> de = new ArrayDeque<>();
        de.addLast(new PII(0, 0));
        dist[0][0] = 0;

        while (!de.isEmpty()) {
            PII t = de.pollFirst();
            int x = t.x, y = t.y;

            if (st[x][y]) continue;
            st[x][y] = true;
            if (st[r][c]) return dist[r][c];

            for (int i = 0; i < 4; i++) {
                int a = x + dx[i], b = y + dy[i];
                if (a < 0 || a > r || b < 0 || b > c) continue;

                int ca = x + ix[i], cb = y + iy[i];
                int w = g[ca][cb] == cs[i] ? 0 : 1;
                int d = dist[x][y] + w;

                if (d < dist[a][b]) {
                    dist[a][b] = d;
                    if (w == 0) de.addFirst(new PII(a, b));
                    else de.addLast(new PII(a, b));
                }
            }
        }

        return dist[r][c];
    }
}
