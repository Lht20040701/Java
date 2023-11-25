package leetcode;

public class lec1156N {
    public int maxRepOpt1(String s) {
        // init 初始化
        int[] t = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i ++ ) t[s.charAt(i) - 'a'] ++ ;

        // solve 解决问题
        int i = 0, j = 0, k = 0;
        int ans = 0;
        while (i < n) { // 采用滑动窗口(或者理解为双指针, 因为我觉得这题和双指针比较像)
            while (j < n && s.charAt(j) == s.charAt(i)) j ++ ; // 查看我当前单字符重复子串的长度
            int x = t[s.charAt(i) - 'a'];
            if (j - i == x) ans = Math.max(ans, j - i); // 如果我当前当前单字符重复子串的长度就是我单字符的个数, 说明无法交换, 所以直接尝试更新答案
            else { // 如果当前单字符重复子串长度不是该字符的个数的话, 就说明还是可以进行交换的
                ans = Math.max(ans, j - i + 1); // 直接把后面的一个相同字符放过来(这个放过来很重要)计算一下长度, 然后尝试更新答案
                k = j + 1; // 让k从j + 1开始往后枚举看是否还是该字符的单字符重复子串 (此时j的位置已经是该字符了, 因为我上一行把一个后面的字符放到j的位置了)
                while (k < n && s.charAt(k) == s.charAt(i)) k ++ ; // 枚举
                ans = Math.max(ans, Math.min(k - i, x)); // 这里k搜完以后的处理比较特殊
                // 解释一下里面的Math.min(k - i, x) :
                //              因为后面接上另一段该字符的单字符子串以后有两种可能 :
                //                      a. 我的后面还有别的该字符, 也就是k - i < x, 说明不影响我之前把后面的该字符放到j的位置
                //                      b. 我的后面没有别的字符了, 也就是k - i == x, 这导致我之前往j放的该字符其实就是该段的一个字符, 这样的话我们的长度其实就应该是k - i - 1 (和x相同)
                //                      c. k还没开始后移就直接停下来了, k还是j + 1的位置, 代入后还是j - i + 1, 也就是我们之前写过的公式, 不影响我们的结果
            }
            i = j; // 这一段单字符重复字串处理完了, 然后i从j开始搜索准备去处理下一段
        }
        return ans;
    }
}
