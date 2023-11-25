package newCode;

import java.util.Scanner;

public class NC234809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t -- > 0) {
            int xx = sc.nextInt();
            if (xx <= 9 && xx >= 5) {
                System.out.println("10");
                continue;
            }
            StringBuilder s = new StringBuilder(String.valueOf(xx));

            int Min = 0x3f3f3f3f;
            for (int i = s.length() - 1; i >= 1; i -- ) {
//                System.out.println("debug");
                int x = s.charAt(i) - '0';
                if (x >= 5) {
                    if (s.charAt(i - 1) != '9') s.setCharAt(i - 1, (char) (s.charAt(i - 1) + 1));
                    else s.setCharAt(i - 1, 'a');
                    Min = i;
                }
            }

            if (s.charAt(0) == 'a' || s.charAt(0) >= '5' && s.charAt(0) <= '9') {
                Min = 0;
                for (; Min < s.length(); Min ++ ) s.setCharAt(Min, '0');
                System.out.println("1" + s);
            } else {
                for (; Min < s.length(); Min ++ ) s.setCharAt(Min, '0');
                System.out.println(s);
            }
        }
    }
}
