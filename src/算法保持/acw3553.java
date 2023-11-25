package 算法保持;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class acw3553 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.next();

        s = " " + s;

        HashMap<Integer, Integer> ha = new HashMap<>();

        int[] n0 = new int[s.length() + 10];
        int[] n1 = new int[s.length() + 10];

        int ans = 0;

        for (int i = 1; i < s.length(); i ++ ) {
            if (s.charAt(i) == '0') n0[i] = n0[i - 1] + 1;
            else n0[i] = n0[i - 1];
            if (s.charAt(i) == '1') n1[i] = n1[i - 1] + 1;
            else n1[i] = n1[i - 1];

            int c = n0[i] - n1[i];
//            System.out.println(c);
            if (c == 0) ans = Math.max(ans, i);
            if (!ha.containsKey(c)) ha.put(c, i);
            else ans = Math.max(ans, i - ha.get(c));
        }

        System.out.println(ans);
    }
}
