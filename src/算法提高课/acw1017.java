package 算法提高课;

import java.util.Scanner;

public class acw1017 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int k = sc.nextInt();
        while (k -- > 0) solve();
    }

    public static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n + 10], b = new int[n + 10];

        for (int i = 0; i < n; i ++ ) a[i] = sc.nextInt();
        for (int i = 0; i < n; i ++ ) b[i] = a[n - 1 - i];

        int ans = 0;
        int[] p = new int[n + 10];
        int len = 0;
        p[0] = -1;

        for (int i = 0; i < n; i ++ ) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (p[mid] < a[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len, r + 1);
            p[r + 1] = a[i];
        }

        ans = len;

        p = new int[n + 10];
        len = 0;
        p[0] = -1;

        for (int i = 0; i < n; i ++ ) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (p[mid] < b[i]) l = mid;
                else r = mid - 1;
            }
            len = Math.max(len, r + 1);
            p[r + 1] = b[i];
        }

        ans = Math.max(ans, len);
        System.out.println(ans);
    }
}
