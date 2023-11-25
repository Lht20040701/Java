package 算法保持;

import java.util.Arrays;
import java.util.Scanner;

public class acw3666 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i ++ ) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        Arrays.sort(x);

        for (int i = 0; i < n; i ++ ) {
            x[i] -= i; // 少移动多少
        }
        Arrays.sort(x);

        Arrays.sort(y);

        int ax = 0;
        int ay = 0;
        for (int i = 0; i < n; i ++) {
            ax += Math.abs(x[i] - x[n / 2]);
            ay += Math.abs(y[i] - y[n / 2]);
        }

        System.out.println(ax + ay);
    }
}
