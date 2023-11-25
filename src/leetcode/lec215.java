package leetcode;

public class lec215 {
    public int findKthLargest(int[] nums, int k) {
        return qs(nums, 0, nums.length - 1, k);
    }

    public int qs(int[] nums, int l, int r, int k) {
        if (l >= r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[ ++ i] > x) ;
            while (nums[ -- j] < x) ;
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        int sl = j - l + 1;
        if (k <= sl) return qs(nums, l, j, k);
        return qs(nums, j + 1, r, k - sl);
    }
}
