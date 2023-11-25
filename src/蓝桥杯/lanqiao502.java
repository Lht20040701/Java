package 蓝桥杯;

import java.util.Scanner;

public class lanqiao502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cntj = 0, cnty = 0;
        for (int i = 1; i <= n; i ++ ) {
            int x = sc.nextInt();
            if (x >= 60) cntj ++ ;
            if (x >= 85) cnty ++ ;
        }

        System.out.printf("%.0f%%\n%.0f%%", (double) cntj * 100 / n, (double) cnty * 100 / n);
    }
}
