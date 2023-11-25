package leetcode;

public class lec283N {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i ++ ) {
            if (nums[i] != 0) swap(nums, i, j ++ );
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
