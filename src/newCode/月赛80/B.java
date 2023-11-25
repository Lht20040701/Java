package newCode.月赛80;
import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt();
            a[x] ++ ;
        }

        Arrays.sort(a, 1, m + 1);

        int i = 1;
        for (; i <= m; i ++ ) {
            k -= a[i];
            if (k <= 0) break;
        }

        if (i < m) System.out.println(a[m]);
        else System.out.println(-k);
    }
}