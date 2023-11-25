package leetcode;

import java.util.Arrays;

public class lec154 {
    /**
     *  首先是思路来源 : https://leetcode.cn/problems/russian-doll-envelopes/solutions/19681/zui-chang-di-zeng-zi-xu-lie-kuo-zhan-dao-er-wei-er/
     *  思路 :先按照宽度降序(升序) 接着宽度相同时再按照高度升序 (降序) (重点), 接着对高度求最长下降(上升) 子序列就可以
     *  正确性 : 宽度降序(升序) 以后我们的宽度前面一定大于(小于) 后面, 这样就保证了一个条件了, 然后就是宽度相同时, 我们按高度升序(降序) 排列, 这样我们保证求最长下降(上升) 子序列的时候同一宽度的信封就只选一个了 (太巧妙了, 我去)
     * */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int[] p = new int[envelopes.length + 10];
        p[0] = -0x3f3f3f3f;
        int len = 0;
        for (int i = 0; i < envelopes.length; i ++ ) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (p[mid] > envelopes[i][1]) l = mid;
                else r = mid - 1;
            }

            len = Math.max(len, r + 1);
            p[r + 1] = envelopes[i][1];
        }

        return len;
    }
}
