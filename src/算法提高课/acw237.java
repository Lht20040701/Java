package 算法提高课;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class acw237 {
    static class Q {
        int x, y, e;
        public Q(int x, int y, int e) {
            this.x = x;
            this.y = y;
            this.e = e;
        }
    }

    /**
     * 思路 : 解出本题有三个关键点 ->
     *             1. 首先i, j的数据范围是1e9, 但是实际我们用到的最多只有其中2e5个数, 所以我们需要想到之前我们学过的离散化的知识, 但是和基础课中的离散化略有不同, 这里的离散化无序就行, 所以用哈希表做一个简单的实现 (具体看代码
     *             2. 首先给出的约束条件执行的顺序对答案是没有任何影响的, 所以我们采用以下策略
     *                      a. 先考虑所有相等的约束条件如 : xi == xj, 我们处理这些条件的时候只需要利用并查集合并就好了, 所以此时一定不会有矛盾
     *                      b. 再处理所有不等的约束条件如 : xi != xj, 我们处理这些条件的时候其实就等价于询问并查集中两个数是否在同一个集合中
     *
     *
     *             综上, 问题得到解决, 接下来就是看代码
     * */

    static int use;
    static Map<Integer, Integer> ma;
    static int[] p;

    private static int get(int x) { // 离散化的映射函数
        if (!ma.containsKey(x)) ma.put(x, ++ use); // 如果x之前没用过, 那将x映射到use上
        return ma.get(x);
    }

    private static int find(int x) { // 并查集
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public static void main(String[] args) throws IOException {
        Read sc = new Read();

        int T = sc.nextInt();
        while (T -- > 0) {
            use = 0;
            ma = new HashMap<>(); // 记得重置现场

            int n = sc.nextInt();
            Q[] q = new Q[n + 10];

            for (int i = 1; i <= n; i ++ ) {
                int x = sc.nextInt(), y = sc.nextInt(), e = sc.nextInt();
                q[i] = new Q(get(x), get(y), e); // 将每一个条件进行离散处理然后存起来
            }

            p = new int[use + 10];
            for (int i = 1; i <= use; i ++ ) p[i] = i; // 并查集初始化

            for (int i = 1; i <= n; i ++ )
                if (q[i].e == 1) {
                    int px = find(q[i].x), py = find(q[i].y); // 处理每一个相等约束
                    p[px] = py;
                }

            boolean f = true;
            for (int i = 1; i <= n; i ++ )
                if (q[i].e == 0) {
                    int px = find(q[i].x), py = find(q[i].y); // 处理每一个不等约束
                    if (px == py) f = false;
                }

            if (f) System.out.println("YES");
            else System.out.println("NO");
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
