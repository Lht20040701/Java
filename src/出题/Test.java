package 出题;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static Scanner sc = new Scanner(System.in);
    static int t;
    static int n;

    public static void solved() {
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++ ) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[1] + " " + a[0]);
    }

    public static void main(String[] args) {
        t = sc.nextInt();
        while (t -- != 0) {
            solved();
        }
    }
}
