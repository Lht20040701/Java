package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec13 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
    static Map<String, Integer> ma = new HashMap<>() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};
    public static int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length();) {
            if (i + 1 < s.length()) {
                if (ma.getOrDefault(s.substring(i, i + 1), 0) < ma.getOrDefault(s.substring(i + 1, i + 2), 0)) {
                    ans += ma.getOrDefault(s.substring(i, i + 2), 0);
                    i += 2;
                } else {
                    ans += ma.getOrDefault(s.substring(i, i + 1), 0);
                    i ++ ;
                }
            } else {
                ans +=  ma.getOrDefault(s.substring(i, i + 1), 0);
                i ++ ;
            }
        }
        return ans;
    }
}
