package leetcode;

public class lec7 {
    public int reverse(int x) {
        Long xi = Long.valueOf(x);
        StringBuilder s = new StringBuilder(xi.toString());

        if (s.charAt(0) == '-') {
            s.deleteCharAt(0);
            s.reverse();

            s.insert(0, '-');
        } else {
            s.reverse();
        }

        long ans = Long.parseLong(s.toString());
        if (ans > 2147483647 || ans < -2147483648) return 0;

        return Integer.parseInt(s.toString());
    }
}
