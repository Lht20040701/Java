package 蓝桥杯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class lanqiao1443 {
    static final int N = 2010, M = 2 * 100010;
    static int[] h, e, ne, w, target;
    static int[] dist;
    static int n, m, k, t;
    static int idx;
    static boolean[] st;
    static Queue<Integer> q;

    /**
     * 思路 : 另类的spfa建图方式 (spfa的本质是动态规划)
     *       本题不寻常于普通的图论主要是因为普通图论是一个点到另一个点, 但是这个图是一个点借助别的点到另一个点
     *       所以需要从本质出发, 重新推导一下spfa的公式
     *       先说一下最重要的存边方式, 我们的h[i]发生了改变, 此处的h[i]所串起来的邻接表表示i这个点可以和后面邻接表上的点杂交产生对应的target
     *       我们用一个例子讲解一下边权的存储 :
     *       比如我x + y => z
     *       那么我h[x]中必定有个点是y, 其对应的target就是z
     *       那么我从x + y -> z (或者从y + z -> z) 的边权 w 就是 max(w[x], w[y])
     *       那我我就需要看看dist[z] 的答案是否需要更新成 max(dist[x], dist[y]) + max(w[x], w[y]) 这个东西
     *
     *       总结下来存的信息其实是两个 a --(w, b)--> c  b --(w, a)--> c 其中w = max(w[x], w[y])
     *
     *       看明白了以后其实就是套spfa的板子了, 可以看看基础课的板子怎么写的
     * */

    private static void init() {
        h = new int[N]; // 邻接表
        e = new int[M];
        ne = new int[M];
        target = new int[M];
        w = new int[N]; // 每个作物成熟的花费时间
        dist = new int[N]; // dist数组
        st = new boolean[N]; // spfa用的是否在队列中数组
        q = new LinkedList<>(); // 队列
        Arrays.fill(dist, 0x3f3f3f3f); // 初始化
        Arrays.fill(h, -1); // 初始化
    }

    private static void add(int a, int b, int c) {
        e[idx] = b; target[idx] = c; ne[idx] = h[a]; h[a] = idx ++ ;
    }

    private static void spfa() {
        while (!q.isEmpty()) {
            int x = q.poll();
            st[x] = false;

            for (int i = h[x]; i != -1; i = ne[i]) {
                int y = e[i], z = target[i];

                if (dist[z] > Math.max(dist[x], dist[y]) + Math.max(w[x], w[y])) {
                    dist[z] = Math.max(dist[x], dist[y]) + Math.max(w[x], w[y]);
                    q.add(z);
                    if (!st[z]) {
                        q.add(z);
                        st[z] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt(); t = sc.nextInt();
        init();
        for (int i = 1; i <= n; i ++ ) w[i] = sc.nextInt();


        while (m -- > 0) { // 将所有拥有的种子的dist更新成0, 并且入队
            int x = sc.nextInt();
            dist[x] = 0;
            q.add(x);
            st[x] = true;
        }

        while (k -- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c); // 加边, a配合b合成c
            add(b, a, c); // 加边, b配合a合成c
        }

        spfa();

        System.out.println(dist[t]);
    }
}
