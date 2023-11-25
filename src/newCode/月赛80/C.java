package newCode.月赛80;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {
    static int _n, m, k;
    static int[] a = new int[110];
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Read sc = new Read();
        _n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
        for (int i = 1; i <= _n; i ++ ) {
            int x = sc.nextInt();
            a[x] ++ ;
        }

        for (int _i = 1; _i <= m; _i ++ ) {
            int n = _n;

            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            for (int i = 1; i <= m; i ++ ) {
                if (i == _i || a[i] == 0) continue;
                pq.add(a[i]);
            }

            boolean f = false;
            for (int i = 1; i <= k; i ++ ) {
                if (pq.isEmpty()) {
                    f = true;
                    break;
                }
                int x = pq.poll();
                x -- ;
                if (x > 0) pq.add(x);
            }


            if (f) ans.add(-1);
            else if (pq.isEmpty()) ans.add(0);
            else ans.add(pq.poll());
        }

        for (int x : ans) System.out.print(x + " ");
    }
}

// 使用的时候注意抛出异常throws IOException
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
