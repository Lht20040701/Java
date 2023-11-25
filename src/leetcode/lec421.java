package leetcode;

import java.util.Arrays;

public class lec421 {
    int[][] son;
    int idx = 0;
    public int findMaximumXOR(int[] nums) {
        son = new int[31 * nums.length][2];
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i ++ ) {
            insert(nums[i]);
            int t = querry(nums[i]);
            ans = Math.max(ans, t ^ nums[i]);
        }
        return ans;
    }

    public void insert(int x) {
        int p = 0;
        for (int i = 30; i >= 0; i -- ) {
            int u = x >> i & 1;
            if (son[p][u] == 0) son[p][u] = ++ idx;
            p = son[p][u];
        }
    }

    public int querry(int x) {
        int ret = 0;
        int p = 0;
        for (int i = 30; i >= 0; i -- ) {
            int u = x >> i & 1;
            int t = Math.abs(u - 1);
            if (son[p][t] != 0) {
                ret = ret * 2 + t;
                p = son[p][t];
            }
            else {
                ret = ret * 2 + u;
                p = son[p][u];
            }
        }
        return ret;
    }
}
