package newCode.月赛81;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    static Map<Integer, Integer> ma = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int sign1 = 1;
        for (int i = 1; i <= m; i ++ ) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            if (x < 0) sign1 = -sign1;

            divide(x, op);
        }

        int sign2 = 1;
        m = sc.nextInt();
        for (int i = 1; i <= m; i ++ ) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            if (x < 0) sign2 = -sign2;

            divide2(x, op);
        }

        if (sign2 != sign1) {
            System.out.println("NO");
            return ;
        }

        boolean f = true;
        for (int x : ma.keySet()) {
//            System.out.println("x -> " + x + " : ma[x] -> " + ma.get(x));
            if (ma.get(x) != 0) {
                f = false;
                break;
            }
        }

        if (f) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void divide(int n, int op) {
        for (int i = 2; i <= n / i; i ++ ) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s ++ ;
                }

                ma.put(i, op == 1 ? ma.getOrDefault(i, 0) + s : ma.getOrDefault(i, 0) - s);
//                System.out.println("debug : i -> " + i + " ma[i] -> " + ma.getOrDefault(i, 0));
            }
        }
        if (n > 1) ma.put(n, op == 1 ? ma.getOrDefault(n, 0) + 1 : ma.getOrDefault(n, 0) - 1);
//        System.out.println("debug : i -> " + n + " ma[i] -> " + ma.getOrDefault(n, 0));
    }

    public static void divide2(int n, int op) {
        for (int i = 2; i <= n / i; i ++ ) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n /= i;
                    s ++ ;
                }

                ma.put(i, op == 1 ? ma.getOrDefault(i, 0) - s : ma.getOrDefault(i, 0) + s);
//                System.out.println("i -> " + i + " ma[i] -> " + ma.getOrDefault(i, 0));
            }
        }
        if (n > 1) ma.put(n, op == 1 ? ma.getOrDefault(n, 0) - 1 : ma.getOrDefault(n, 0) + 1);
//        System.out.println("debug : i -> " + n + " ma[i] -> " + ma.getOrDefault(n, 0));
    }
}
