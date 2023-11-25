package 算法保持;

import java.util.Scanner;

public class acw3667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            if (n % 2 == 1) {
                System.out.println(0);
                continue;
            }
            n /= 2;

            boolean f = false;
            if (n % 2 == 0) f = true;

            n /= 2;
            if (f) n -= 1;

            System.out.println(n);
        }
    }
}
