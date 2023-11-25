package 算法保持;

import java.util.HashMap;
import java.util.Scanner;

public class acw3674 {
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, Integer> ha = new HashMap<>();

    static void init() {
        ha.put("zero", 0);
        ha.put("one", 1);
        ha.put("two", 2);
        ha.put("three", 3);
        ha.put("four", 4);
        ha.put("five", 5);
        ha.put("six", 6);
        ha.put("seven", 7);
        ha.put("eight", 8);
        ha.put("nine", 9);

    }

    public static void main(String[] args) {
        init();
        while (sc.hasNext()) {
            int a = 0;
            do {
                String t = sc.next();
                if (t.equals("+")) break;

                if (ha.containsKey(t)) a =  a * 10 + ha.get(t);
            } while (true);

            int b = 0;
            do {
                String t = sc.next();
                if (t.equals("=")) break;

                if (ha.containsKey(t)) b = b * 10 + ha.get(t);
            } while (true);
            if (a != 0 || b != 0) System.out.println(a + b);
        }
    }
}
