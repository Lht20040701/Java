package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec12 {
    public static void main(String[] args) {

    }

    Map<Integer, String> ma = new HashMap<>() {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
        put(4, "IV");
        put(9, "IX");
        put(40, "XL");
        put(90, "XC");
        put(400, "CD");
        put(900, "CM");
    }};

    int[] st = new int[] {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        for (int x : st) {
            while (num >= x) {
                num -= x;
                ans.append(ma.getOrDefault(x,""));
            }
        }
        return ans.toString();
    }
}
