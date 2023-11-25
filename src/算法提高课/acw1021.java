package 算法提高课;

import java.util.Scanner;

public class acw1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] w = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) w[i] = sc.nextInt();
        long[] f = new long[m + 10];

        f[0] = 1;
        for (int i = 1; i <= n; i ++ )
            for (int j = w[i]; j <= m; j ++ ) {
                f[j] += f[j - w[i]];
            }

        System.out.println(f[m]);
    }
}
