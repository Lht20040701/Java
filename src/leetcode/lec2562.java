package leetcode;

public class lec2562 {
    public static void main(String[] args) {

    }

    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i ++ , j -- ) {
            if (i != j)
                ans += Integer.parseInt(nums[i] + "" + nums[j]);
            else ans += nums[i];
        }
        return ans;
    }
}
