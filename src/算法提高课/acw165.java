package 算法提高课;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class acw165 {
    static int ans = 0x3f3f3f3f;
    static int n, w;
    static Integer[] c, t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); w = sc.nextInt();
        c = new Integer[n + 10]; t = new Integer[n + 10];
        Arrays.fill(t, 0);
        for (int i = 1; i <= n; i ++ ) c[i] = sc.nextInt();

        Arrays.sort(c, 1, n + 1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        dfs(1, 0);
        System.out.println(ans);
    }

    public static void dfs(int now, int cost) { // now代表当前我枚举到哪个猫猫了, cost表示当前我有几个缆车
        if (cost >= ans) return ;
        if (now == n + 1) {
            ans = cost;
            return ;
        }

        for (int i = 1; i <= cost; i ++ ) {
            if (t[i] + c[now] <= w) {
                t[i] += c[now];
                dfs(now + 1, cost);
                t[i] -= c[now];
            }
        }

        t[cost + 1] = c[now];
        dfs(now + 1, cost + 1);
        t[cost + 1] = 0;
    }
}
