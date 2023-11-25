package leetcode;

public class lec5N {
    // 中心扩展算法
    // 大概思路, 如果s[i, j]是一个回文串, 那么s[i + 1, j - 1]一定是一个回文串
    public String longestPalindrome(String s) {
        int st = 0, ed = 0; // 记录初始和结束位置

        for (int i = 0; i < s.length(); i ++ ) { // 枚举中心点
            int len1 = expandAroundCenter(s, i, i); // 长度为奇数
            int len2 = expandAroundCenter(s, i, i + 1); // 长度为偶数

            int len = Math.max(len1, len2);
            if (len > ed - st + 1) {
                st = i - (len - 1) / 2; // 因为从i开始往左找分为两种情况, 偶数和奇数, 为了返回正确的结果这里直接减去长度减1除2就好了
                ed = i + len / 2; // 无论原本偶数的话是从i + 1开始找的, 但这里发现用长度的一半可以直接返回正确的结果, 为了代码更精炼, 这里直接就这样写了
            }
        }
        return s.substring(st, ed + 1); // 注意API是左闭右开
    }

    // 核心代码, 利用双指针的思想
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -- ;
            right ++ ;
        }
        return right - left - 1;
        // 指针最后停在了不满足条件的位置, 但返回的是满足条件的子串长度, 这里根据关系返回正确的结果
    }
}
