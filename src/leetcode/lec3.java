package leetcode;

public class lec3 {
    public static int lengthOfLongestSubstring(String s) {
        int[] arr = new int[1000];
        int ans = 0;
        for (int i = 0, j = 0; i < s.length(); i ++ ) {
            arr[s.charAt(i)] ++ ;
            while (arr[s.charAt(i)] > 1 && j <= i) {
                arr[s.charAt(j)] -- ;
                j ++ ;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
