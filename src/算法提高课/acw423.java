package 算法提高课;

import java.util.Scanner;

public class acw423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(), m = sc.nextInt();
        int[] w = new int[m + 10], v = new int[m + 10];
        for (int i = 1; i <= m; i ++ ) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] f = new int[t + 10];

        for (int i = 1; i <= m; i ++ )
            for (int j = t; j >= w[i]; j -- )
                f[j] = Math.max(f[j], f[j - w[i]] + v[i]);

        System.out.println(f[t]);
    }
}
