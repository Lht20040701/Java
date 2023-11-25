package 算法保持;

import java.util.Scanner;

public class acw3546 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc .next();

        int m = sc.nextInt();
        String t = "";
        for (int i = 1; i <= m; i ++ ) {
            String op = sc.next();
            if (op.equals("COPY")) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                t = s.substring(l, r + 1);
                System.out.println(s);
            } else if (op.equals("CUT")) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                t = s.substring(l, r + 1);
                s = s.substring(0, l) + s.substring(r + 1);
                System.out.println(s);
            } else if (op.equals("PASTE")) {
                int n = sc.nextInt();
                s = s.substring(0, n + 1) + t + s.substring(n + 1);
                System.out.println(s);
            }
        }
    }
}
