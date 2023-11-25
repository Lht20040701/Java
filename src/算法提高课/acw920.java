package 算法提高课;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class acw920 {

    /**
     * 本题的建图方式 :
     *        我们对于每一个巴士路线进行观察, 发现从前面的站走向这一条巴士路线后面的站是不用换站的, 所以我们就认为前面的站到后面的站之间是有边的, 设边权为1
     *         => 注意这里设边权为1的含义, 比如 : 从a -> b 边权是1, 意味着我从a到b经过了一条巴士路线
     *        将所有的巴士路线都处理好以后, 图中就只有边权为1的路线, 此时我们可以使用bfs来解这道题
     *        注意最终d[i]代表我从1 -> i路上总共经历了几条巴士路线, 但开头的一条路线不是换乘上来的, 所以答案是d[i] - 1
     *
     *        这里文字描述的可能并没有那么直观, 不明白建图的话可以再看一遍视频回忆一下
     * */
    static int m, n;
    static boolean[][] g;
    static int[] d;
    static int[] stop;

    private static void init() {
        g = new boolean[n + 10][n + 10]; stop = new int[n + 10]; d = new int[n + 10];
        Arrays.fill(d, -1);
    }

    private static void bfs() { // 初始化
        Queue<Integer> q = new LinkedList<>();
        d[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i = 1; i <= n; i ++ )
                if (g[t][i] && d[i] == -1) { // bfs板子, 如果一个点可以走并且没被走过, 那就更新他 (入队时答案最优
                    d[i] = d[t] + 1;
                    q.add(i);
                }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt(); n = sc.nextInt();
        init();

        sc.nextLine(); // 吸收掉换行符
        // 下面的输入问题非常蛋疼, 我们需要手动再开一个从str读入的Scanner
        for (int i = 1; i <= m; i ++ ) {
            int idx = 0;
            String str = sc.nextLine();
            Scanner sin = new Scanner(str);
            while (sin.hasNext()) stop[idx ++ ] = sin.nextInt();
            for (int j = 0; j < idx; j ++ )
                for (int k = j + 1; k < idx ; k ++ )
                    g[stop[j]][stop[k]] = true; // 建图
        }

        bfs();

        if (d[n] == -1) System.out.println("NO");
        else System.out.println(d[n] - 1); // 注意答案是边数减1
    }
}
