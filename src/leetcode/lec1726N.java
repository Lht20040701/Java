package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec1726N {
    Map<Integer, Integer> map = new HashMap<>();
    public int tupleSameProduct(int[] nums) {
        int ans = 0;

        int n = nums.length;
        for (int i = 0; i < n; i ++ )
            for (int j = i + 1; j < n; j ++ ) {
                int x = nums[i] * nums[j];
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

        for (Integer v : map.values()) ans += v * (v - 1) * 4;
        return ans;
    }
}
