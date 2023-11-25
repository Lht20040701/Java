package leetcode;

public class lec121 {
    public int maxProfit(int[] prices) {
        int nowMin = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i ++ ) {
            if (prices[i] > nowMin) ans = Math.max(ans, prices[i] - nowMin); // 算是动态规划, 每次都用当前的减去我前面的最小值
            nowMin = Math.min(nowMin, prices[i]);
        }
        return ans;
    }
}
