//package 传智杯院赛;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class F {
//    static int n;
//    static int[] d;
//    static char[] ans;
//    static int[] h, ne, e;
//    static int idx;
//
//    private static void init() {
//        h = new int[n + 10]; ne = new int[2 * n + 10]; e = new int[2 * n + 10];
//        Arrays.fill(h, -1);
//    }
//
//    private static void add(int a, int b) {
//        e[idx] = b; ne[idx] = h[a]; h[a] = idx ++ ;
//    }
//
//    private static boolean dfs(int u, int fa, int le) {
//        if (le == 1 && d[u] - 1 > 2) return false;
//        if (le == 1) ans[u] = ans[fa];
//
//        if (le == 0 && d[u] - 1 > 2) return false;
//        if (le == 0) {
//            if (u == 1) ans[u] = 'R';
//            else if (ans[fa] == 'R') ans[u] = 'B';
//            else ans[u] = 'R';
//        }
//
//        if (le == 0 && u != 1 && d[u] - 1 == 1 || u == 1 && d[u] == 1) {
//            for (int i = h[u]; i != -1; i = ne[i]) {
//                int j = e[i];
//                if (j == fa) continue;
//                return dfs(j, u, 1);
//            }
//        }
//        if (le == 0 && u != 1 && d[u] - 1 == 0) return false;
//
//        if (le == 0 && u != 1 && d[u] - 1 == 2 || u == 1 && d[u] == 2) {
//            int fr = 0, se = 0;
//            for (int i = h[u]; i != -1; i = ne[i]) {
//                int j = e[i];
//                if (j == fa) continue;
//                if (fr == 0) fr = j;
//                else if (se == 0) se = j;
//            }
//
//            boolean canf = false;
//            canf = canf || (dfs(se, u, 1) && dfs(fr, u, 0));
//            if (canf) return true;
//            canf = canf || (dfs(fr, u, 1) && dfs(se, u, 0));
//            if (canf) return true;
//            return false;
//        }
//
//        if (le == 1 && d[u] - 1 == 1) {
//            for (int i = h[u]; i != -1; i = ne[i]) {
//                int j = e[i];
//                if (j == fa) continue;
//                return dfs(j, u, 0);
//            }
//        }
//        if (le == 1 && d[u] - 1 == 2) {
//            boolean dug = true;
//            for (int i = h[u]; i != -1; i = ne[i]) {
//                int j = e[i];
//                if (j == fa) continue;
//                dug = dug && dfs(j, u, 0);
//            }
//            return dug;
//        }
//        if (le == 1 && d[u] - 1 == 0) return true;
//
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        n = sc.nextInt();
//
//        d = new int[n + 10];
//        int[] u = new int[n + 10], v = new int[n + 10];
//        ans = new char[n + 10];
//        init();
//
//        for (int i = 1; i <= n - 1; i ++ ) {
//            u[i] = sc.nextInt();
//            v[i] = sc.nextInt();
//            d[u[i]] ++ ;
//            d[v[i]] ++ ;
//
//            add(u[i], v[i]);
//            add(v[i], u[i]);
//        }
//
//        if (dfs(1, -1, 0)) {
//            for (int i = 1; i <= n; i ++ ) System.out.print(ans[i]);
//            System.out.println();
//        } else {
//            System.out.println(-1);
//        }
//    }
//}
