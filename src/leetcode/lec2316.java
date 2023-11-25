package leetcode;

import java.util.HashSet;
import java.util.Set;

public class lec2316 {
//    public static void main(String[] args) {
//        System.out.println();
//    }
    static final int N = 200010;
    int[] p = new int[N];
    int[] ps = new int[N];
    Set<Integer> st = new HashSet<>();

    public void init(int n) {
        for (int i = 0; i < n; i ++ ) {
            p[i] = i;
            ps[i] = 1;
            st.add(i);
        }
    }

    public int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }

    public int C(int x) {
        return x * (x - 1) / 2;
    }

    public long countPairs(int n, int[][] edges) {
        init(n);
        int cnt = n;
        for (int[] x : edges) {
            int a = x[0], b = x[1];
            int pa = find(a), pb = find(b);

            if (pa != pb) {
                p[pa] = pb; // 把pa接在pb上
                st.remove(pa);
                ps[pb] += ps[pa];
            }
        }

        long ans = 0;
        for (int x : st) {
            ans += (long) (cnt - ps[x]) * ps[x];
            cnt -= ps[x];
        }
        return ans;
    }
}
