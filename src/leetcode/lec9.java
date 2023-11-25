package leetcode;

public class lec9 {
    public static void main(String[] args) {

    }
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        StringBuilder sb = new StringBuilder(Integer.valueOf(x).toString());

        return sb.toString().equals(sb.reverse().toString());
    }
}
