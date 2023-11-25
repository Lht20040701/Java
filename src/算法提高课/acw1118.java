package 算法提高课;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class acw1118 {
    static int ans = 0x3f3f3f3f, n;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        dfs(new ArrayList<>(), 1);

        System.out.println(ans);
    }

    private static void dfs(List<List<Integer>> lis, int now) { // lis表示我当前的组, now表示我枚举到了哪个数
        if (now == n + 1) {
            ans = Math.min(lis.size(), ans);
            return ;
        }

        for (int i = 0; i < lis.size(); i ++ ) {
            boolean f = true;
            for (int j = 0; j < lis.get(i).size(); j ++ ) {
                if (check(lis.get(i).get(j), a[now])) continue;
                f = false;
                break;
            }

            if (f) {
                lis.get(i).add(a[now]);
                dfs(lis, now + 1);
                lis.get(i).remove((Integer) a[now]);
            }
        }

        List<Integer> t = new ArrayList<>();
        t.add(a[now]);
        lis.add(t);
        dfs(lis, now + 1);
        lis.remove(t);
    }

    private static boolean check(int a, int b) {
        return 1 == gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
