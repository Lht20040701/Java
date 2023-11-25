package leetcode;

import java.math.BigInteger;

public class lec8 {
//    public static void main(String[] args) {
//        System.out.println(myAtoi("-42"));
//    }

    public int myAtoi(String s) {
        if (s.equals("")) return 0;
        boolean f = false, sign = true, hasExist = false;
        BigInteger bg = BigInteger.valueOf(0L);
        s = s.trim();
        int st;
        for (st = 0; st < s.length(); st ++) {
            if (!Character.isDigit(s.charAt(st))) {
                if (s.charAt(st) != '-' && s.charAt(st) != '+') {
//                    System.out.println("debug");
                    return 0;
                }
                if (!hasExist && (s.charAt(st) == '-' || s.charAt(st) == '+')) {
                    hasExist = true;
                    if (s.charAt(st) == '-') sign = false;
                    continue;
                }
                if (hasExist) {
//                    System.out.println("debug");
                    return 0;
                }
            }
            else break;
        }
        if (st == s.length()) return 0;

//        if (st - 1 >= 0 && s.charAt(st - 1) == '-') sign = false;

        for (int i = st; i < s.length(); i ++ ) {
            if (!Character.isDigit(s.charAt(i))) {
                bg = bg.add(new BigInteger(s.substring(st, i)));
                f = true;
                break;
            }
        }

        if (!f) {
//            System.out.println("debug");
            bg = bg.add(new BigInteger(s.substring(st)));
        }
//        System.out.println(bg);

        if (sign && bg.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) return  Integer.MAX_VALUE;
        if (!sign && bg.compareTo(BigInteger.valueOf(2147483648L)) > 0) return  Integer.MIN_VALUE;
        return sign ? bg.intValue() : -1 * bg.intValue();
    }
}
