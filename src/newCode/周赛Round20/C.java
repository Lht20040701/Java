package newCode.周赛Round20;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), t = sc.nextInt();
        if (t >= k || 2 * k - 2 * t - 2 + t + 1 > n) {
            System.out.println(-1);
            return ;
        }

        int w = n - (2 * k - 2 * t - 2 + t + 1);
        StringBuilder sb = new StringBuilder();

//        System.out.println("w -> : " + w);
        for (int i = 1; i <= k - t - 1; i ++ ) sb.append("10");
        for (int i = 1; i <= w; i ++ ) sb.append("0");
        for (int i = 1; i <= t + 1; i ++ ) sb.append("1");

        System.out.println(sb);
    }
}
