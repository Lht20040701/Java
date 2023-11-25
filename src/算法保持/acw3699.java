package 算法保持;

import java.util.Scanner;

public class acw3699 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static final int N = 10010;
    static int[] h = new int[2 * N], e = new int[2 * N], ne = new int[2 * N];
    static int idx;
    static int ans;

    public static void add(int a, int b) {
        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++ ;
    }

    public static void init() {
        for (int i = 1; i <= n; i ++ )
            h[i] = -1;
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        init();

        for (int i = 1; i <= n - 1; i ++ ) {
            int u = sc.nextInt(), v = sc.nextInt();
            add(u, v); add(v, u);
        }

        dfs(m, -1, 0);

        System.out.println(ans);
    }

    public static void dfs(int u, int f, int d) {
        ans = Math.max(d, ans);

        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j != f)
                dfs(j, u, d + 1);
        }
    }
}
