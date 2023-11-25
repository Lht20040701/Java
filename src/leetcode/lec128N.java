package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec128N {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> m = new HashMap<>();

        for (int i = 0; i < nums.length; i ++ ) m.put(nums[i], true);

        int ans = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (m.containsKey(nums[i] - 1)) continue;
            else {
                int y = 1;
                while (m.containsKey(nums[i] + y)) y ++ ;
                ans = Math.max(ans, y);
            }
        }
        return ans;
    }
}
