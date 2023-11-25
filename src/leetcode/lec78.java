package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec78 {
    List<List<Integer>> ans = new ArrayList<>();
    int[] nums;
    int n;
    public List<List<Integer>> subsets(int[] _nums) {
        nums = _nums; n = nums.length;
        dfs(0, new ArrayList<>());
        return ans;
    }

    public void dfs(int now, List<Integer> lis) {
        List<Integer> temp = new ArrayList<>(lis);
        // 当前集合直接加到答案里
        if (now == n) {
            ans.add(temp);
            return ;
        }
        // 用Java写递归的时候一定要注意引用数据类型
        dfs(now + 1, temp);
        temp.add(nums[now]);
        dfs(now + 1, temp);
    }
}
