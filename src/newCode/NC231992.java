package newCode;

import java.util.Scanner;

public class NC231992 {
    static int n;
    static int[] arr;
    static double ans = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i ++ ) arr[i] = sc.nextInt();
        dfs(0, 0,0, 0);
        if (ans > 0) System.out.printf("%.1f\n", ans);
        else System.out.println(-1);
    }

    public static void dfs(int a, int b, int c, int now) {
        if (now == n) {
            if (check(a, b, c)) {
                double p = (double) (a + b + c) / 2;
                ans = Math.max(ans, Math.sqrt(p * (p - a) * (p - b) * (p - c)));
            }
            return ;
        }

        dfs(a + arr[now], b, c, now + 1);
        dfs(a, b + arr[now], c, now + 1);
        dfs(a, b, c + arr[now], now + 1);
        dfs(a, b, c, now + 1);
    }

    public static boolean check(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) return false;
        return true;
    }

}
