package 算法保持;

import java.util.Scanner;

public class acw3532 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i ++ ) {
            int x = sc.nextInt();
            if (x % 2 == 0) even ++ ;
            else odd ++ ;
        }

        if (even > odd) System.out.println("NO");
        else System.out.println("YES");
    }
}
