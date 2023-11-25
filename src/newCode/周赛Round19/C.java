package newCode.周赛Round19;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    static int n;
    static int ans;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 10];
        for (int i = 1; i <= n; i ++ ) arr[i] = sc.nextInt();

        //
        int[] f = new int[100010];
        Arrays.fill(f, 0x3f3f3f3f);
        f[1] = 0;
        f[2] = 1;
        //

        for (int i = 3; i <= 100001; i ++ ) {
            f[i] = f[i - 1] + 1;
            for (int x = 2; x <= i / x; x ++ ) {
                if (i % x == 0) f[i] = Math.min(f[i], f[x] + f[i / x] + 1);
            }
        }

        for (int i = 1; i <= n; i ++ ) ans += f[arr[i]];

        System.out.println(ans);
    }
}
