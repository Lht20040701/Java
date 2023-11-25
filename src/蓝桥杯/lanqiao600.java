package 蓝桥杯;

import java.util.Scanner;

public class lanqiao600 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = 1, b = 1, c = 1;
        long ans = 0;
        for (int i = 4; i <= 20190324; i ++ ) {
            ans = (a + b + c) % 10000;
            a = b;
            b = c;
            c = ans;
        }

        System.out.println(ans);
    }
}
