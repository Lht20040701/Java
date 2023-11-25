package 算法提高课;

import java.util.Scanner;

public class acw482 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        int[] f = new int[n + 10], g = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            f[i] = 1;
            for (int j = 1; j < i; j ++ )
                if (a[j] < a[i]) f[i] = Math.max(f[i], f[j] + 1);
        }

        for (int i = n; i >= 0; i -- ) {
            g[i] = 1;
            for (int j = n; j > i; j -- )
                if (a[j] < a[i]) g[i] = Math.max(g[i], g[j] + 1);
        }

        int ans = 0x3f3f3f3f;
        for (int i = 1; i <= n; i ++ ) ans = Math.min(ans, n - (f[i] + g[i] - 1));
        System.out.println(ans);
    }
}
