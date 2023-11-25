package newCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static class PII implements Comparable {
        long t;
        int id;

        public PII(long t, int id) {
            this.t = t;
            this.id = id;
        }

        @Override
        public int compareTo(Object o) {
            PII pe = (PII) o;
            return (int)(this.t - pe.t);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), p = sc.nextInt();
        PII[] per = new PII[n + 10];
        for (int i = 1; i <= n; i ++ ) per[i] = new PII(sc.nextLong(), i);

        Arrays.sort(per, 1, 1 + n);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long pos = 0;
        long[] ans = new long[n + 10];
        for (int i = 1; i <= n; i ++ ) {
            while (!pq.isEmpty() && pos < per[i].t) {
                int id = pq.poll();
                pos += p;
                ans[id] = pos;
            }

            pq.add(per[i].id);
            if (pos < per[i].t) pos = per[i].t;
        }

        while (!pq.isEmpty()) {
            int id = pq.poll();
            pos += p;
            ans[id] = pos;
        }

        for (int i = 1; i <= n; i ++ ) System.out.print(ans[i] + " ");
    }
}