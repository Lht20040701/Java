package leetcode;

import java.util.ArrayList;
import java.util.List;

public class lec39 {
    List<List<Integer>> ans = new ArrayList<>();
    int target;
    int[] candidates;
    int n;
    public List<List<Integer>> combinationSum(int[] _candidates, int _target) {
        target = _target; candidates = _candidates; n = candidates.length;
        dfs(0, 0, new ArrayList<>());
        return ans;
    }

    public void dfs(int now, int nowSum, List<Integer> lis) {
        if (nowSum > target) return ;
        List<Integer> temp = new ArrayList<>(lis);
        if (nowSum == target) {
            ans.add(temp);
            return ;
        }
        if (now == n) return ;

        dfs(now + 1,  nowSum, temp); // 不加直接搜索下一层

        int x = candidates[now];
        for (int i = 1; nowSum <= target; i ++ ) {
            nowSum += x;
            temp.add(x);
            dfs(now + 1, nowSum, temp);
        }
    }
}
