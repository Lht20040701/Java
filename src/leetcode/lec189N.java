package leetcode;

public class lec189N {
    public void rotate(int[] nums, int k) {
        // 题解 : https://leetcode.cn/problems/rotate-array/solutions/551039/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/?envType=study-plan-v2&envId=top-100-liked
        k %= nums.length; // 先取模
        int x = gcd(nums.length, k); // 再求长度和x的最大公约数, 代表有几个环, 证明见题解

        for (int i = 0; i < x; i ++ ) {
            int t = nums[i]; // 记录开始位置的数值
            int ed = i; // ed表示我当前的位置
            for (; ; ed = (ed - k + nums.length) % nums.length) // 环状替换, 注意倒着枚举
                if ((ed - k + nums.length) % nums.length != i) nums[ed] = nums[(ed - k + nums.length) % nums.length]; // 替换
                else break; // 结束的条件是该位置的下一个位置是我刚开始的位置
            nums[ed] = t; // 手动把这个位置的值设置为开始位置的数值
        }
    }
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
