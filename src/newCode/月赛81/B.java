package newCode.月赛81;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong(), u = sc.nextLong();
        long[] a = new long[n + 10], b = new long[n + 10];

        for (int i = 1;  i <= n; i ++ ) a[i] = sc.nextLong();
        for (int i = 1;  i <= n; i ++ ) b[i] = sc.nextLong();

        long[] sa = new long[n + 10];
        long[] sb = new long[n + 10];

        for (int i = 1; i <= n; i ++ ) {
            sa[i] = sa[i - 1] + a[i];
            sb[i] = sb[i - 1] + b[i];
        }

        int ans = 0;
        for (int i = 1; i <= n; i ++ ) {
            long nowb = u, nowm = m;
            int cnt = 0;

            long spa = 0, spb = 0;

            for (int j = i; j <= n; j ++ ) {
                if (b[j] < 0 && spb > b[j]) {
                    spb = b[j];
                    spa = a[j];
                }

                if (nowb - b[j] >= 0 && nowm - a[j] >= 0) {
                    cnt ++ ;
                    nowb -= b[j];
                    nowm -= a[j];
                } else if (nowm - a[j] >= 0 && nowb - b[j] < 0 && spb < 0 && nowm >= spa) {
                    while (nowb < b[j] &&  nowm >= spa) {
                        nowm -= spa;
                        nowb -= spb;
                    }

                    if (nowb >= b[j] && nowm >= a[j]) {
                        cnt ++ ;
                        nowb -= b[j];
                        nowm -= a[j];
                    } else break;
                } else break;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
