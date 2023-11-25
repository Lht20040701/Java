package 算法提高课;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class acw1127 {
    static int n, p, c;
    static int[] id;
    static int[] h, e, ne, w;
    static boolean[] st;
    static int[] d;
    static int idx;

    static class PII implements Comparable {
        int dis, ver;

        public PII(int dis, int ver) {
            this.dis = dis;
            this.ver = ver;
        }

        @Override
        public int compareTo(Object o) {
            PII te = (PII) o;
            return this.dis - te.dis;
        }
    }

    private static void init() {
        h = new int[p + 10]; e = new int[2 * c + 10]; ne = new int[2 * c + 10]; w = new int[2 * c + 10];
        id = new int[p + 10]; st = new boolean[p + 10]; d = new int[p + 10];
        Arrays.fill(h, - 1);
    }

    private static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx ++ ;
    }

    private static int dij(int s) {
        Arrays.fill(d, 0x3f3f3f3f);
        Arrays.fill(st, false);
        d[s] = 0;
        PriorityQueue<PII> pq = new PriorityQueue<>();
        pq.add(new PII(0, s));

        while (!pq.isEmpty()) {
            PII te = pq.poll();
            int ver = te.ver, dis = te.dis;

            if (st[ver]) continue;
            st[ver] = true;

            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                    pq.add(new PII(d[j], j));
                }
            }
        }

        int ret = 0;
        for (int i = 1; i <= p; i ++ ) {
            if (d[i] == 0x3f3f3f3f && id[i] != 0) return 0x3f3f3f3f;
            ret += id[i] * d[i];
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); p = sc.nextInt(); c = sc.nextInt();
        init();

        for (int i = 1; i <= n; i ++ ) id[sc.nextInt()] ++ ;
        for (int i = 1; i <= c; i ++ ) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        int ans = 0x3f3f3f3f;
        for (int i = 1; i <= p; i ++ ) ans = Math.min(ans, dij(i));
        System.out.println(ans);
    }
}
