package leetcode;

import java.util.Arrays;

public class lec455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length, m = s.length;
        int ans = 0;
        for (int i = 0, j = 0; i < n; i ++ ) {
            while (j < m && s[j] < g[i]) j ++ ; // 跳过满足不了第i孩子胃口的饼干
            if (j == m) break;
            ans ++ ;
            j ++ ; // 这个饼干分完了, 别忘了这里也要j ++ ;
        }
        return ans;
    }
}
