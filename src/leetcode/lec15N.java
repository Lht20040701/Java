package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lec15N {
    public static void main(String[] args) {
        List<List<Integer>> tes = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(tes);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        /**
         * 假设三个数分别为 i, j, r, 我们枚举i, 让j, r使用双指针, 可以将时间复杂度控制在O(n * n)
         * 比较恶心的是如何去重, 需要两重操作去重, 枚举i的时候去重一次, 给j, r使用双指针的时候再去重一次, 具体去重操作可以看下面代码
         * */

        for (int i = 0; i < nums.length - 2; i ++ ) {
            if (nums[i] > 0) return ans; // 因为排好序了, 所以这里如果nums[i] > 0的话直接退掉就好了

            if (i > 0 && nums[i] == nums[i - 1]) continue; // 枚举i的时候去重

            int r = nums.length - 1;
            int j = i + 1; // j从i + 1位置开始枚举

            while (j < r) {
                int sum = nums[i] + nums[j] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[r])); // 比较好用的API, 挺优雅的

                    // 对j, r进行去重
                    while (j < r && nums[j] == nums[j + 1]) j ++ ;
                    while (j < r && nums[r] == nums[r - 1]) r -- ;
                    j ++ ;
                    r -- ;
                } else if (sum < 0) { // 双指针 : j右移
                    j ++ ;
                } else { // 双指针 : r左移
                    r -- ;
                }
            }
        }
        return ans;
    }
}
