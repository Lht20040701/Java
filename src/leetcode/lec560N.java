package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lec560N {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

    /*
    * 先考虑暴力再考虑优化(暴力都打错了, 我真是服了)
    *             此处为了省篇幅, 直接写最终思路 :
    *                           我们根据前缀和(Sum[l, r]代表数组从l到r的区间和, s代表数组的前缀和)的公式, 知道目标是 -> Sum[l, r] = s[i] - s[j - 1] == k
    *                           我们知道当前的s[i]目标是找出有多少个j可以使得上述公式成立, 所以公式推导后为s[i] - k == s[j - 1]
    *                           所以我们可以从前往后遍历, 配合哈希表找出前面有多少个前缀和为s[i] - k的s[j]
    *
    * 类似题目 : 蓝桥杯 -> k倍区间, 最长平衡子串
    * */
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;

        Map<Integer, Integer> ma = new HashMap<>();
        ma.put(0, 1); // 这里一定要初始化为1 !!!!!!!!!!

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int x = ma.getOrDefault(sum - k, 0);
            ans += x;
            ma.put(sum, ma.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
