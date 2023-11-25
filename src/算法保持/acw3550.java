package 算法保持;

import javax.swing.plaf.metal.MetalTheme;
import java.util.Scanner;

public class acw3550 {
    static Scanner sc = new Scanner(System.in);
    static boolean[] two = new boolean[100010];
    static boolean[] three = new boolean[100010];

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) solved();
    }

    public static void solved() {
        int n = sc.nextInt();

        int ans = 0;
        for (int i = 1; i * i * i <= n; i ++ ) {
            int x = i * i * i;
            if (Math.sqrt(x) == (int) Math.sqrt(x)) ans ++ ;
        }

        System.out.println(ans);
    }
}
