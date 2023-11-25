package 算法提高课;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class acw1128 {
    static int n, m;
    static int[] h, e, w, ne;
    static int[] d;
    static boolean[] st;
    static int idx;
    static class PII implements Comparable {
        int ver, dis;

        public PII(int ver, int dis) {
            this.ver = ver;
            this.dis = dis;
        }

        @Override
        public int compareTo(Object o) {
            PII te = (PII) o;
            return this.dis - te.dis;
        }
    }
    private static void init() {
        h = new int[n + 10]; e = new int[2 * m + 10]; w = new int[2 * m + 10]; ne = new int[2 * m + 10];
        d = new int[n + 10]; st = new boolean[n + 10];
        Arrays.fill(h, -1);
    }

    private static int dij() {
        PriorityQueue<PII> pq = new PriorityQueue<>();
        int ans = -1, cnt = 0;
        Arrays.fill(d, 0x3f3f3f3f);
        d[1] = 0;
        pq.add(new PII(1, 0));

        while (!pq.isEmpty()) {
            PII te = pq.poll();
            int ver = te.ver, dis = te.dis;

            if (st[ver]) continue;
            st[ver] = true;
            cnt ++ ;

            ans = Math.max(dis, ans);

            for (int i = h[ver]; i != -1; i = ne[i]) {
                int j = e[i];
                if (d[j] > dis + w[i]) {
                    d[j] = dis + w[i];
                    pq.add(new PII(j, d[j]));
                }
            }
        }

        if (cnt != n) return -1;
        return ans;
    }

    private static void add(int a, int b, int c) {
        e[idx] = b; w[idx] = c; ne[idx] = h[a]; h[a] = idx ++ ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        init();

        for (int i = 1; i <= m; i ++ ) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }

        System.out.println(dij());
    }
}
