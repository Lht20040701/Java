package 传智杯院赛;

import java.util.Scanner;

public class D {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String s = " " + sc.next();
        int[][] al = new int[n + 10][26];

        for (int i = 1; i <= n; i ++ ) {
            int x = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j ++ ) {
                al[i][j] = al[i - 1][j];
                if (j == x) al[i][j] ++ ;
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i ++ ) {
            int x = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j ++ ) {
                if (j == x) continue;
                ans += f(al[n][j] - al[i][j]);
            }
        }

        System.out.println(ans);


    }

    private static int f(int x) {
        return x * (x - 1) / 2;
    }
}
