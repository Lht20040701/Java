package 算法提高课;

import java.util.Scanner;

public class acw1024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(), n = sc.nextInt();
        int[] wx = new int[n + 10];

        /**
         * 使箱子剩余空间最小 --> 使箱子中装的东西的价值最大 <-- 让东西的价值和体积一至
         * */
        for (int i = 1; i <= n; i ++ ) wx[i] = sc.nextInt();
        int[] f = new int[v + 10];
        for (int i = 1; i <= n; i ++ )
            for (int j = v; j >= wx[i]; j -- )
                f[j] = Math.max(f[j], f[j - wx[i]] + wx[i]);

        System.out.println(v - f[v]);
    }
}
