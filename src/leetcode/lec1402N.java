package leetcode;

import java.util.Arrays;

public class lec1402N {
    public int maxSatisfaction(int[] satisfaction) {
        int ans = 0, sum = 0;
        Arrays.sort(satisfaction);
//        从后往前枚举
//        每多加入一个数, 已经加过的数都会被多加一遍
        for (int i = satisfaction.length - 1; i >= 0; i -- ) {
            sum += satisfaction[i];
            if (sum < 0) break;
            ans += sum;
        }

        return ans;
    }
}
