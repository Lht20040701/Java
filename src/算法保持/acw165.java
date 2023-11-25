package 算法保持;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class acw165 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int w;
    static int[] a = new int[20];
    static int[] t = new int[20];
    static int ans = 0x3f3f3f3f;

    public static void dfs(int u, int sp) { // u代表当前的小猫，sp是消耗的缆车
        if (sp >= ans) return ;
        if (u == n + 1) {
            ans = Math.min(ans, sp);
            return ;
        }

        for (int i = 1; i <= sp; i ++ ) {
            if (t[i] + a[u] <= w) {
                t[i] += a[u];
                dfs(u + 1, sp);
                t[i] -= a[u];
            }
        }

        t[sp + 1] += a[u];
        dfs(u + 1, sp + 1);
        t[sp + 1] -= a[u];
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        w = sc.nextInt();
        Arrays.sort(a, 1, n + 1);
        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        dfs(1, 0);
        System.out.println(ans);
    }
}
