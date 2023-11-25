package leetcode;

public class lec2520 {
    public int countDigits(int num) {
        int x = num;
        int ans = 0;
        while (num != 0) {
            int y = num % 10;
            if (x % y == 0) ans ++ ;
            num /= 10;
        }
        return ans;
    }
}
