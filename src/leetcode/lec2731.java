package leetcode;

import java.util.Arrays;

public class lec2731 {
    // 和蓝桥杯上一个叫做蚂蚁感冒的问题非常相似
    /**
     * 第一个点 : 两个机器人撞面以后可以看作没有任何事情发生 (套路)
     *
     * 第二个点 : 求一排点的距离和这个也是一个套路 (套路)
     *          看这个点到后面下一个点的距离会被加几次
     *          然后直接把距离和次数的乘积累加到结果上
     * */
    static final int Mod = (int) (1e9 + 7);
    public int sumDistance(int[] nums, String s, int d) {

        long[] pos = new long[nums.length];

        for (int i = 0; i < nums.length; i ++ ) {
            if (s.charAt(i) == 'L') pos[i] = (long) nums[i] - d;
            else pos[i] = (long) nums[i] + d;
        } // 这里防止变动以后的坐标爆掉int

        long ans = 0;

        Arrays.sort(pos);

        for (int i = 0; i < pos.length - 1; i ++ ) {
            ans += (pos[i + 1] - pos[i]) * (i + 1) % Mod * (pos.length - 1 - i) % Mod;
            // 注意数据范围, 防止连long都爆掉
            ans %= Mod;
        }

        return (int) ans;
    }
}
