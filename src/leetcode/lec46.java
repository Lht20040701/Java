package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec46 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] _nums) {
        nums = _nums;
        dfs(0);
        return ans;
    }

    public void dfs(int u) { // 放了几个数字
        if (u == nums.length) {
//            System.out.println(path);
            List<Integer> path = new ArrayList<>(this.path);
            // 如果不这么写而是直接把path放到ans中, 会因为是引用数据类型而导致答案到最后都为空
            ans.add(path);
            return ;
        }

        for (int i = 0; i < nums.length; i ++ ) {
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs(u + 1);
            path.remove(path.size() - 1);
        }
    }
}
