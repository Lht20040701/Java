package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec2609 {
    public int findTheLongestBalancedSubstring(String s) {
        if (s == null) return 0;
        int now = 0, cnt = 0;
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < s.length(); i ++ ) {
            if (now == s.charAt(i) - '0') cnt ++ ;
            else {
                lis.add(cnt);
                now = Math.abs(now - 1);
                cnt = 1;
            }
        }
        lis.add(cnt);
        int ans = 0;
        for (int i = 0; i < lis.size() - 1; i += 2) {
            int x = lis.get(i), y = lis.get(i + 1);
            ans = Math.max(ans, 2 * Math.min(x, y));
        }
        return ans;
    }
}