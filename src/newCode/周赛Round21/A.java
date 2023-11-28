package newCode.周赛Round21;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            boolean B, a, i, d, u;
            B = a = i = d = u = false;
            String s = sc.next();
            if (s.length() > 5) {
                System.out.println("No");
                continue;
            }
            for (int k = 0; k < s.length(); k ++ ) {
                if (s.charAt(k) == 'B') B = true;
                else if (s.charAt(k) == 'a') a = true;
                else if (s.charAt(k) == 'i') i = true;
                else if (s.charAt(k) == 'd') d = true;
                else if (s.charAt(k) == 'u') u = true;
            }

            if (B && a && i && d && u) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
