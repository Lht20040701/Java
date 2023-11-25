package 算法保持;

import java.util.Scanner;

public class acw3544 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++ ) {
            String s = sc.next();

            System.out.println(s.replace("111110", "11111"));
        }
    }
}
