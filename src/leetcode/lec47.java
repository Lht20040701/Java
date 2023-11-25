package leetcode;

import java.util.*;

public class lec47 {
    Set<List<Integer>> st = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    int[] nums;
    int n;
    boolean[] f = new boolean[30];
    public List<List<Integer>> permuteUnique(int[] _nums) {
        nums = _nums;
        n = nums.length;
        dfs(0);
        return new ArrayList<>(st);
    }

    public void dfs(int u) { // u代表我放了几个数了
        if (u == n) {
            List<Integer> path = new ArrayList<>(this.path);
//            System.out.println(path);
            st.add(path);
            return ;
        }

        for (int i = 0; i < n; i ++ ) {
            if (f[i]) continue;
            f[i] = true;
            path.add(nums[i]);
            dfs(u + 1);
            path.remove(path.size() - 1);
            f[i] = false;
        }
    }
}
