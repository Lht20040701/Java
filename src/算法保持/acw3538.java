package 算法保持;

import java.util.Scanner;

public class acw3538 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();

        int n = sc.nextInt();

        for (int i = 1; i <= n; i ++ ) {
            String or = sc.next();

            int op = or.charAt(0) - '0';
            int st = or.charAt(1) - '0';
            int len = or.charAt(2) - '0';

            if (op == 0) {
                StringBuilder sb = new StringBuilder(s.substring(st, st + len));

                String fr = s.substring(0, st);
                String ba = s.substring(st + len);

                s = fr + sb.reverse().toString() + ba;
                System.out.println(s);
            }

            if (op == 1) {
                or = or.substring(3);

                String fr = s.substring(0, st);
                String ba = s.substring(st + len);

                s = fr + or + ba;
                System.out.println(s);
            }
        }
    }
}
