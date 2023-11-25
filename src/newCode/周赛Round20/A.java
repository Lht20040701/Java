package newCode.周赛Round20;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n + 10];

        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();
        Arrays.sort(a, 1, 1 + n);

        int ans = 0;
        for (int i = 1; i <= n - 1; i ++ ) {
            if (a[i] < a[n]) ans ++ ;
        }

        System.out.println(ans);
    }
}
