package newCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NC20910 {
    static class Seg implements Comparable {
        int l, r;

        public Seg(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Object o) {
            Seg t = (Seg) o;
            return this.r - t.r;
        }
    }

    public static void main(String[] args) throws IOException {
        Read sc = new Read();

        int n = sc.nextInt();
        int[] x = new int[n];
        int[] a = new int[n];
        Seg[] seg = new Seg[n];

        for (int i = 0; i < n; i ++ ) x[i] = sc.nextInt();
        for (int i = 0; i < n; i ++ ) a[i] = sc.nextInt();
        for (int i = 0; i < n; i ++ ) seg[i] = new Seg(x[i] - a[i], x[i] + a[i]);

        Arrays.sort(seg);

        int ans = 0;
        int ed = -(int)1e9;
        for (int i = 0; i < n; i ++ ) {
            if (ed <= seg[i].l) {
                ans ++ ;
                ed = seg[i].r;
            }
        }

        System.out.println(ans);
    }
}

class Read {
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

