package 蓝桥杯;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class acw4664 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Map<Character, Integer> m = new HashMap<>();
        int ma = 0;

        for (int i = 0; i < s.length(); i ++ ) {
            char x = s.charAt(i);
            m.put(x, m.getOrDefault(x, 0) + 1);
//            System.out.println(m.getOrDefault(x, 0));
            ma = Math.max(ma, m.getOrDefault(x, 0));
        }

//        System.out.println(ma);

        for (char i = 'A'; i <= 'Z'; i ++ ) {
            if (m.getOrDefault(i, 0) == ma) System.out.print(i);
        }
    }
}