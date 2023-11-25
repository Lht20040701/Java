package 算法保持;

import java.util.Scanner;

public class acw3682 {
    static Scanner sc = new Scanner(System.in);

    static int n, m;

    static void solved() {
        n = sc.nextInt();
        m = sc.nextInt();
        int[] p = new int[m + 10];

        for (int i = 1; i <= m; i ++ ) p[i] = i;
        int ans = n;
    }

    public static void main(String[] args) {
        while (sc.hasNextInt()) {
            solved();
        }
    }
}
