package 算法提高课;

import java.util.Scanner;

public class acw1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 10];
        for (int i = 0; i < n; i ++ ) a[i] = sc.nextInt();

        int[] f = new int[n + 10], g = new int[n + 10];
        for (int i = 0; i < n; i ++ ) {
            f[i] = 1;
            for (int j = 0; j < i; j ++ )
                if (a[j] < a[i])
                    f[i] = Math.max(f[i], f[j] + 1);
        }

        for (int i = n - 1; i >= 0; i -- ) {
            g[i] = 1;
            for (int j = n - 1; j > i; j -- )
                if (a[j] < a[i])
                    g[i] = Math.max(g[i], g[j] + 1);
        }

        int res = 0;
        for (int i = 0; i < n; i ++ )
            res = Math.max(res, f[i] + g[i] - 1); // 注意i这个位置算了两次, 需要减一下

        System.out.println(res);
    }
}
