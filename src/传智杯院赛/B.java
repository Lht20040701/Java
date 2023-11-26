package 传智杯院赛;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static int n;
    static int[] a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        Arrays.sort(a, 1, 1 + n);

        int ans = 0x3f3f3f3f;

        for (int i = 2; i <= n; i ++ ) {
            ans = Math.min(ans, a[i] - a[i - 1]);
        }

        System.out.println(ans);
    }
}
