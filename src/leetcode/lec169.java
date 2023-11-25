package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec169 {
    HashMap<Integer, Integer> ha = new HashMap<>();
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++ ) ha.put(nums[i], ha.getOrDefault(nums[i], 0) + 1);
        for (Map.Entry<Integer, Integer> entry : ha.entrySet()) {
            if (entry.getValue() > n / 2) return entry.getKey();
        }
        return 0;
    }
}
