package leetcode;

public class lec238N {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] PI = new int[n];

        int k = 1;
        for (int i = 0; i < n; i ++ ) {
            PI[i] = k; // k是当前位置左边数组的乘积
            k *= nums[i];
        }

        k = 1; // 重置
        for (int i = n - 1; i >= 0; i -- ) {
            PI[i] *= k; // k是当前位置右边数组的乘积
            k *= nums[i];
        }

        return PI;
    }
}
