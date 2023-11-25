package newCode.月赛81;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), x = sc.nextInt();
        int[] a = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) a[i] = sc.nextInt();

        Arrays.sort(a, 1, n + 1);

        int ans = 0;
        for (int i = 1; i <= n; i ++ ) {
//            System.out.println(a[i] + " " + x);
            if (a[i] < x) ans += a[i];
            else break;
        }

        System.out.println(ans);
    }
}
