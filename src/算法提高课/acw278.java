package 算法提高课;

import java.util.Scanner;

public class acw278 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] w = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) w[i] = sc.nextInt();
        int[] f = new int[m + 10];
        f[0] = 1; // 状态初始值 : 使加起来和等0的方案数只有什么也不选这一种

        for (int i = 1; i <= n; i ++ )
            for (int j = m; j >= w[i]; j--)
                f[j] += f[j - w[i]];

        System.out.println(f[m]);
    }
}
