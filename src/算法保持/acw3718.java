package 算法保持;

import java.util.Scanner;

public class acw3718 {
    static Scanner sc = new Scanner(System.in);

    static long ans = 0;

    static void dfs(long s, long u, long res) { // u 代表还需要插的个数
        if (u == 0) {
            ans = Math.max(res * s, ans);
            return ;
        }

        for (long i = 10; s % i != s; i *= 10) {
            long fr = s / i;
            long ba = s % i;

            dfs(fr, u - 1, ba * res);
        }
    }

    public static void main(String[] args) {
        long n = sc.nextInt();
        long k = sc.nextInt();

        long s = sc.nextLong();
        dfs(s, k, 1);
        System.out.println(ans);
    }
}
