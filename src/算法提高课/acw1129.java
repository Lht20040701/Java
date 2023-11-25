package 算法提高课;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class acw1129 {
    static class PII implements Comparable {
        int dis, tar; // tar表示我这条边的入弧, dis表示我这条边的距离
        public PII(int dis, int tar) {
            this.dis = dis;
            this.tar = tar;
        }

        @Override
        public int compareTo(Object o) {
            PII t = (PII) o;
            return this.dis - t.dis;
        }
    }

    static PriorityQueue<PII> heap = new PriorityQueue<>();

    static int[] h, e, ne, w;
    static int idx;
    static int t, c, ts, te;
    static int[] d;
    static boolean[] st;

    private static void init() {
        h = new int[t + 100]; e = new int[2 * c + 100]; ne = new int[2 * c + 100]; w = new int[2 * c + 100];
        d = new int[t + 100]; st = new boolean[t + 100];
        Arrays.fill(h, -1);
    }

    private static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx ++ ;
    }

    private static int dij(int s) {
        Arrays.fill(d, 0x3f3f3f3f);
        d[s] = 0;
        heap.add(new PII(0, s));

        while (!heap.isEmpty()) {
            PII te = heap.poll();
            int ver = te.tar, dis = te.dis;

            if (st[ver]) continue;
            st[ver] = true;

            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                    heap.add(new PII(d[j], j));
                }
            }
        }

        return d[te];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt(); c = sc.nextInt(); ts = sc.nextInt(); te = sc.nextInt();
        init();

        for (int i = 1; i <= c; i ++ ) {
            int a = sc.nextInt(), b = sc.nextInt(), w = sc.nextInt();
            add(a, b, w);
            add(b, a, w);
        }

        System.out.println(dij(ts));
    }
}
