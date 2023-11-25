package 算法保持;

import java.util.Scanner;

public class acw3545 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 1; i <= t; i ++ ) solved();
    }

    private static void solved() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = 0;
        for (int i = 1; i <= m / i; i ++ ) {
            if (m % i == 0) {
                if (i <= n && m / i <= n) {
                    ans += 2;
                    if (i == m / i) ans -- ;
                }
            }
        }
        System.out.println(ans);
    }
}
