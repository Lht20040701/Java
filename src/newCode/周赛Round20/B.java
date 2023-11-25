package newCode.周赛Round20;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        StringBuilder s1 = new StringBuilder(s), s0 = new StringBuilder(s);

        for (int i = 0; i < s1.length(); i ++ ) {
            if (s1.charAt(i) == '?') s1.setCharAt(i, '1');
        }

        for (int i = 0; i < s0.length(); i ++ ) {
            if (s0.charAt(i) == '?') s0.setCharAt(i, '0');
        }

        int ans = 0;
        for (int i = 0, j = 0; i < s1.length(); ) {
            char x = s1.charAt(i);
            while (j < s1.length() && s1.charAt(j) == x) j ++ ;
            ans = Math.max(ans, j - i);
            i = j;
        }

        for (int i = 0, j = 0; i < s0.length(); ) {
            char x = s0.charAt(i);
            while (j < s0.length() && s0.charAt(j) == x) j ++ ;
            ans = Math.max(ans, j - i);
            i = j;
        }

        System.out.println(ans);
    }
}
