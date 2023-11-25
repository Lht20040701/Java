package leetcode;

public class lec2640 {
    public static void main(String[] args) {

    }

    public long[] findPrefixScore(int[] nums) {
        long[] s = new long[nums.length];
        int[] conver = new int[nums.length];
        int ma = 0;

        for (int i = 0; i < nums.length; i ++ ) {
            ma = Math.max(ma, nums[i]);
            conver[i] = nums[i] + ma;
            if (i != 0) s[i] = s[i - 1] + conver[i];
            else s[i] = conver[i];
        }
        return s;
    }
}
