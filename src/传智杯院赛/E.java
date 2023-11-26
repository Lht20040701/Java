package 传智杯院赛;

import java.util.*;

public class E {
    static int n;
    static int[] a;
    static ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
    static int ans = 0x3f3f3f3f;
    static Set<Integer> st = new HashSet<>();

    private static boolean f(int x) {
        if (x == 1) return false;
        for (int i = 2; i * i <= x; i ++ ) {
            if (x % i == 0) return false;
        }
        return true;
    }
    private static void getY(int x, int id) {
        for (int i = 2; i <= x; i ++ ) {
            if (x % i == 0 && f(i)) ar.get(id).add(i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n + 10];

        for (int i = 0; i < n; i ++ ) a[i] = sc.nextInt();
        for (int i = 0; i < n; i ++ ) ar.add(new ArrayList<>());

        for (int i = 0; i < n; i ++ ) getY(a[i], i);

//        System.out.println("f(15) -> " + f(15));

//        for (int i = 0; i < n; i ++ ) {
//            System.out.println(ar.get(i));
//        }

        dfs(0, 0);
        if (ans != 0x3f3f3f3f) System.out.println(ans);
        else System.out.println(-1);
    }

    private static void dfs(int u, int sum) {
        if (sum >= ans) return ;
        if (u == n) {
            ans = sum;
            return ;
        }

        for (int i = 0; i < ar.get(u).size(); i ++ ) {
            if (st.contains(ar.get(u).get(i))) continue;

            st.add(ar.get(u).get(i));
            dfs(u + 1, sum + ar.get(u).get(i));
            st.remove(ar.get(u).get(i));
        }
    }
}
